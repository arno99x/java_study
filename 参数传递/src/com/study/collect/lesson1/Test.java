package com.study.collect.lesson1;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {

        //类型：基本类型
        //结果：不变
        //原因：XXXXXxXXXXXXX
        int a = 1;
        int b = 2;
        update(a,b);
        System.out.println("a : "+a+" ; b : "+b);

        //类型：包装类型
        //结果：不变
        //原因：
        Integer aa = 1;
        Integer bb = 2;
        update(aa,bb);
        System.out.println("aa : "+aa+" ; bb : "+bb);

        //类型：集合类型
        //结果：改变了
        //原因：
        List<Integer> aaa = new ArrayList<>();
        List<Integer> bbb = new ArrayList<>();
        update(aaa,bbb);
        System.out.println("aaa.size() : "+aaa.size()+" ; bbb.size() : "+bbb.size());

        //类型：自定义类
        //结果：改变了
        //原因：
        User user = new User();
        user.setAge("17");
        user.setName("arno");
        user.setSex("男");
        update(user);
        System.out.println(user.toString());


        /**
         * 结论：
         */

    }

    private static void update(int a , int b){
        a = 11;
        b = 22;
    }

    private static void update(Integer a , Integer b){
        a = 11;
        b = 22;
    }

    private static void update(List<Integer> a , List<Integer> b){
        a.add(11);
        b.add(22);
    }

    private static void update(User user){
        user.setSex("女");
    }

    public static class User{
        private String name;
        private String age;
        private String sex;

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

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age='" + age + '\'' +
                    ", sex='" + sex + '\'' +
                    '}';
        }
    }
}
