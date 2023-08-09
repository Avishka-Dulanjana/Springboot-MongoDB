package com.springmongo.springbootmongodbcrud.repository;

import com.springmongo.springbootmongodbcrud.entity.Expenses;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ExpensesRepository extends MongoRepository<Expenses, String> {
    @Query("{'name': ?0}")
    Optional<Expenses> findByName(String name);
}
