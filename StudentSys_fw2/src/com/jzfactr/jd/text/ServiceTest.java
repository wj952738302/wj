package com.jzfactr.jd.text;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jzfactr.jd.bean.Black;
import com.jzfactr.jd.service.BlackService;

public class ServiceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        BlackService service=(BlackService) ac.getBean("BlackService");
        Black black=service.findByName("坏人");
        System.out.println(black);

	}

}
