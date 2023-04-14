package com.casestudymodule4.repository.home;

import com.casestudymodule4.model.home.order.HomeDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHomeDayRepository extends JpaRepository<HomeDay, Long> {
}
