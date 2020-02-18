package com.wangwei.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassUtil {

	/**
	 * 打印类的信息，包括类的成员函数，成员变量
	 * @param obj
	 */
	public static void printClassMethodMessage(Object obj){
		// 获取类的类类型
		Class c = obj.getClass(); //传的是哪个子类的对象，c就是改类的类类型
		System.out.println("类的名称:"+c.getName());

		/**
		 * Method类 方法对象
		 * 一个成员方法就是一个Method对象
		 * getMethods()获取的是所有public的函数，包括父类继承而来的
		 * getDeclaredMethods()获取的是所有该类自己声明的方法，不问访问权限
		 */
		Method[] ms = c.getMethods();//c.getDeclaredMethods()
		for(int i = 0; i < ms.length;i++){
			// 得到方法返回类型的类类型
			Class returnType = ms[i].getReturnType();
			// 方法返回类型名称
			System.out.print(returnType.getName()+" ");
			// 方法名称
			System.out.print(ms[i].getName()+"(");
			// 获取该方法的所有类型
			Class[] paramTypes = ms[i].getParameterTypes();
			for (Class class1 : paramTypes) {
				// 方法参数类型名称
				System.out.print(class1.getName()+",");
			}
			System.out.println(")");
		}
	}


	public static void printFieldMessage(Object obj) {
		Class c = obj.getClass();
		//Field[] fs = c.getFields();
		Field[] fs = c.getDeclaredFields();
		for (Field field : fs) {
			Class fieldType = field.getType();
			String typeName = fieldType.getName();
			String fieldName = field.getName();
			System.out.println(typeName + " " + fieldName);
		}
	}


	public static void printConMessage(Object obj){
		Class c = obj.getClass();

		//Constructor[] cs = c.getConstructors();
		Constructor[] cs = c.getDeclaredConstructors();
		for (Constructor constructor : cs) {
			System.out.print(constructor.getName()+"(");
			Class[] paramTypes = constructor.getParameterTypes();
			for (Class class1 : paramTypes) {
				System.out.print(class1.getName()+",");
			}
			System.out.println(")");
		}
	}
}
