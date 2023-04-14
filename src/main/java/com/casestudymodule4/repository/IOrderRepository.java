package com.casestudymodule4.repository;

import com.casestudymodule4.model.DTO.MonthMoneyTable;
import com.casestudymodule4.model.home.order.Order;
import com.casestudymodule4.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderRepository extends JpaRepository<Order,Long> {
    Iterable<Order> findAllByOrderer(User user);
    @Query(nativeQuery = true,
            value = "select Count(Home_days)*homes.price as money,month " +
                    "from home_days " +
                    "join order on order.id=home_days.order_id " +
                    "join homes on order.home_id=homes.id " +
                    "join users on users.id=home.user_id " +
                    "GROUP BY DATE_FORMAT(day,'%Y-%m') as month where users.id=?1"
    )
    Iterable<MonthMoneyTable> printMonthMoneyTableByOwner(Long owner_id);
}
