package com.charan.learning.forexservice.controller;

import com.charan.learning.forexservice.domain.ExchangeEntity;
import com.charan.learning.forexservice.repository.ExchangeRepositoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ForexController {

  @Autowired
  private Environment environment;

  @Autowired
  private ExchangeRepositoryDAO repository;

  @GetMapping("/currency-exchange/from/{from}/to/{to}")
  public ExchangeEntity retrieveExchangeValue
      (@PathVariable String from, @PathVariable String to) {

    ExchangeEntity exchangeValue =
        repository.findByFromAndTo(from, to);

    exchangeValue.setPort(
        Integer.parseInt(environment.getProperty("local.server.port")));

    return exchangeValue;
  }
}
