package com.pet.survery.fastjson;

import com.alibaba.fastjson.serializer.PropertyFilter;
import com.alibaba.fastjson.serializer.ValueFilter;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 *	JSON序列化过滤器
 * @author ZBW-dsigner
 */
public class JsonSerializerFilter {

	/** 日期强制转为时间戳 */
	public static final ValueFilter DATE_TO_TIMESTAMP = new ValueFilter() {
		@Override
		public Object process(Object object, String name, Object value) {
			if (value != null && value instanceof Date) {
				return ((Date)value).getTime();
			}
			return value;
		}
	};

	//过滤前端无用字段
	public static final PropertyFilter IGNORE_KEY = new PropertyFilter() {
		Set<String> ignoreKeys = new HashSet<String>(
				Arrays.asList("isLocked", "lockDate", "lockKey", "lockUser", "md5", "tenantId", "version"));

		@Override
		public boolean apply(Object object, String name, Object value) {
			if(ignoreKeys.contains(name)){
				//false表示该字段将被排除在外
				return false;
			}
			return true;
		}
	};
	
  
}