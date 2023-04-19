package com.casestudymodule4.service.status;

import com.casestudymodule4.model.home.order.Status;
import com.casestudymodule4.service.IGeneralService;

import java.util.Optional;

public interface IStatusService extends IGeneralService<Status> {
    Optional<Status> findByName(Status.StatusType name);
}
