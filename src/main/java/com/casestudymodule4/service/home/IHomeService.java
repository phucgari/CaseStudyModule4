package com.casestudymodule4.service.home;

import com.casestudymodule4.model.home.Home;
import com.casestudymodule4.service.IGeneralService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IHomeService extends IGeneralService<Home> {
    List<Home> complexSearch
            (Optional<Integer> minNumberOfBathroom,
             Optional<Integer> maxNumberOfBathroom,
             Optional<Integer> minNumberOfBedroom,
             Optional<Integer> maxNumberOfBedroom,
             Optional<String> address,
             Optional<Double> priceMin,
             Optional<Double> priceMax,
             Optional<LocalDate> minDate,
             Optional<LocalDate> maxDate);
}
