package com.example.springdata.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * @author Oksiuta Andrii
 * 26.01.2023
 * 10:46
 */
@RestController
@RequestMapping("ping")
@RequiredArgsConstructor
@Slf4j
public class PingRestController {

  @GetMapping
  public String ping() {
    log.info("PING");
    return "Ok";
  }
}
