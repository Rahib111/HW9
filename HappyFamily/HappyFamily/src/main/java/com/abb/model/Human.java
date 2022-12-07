package com.abb.model;

import com.abb.enums.DayOfWeek;

import java.util.Arrays;
import java.util.Map;

public class Human {
    private String name;
    private String surname;
    private Integer year;
    private Integer iq;
    private Pet pet;
    private Human mother;
    private Human father;
    private Map<DayOfWeek, String> schedule;

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

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getIq() {
        return iq;
    }

    public void setIq(Integer iq) {
        this.iq = iq;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public Map<DayOfWeek, String> getSchedule ()
    {
        return schedule;
    }

    public void setSchedule (Map<DayOfWeek, String> schedule)
    {
        this.schedule = schedule;
    }

    public Human (String name, String surname, Integer year) {
        this.name = name;
        this.surname = surname;
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Human))//o == int
            return false;

        Human human = (Human) o;

        if (!this.name.equals(human.getName()))
            return false;
        if (!this.surname.equals(human.surname))
            return false;
        if (!this.year.equals(human.year))
            return false;

        return true;
    }

    public Human(String name, String surname, Integer year, Human mother, Human father) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.mother = mother;
        this.father = father;
    }

    public Human (String name, String surname, Integer year, Integer iq, Pet pet, Human mother, Human father,
            Map<DayOfWeek, String> schedule)
    {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.iq = iq;
        this.pet = pet;
        this.mother = mother;
        this.father = father;
        this.schedule = schedule;
    }

    public Human () {
    }

    public void greetPet() {
        System.out.println("Hello, " + pet.getNickname());
    }

    public void describePet() {
        System.out.println("I have a " + pet.getSpecies() + ", he is " + pet.getAge() + " years old, he is " + getTrickLevel());
    }

    private String getTrickLevel() {
        if (pet.getTrickLevel() > 50)
            return "very sly";

        return "almost sly";
    }

    @Override
    public String toString() {
        return "Human{\n" +
                "   name='" + name + '\'' + ",\n" +
                "   surname='" + surname + '\'' + ",\n" +
                "   year=" + year + ",\n" +
                "   iq=" + iq + ",\n" +
                "   pet=" + pet + ",\n" +
                "   mother=" + mother + ",\n" +
                "   father=" + father + ",\n" +
                "   schedule=" + schedule + '\n' +
                '}';
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Human finalize method was called!");
        super.finalize();
    }
}
