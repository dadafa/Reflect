/**
 * 
 */
package com.xyd.demo01;

import java.lang.reflect.Constructor;

/**
 * @author scott
 * @date 2017年12月27日上午9:38:18
 * @version 
 * @description  通过Class 对象  来获取 类的信息（获取构造器的信息）
 */
public class RelectDemo02 {

	public static void main(String[] args) throws Exception {
		
		Class<User> clazz = (Class<User>) Class.forName("com.xyd.demo01.User");
		
		//获取  构造器的信息 getConstructors();
		Constructor<User>[] constructors = (Constructor<User>[]) clazz.getConstructors();
		
		for (Constructor<User> constructor : constructors) {
		
			//getName()  获取名字       getParameterCount() 获取参数的个数  
			System.out.println(constructor.getName() + " " + constructor.getParameterCount());
		}
		
		//获取 具体的对应参数的构造器
		Constructor<User> con1 = clazz.getConstructor(int.class,String.class);
		
		System.out.println(con1.getName() + " " + con1.getParameterCount());
		
		//获取无参的构造
		Constructor<User> con2 = clazz.getConstructor();
		System.out.println(con2.getName() + " " + con2.getParameterCount());
		
	}
}
