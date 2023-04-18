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
        if (homeDay.getId() != null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            this.iHomeDayService.save(homeDay);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        this.iHomeDayService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity<HomeDay> updateStatusHomeDay(@RequestBody HomeDay homeDay) {
        Optional<HomeDay> homeDaySearch = this.iHomeDayService.findByDayAndHomeId(homeDay.getDay(), homeDay.getHome().getId());
        if (homeDaySearch.isPresent()) {
            HomeDay updateHomeDay=homeDaySearch.get();
            updateHomeDay.setStatus(homeDay.getStatus());
            return update(updateHomeDay);
        } else {
            return create(homeDay);
        }
    }
}
