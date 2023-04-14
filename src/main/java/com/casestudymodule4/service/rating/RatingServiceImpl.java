package com.casestudymodule4.service.rating;

import com.casestudymodule4.model.home.rating.Rating;
import com.casestudymodule4.repository.IRatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RatingServiceImpl implements IRatingService{
    @Autowired
    private IRatingRepository iRatingRepository;

    @Override
    public Iterable<Rating> findAll() {
        return iRatingRepository.findAll();
    }

    @Override
    public Optional<Rating> findById(Long id) {
        return iRatingRepository.findById(id);
    }

    @Override
    public Rating save(Rating rating) {
        return iRatingRepository.save(rating);
    }

    @Override
    public void remove(Long id) {
        iRatingRepository.deleteById(id);
    }
}
