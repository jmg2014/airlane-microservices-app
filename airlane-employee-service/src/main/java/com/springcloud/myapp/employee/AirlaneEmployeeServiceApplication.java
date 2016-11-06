package com.springcloud.myapp.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AirlaneEmployeeServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(AirlaneEmployeeServiceApplication.class, args);
  }
}
