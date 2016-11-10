package com.jm.app.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import static org.hibernate.criterion.Example.create;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.jm.app.bean.Prorder;
import com.jm.app.bean.User;

/**
 * A data access object (DAO) providing persistence and search support for User
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.jm.app.been.User
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class UserDAO {
	private static final Logger log = LoggerFactory.getLogger(UserDAO.class);
	// property constants
	public static final String NAME = "name";
	public static final String PASSWORD = "password";
	public static final String TEL = "tel";
	public static final String PICTURE = "picture";
	public static final String REAL_NAME = "realName";
	public static final String SEX = "sex";
	public static final String PROVINCE = "province";
	public static final String CITY = "city";
	public static final String POSTCODE = "postcode";
	public static final String CONSIGNEE = "consignee";
	public static final String CONSIGN_TEL = "consignTel";
	public static final String ADDRESS = "address";
	public static final String EMAIL = "email";

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}

	public void save(User transientInstance) {
		log.debug("saving User instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(User persistentInstance) {
		log.debug("deleting User instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public User findById(java.lang.Integer id) {
		log.debug("getting User instance with id: " + id);
		try {
			User instance = (User) getCurrentSession().get(
					"com.jm.app.bean.User", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<User> findByExample(User instance) {
		log.debug("finding User instance by example");
		try {
			List<User> results = (List<User>) getCurrentSession()
					.createCriteria("com.jm.app.bean.User")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding User instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from User as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<User> findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List<User> findByPassword(Object password) {
		return findByProperty(PASSWORD, password);
	}

	public List<User> findByTel(Object tel) {
		return findByProperty(TEL, tel);
	}

	public List<User> findByPicture(Object picture) {
		return findByProperty(PICTURE, picture);
	}

	public List<User> findByRealName(Object realName) {
		return findByProperty(REAL_NAME, realName);
	}

	public List<User> findBySex(Object sex) {
		return findByProperty(SEX, sex);
	}

	public List<User> findByProvince(Object province) {
		return findByProperty(PROVINCE, province);
	}

	public List<User> findByCity(Object city) {
		return findByProperty(CITY, city);
	}

	public List<User> findByPostcode(Object postcode) {
		return findByProperty(POSTCODE, postcode);
	}

	public List<User> findByConsignee(Object consignee) {
		return findByProperty(CONSIGNEE, consignee);
	}

	public List<User> findByConsignTel(Object consignTel) {
		return findByProperty(CONSIGN_TEL, consignTel);
	}

	public List<User> findByAddress(Object address) {
		return findByProperty(ADDRESS, address);
	}

	public List<User> findByEmail(Object email) {
		return findByProperty(EMAIL, email);
	}

	public List findAll() {
		log.debug("finding all User instances");
		try {
			String queryString = "from User";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public User merge(User detachedInstance) {
		log.debug("merging User instance");
		try {
			User result = (User) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(User instance) {
		log.debug("attaching dirty User instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
    
	public void attachClean(User instance) {
		log.debug("attaching clean User instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
    /**
     * 验证新用户的名称与手机号是否已经注册
     * @param name
     * @param tel
     * @return
     */
	public int validateNewUser(String name,String tel)
	{
		String hql="select u.name,u.tel from User u where u.name=? or u.tel=?";
		Query query=getCurrentSession().createQuery(hql);
		query.setString(0, name);
		query.setString(1, tel);
		List<Object[]> objList=query.list();
		if(objList==null || objList.size()==0)
			return 0;
		else if(objList!=null && objList.size()==1)
		{
			Object[] objs=objList.get(0);
			String u_name=objs[0].toString();
			String u_tel=objs[1].toString();
			if(u_name.equals(name) && u_tel.equals(tel))
				return 3;
			else if(u_name.equals(name))
				return 1;
			else
				return 2;
		}
		else
			return 3;
	}
	public boolean validateTel(String tel)
	{
		String hql="select u.name,u.tel from User u where u.tel=?";
		Query query=getCurrentSession().createQuery(hql);
		query.setString(0, tel);
		Object obj=query.uniqueResult();
		if(obj==null)
			return true;
		else
			return false;
	}
	
	
	public static UserDAO getFromApplicationContext(ApplicationContext ctx) {
		return (UserDAO) ctx.getBean("UserDAO");
	}
	
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDAO dao= getFromApplicationContext(ac);
		dao.findById(2);
	}
}