package com.jzfactr.jd.dao;

import com.jzfactr.jd.bean.Clasz;
import com.jzfactr.jd.bean.Student;
import com.jzfactr.jd.util.BaseHibernateDAO;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import static org.hibernate.criterion.Example.create;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

/**
 	* A data access object (DAO) providing persistence and search support for Clasz entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.jzfactr.jd.bean.Clasz
  * @author MyEclipse Persistence Tools 
 */
@Transactional
public class ClaszDAO  {
	     private static final Logger log = LoggerFactory.getLogger(ClaszDAO.class);
		//property constants
	public static final String NAME = "name";
	public static final String _TNAME = "TName";
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
    public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
    private Session getSession(){
    	return sessionFactory.getCurrentSession();
    }



    
    public void save(Clasz transientInstance) {
        log.debug("saving Clasz instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Clasz persistentInstance) {
        log.debug("deleting Clasz instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Clasz findById( java.lang.Integer id) {
        log.debug("getting Clasz instance with id: " + id);
        try {
            Clasz instance = (Clasz) getSession()
                    .get("com.jzfactr.jd.bean.Clasz", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List<Clasz> findByExample(Clasz instance) {
        log.debug("finding Clasz instance by example");
        try {
            List<Clasz> results = (List<Clasz>) getSession()
                    .createCriteria("com.jzfactr.jd.bean.Clasz")
                    .add( create(instance) )
            .list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding Clasz instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Clasz as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List<Clasz> findByName(Object name
	) {
		return findByProperty(NAME, name
		);
	}
	
	public List<Clasz> findByTName(Object TName
	) {
		return findByProperty(_TNAME, TName
		);
	}
	

	public List findAll() {
		log.debug("finding all Clasz instances");
		try {
			String queryString = "from Clasz";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Clasz merge(Clasz detachedInstance) {
        log.debug("merging Clasz instance");
        try {
            Clasz result = (Clasz) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Clasz instance) {
        log.debug("attaching dirty Clasz instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Clasz instance) {
        log.debug("attaching clean Clasz instance");
        try {
                      	getSession().buildLockRequest(LockOptions.NONE).lock(instance);
          	            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    /**
     * 同步数据库
     * @param cls
     */
//    public void reflush(Clasz cls)
//    {
//    	Session session=getSession();
//    	session.refresh(cls);
//    }
    /**
     * 通过班级的id删除班级
     * @param claszId班级的id
     * @param isDelStud 是否可以关联删除学生true-可以
     * @return 是否删除成功
     */
    public boolean delete(int claszId,boolean isDelStud)
    {        
    	Clasz cls=this.findById(claszId);
    	if(!isDelStud && cls.getStudents().size()>0)
    		return false;
    	this.delete(cls);
    	return true;
    }
    public List<Clasz> findByName2(String name)
    {
    	String hql="from Clasz c where c.name like ?";
    	Query query=getSession().createQuery(hql);	
    	query.setString(0, "%"+name+"%");
    	return query.list();
    }

    public static void main(String[] args) {
		ClaszDAO clsDao=new ClaszDAO();
//		Clasz cls=new Clasz();
//		cls.setName("五年六班");
//		cls.setTName("王老师");
//		clsDao.save(cls);
		
//		Clasz cls1=clsDao.findById(11);
//		Student s=new Student();
//		s.setBirth(new Date());
//		s.setCode("123456");
//		s.setName("牛头");
//		s.setSex(1);
//		cls.getStudents().add(s);
//		cls1.getStudents().add(s);
//		clsDao.attachDirty(cls);
		
		Clasz cls=clsDao.findById(7);
		clsDao.delete(cls);
	}
}