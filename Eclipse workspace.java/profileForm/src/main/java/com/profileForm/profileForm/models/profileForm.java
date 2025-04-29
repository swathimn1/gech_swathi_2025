package com.profileForm.profileForm.models;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "profiles")
public class profileForm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String gender;
    private String color;
    private int fontSize;

    // ✅ Full-args constructor
    public profileForm(Long id, String name, String gender, String color, int fontSize) {
        super();
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.color = color;
        this.fontSize = fontSize;
    }

    // ✅ No-args constructor
    public profileForm() {
        super();
    }

    // ✅ Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getFontSize() {
        return fontSize;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    // ✅ toString()
    @Override
    public String toString() {
        return "profileForm{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", color='" + color + '\'' +
                ", fontSize=" + fontSize +
                '}';
    }
}
