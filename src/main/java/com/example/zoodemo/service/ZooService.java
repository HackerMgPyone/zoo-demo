package com.example.zoodemo.service;

import com.example.zoodemo.dao.*;
import com.example.zoodemo.entity.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ZooService {
    private final AnimalDao animalDao;
    private final CageDao cageDao;
    private final CategoryDao categoryDao;
    private final FoodItemDao foodItemDao;
    private final SupplierDao supplierDao;


    @Transactional
    public void insertNewAnimal(){
        Category category = categoryDao.fetchCategory("WarmBlood");
        Animal animal = new Animal("Leopard",12);

        Cage cage = new Cage("E003","East");
        animal.setCage(cage);
        cage.setAnimal(animal);
        category.addAnimal(animal);
        categoryDao.save(category);
        animalDao.save(animal);

    }
    @Transactional
    public void removeLastAnimal(){
        Category category = categoryDao.fetchCategory("WarmBlood");
        List<Animal> animals = category.getAnimals();
        animals.remove(animals.size() - 1);
    }
    @Transactional
    public void createAnimalsWithCategory(){
        Category category = new Category();
//        category.setCategoryType("CoolBlood");
        category.setCategoryType("WarmBlood");

        Animal animal1 = new Animal("Lion",10);
        Animal animal2 = new Animal("Panda",25);

        Cage cage1 = new Cage("E002","East");
        Cage cage2 = new Cage("W002","West");

        //mapping

        animal1.setCage(cage1);
        cage1.setAnimal(animal1);
        animal2.setCage(cage2);
        cage2.setAnimal(animal2);

        category.addAnimal(animal1);
        category.addAnimal(animal2);

        categoryDao.save(category);
        animalDao.save(animal1);
        animalDao.save(animal2);

    }

    @Transactional
    public void createDb(){
        Category category = new Category();
        category.setCategoryType("Cool Blood");
        Category category1 = new Category();
        category1.setCategoryType("WarmBlood");
//        Category category1 = categoryDao.fetchCategory("WarmBlood");

        Animal animal1 = new Animal("Tiger",20);
        Animal animal2 = new Animal("Fish",100);
        Animal animal3 = new Animal("Monkey",50);
        Animal animal4 = new Animal("Dear",30);

        category1.addAnimal(animal1);
        category1.addAnimal(animal3);
        category1.addAnimal(animal4);

        category.addAnimal(animal2);

        Cage cage1 = new Cage("E001","East");
        Cage cage2 = new Cage("W001","West");
        Cage cage3 = new Cage("N001","North");
        Cage cage4 = new Cage("S001","South");

        Supplier supplier1 = new Supplier("Mg Mg","555-555-555","Mandalay");
        Supplier supplier2 = new Supplier("Aung Aung","000-000-000","Yangon");

        FoodItem foodItem1 = new FoodItem("Vege",20);
        FoodItem foodItem2 = new FoodItem("Grain",20);
        FoodItem foodItem3 = new FoodItem("Meat",40);
        FoodItem foodItem4 = new FoodItem("Egg",30);


        //mapping

        animal4.addFoodItem(foodItem1);
        animal4.addFoodItem(foodItem4);
        animal1.addFoodItem(foodItem3);
        animal2.addFoodItem(foodItem4);
        animal3.addFoodItem(foodItem1);
        animal3.addFoodItem(foodItem2);


        supplier1.addFoodItem(foodItem1);
        supplier1.addFoodItem(foodItem2);
        supplier2.addFoodItem(foodItem3);
        supplier2.addFoodItem(foodItem4);


        cage1.setAnimal(animal1);
        cage2.setAnimal(animal2);
        cage3.setAnimal(animal3);
        cage4.setAnimal(animal4);

        animal1.setCage(cage1);
        animal2.setCage(cage2);
        animal3.setCage(cage3);
        animal4.setCage(cage4);

        cageDao.save(cage1);
        cageDao.save(cage2);
        cageDao.save(cage3);
        cageDao.save(cage4);

        animalDao.save(animal1);
        animalDao.save(animal2);
        animalDao.save(animal3);
        animalDao.save(animal4);


        supplierDao.save(supplier1);
        supplierDao.save(supplier2);

        categoryDao.save(category);
        categoryDao.save(category1);
    }
}
