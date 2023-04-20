package com.casestudymodule4.repository.home;

import com.casestudymodule4.model.home.Home;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IHomeRepository extends JpaRepository<Home, Long> {
    List<Home> findAllByNumberOfBathroomBetweenAndNumberOfBedroomBetweenAndAddressContainingAndPriceBetween
            (Optional<Integer> minNumberOfBathroom,
             Optional<Integer> maxNumberOfBathroom,
             Optional<Integer> minNumberOfBedroom,
             Optional<Integer> maxNumberOfBedroom,
             Optional<String> address,
             Optional<Double> priceMin,
             Optional<Double> priceMax);

    @Query(value = "select count(o.home_id) as order_count,h.* " +
            "from homes h join orders o on h.id = o.home_id group by h.id order by order_count desc limit 5;", nativeQuery = true)
    List<Home> showTopFiveRental();
}
