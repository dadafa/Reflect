/**
 * 
 */
package com.xyd.demo01;

import java.lang.reflect.Method;

/**
 * @author scott
 * @date 2017年12月27日上午9:54:04
 * @version
 * @description  通过Class 对象  来获取 类的信息（获取方法的信息）
 */
public class RelectDemo04 {

	public static void main(String[] args) throws Exception {

		Class<User> clazz = (Class<User>) Class.forName("com.xyd.demo01.User");
		
		//获取所有的方法
		Method[] declaredMethods = clazz.getDeclaredMethods();
		
		for (Method method : declaredMethods) {
			System.out.println(method.getName());
		}
		
		System.out.println("********获取具体的某个方法********");
		//获取具体的某个方法 name 方法名称           方法的参数 
		Method declaredMethod = clazz.getDeclaredMethod("setAge", int.class);
		//获取方法的名字
		String name = declaredMethod.getName();
		System.out.println(name);
		
		//获取方法的参数个数
		int parameterCount = declaredMethod.getParameterCount();
		System.out.println(parameterCount);
	}
}
