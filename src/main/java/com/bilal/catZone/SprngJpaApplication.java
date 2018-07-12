package com.bilal.catZone;

import com.bilal.catZone.Seeders.Seeder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;


@SpringBootApplication
public class SprngJpaApplication implements CommandLineRunner {

    @Autowired
    Seeder seeder;




    @Autowired
    Environment environment;

    public static void main(String[] args) {
        SpringApplication.run(SprngJpaApplication.class, args);

    }

    @Override
    public void run(String... args) {
       seeder.seedOwnerData();
       seeder.seedCatData();
       seeder.seedOwnerCatsData();
        System.out.println(environment.getProperty("uploaded.cat.images"));
    }
}
