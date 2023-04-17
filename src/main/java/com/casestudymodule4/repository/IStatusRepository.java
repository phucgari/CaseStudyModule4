package com.casestudymodule4.repository;

import com.casestudymodule4.model.home.order.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IStatusRepository extends JpaRepository<Status, Long> {
    Optional<Status> findByName(Status.StatusType type);
}
