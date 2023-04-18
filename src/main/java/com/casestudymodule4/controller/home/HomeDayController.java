package com.casestudymodule4.controller.home;

import com.casestudymodule4.model.home.Home;
import com.casestudymodule4.model.home.order.HomeDay;
import com.casestudymodule4.service.homeday.IHomeDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/homeday")
@CrossOrigin("*")
public class HomeDayController {
    @Autowired
    private IHomeDayService iHomeDayService;
    @GetMapping
    public ResponseEntity<Iterable<HomeDay>> findAll(@RequestParam String year,
                                                     @RequestParam String month,
                                                     @RequestParam Home home) {
        return new ResponseEntity<>(iHomeDayService.findAllByDayBetweenAndHome(year,month,home), HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Optional<HomeDay>> findById(@PathVariable Long id) {
        return new ResponseEntity<>(this.iHomeDayService.findById(id), HttpStatus.OK);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<HomeDay> updateHomeDay( @RequestBody HomeDay homeDay) {
        this.iHomeDayService.save(homeDay);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        this.iHomeDayService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
