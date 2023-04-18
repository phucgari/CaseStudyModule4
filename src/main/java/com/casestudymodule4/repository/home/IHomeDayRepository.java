package com.casestudymodule4.repository.home;

import com.casestudymodule4.model.home.Home;
import com.casestudymodule4.model.home.order.HomeDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface IHomeDayRepository extends JpaRepository<HomeDay, Long> {

    List<HomeDay> findAllByDayBetweenAndHome(@NotBlank LocalDate from, @NotBlank LocalDate to, @NotBlank Home home);

    Optional<HomeDay> findByDayAndHomeId(LocalDate day, Long id);
}
