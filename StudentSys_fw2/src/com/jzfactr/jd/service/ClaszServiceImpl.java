package com.jzfactr.jd.service;

import java.util.Map;

import com.jzfactr.jd.bean.Clasz;
import com.jzfactr.jd.dao.ClaszDAO;

public class ClaszServiceImpl implements ClaszService {
	private ClaszDAO clsDao;
	

	public ClaszDAO getClsDao() {
		return clsDao;
	}

	public void setClsDao(ClaszDAO clsDao) {
		this.clsDao = clsDao;
	}

	@Override
	public Map<Integer, String> getClaszNameWithId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(Clasz c) {
		// TODO Auto-generated method stub
		clsDao.save(c);

	}

	@Override
	public void delete(int claszid,boolean isDelId) {
		// TODO Auto-generated method stub
		clsDao.delete(claszid, isDelId);

	}

	@Override
	public void update(Clasz cls) {
		// TODO Auto-generated method stub
		clsDao.merge(cls);

	}
	public static void main(String[] args) {
		ClaszService service=new ClaszServiceImpl();
		Clasz cls=new Clasz();
		service.delete(16, true);
	}

}
