package com.casestudymodule4.controller.home;

import com.casestudymodule4.model.home.Home;
import com.casestudymodule4.model.picture.Picture;
import com.casestudymodule4.model.user.Role;
import com.casestudymodule4.model.user.User;
import com.casestudymodule4.security.jwt.JwtProvider;
import com.casestudymodule4.service.home.IHomeService;
import com.casestudymodule4.service.picture.IPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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

    @GetMapping("/search")
    public ResponseEntity<Iterable<Home>> findAllWithComplexSearch(Optional<Integer> minNumberOfBathroom,
                                                                   Optional<Integer> maxNumberOfBathroom,
                                                                   Optional<Integer> minNumberOfBedroom,
                                                                   Optional<Integer> maxNumberOfBedroom,
                                                                   Optional<String> address,
                                                                   Optional<Double> priceMin,
                                                                   Optional<Double> priceMax,
                                                                   Optional<LocalDate> minDate,
                                                                   Optional<LocalDate> maxDate) {
        List<Home> homes = iHomeService.complexSearch(
                minNumberOfBathroom,
                maxNumberOfBathroom,
                minNumberOfBedroom,
                maxNumberOfBedroom,
                address,
                priceMin,
                priceMax,
                minDate,
                maxDate);
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

        home.setOwner(optionalUser.get());
        Home saved = iHomeService.save(home);
        for (Picture pic :
                home.getPictures()) {
            pictureService.save(pic);
        }
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

}
