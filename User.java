/**
 * 
 */
package com.xyd.demo01;

/**
 * @author scott
 * @date 2017年12月27日上午9:28:56
 * @version 
 * @description 
 */
public class User {
	
	public double salary;
	
	private int age;
	
	private String name;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	private void test01(String msg) {
		System.out.println(msg);
	}
	
	private void test02(String msg) {
		System.out.println(msg);
	}

	public User(int age, String name) {
		this.age = age;
		this.name = name;
	}
	
	public User() {
	}

}
