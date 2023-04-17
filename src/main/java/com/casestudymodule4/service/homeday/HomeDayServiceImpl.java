package com.casestudymodule4.service.homeday;

import com.casestudymodule4.model.home.order.HomeDay;
import com.casestudymodule4.repository.home.IHomeDayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class HomeDayServiceImpl implements IHomeDayService {
    @Autowired
    private IHomeDayRepository iHomeDayRepository;

    @Override
    public Iterable<HomeDay> findAll() {
        return iHomeDayRepository.findAll();
    }

    @Override
    public Optional<HomeDay> findById(Long id) {
        return iHomeDayRepository.findById(id);
    }

    @Override
    public HomeDay save(HomeDay homeDay) {
        return iHomeDayRepository.save(homeDay);
    }

    @Override
    public void remove(Long id) {
        iHomeDayRepository.deleteById(id);
    }

    @Override
    public Optional<HomeDay> findByDayAndHomeId(LocalDate date, Long homeId) {
        return this.iHomeDayRepository.findByDayAndHomeId(date, homeId);
    }
}
