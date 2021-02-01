package com.hut.djh;

import org.junit.Test;

import java.lang.reflect.Field;

/**
 * @author HP
 * @data 2021-02-02
 * 反射属性
 */
public class Reflection {

    /*
    属性字段
    public String name = "Paige";
    public static int id = 147;
    private int age = 5;
     */

    @Test
    public void test1() throws Exception{
        Class tClass = Class.forName("com.hut.djh.Test_Main");
        Test_Main test_main = (Test_Main) tClass.newInstance(); //新建实例

        Field field1 = tClass.getField("name"); //获取属性
        String returnValue = (String) field1.get(test_main); //通过get获取属性
        System.out.println(returnValue); //打印出：Paige

        field1.set(test_main,"tom"); //set修改属性
        System.out.println(field1.get(test_main)); //打印出：tom

        Field field2 = tClass.getDeclaredField("age");
        field2.setAccessible(true); //private属性同样需要强制访问
        System.out.println(field2.get(test_main)); //打印出：5

        Field field3 = tClass.getField("id");
        System.out.println(field3.get(null)); //static 同样不需要实例，设置为null即可 //打印出：147


    }
}
