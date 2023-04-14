package com.casestudymodule4.repository.home;

import com.casestudymodule4.model.home.type.HomeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IHomeTypeRepository extends JpaRepository<HomeType, Long> {
    Optional<HomeType> findByName(HomeType.TypeName name);
}
