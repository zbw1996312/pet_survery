package com.pet.survery.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Pattern;

/**
 * 正则工具类 提供验证邮箱、手机号、电话号码、身份证号码、数字等方法
 */
public final class RegexUtils {
	static Logger logger = LoggerFactory.getLogger(RegexUtils.class);

	/**
	 * 验证Email
	 * 
	 * @param email
	 *            email地址，格式：zhangsan@sina.com，zhangsan@xxx.com.cn，xxx代表邮件服务商
	 * @return 验证成功返回true，验证失败返回false
	 */
	public static boolean checkEmail(String email) {
		String regex = "[\\w\\.\\-]+@([\\w\\-]+\\.)+[\\w\\-]+";
		if( Pattern.matches(regex, email)){
			if(email.contains("..")){
				return false;
			}else{
				return true;
			}
		}else{
			return false;
		}
	}

	/**
	 * 短信验证码
	 * 
	 * @param captcha
	 *            ，格式：6位数字
	 * @return 验证成功返回true，验证失败返回false
	 */
	public static boolean checkCaptcha(String captcha) {
		String regex = "\\d{6}";
		return Pattern.matches(regex, captcha);
	}

	/**
	 * 验证身份证号码
	 * 
	 * @param idCard
	 *            居民身份证号码15位或18位，最后一位可能是数字或字母
	 * @return 验证成功返回true，验证失败返回false
	 */
	public static boolean checkIdCard(String idCard) {
		boolean flag = false;
		//String regex = "[1-9]\\d{13,16}[xX0-9]{1}";
		if(idCard==null){
			//
		}else if(idCard.length()==15){
			//不再支持15位
			return false;
//			String regex15 = "[1-9]\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}";
//			flag = Pattern.matches(regex15, idCard);
		}else if(idCard.length()==18){			
			String regex18 = "[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]";
			boolean match = Pattern.matches(regex18, idCard);
			if(match){
				//校验身份证
				char[] nums = idCard.toCharArray();
				
				//1、将前面的身份证号码17位数分别乘以不同的系数。从第一位到第十七位的系数分别为：7 9 10 5 8 4 2 1 6 3 7 9 10 5 8 4 2 ；
				//2、将这17位数字和系数相乘的结果相加；				
				int sum = Integer.parseInt(nums[0]+"") * 7
						+ Integer.parseInt(nums[1]+"") * 9
						+ Integer.parseInt(nums[2]+"") * 10
						+ Integer.parseInt(nums[3]+"") * 5
						+ Integer.parseInt(nums[4]+"") * 8
						+ Integer.parseInt(nums[5]+"") * 4
						+ Integer.parseInt(nums[6]+"") * 2
						+ Integer.parseInt(nums[7]+"") * 1
						+ Integer.parseInt(nums[8]+"") * 6
						+ Integer.parseInt(nums[9]+"") * 3
						+ Integer.parseInt(nums[10]+"") * 7
						+ Integer.parseInt(nums[11]+"") * 9
						+ Integer.parseInt(nums[12]+"") * 10
						+ Integer.parseInt(nums[13]+"") * 5
						+ Integer.parseInt(nums[14]+"") * 8						
						+ Integer.parseInt(nums[15]+"") * 4
						+ Integer.parseInt(nums[16]+"") * 2;
				
				//3、用加出来和除以11，看余数是多少；
				int emainder = sum % 11;
				
				int verificationCode = nums[17]=='X'||nums[17]=='x'?10:Integer.parseInt(nums[17]+"");
				
				//4、余数只可能有0 1 2 3 4 5 6 7 8 9 10这11个数字。其分别对应的最后一位身份证的号码为1 0 X 9 8 7 6 5 4 3 2；
				if(emainder+verificationCode==1 || emainder+verificationCode==12){
					flag = true;
				}else {
					logger.info("校验失败");
				}
				
				
			}else {
				logger.info("18位 正则表达式匹配失败");
			}
		}
		
		return flag;
	}

	/**
	 * 验证执业证书编码
	 * 
	 * @param
	 * @return 验证成功返回true，验证失败返回false
	 */
	public static boolean checkCertificateCard(String certificateCard,int post) {
		if(1<=post&&post<=4){
			String regex = "[1-2][1-4][0-9][1-6]\\d{11}";
			return Pattern.matches(regex, certificateCard);
		}else if(6<=post&&post<=10){
			String regex2 = "\\d{12}";
			return Pattern.matches(regex2, certificateCard);
		}else{
			return false;
		}
		
	}

	/**
	 * 验证手机号码（支持国际格式，+86135xxxx...（中国内地），+00852137xxxx...（中国香港））
	 * 
	 * @param mobile
	 *            移动、联通、电信运营商的号码段
	 *            <p>
	 *            		13/14/15/17/18开头，11位
	 *            </p>
	 * @return 验证成功返回true，验证失败返回false
	 */
	public static boolean checkMobile(String mobile) {
		String regex = "(\\+\\d+)?1[123456789]\\d{9}$";
		return Pattern.matches(regex, mobile);
	}

