package com.casestudymodule4.controller.home;

import com.casestudymodule4.model.home.Home;
import com.casestudymodule4.model.home.type.HomeType;
import com.casestudymodule4.model.picture.Picture;
import com.casestudymodule4.model.user.Role;
import com.casestudymodule4.model.user.User;
import com.casestudymodule4.security.jwt.JwtProvider;
import com.casestudymodule4.service.home.IHomeService;
import com.casestudymodule4.service.hometype.IHomeTypeService;
import com.casestudymodule4.service.picture.IPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;

import java.util.Optional;
import java.util.Set;

@RequestMapping("homes")
@RestController
@CrossOrigin("*")
public class HomeController {
    @Autowired
    private IHomeService iHomeService;
    @Autowired
    private JwtProvider jwtProvider;
    @Autowired
    private IPictureService pictureService;
    @Autowired
    private IHomeTypeService homeTypeService;

    @GetMapping("/search")
    public ResponseEntity<Iterable<Home>> findAllWithComplexSearch(Optional<Integer> minNumberOfBathroom,
                                                                   Optional<Integer> maxNumberOfBathroom,
                                                                   Optional<Integer> minNumberOfBedroom,
                                                                   Optional<Integer> maxNumberOfBedroom,
                                                                   Optional<String> address,
                                                                   Optional<Double> priceMin,
                                                                   Optional<Double> priceMax,
                                                                   Optional<String> minDate,
                                                                   Optional<String> maxDate) {
        Optional<LocalDate> newMinDate= minDate.get().isBlank()?Optional.empty(): Optional.ofNullable(LocalDate.parse(minDate.orElse("")));
        Optional<LocalDate> newMaxDate= maxDate.get().isBlank()?Optional.empty(): Optional.ofNullable(LocalDate.parse(maxDate.orElse("")));
        List<Home> homes = iHomeService.complexSearch(
                minNumberOfBathroom,
                maxNumberOfBathroom,
                minNumberOfBedroom,
                maxNumberOfBedroom,
                address,
                priceMin,
                priceMax,
                newMinDate,
                newMaxDate);
        return new ResponseEntity<>(homes, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<Iterable<Home>> showListHome() {
        List<Home> homes = (List<Home>) iHomeService.findAll();
        if (homes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(homes, HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<Home> createNewHome(@RequestBody Home home,
                                              @RequestHeader(name = "Authorization") String authHeader) {
        Optional<User> optionalUser=jwtProvider.getUserFromBearer(authHeader);
        if(optionalUser.isEmpty())return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        Set<Role> roleSet=optionalUser.get().getRoles();
        for (Role role :
                roleSet) {
            if(role.getName()== Role.RoleType.USER)
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        Set<HomeType>homeTypes=new HashSet<>();
        for (HomeType hometype :
                home.getTypes()) {
            HomeType homeType=homeTypeService.findByName(hometype.getName());
            homeTypes.add(homeType);
        }
        home.setTypes(homeTypes);
        home.setOwner(optionalUser.get());
        Home saved = iHomeService.save(home);
        home.setOwner(optionalUser.get());
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Home> updateHome(@PathVariable Long id, @RequestBody Home home) {
        iHomeService.save(home);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/home/owner/{id}")
    public ResponseEntity<Home> findById(@PathVariable Long id){
        Optional<Home> byId = iHomeService.findById(id);
        return ResponseEntity.ok(byId.get());
    }
    @DeleteMapping({"/delete/{id}"})
    public ResponseEntity<Home> deleteById(@PathVariable Long id) {
        iHomeService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/showTopHome")
    public ResponseEntity<Iterable<Home>> showTopFiveHomeRentals() {
        List<Home> homes = (List<Home>) iHomeService.showTopFiveRental();
        return new ResponseEntity<>(homes, HttpStatus.OK);
    }
}
