/**
 * 
 */
package com.xyd.demo01;

import java.lang.reflect.Field;

/**
 * @author scott
 * @date 2017年12月27日上午9:47:03
 * @version 
 * @description  通过Class 对象  来获取 类的信息（获取属性的信息）
 */
public class RelectDemo03 {

	public static void main(String[] args) throws Exception {
		
		Class<User> clazz = (Class<User>) Class.forName("com.xyd.demo01.User");
		
		//获取 所有属性的信息
		//不能获取私有属性   信息
		Field[] fields = clazz.getFields();
		
		System.out.println("不能获取私有属性   信息");
		for (Field field : fields) {
			System.out.println(field.getName());
		}
		
		System.out.println("所有的属性信息... ");
		//暴力获取 所有的属性信息
		Field[] declaredFields = clazz.getDeclaredFields();
		
		for (Field field : declaredFields) {
			System.out.println(field.getName());
		}
		
		//可以获取 某个具体的 属性的信息
		Field field = clazz.getDeclaredField("age");
		
		System.out.println(field);
	}
}
