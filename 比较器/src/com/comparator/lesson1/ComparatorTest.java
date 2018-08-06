package com.comparator.lesson1;

import java.util.ArrayList;
import java.util.List;

public class ComparatorTest {
    public static void main(String[] args) {
        List<Human> humans = new ArrayList<>();
        humans.add(new Human("tomy", "22"));
        humans.add(new Human("li", "25"));
        humans.add(new Human("lee", "21"));

        //JAVA8比较器简单霸气
        humans.sort((Human h1, Human h2) -> h1.getAge().compareTo(h2.getAge()));
        System.out.println(humans.toString());
    }


}
 class Human{
    private String name;
    private String age;
    public Human(String name,String age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

     @Override
     public String toString() {
         return "Human{" +
                 "name='" + name + '\'' +
                 ", age='" + age + '\'' +
                 '}';
     }
 }
