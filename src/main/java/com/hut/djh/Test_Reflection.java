package com.hut.djh;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @author HP
 * @data 2021-01-30
 * 反射方法
 */
public class Test_Reflection {
    //三种获取Class类的方法


    /*  m1() 无参方法
        public void m1(){
        System.out.println("m1");
    }
     */
    @Test
    public void test1() throws Exception{
        Class tClass = Class.forName("com.hut.djh.Test_Main");
        Test_Main test_main = (Test_Main)tClass.newInstance(); //新建实例
        Method m1 = tClass.getMethod("m1",null); //输入类型空值
        m1.invoke(test_main,null); //调用实例和输入值
    }

    /*  m2():
        public void m2(String name){
        System.out.println(name);
    }
     */
    @Test
    public void test2() throws Exception{
        Class tClass = Test_Main.class;
        Test_Main test_main = (Test_Main)tClass.newInstance();
        Method m2 = tClass.getMethod("m2", String.class);
        m2.invoke(test_main,"tom");//输出tom
    }
    /*
    private void m3(){
        System.out.println("m3");
    }
     */
    @Test
    public void test3() throws Exception{
        Class tClass = new Test_Main().getClass();
        Test_Main test_main = (Test_Main)tClass.newInstance(); //新建实例
        Method m3 = tClass.getDeclaredMethod("m3",null); //强制访问
        m3.setAccessible(true); //设置访问标志位为 True
        m3.invoke(test_main,null);
    }

    /*
        public String m4(String name ,int age){
        return name+age;
    }
     */
    @Test
    public void test4() throws Exception{
        Class tClass = Class.forName("com.hut.djh.Test_Main");
        Test_Main test_main = (Test_Main) tClass.newInstance();
        Method m4 = tClass.getMethod("m4", String.class, int.class);
        String returnValue = (String) m4.invoke(test_main,"jerry",5); //返回类型
        System.out.println(returnValue); //打印jerry5
    }

    /*  static 方法
        public static void m5(){
        System.out.println("m5");
    }
     */
    @Test
    public void test5() throws Exception{
        Class tClass = Class.forName("com.hut.djh.Test_Main");
        Method m5 = tClass.getMethod("m5",null); //没有返回值
        m5.invoke(null,null); // 没有实例化对象，无输入参数 打印m5
    }
    /*
        public Test_Main() {
        System.out.println("无参构造方法");
    }
     */
    @Test
    public void test_constructor1() throws Exception{
        Class tClass = Class.forName("com.hut.djh.Test_Main");
        Constructor constructor1 = tClass.getConstructor(null); //得到无参构造函数
        constructor1.newInstance(null); //用构造方法创建对象
    }
    /*
        public Test_Main(String name) {
        this.name = name;
        System.out.println("name:"+name);
    }
     */
    @Test
    public void test_constructor2() throws Exception{
        Class tClass = Class.forName("com.hut.djh.Test_Main");
        Constructor constructor1 = tClass.getConstructor(String.class); //得到String构造函数
        constructor1.newInstance("tomas"); //用构造方法创建对象,输出name: tomas
    }

    /*
    public Test_Main(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("name: "+name+" age: "+age);
    }
 */
    @Test
    public void test_constructor3() throws Exception{
        Class tClass = Class.forName("com.hut.djh.Test_Main");
        Constructor constructor1 = tClass.getConstructor(String.class,int.class); //得到String、int构造函数
        constructor1.newInstance("tomas",58); //用构造方法创建对象，输出name: tomas age: 58
    }
}
