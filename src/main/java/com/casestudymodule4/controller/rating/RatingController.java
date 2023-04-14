package com.casestudymodule4.controller.rating;

import com.casestudymodule4.model.home.Home;
import com.casestudymodule4.model.home.rating.Rating;
import com.casestudymodule4.service.home.IHomeService;
import com.casestudymodule4.service.rating.IRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("ratings")
@CrossOrigin("*")
public class RatingController {
    @Autowired
    private IRatingService iRatingService;

    @GetMapping("")
    public ResponseEntity<Iterable<Rating>> findAll() {
        return new ResponseEntity<>(iRatingService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Rating> createNewRating(@RequestBody Rating rating) {
        return new ResponseEntity<>(iRatingService.save(rating), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Rating> updateRating(@PathVariable Long id, @RequestBody Rating rating) {
        iRatingService.save(rating);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<Rating> deleteById(@PathVariable Long id) {
        iRatingService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
