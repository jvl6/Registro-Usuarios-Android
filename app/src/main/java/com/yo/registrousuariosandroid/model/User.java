package com.yo.registrousuariosandroid.model;

public class User {
    private String name, surname, rut, favoriteDrink;
    private int age;
    private boolean isF;

    public User() {

    };

    public User(String name, String surname, String rut, String favoriteDrink, int age, boolean isF) {
        this.name = name;
        this.surname = surname;
        this.rut = rut;
        this.favoriteDrink = favoriteDrink;
        this.age = age;
        this.isF = isF;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getFavoriteDrink() {
        return favoriteDrink;
    }

    public void setFavoriteDrink(String favoriteDrink) {
        this.favoriteDrink = favoriteDrink;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isF() {
        return isF;
    }

    public void setF(boolean f) {
        isF = f;
    }
}
