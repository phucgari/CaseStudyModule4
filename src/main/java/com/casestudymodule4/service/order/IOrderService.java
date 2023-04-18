package com.casestudymodule4.service.order;

import com.casestudymodule4.model.DTO.MonthMoneyTable;
import com.casestudymodule4.model.home.order.Order;
import com.casestudymodule4.model.user.User;
import com.casestudymodule4.service.IGeneralService;
import org.springframework.data.jpa.repository.Query;

public interface IOrderService extends IGeneralService<Order> {
    Iterable<Order> findAllByOrderer(User user);

    Iterable<MonthMoneyTable> printMonthMoneyTableByOwner(User owner);

    boolean removeOrderBefore1Day(Order order);
}
