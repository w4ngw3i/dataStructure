package com.wangwei.reflect;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class MethodDemo4 {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		
		ArrayList<String> list1 = new ArrayList<String>();
		list1.add("hello");
		//list1.add(20);
		Class c1 = list.getClass();
		Class c2 = list1.getClass();
		System.out.println(c1 == c2);
		// 反射的操作都是编译之后的操作
		try {
			/**
			 * java中集合的泛型，是防止错误输入的，只在编译阶段有效
			 * 绕过编译之后就无效了
			 * 验证：我们可以通过方法的反射来操作，绕过编译
			 */
			Method m = c2.getMethod("add", Object.class);
			m.invoke(list1, 20);//
			System.out.println(list1.size());
			System.out.println(list1);
		} catch (Exception e) {
		  e.printStackTrace();
		}
	}

}
