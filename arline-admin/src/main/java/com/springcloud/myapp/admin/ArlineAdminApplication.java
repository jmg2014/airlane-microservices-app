package com.springcloud.myapp.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.codecentric.boot.admin.config.EnableAdminServer;

@SpringBootApplication
@EnableAdminServer
public class ArlineAdminApplication {

  public static void main(String[] args) {
    SpringApplication.run(ArlineAdminApplication.class, args);
  }
}
