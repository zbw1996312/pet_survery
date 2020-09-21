package com.pet.survery.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.pet.survery.fastjson.JsonSerializerFilter;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class JsonUtils {
	static Logger logger = LoggerFactory.getLogger(JsonUtils.class);

	public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

	/**
	 * 是否为Json格式
	 * @param str
	 * @return
	 */
	public static boolean isJsonString(String str) {
		try {
			if(StringUtils.isBlank(str)) {
				logger.warn("\nJSON为空");
				return false;
			}

			if(!str.startsWith("{")||!str.endsWith("}")) {
				logger.warn("\n不是JSON， str格式不是{}");
				return false;
			}
			JSONObject.parse(str);
			return true;
		} catch (Exception e) {
			logger.warn("\n不是JSON， json解析异常", e);
			return false;
		}
	}

	/**
	 * 获取String根据Path
	 * @param json
	 * @param path 路径key (如body.success)
	 * @return
	 */
	public static String getStringByPath(String json, String path){
		String result = null;
		try {
			Object o = JSONPath.eval(json, "$."+path);
			result = o==null? null : o.toString();
		}catch (Exception e){
			logger.warn("\n\t getStringByPath异常", e);
		}
		return result;
	}

	/**
	 * 转为json对象
	 * @param obj
	 * @return
	 */
	public static JSONObject toJsonObject(Object obj){
		return JSONObject.parseObject(toJsonString(obj));
	}

	/**
	 * JSONString（Date强制转为时间戳）
	 * @param obj
	 * @return
	 */
	public static String toJSONStringWithDateToTimestamp(Object obj) {
		//特性
		SerializerFeature[] features = new SerializerFeature[]{
				//输出值为null的字段
				SerializerFeature.WriteMapNullValue,
				//消除对同一对象循环引用的问题
				SerializerFeature.DisableCircularReferenceDetect,
				//List字段如果为null,输出为[],而非null
				SerializerFeature.WriteNullListAsEmpty
		};

		if(OSUtils.isWindows()){
			//fastjson windows上 ValueFilter有bug  先不强转时间戳
//			filters = new SerializeFilter[]{
////					//忽略某些无用字段
////					JsonSerializerFilter.IGNORE_KEY
////			};
			return JSON.toJSONString(obj, features);
		}else {
			SerializeFilter[] filters = new SerializeFilter[]{
					//Date转为时间戳
					JsonSerializerFilter.DATE_TO_TIMESTAMP,
					//忽略某些无用字段
					JsonSerializerFilter.IGNORE_KEY
			};

			return JSON.toJSONString(obj, filters, features);
		}

	}

	/**
	 * JSONString
	 * @param obj
	 * @return
	 */
	public static String toJsonString(Object obj) {
		//返回null的值 ；时间自定义格式化
		//JSON.DEFFAULT_DATE_FORMAT = DEFAULT_DATE_FORMAT;
		//WriteMapNullValue	是否输出值为null的字段,默认为false
		//DisableCircularReferenceDetect	消除对同一对象循环引用的问题，默认为false
		//WriteNullListAsEmpty	List字段如果为null,输出为[],而非null
		//WriteDateUseDateFormat	全局修改日期格式,默认为false。JSON.DEFFAULT_DATE_FORMAT = “yyyy-MM-dd”;JSON.toJSONString(obj, SerializerFeature.WriteDateUseDateFormat);

		return JSON.toJSONString(obj,
				SerializerFeature.WriteMapNullValue,
				SerializerFeature.DisableCircularReferenceDetect,
				//SerializerFeature.WriteDateUseDateFormat,
				SerializerFeature.WriteNullListAsEmpty);
	}

	/**
	 * 获取bollean根据Path
	 * @param json
	 * @param path 路径key (如body.success)
	 * @return
	 */
	public static boolean getBooleanValueByPath(String json, String path){
		boolean result = false;
		try {
			Object o = JSONPath.eval(json, "$."+path);
			if(o!=null){
				result = Boolean.valueOf(o.toString());
			}
		}catch (Exception e){
			logger.warn("\n\t getStringByPath异常", e);
		}
		return result;
	}

	/**
	 * 获取long根据Path
	 * @param json
	 * @param path 路径key (如body.success)
	 * @return
	 */
	public static long getLongValueByPath(String json, String path){
		long result = 0;
		try {
			Object o = JSONPath.eval(json, "$."+path);
			result = o==null? 0 : Long.valueOf(o.toString());
		}catch (Exception e){
			logger.warn("\n\t getStringByPath异常", e);
		}
		return result;
	}

	/**
	 * 获取int根据Path
	 * @param json
	 * @param path 路径key (如body.success)
	 * @return
	 */
	public static int getIntValueByPath(String json, String path){
		int result = 0;
		try {
			Object o = JSONPath.eval(json, "$."+path);
			if(o!=null){
				result = Integer.valueOf(o.toString());
			}
		}catch (Exception e){
			logger.warn("\n\t getStringByPath异常", e);
		}
		return result;
	}

	/**
	 * 获取Object根据Path
	 * @param json
	 * @param path 路径key (如body.success)
	 * @return
	 */
	public static Object getByPath(String json, String path){
		Object o = null;
		try {
			o = JSONPath.eval(json, "$."+path);
		}catch (Exception e){
			logger.warn("\n\t getStringByPath异常", e);
		}
		return o;
	}

	public static List<String> getListString(JSONObject json, String key){
		List<String> list = null;
		try {
			list = json.getObject(key, List.class);
		}catch (Exception e){
			logger.warn("\n\t getListString异常", e);
		}
		return list;
	}

	public static Set<String> getSetString(JSONObject json, String key){
		Set<String> set = null;
		try {
			List<String> list = getListString(json, key);
			set = list==null?null:new HashSet(list);
		}catch (Exception e){
			logger.warn("\n\t getSetString异常", e);
		}
		return set;
	}

	public static List<Integer> getListInteger(JSONObject json, String key){
		List<Integer> list = null;
		try {
			list = json.getObject(key, List.class);
		}catch (Exception e){
			logger.warn("\n\t getListInteger异常", e);
		}
		return list;
	}

	public static Set<Integer> getSetInteger(JSONObject json, String key){
		Set<Integer> set = null;
		try {
			List<Integer> list = getListInteger(json, key);
			set = list==null?null:new HashSet(list);
		}catch (Exception e){
			logger.warn("\n\t getSetInteger异常", e);
		}
		return set;
	}

	public static List<Map<String, Object>> getListMapByPath(String json, String path){
		List<Map<String, Object>> list = null;
		try {
			list = (List<Map<String, Object>>) JSONPath.eval(json, "$."+path);
		}catch (Exception e){
			logger.warn("\n\t getListMap异常", e);
		}
		return list;
	}


}
