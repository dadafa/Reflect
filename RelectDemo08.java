/**
 * 
 */
package com.xyd.demo01;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @author scott
 * @date 2017年12月27日下午2:06:44
 * @version 
 * @description   map - > 对象 
 *               反射:
 *                  
 *                  
 */
public class RelectDemo08 {
	
	public static void main(String[] args) throws Exception {
		
		//组装数据
		Map<String, String> map = new HashMap<>();
		map.put("age", "44");
		map.put("name", "tom");
		Class<User> clazz =(Class<User>) Class.forName("com.xyd.demo01.User");
		
		User u = getBean(clazz,map);
		System.out.println(u);
		
	}

	private static <T> T getBean(Class<T> clazz, Map<String, String> map) throws Exception {
		
		T t = clazz.newInstance(); 
		
		Set<Entry<String, String>> entrySet = map.entrySet();
		
		for (Entry<String, String> entry : entrySet) {
			String key = entry.getKey();
			String value = entry.getValue();
			
			//通过反射 拿到属性
			Field field = clazz.getDeclaredField(key);
			
			//可以获取属性的修饰符   如果是private 就设置 跳过权限检查
//			int modifiers = field.getModifiers();
//			System.out.println(modifiers);
			
			field.setAccessible(true);
			
			Class type = field.getType();
			
			if (type == int.class) { //类型要匹配 int
				field.set(t, Integer.valueOf(value));
			}else if (type == String.class) {
				field.set(t,value);
			}
		}
		return t;
	}
}
