package com.casestudymodule4.repository;

import com.casestudymodule4.model.Picture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPictureRepository extends JpaRepository<Picture, Long> {
}
