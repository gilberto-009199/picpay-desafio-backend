package com.github.gilberto009199.picpay.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.github.gilberto009199.picpay.entities.WalletEntity;

@Repository
public interface WalletRepository extends JpaRepository<WalletEntity, Long>{}
