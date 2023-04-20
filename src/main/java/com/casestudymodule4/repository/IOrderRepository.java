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
            value = "select sum(money) as money,month\n" +
                    "from\n" +
                    "    (select count(day)*price as money,DATE_FORMAT(day,'%Y-%m') as month\n" +
                    "     from home_days\n" +
                    "         join status on home_days.status_id = status.id\n" +
                    "         join homes on home_days.home_id=homes.id\n" +
                    "         join users on users.id=homes.user_id\n" +
                    "     where users.id=?1 and status.name like 'ORDERED'\n" +
                    "     GROUP BY homes.id,DATE_FORMAT(day,'%Y-%m')) as subquery\n" +
                    "GROUP BY month"
    )
    Iterable<MonthMoneyTable> printMonthMoneyTableByOwner(Long owner_id);
}
