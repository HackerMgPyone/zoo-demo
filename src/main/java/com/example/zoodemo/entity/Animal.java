package com.example.zoodemo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/*
1.directionality - uni, bi
2.ownership - who is owner(fk pai tae table)
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Animal extends IdClass{
    private String type;
    private int totalNum;

    @OneToOne (mappedBy = "animal",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Cage cage;
    @ManyToOne
    private Category category;
    @ManyToMany(mappedBy = "animals")
    private List<FoodItem> foodItems =
            new ArrayList<>();

    public void addFoodItem(FoodItem foodItem){
        foodItem.getAnimals().add(this);
        foodItems.add(foodItem);
    }

    public Animal(String type, int totalNum) {
        this.type = type;
        this.totalNum = totalNum;
    }
}
