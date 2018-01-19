/**
 * 
 */
package com.xyd.demo01;

/**
 * @author scott
 * @date 2017年12月27日上午9:28:13
 * @version 
 * @description  如何获取Class 对象 ,一个类 只有一个对应Class 
 *    三种方式:
 *      Class.forName();
 *      
 *      类名.class
 *      
 *      用对象.getClass()
 *      
 */
public class RelectDemo01 {

	public static void main(String[] args) throws Exception {
		
		//Class.forName(全路径)  user 对应的class 对象
		Class<User> clazz = (Class<User>) Class.forName("com.xyd.demo01.User");
		System.out.println(clazz.hashCode());
		Class<User> c1 = User.class;
		System.out.println(c1.hashCode());
		
		Class<User> c2 = (Class<User>) new User().getClass();
		System.out.println(c2.hashCode());
		                                    
		Class<String> class1 = (Class<String>) "abc".getClass();
		                    // User.class;  类名 来获取class
		Class<String> class2 = String.class;
		
		System.out.println(class1.hashCode());
		System.out.println(class2.hashCode());
		
	}
}
