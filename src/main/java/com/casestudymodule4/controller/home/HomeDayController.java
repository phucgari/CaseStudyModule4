package com.casestudymodule4.controller.home;

import com.casestudymodule4.model.home.Home;
import com.casestudymodule4.model.home.order.HomeDay;
import com.casestudymodule4.model.home.order.Status;
import com.casestudymodule4.service.home.IHomeService;
import com.casestudymodule4.service.homeday.IHomeDayService;
import com.casestudymodule4.service.status.IStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping("/homeday")
@CrossOrigin("*")
public class HomeDayController {
    @Autowired
    private IHomeDayService iHomeDayService;
    @Autowired
    private IHomeService iHomeService;
    @Autowired
    private IStatusService iStatusService;

    @GetMapping
    public ResponseEntity<Iterable<HomeDay>> findAll(@RequestParam String year,
                                                     @RequestParam String month,
                                                     @RequestParam Home home) {
        return new ResponseEntity<>(iHomeDayService.findAllByDayBetweenAndHome(year,month,home), HttpStatus.OK);
    }

    @PostMapping("create")
    public ResponseEntity<HomeDay> create(@RequestBody HomeDay homeDay) {
        return new ResponseEntity<>(this.iHomeDayService.save(homeDay), HttpStatus.CREATED);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Optional<HomeDay>> findById(@PathVariable Long id) {
        return new ResponseEntity<>(this.iHomeDayService.findById(id), HttpStatus.OK);
    }

    @PutMapping("update")
    public ResponseEntity<HomeDay> update(@RequestBody HomeDay homeDay) {
        if (homeDay.getId() == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            this.iHomeDayService.save(homeDay);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HomeDay> deleteById(@PathVariable Long id) {
        this.iHomeDayService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity<HomeDay> updateStatusHomeDay(@RequestBody HomeDay homeDay) {
        LocalDate day = homeDay.getDay();
        Long homeId = homeDay.getHome().getId();
        Optional<Home> optionalHome=iHomeService.findById(homeId);
        if(optionalHome.isEmpty())return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        Home home=optionalHome.get();
        Optional<HomeDay> homeDaySearch = iHomeDayService.findByDayAndHome(day, home);
        Status status = iStatusService.findByName(homeDay.getStatus().getName()).get();
        if (homeDaySearch.isPresent()) {
            if(status.getName()== Status.StatusType.FREE){
                return deleteById(homeDaySearch.get().getId());
            }
                else{
                HomeDay updateHomeDay = homeDaySearch.get();
                updateHomeDay.setStatus(status);
                return update(updateHomeDay);
            }
        } else {
            homeDay.setStatus(status);
            return create(homeDay);
        }
    }
}
