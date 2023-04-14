package com.casestudymodule4.controller.home;

import com.casestudymodule4.model.home.type.HomeType;
import com.casestudymodule4.service.hometype.IHomeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("hometype")
public class HomeTypeController {
    @Autowired
    private IHomeTypeService iHomeTypeService;

    @GetMapping
    public ResponseEntity<Iterable<HomeType>> findAll() {
        return new ResponseEntity<>(this.iHomeTypeService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Optional<HomeType>> findById(@PathVariable Long id) {
        return new ResponseEntity<>(this.iHomeTypeService.findById(id), HttpStatus.OK);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<HomeType> updateHomeType(@RequestBody HomeType homeType) {
        this.iHomeTypeService.save(homeType);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        this.iHomeTypeService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("findByName/{name}")
    public ResponseEntity<Optional<HomeType>> findByName(@PathVariable String name) {
        return new ResponseEntity<>(this.iHomeTypeService.findByName(name), HttpStatus.OK);
    }
}
