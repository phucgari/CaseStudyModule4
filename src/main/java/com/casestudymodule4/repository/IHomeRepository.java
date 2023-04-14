package com.casestudymodule4.repository;

import com.casestudymodule4.model.home.Home;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHomeRepository extends JpaRepository<Home,Long> {
}
