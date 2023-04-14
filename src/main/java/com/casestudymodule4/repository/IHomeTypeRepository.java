package com.casestudymodule4.repository;

import com.casestudymodule4.model.home.type.HomeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHomeTypeRepository extends JpaRepository<HomeType, Long> {
}
