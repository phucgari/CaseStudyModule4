package com.casestudymodule4.repository.home;

import com.casestudymodule4.model.home.order.HomeDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

@Repository
public interface IHomeDayRepository extends JpaRepository<HomeDay, Long> {
    Optional<HomeDay> findByDayAndHomeId(LocalDate day, Long id);
}
