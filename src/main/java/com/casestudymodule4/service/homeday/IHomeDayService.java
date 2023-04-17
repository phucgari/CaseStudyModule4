package com.casestudymodule4.service.homeday;

import com.casestudymodule4.model.home.order.HomeDay;
import com.casestudymodule4.service.IGeneralService;

import java.time.LocalDate;
import java.util.Optional;

public interface IHomeDayService extends IGeneralService<HomeDay> {
    Optional<HomeDay> findByDayAndHomeId(LocalDate date , Long homeId);
}
