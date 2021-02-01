package com.hut.djh;

/**
 * @author HP
 * @data 2021-01-30
 */
public class Test_Main {

    //属性字段
    public String name = "Paige";
    public static int id = 147;
    private int age = 5;

    //方法
    public void m1(){
        System.out.println("m1");
    }

    public void m2(String name){
        System.out.println(name);
    }

    private  void m3() {
        System.out.println("m3");
    }

    public String m4(String name ,int age){
        return name+age;
    }

    public static void m5(){
        System.out.println("m5");
    }

    //构造函数
    public Test_Main(String name) {
        this.name = name;
        System.out.println("name: "+name);
    }

    public Test_Main() {
        System.out.println("无参构造方法");
    }

    public Test_Main(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("name: "+name+" age: "+age);
    }

}
