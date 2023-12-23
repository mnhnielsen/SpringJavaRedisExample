package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Model.Reservation;
import repository.ReservationDao;

@SpringBootApplication()
@EnableAutoConfiguration
@ComponentScan("repository")
@RestController
@RequestMapping("/reservation")
public class DemoApplication {

	@Autowired
	private ReservationDao dao;

	@PostMapping
    public Reservation save(@RequestBody Reservation reservation) {
        return dao.save(reservation);
    }

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
