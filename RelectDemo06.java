/**
 * 
 */
package com.xyd.demo01;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.Properties;

/**
 * @author scott
 * @date 2017年12月27日上午10:58:46
 * @version 
 * @description  读取配置文件
 *                  properties
 *                  1.io流操作 读取文件
 *                  
 *                  2.通过反射api 创建对象 给对象赋值
 *                  
 */
public class RelectDemo06 {

	public static void main(String[] args) throws Exception {
		
		 //创建pro   pro 是 Hashtable 的子类  实现了Map的一些功能
		 Properties pro = new Properties();
		
		 //加载(读取)配置文件
		 try {
			 //src\test.properties (系统找不到指定的文件。) 文件错误
			pro.load(new BufferedReader(new FileReader("src/test.properties")));
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
		 //pro 的方法
		 // null 读取到有  空   key 出现了错误
		 String path = pro.getProperty("path");
		 String age = pro.getProperty("age");
		 String name = pro.getProperty("name");
		 
		 //反射
		 Class<User> clazz = (Class<User>) Class.forName(path);
		 
		 Constructor<User> cons = clazz.getConstructor(int.class,String.class);
//		 java.lang.IllegalArgumentException: argument type mismatch
		 
		 User u = cons.newInstance(Integer.valueOf(age),name);
		 System.out.println(u);
		 
	}
}
