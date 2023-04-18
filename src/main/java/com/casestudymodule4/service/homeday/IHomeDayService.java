package com.casestudymodule4.service.homeday;

import com.casestudymodule4.model.home.Home;
import com.casestudymodule4.model.home.order.HomeDay;
import com.casestudymodule4.service.IGeneralService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IHomeDayService extends IGeneralService<HomeDay> {
    List<HomeDay> findAllByDayBetweenAndHome(String year, String month, Home home);

    Optional<HomeDay> findByDayAndHome(LocalDate date , Home home);
}
