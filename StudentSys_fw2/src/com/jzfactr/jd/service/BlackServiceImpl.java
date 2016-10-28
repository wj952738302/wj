package com.jzfactr.jd.service;

import java.sql.Connection;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.jzfactr.jd.bean.Black;
import com.jzfactr.jd.dao.BlackDAO;

public class BlackServiceImpl implements BlackService {
	private BlackDAO btDao;
	
	public BlackDAO getBtDao() {
		return btDao;
	}

	public void setBtDao(BlackDAO btDao) {
		this.btDao = btDao;
	}

	@Override
	public List<Black> getAll() {
		// TODO Auto-generated method stub
		return btDao.findAll();
	}

	@Override
	public Black findByName(String name) {
		// TODO Auto-generated method stub
		return btDao.findByName(name);
	}

	@Override
	public void saveBlack(Black black) {
		// TODO Auto-generated method stub
		btDao.save(black);

	}

	@Override
	public void updateBlack(Black black) {
		// TODO Auto-generated method stub
		btDao.attachDirty(black);

	}

	@Override
	public List<Black> getInTable() {
		// TODO Auto-generated method stub
		return btDao.findInTable();
	}

	@Override
	public boolean isInBlack(String name) {
		// TODO Auto-generated method stub
		Black bt=new Black();
		bt=btDao.findByName(name);
		
		if(bt!=null)
		{
			return true;
		}else{
			return false;
		}
	}
	public static void main(String[] args) {
		BlackService bs=new BlackServiceImpl();
		//getAll
//		System.out.println(bs.getAll());
		//findByName
//		System.out.println(bs.findByName("坏人"));
		//saveBlack
//		Black b=new Black();
//		b.setUsername("牛头");
//		Timestamp stramp=new Timestamp((new Date()).getTime());
//		b.setIncludeDate(stramp);
//		b.setRemoved(1);
		//saceBlack
//		bs.saveBlack(b);
		//updateBlack
//		bs.updateBlack(b);
		//getInTable
//		System.out.println(bs.getInTable());
		//isInBlack
//		System.out.println(bs.isInBlack("小白"));
		System.out.println(bs.getInTable());
		
	}

	
	

}
