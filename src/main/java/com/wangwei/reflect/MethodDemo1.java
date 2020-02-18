package com.wangwei.reflect;

import java.lang.reflect.Method;

public class MethodDemo1 {
	public static void main(String[] args) {
		A a1 = new A();
		Class c = a1.getClass();

	    try {
			/**
			 * 获取方法 名称和参数列表来决定
			 * c.getMethod获取的是public的方法
			 * c.getDeclaredMethod() 获取自己声明的方法
			 *
			 */
			//Method m = c.getMethod("print", new Class[]{int.class,int.class});
			Method m = c.getMethod("print", int.class,int.class);
			// 方法反射操作是用m对象来进行方法调用和a1.print调用效果一样
	    	//Object o = m.invoke(a1, new Object[]{10, 20});
	    	Object o = m.invoke(a1, 10,20);
	    	System.out.println("==================");
             Method m1 = c.getMethod("print",String.class,String.class);
             //a1.print("hello", "WORLD");
             o = m1.invoke(a1, "hello","WORLD");
             System.out.println("===================");
           //  Method m2 = c.getMethod("print", new Class[]{});
                Method m2 = c.getMethod("print");
               // m2.invoke(a1, new Object[]{});
                m2.invoke(a1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
     
	}
}
class A{
	public void print(){
		System.out.println("helloworld");
	}
	public void print(int a,int b){
		System.out.println(a+b);
	}
	public void print(String a,String b){
		System.out.println(a.toUpperCase()+","+b.toLowerCase());
	}
}
