package com.casestudymodule4.repository.home;

import com.casestudymodule4.model.home.Home;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IHomeRepository extends JpaRepository<Home, Long> {
    List<Home> searchAllByNumberOfBathroomBetweenAndNumberOfBedroomBetweenAndAddressLikeIgnoreCaseAndPriceBetween
            (Optional<Integer> minNumberOfBathroom,
             Optional<Integer> maxNumberOfBathroom,
             Optional<Integer> minNumberOfBedroom,
             Optional<Integer> maxNumberOfBedroom,
             Optional<String> address,
             Optional<Double> priceMin,
             Optional<Double> priceMax);
}
