/**
 * 
 */
package com.xyd.demo01;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author scott
 * @date 2017年12月27日上午10:33:38
 * @version 
 * @description  拿到构造器  如何操作
 * 
 *               同 class 对象拿到 构造器  （Constructor）
 *               可以通过反射api (Constructor 中的方法 操作构造器)
 *               
 *               clas 对象拿到 属性（Filed）
 *               可以同 通过反射api  (Filed 中的方法 操作属性)
 *               
                  
 */
public class RelectDemo05 {

	public static void main(String[] args) throws Exception {
		
		Class<User> clazz =(Class<User>) Class.forName("com.xyd.demo01.User");
		
//		testConstructor(clazz);
		
//		testField(clazz);
		
		testMethod(clazz);
	}

	private static void testMethod(Class<User> clazz)
			throws Exception {
		/**
		 * test01 方法的名字
		 * parameterTypes  方法参数类型
		 */
		User u1 = clazz.newInstance();
		Method method = clazz.getDeclaredMethod("test01", String.class);
		/**
		 * invoke 执行拿到的方法
		 * obj  执行那个对象的方法
		 * args 方法的参数
		 */
		//跳过 权限检查 Class com.xyd.demo01.RelectDemo05 can not access a member of class com.xyd.demo01.User with modifiers "private"
		method.setAccessible(true);
		method.invoke(u1, "反射方法的操作和属性操作一样");
		
		//拿到方法的对象
		Method setAge = clazz.getDeclaredMethod("setAge", int.class);
		setAge.invoke(u1, 45);
		System.out.println(u1);
	}

	/*
	 * 反射api 操作 属性 
	 */
	private static void testField(Class<User> clazz)
			throws InstantiationException, IllegalAccessException, NoSuchFieldException {
		User u1 = clazz.newInstance();
		
		//field 是属性的对象
		Field field = clazz.getDeclaredField("age");
		
		/**
		 * obj   你要操作的是那个对象
		 * value 你操作的属性的值是多少
		 */
		//跳过权限的检查   （默认是false）
		field.setAccessible(true);
		//操作属性
//		field.set(u1, 34);  
		field.setInt(u1, 44);
		System.out.println(u1);
	}

	/**
	 * 反射api 操作  构造器
	 */
	private static void testConstructor(Class<User> clazz)
			throws Exception {
		//拿到构造器 操作
		
		//直接默认调用了 空构造器
		User u1 = clazz.newInstance();
		u1.setAge(45);
		System.out.println(u1);
		
	    //获取空构造
		Constructor<User> cons1 = clazz.getConstructor();
		User u2 = cons1.newInstance();
		u2.setAge(56);
		System.out.println(u2);
		
		//获取有参构造器  
		Constructor<User> cons2 = clazz.getConstructor(int.class,String.class);
		
		User u3 = cons2.newInstance(45,"马云");
		System.out.println(u3);
	}
}
