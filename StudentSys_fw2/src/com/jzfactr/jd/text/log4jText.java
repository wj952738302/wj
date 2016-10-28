package com.jzfactr.jd.text;

import org.apache.log4j.Logger;

/**
 * @author jay 2016-09-28
 * 测试类
 */
public class log4jText {
	private static Logger logger  =  Logger.getLogger(log4jText. class );
    public static void testDebug(){
    	logger.debug("这是一个debug日志输出");    	
    }
    public static void testInfo(){
    	logger.info("这是一个信息日志");
    }
    public static void testWarn(){
    	logger.warn("这是一个警告错误");
    }
    public static void testError(){
    	logger.error("这是一个错误的信息");
    }
    public static void testFatal(){
    	logger.fatal("这是一个严重的错误");
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testDebug();
		testInfo();
		testWarn();
		testError();
		testFatal();

	}

}
