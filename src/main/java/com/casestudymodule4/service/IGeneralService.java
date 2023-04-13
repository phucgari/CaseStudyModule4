package com.casestudymodule4.service;

<<<<<<< HEAD
public interface IGeneralService<T> {
=======
import java.util.Optional;

public interface IGeneralService<T> {
    Iterable<T> findAll();

    Optional<T> findById(Long id);

    T save(T t);

    void remove(Long id);
>>>>>>> 3ad399cf3995fec439fd21b131a52e29dd8e50b2
}
