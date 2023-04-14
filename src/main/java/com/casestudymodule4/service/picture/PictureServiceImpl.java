package com.casestudymodule4.service.picture;

import com.casestudymodule4.model.picture.Picture;
import com.casestudymodule4.repository.IPictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PictureServiceImpl implements IPictureService {
    @Autowired
    private IPictureRepository iPictureRepository;

    @Override
    public Iterable<Picture> findAll() {
        return iPictureRepository.findAll();
    }

    @Override
    public Optional<Picture> findById(Long id) {
        return iPictureRepository.findById(id);
    }

    @Override
    public Picture save(Picture picture) {
        return iPictureRepository.save(picture);
    }

    @Override
    public void remove(Long id) {
        iPictureRepository.deleteById(id);
    }
}
