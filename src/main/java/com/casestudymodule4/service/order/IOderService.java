package com.casestudymodule4.service.order;

import com.casestudymodule4.model.home.order.Order;
import com.casestudymodule4.model.user.User;
import com.casestudymodule4.service.IGeneralService;

public interface IOderService extends IGeneralService<Order> {
    Iterable<Order> findAllByOrderer(User user);
}
