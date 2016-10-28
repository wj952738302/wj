package com.jzfactr.jd.text;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jzfactr.jd.bean.User;
import com.jzfactr.jd.dao.UserDAO;

public class DaoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//        BlackDAO dao=(BlackDAO) ac.getBean("BlackDAO");
//        Black black=dao.findById(8);
//        System.out.println(black);
        
//        ClaszDAO dao=(ClaszDAO) ac.getBean("ClaszDAO");
//        Clasz clasz=dao.findById(1);
//        System.out.println(clasz);
        
//        StudentDAO dao=(StudentDAO) ac.getBean("StudentDAO");
//        Student stud=dao.findById(14);
//        System.out.println(stud);
        
        UserDAO dao=(UserDAO) ac.getBean("UserDAO");
        User user=dao.findById(5);
        System.out.println(user);
	}

}
