package com.casestudymodule4.controller.home;

import com.casestudymodule4.model.home.Home;
import com.casestudymodule4.service.home.IHomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("homes")
@RestController
@CrossOrigin("*")
public class HomeController {
    @Autowired
    private IHomeService iHomeService;

    @GetMapping("")
    public ResponseEntity<Iterable<Home>> findAll() {
        return new ResponseEntity<>(iHomeService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Home> createNewHome(@RequestBody Home home) {
        return new ResponseEntity<>(iHomeService.save(home), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Home> updateHome(@PathVariable Long id, @RequestBody Home home) {
        iHomeService.save(home);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<Home> deleteById(@PathVariable Long id) {
        iHomeService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
