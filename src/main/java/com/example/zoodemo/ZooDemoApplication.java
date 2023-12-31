package com.example.zoodemo;

import com.example.zoodemo.service.ZooService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class ZooDemoApplication implements CommandLineRunner {
    private final ZooService zooService;

    @Override
    public void run(String... args) throws Exception {
        zooService.createDb();
       // zooService.createAnimalsWithCategory();
        //zooService.insertNewAnimal();
        //zooService.removeLastAnimal();
        JPAUtil.checkData("select * from cage");
        JPAUtil.checkData("select * from animal");
        JPAUtil.checkData("select * from category");
        JPAUtil.checkData("select * from supplier");
        JPAUtil.checkData("select * from food_item");
        JPAUtil.checkData("select * from food_item_animals");



    }

    public static void main(String[] args) {
        SpringApplication.run(ZooDemoApplication.class, args);
    }

}
