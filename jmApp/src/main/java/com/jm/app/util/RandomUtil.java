package com.jm.app.util;

import java.util.Random;

/**
 * 随机产生随机数
 * @author Administrator
 *
 */
public class RandomUtil {
	
	/**
	 * 产生不同位数的随机数
	 * @param 随机位数
	 * @return 随机数字符串
	 */
	public static String randomNum(int bits)
	{
		Random random=new Random();
		int num=random.nextInt((int)Math.pow(10, bits)-(int)Math.pow(10, bits-1)+1)+(int)Math.pow(10, bits-1);
		return String.valueOf(num);
	}

	public static void main(String[] args) {
		
		System.out.println(randomNum(4));
	}
}
