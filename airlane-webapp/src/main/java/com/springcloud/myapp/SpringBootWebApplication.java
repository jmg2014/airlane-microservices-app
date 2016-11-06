package com.springcloud.myapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringBootWebApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringBootWebApplication.class, args);
  }
  
  @LoadBalanced
  @Bean
  public RestTemplate loadRestTemplate() {
      return new RestTemplate();
  }
}
