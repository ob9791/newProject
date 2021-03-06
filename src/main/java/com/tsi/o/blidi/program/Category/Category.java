package com.tsi.o.blidi.program.Category;

import javax.persistence.*;

@Entity
@Table(name = "category")

public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="category_id")

    private int categoryId;
    private String name;

    public Category(int categoryId, String name){
        this.categoryId = categoryId;
        this.name = name;
    }

    public Category(){}

    // Getters n settes


    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


