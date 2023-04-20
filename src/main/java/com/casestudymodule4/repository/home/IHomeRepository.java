package com.casestudymodule4.repository.home;

import com.casestudymodule4.model.home.Home;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IHomeRepository extends JpaRepository<Home, Long>, JpaSpecificationExecutor<Home> {

    @Query(value = "select count(o.home_id) as order_count,h.* " +
            "from homes h join orders o on h.id = o.home_id group by h.id order by order_count desc limit 5;", nativeQuery = true)
    List<Home> showTopFiveRental();
}
