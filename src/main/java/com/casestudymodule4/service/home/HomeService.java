package com.casestudymodule4.service.home;

import com.casestudymodule4.model.home.Home;
import com.casestudymodule4.repository.IHomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HomeService implements IHomeService {
    @Autowired
    private IHomeRepository iHomeRepository;

    @Override
    public Iterable<Home> findAll() {
        return this.iHomeRepository.findAll();
    }

    @Override
    public Optional<Home> findById(Long id) {
        return this.iHomeRepository.findById(id);
    }

    @Override
    public Home save(Home home) {
        return this.iHomeRepository.save(home);
    }

    @Override
    public void remove(Long id) {
        this.iHomeRepository.deleteById(id);
    }
}