	/**
	 * 验证固定电话号码
	 * 
	 * @param phone
	 *            电话号码，格式：国家（地区）电话代码 + 区号（城市代码） + 电话号码，如：+8602085588447
	 *            <p>
	 *            国家（地区） 代码 ：标识电话号码的国家（地区）的标准国家（地区）代码。它包含从 0 到 9 的一位或多位数字，
	 *            数字之后是空格分隔的国家（地区）代码。
	 *            </p>
	 *            <p>
	 *            区号（城市代码）：这可能包含一个或多个从 0 到 9 的数字，地区或城市代码放在圆括号——
	 *            对不使用地区或城市代码的国家（地区），则省略该组件。
	 *            </p>
	 *            <p>
	 *            电话号码：这包含从 0 到 9 的一个或多个数字
	 *            </p>
	 * @return 验证成功返回true，验证失败返回false
	 */
	public static boolean checkPhone(String phone) {
		String regex = "(\\+\\d+)?(\\d{3,4}\\-?)?\\d{7,8}$";
		return Pattern.matches(regex, phone);
	}

	/**
	 * 验证整数（正整数和负整数）
	 * 
	 * @param digit
	 *            一位或多位0-9之间的整数
	 * @return 验证成功返回true，验证失败返回false
	 */
	public static boolean checkDigit(String digit) {
		String regex = "^-?\\d+$";
		return Pattern.matches(regex, digit);
	}

	/**
	 * 验证整数和浮点数（正负整数和正负浮点数）
	 * 
	 * @param decimals
	 *            一位或多位0-9之间的浮点数，如：1.23，233.30
	 * @return 验证成功返回true，验证失败返回false
	 */
	public static boolean checkDecimals(String decimals) {
		String regex = "\\-?[1-9]\\d+(\\.\\d+)?";
		return Pattern.matches(regex, decimals);
	}

	/**
	 * 验证空白字符
	 * 
	 * @param blankSpace
	 *            空白字符，包括：空格、\t、\n、\r、\f、\x0B
	 * @return 验证成功返回true，验证失败返回false
	 */
	public static boolean checkBlankSpace(String blankSpace) {
		String regex = "\\s+";
		return Pattern.matches(regex, blankSpace);
	}

	/**
	 * 验证中文
	 * 
	 * @param chinese
	 *            中文字符
	 * @return 验证成功返回true，验证失败返回false
	 */
	public static boolean checkChinese(String chinese) {
		String regex = "^[\u4E00-\u9FA5]+$";
		return Pattern.matches(regex, chinese);
	}

	/**
	 * 验证日期（年月日）
	 * 
	 * @param day
	 *            日期，格式：1992-09-03，或1992.09.03
	 * @return 验证成功返回true，验证失败返回false
	 */
	public static boolean checkDay(String day) {
		String regex = "[1-9]{1}\\d{3}([-./])\\d{1,2}\\1\\d{1,2}";
		return Pattern.matches(regex, day);
	}

	/**
	 * 验证URL地址
	 * 
	 * @param url
	 *            格式：http://blog.csdn.net:80/xyang81/article/details/7705960? 或
	 *            http://www.csdn.net:80
	 * @return 验证成功返回true，验证失败返回false
	 */
	public static boolean checkURL(String url) {
		// String regex =
		// "(http(s)?://(w{3}\\.)?)?\\w+\\.\\w+(\\.[a-zA-Z]+)*(:\\d{1,5})?(/\\w*)*(\\??(.+=.*)?(&.+=.*)?)?";
		String regex = "http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?%&=]*)?";
		return Pattern.matches(regex, url);
	}

	/**
	 * 匹配中国邮政编码
	 * 
	 * @param postcode
	 *            邮政编码
	 * @return 验证成功返回true，验证失败返回false
	 */
	public static boolean checkPostcode(String postcode) {
		String regex = "[1-9]\\d{5}";
		return Pattern.matches(regex, postcode);
	}

	/**
	 * 匹配IP地址(简单匹配，格式，如：192.168.1.1，127.0.0.1，没有匹配IP段的大小)
	 * 
	 * @param ipAddress
	 *            IPv4标准地址
	 * @return 验证成功返回true，验证失败返回false
	 */
	public static boolean checkIpAddress(String ipAddress) {
		String regex = "[1-9](\\d{1,2})?\\.(0|([1-9](\\d{1,2})?))\\.(0|([1-9](\\d{1,2})?))\\.(0|([1-9](\\d{1,2})?))";
		return Pattern.matches(regex, ipAddress);
	}
	
	/**
	 * 是否为整数
	 * @param number
	 * @return
	 */
	public static boolean checkNumeric(String number) {
		String regex = "^[0-9]*$";
		return Pattern.matches(regex, number);
	}

	public static void main(String[] args) {
		String birthday = "51290319770130101X".substring(6, 14);
		System.err.println(birthday);
		System.out.println(RegexUtils.checkIdCard("51290319770130101X"));
	}

}
