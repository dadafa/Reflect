                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               /**
 * 
 */
package com.xyd.demo01;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

/**
 * @author scott
 * @date 2017年12月27日下午2:20:42
 * @version
 * @description beanUtils 测试
 */
public class RelectDemo07 {

	public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {

		// 组装数据
		Map<String, String> map = new HashMap<>();
		map.put("age", "44");
		map.put("name", "tom");
		
		User user = new User();

		//给  user 中添加数据
		BeanUtils.populate(user, map);
		
		System.out.println(user);
		
		//设置 属性的值
		BeanUtils.setProperty(user, "age", 34);
		
		//获取属性值 
		String age = BeanUtils.getProperty(user, "age");
		
		System.out.println(age);
	}
}
