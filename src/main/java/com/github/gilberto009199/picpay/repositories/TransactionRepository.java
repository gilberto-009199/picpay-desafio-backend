package com.github.gilberto009199.picpay.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.github.gilberto009199.picpay.entities.TransactionEntity;

@Repository
public interface TransactionRepository extends ListCrudRepository<TransactionEntity, Long> {}
