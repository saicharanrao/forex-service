package com.charan.learning.forexservice.repository;

import com.charan.learning.forexservice.domain.ExchangeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeRepositoryDAO extends
    JpaRepository<ExchangeEntity, Long> {
  ExchangeEntity findByFromAndTo(String from, String to);
}
