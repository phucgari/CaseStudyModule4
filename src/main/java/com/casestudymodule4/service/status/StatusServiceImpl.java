package com.casestudymodule4.service.status;

import com.casestudymodule4.model.home.order.Status;
import com.casestudymodule4.repository.IStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StatusServiceImpl implements IStatusService {
    @Autowired
    private IStatusRepository iStatusRepository;

    @Override
    public Iterable<Status> findAll() {
        return iStatusRepository.findAll();
    }

    @Override
    public Optional<Status> findById(Long id) {
        return iStatusRepository.findById(id);
    }

    @Override
    public Status save(Status status) {
        return iStatusRepository.save(status);
    }

    @Override
    public void remove(Long id) {
        iStatusRepository.deleteById(id);
    }

    @Override
    public Optional<Status> findByName(Status.StatusType name) {
        return iStatusRepository.findByName(name);
    }
}
