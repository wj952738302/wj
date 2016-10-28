package com.jzfactr.jd.dao;

import static org.hibernate.criterion.Example.create;

import java.util.List;







import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import com.jzfactr.jd.bean.User;
import com.jzfactr.jd.util.BaseHibernateDAO;

/**
 * A data access object (DAO) providing persistence and search support for User
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.jzfactr.jd.bean.User
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class UserDAO {
	private static final Logger log = LoggerFactory.getLogger(UserDAO.class);
	// property constants
	public static final String NAME = "name";
	public static final String PASSWORD = "password";
	public static final String EMAIL = "email";
	public static final String SERVER = "server";
	
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

	
	public void save(User transientInstance) {
		log.debug("saving User instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(User persistentInstance) {
		log.debug("deleting User instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public User findById(java.lang.Integer id) {
		log.debug("getting User instance with id: " + id);
		try {
			User instance = (User) getSession().get("com.jzfactr.jd.bean.User",
					id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<User> findByExample(User instance) {
		log.debug("finding User instance by example");
		try {
			List<User> results = (List<User>) getSession()
					.createCriteria("com.jzfactr.jd.bean.User")
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
			Query queryObject = getSession().createQuery(queryString);
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

	public List<User> findByEmail(Object email) {
		return findByProperty(EMAIL, email);
	}

	public List<User> findByServer(Object server) {
		return findByProperty(SERVER, server);
	}

	public List findAll() {
		log.debug("finding all User instances");
		try {
			String queryString = "from User";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public User merge(User detachedInstance) {
		log.debug("merging User instance");
		try {
			User result = (User) getSession().merge(detachedInstance);
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
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(User instance) {
		log.debug("attaching clean User instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	/**
	 * 根据id删除
	 * @param id
	 */
	public void delete(int id)
	{
		User user=this.findById(id);
		this.delete(user);
	}
	/**
	 * 通过HQL语句删除用户
	 * @param id
	 */
	public void delete2(int id)
	{
		String hql="delete from User user where user.id=?";
		Query query=getSession().createQuery(hql);
		query.setInteger(0, id);
		query.executeUpdate();
	}
	/**
	 * 通过sql删除
	 * @param id
	 */
	public void delete3(int id)
	{
		String sql="delete from user where id=:userid";
		SQLQuery query=getSession().createSQLQuery(sql);
		query.setInteger("userid", id);
		query.executeUpdate();
	}
	public User findByname2(String name)
	{
		String hql="from User user where user.name=?";
		Session session=getSession();
		Query query=session.createQuery(hql);
		query.setString(0, name);
		List<User> userList=query.list();
		if(userList==null||userList.size()==0)
		{
			return null;
		}else{
			return userList.get(0);
		}
	}
	/**
	 * 查询黑名单用户信息
	 * @return
	 */
	public List findBlackList()
	{
		String hql="from User user where user.server=1";
    	Query query=getSession().createQuery(hql);
    	return query.list();
	}
	
	public static void main(String[] args) {
		UserDAO u=new UserDAO();
//		u.delete3(20);
		System.out.println(u.findById(5));
		
//		System.out.println(u.findBlackList());
	}
}