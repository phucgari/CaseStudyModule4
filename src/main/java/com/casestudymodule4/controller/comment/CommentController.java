package com.casestudymodule4.controller.comment;

import com.casestudymodule4.model.home.rating.Comment;
import com.casestudymodule4.model.picture.Picture;
import com.casestudymodule4.service.Comment.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("comment")
public class CommentController {
    @Autowired
    private ICommentService iCommentService;
    @GetMapping
    public ResponseEntity<Iterable<Comment>> findAll() {
        return new ResponseEntity<>(this.iCommentService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Optional<Comment>> findById(@PathVariable Long id) {
        return new ResponseEntity<>(this.iCommentService.findById(id), HttpStatus.OK);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Comment> updateComment( @RequestBody Comment comment) {
        this.iCommentService.save(comment);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        this.iCommentService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
