package com.jzfactr.jd.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author jay 2016-9-6
 * ����
 */
public class DateUtil {
	/**
	 * ���ַ�����ת��ΪDate���͵�����
	 * @param str �����ַ�
	 * @return
	 */
	public static Date toDate(String str) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd");
		Date date=null;
		try {
			date=sdf.parse(str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
	/**
	 * ���ַ�����ת����Date����
	 * @param str �ַ�����
	 * @param formatStr �ַ����ڵĸ�ʽ
	 * @return
	 */
	public static Date toDate(String str,String formatStr)
	{
		SimpleDateFormat sdf=new SimpleDateFormat(formatStr);
		Date date=null;
		try {
			date=sdf.parse(str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
	/**
	 * ���������͸�ʽ�����Ϊ�ַ�
	 * @param date 
	 * @param formatStr
	 * @return
	 */
	public static String toString(Date date,String formatStr)
	{
		SimpleDateFormat sdf=new SimpleDateFormat(formatStr);
		return sdf.format(date);

	}

}
