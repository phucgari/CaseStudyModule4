package com.casestudymodule4.controller;

import com.casestudymodule4.model.picture.Picture;
import com.casestudymodule4.service.picture.IPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("pictures")
public class PictureController {
    @Autowired
    private IPictureService iPictureService;

    @GetMapping
    public ResponseEntity<Iterable<Picture>> findAll() {
        return new ResponseEntity<>(this.iPictureService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Optional<Picture>> findById(@PathVariable Long id) {
        return new ResponseEntity<>(this.iPictureService.findById(id), HttpStatus.OK);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Picture> updatePicture( @RequestBody Picture picture) {
        this.iPictureService.save(picture);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        this.iPictureService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
