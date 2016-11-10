package com.jm.app.dao;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import static org.hibernate.criterion.Example.create;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.jm.app.bean.Sms;

/**
 * A data access object (DAO) providing persistence and search support for Sms
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.jm.app.bean.Sms
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class SmsDAO {
	private static final Logger log = LoggerFactory.getLogger(SmsDAO.class);
	// property constants
	public static final String TEL = "tel";
	public static final String CONTENT = "content";
	public static final String STATUS = "status";
	public static final String MESSAGE = "message";
	public static final String REMAIN = "remain";
	public static final String TASKID = "taskid";
	public static final String SUCCESSES = "successes";

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

	public void save(Sms transientInstance) {
		log.debug("saving Sms instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Sms persistentInstance) {
		log.debug("deleting Sms instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Sms findById(java.lang.Integer id) {
		log.debug("getting Sms instance with id: " + id);
		try {
			Sms instance = (Sms) getCurrentSession().get("com.jm.app.bean.Sms",
					id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Sms> findByExample(Sms instance) {
		log.debug("finding Sms instance by example");
		try {
			List<Sms> results = (List<Sms>) getCurrentSession()
					.createCriteria("com.jm.app.bean.Sms")
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
		log.debug("finding Sms instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Sms as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Sms> findByTel(Object tel) {
		return findByProperty(TEL, tel);
	}

	public List<Sms> findByContent(Object content) {
		return findByProperty(CONTENT, content);
	}

	public List<Sms> findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	public List<Sms> findByMessage(Object message) {
		return findByProperty(MESSAGE, message);
	}

	public List<Sms> findByRemain(Object remain) {
		return findByProperty(REMAIN, remain);
	}

	public List<Sms> findByTaskid(Object taskid) {
		return findByProperty(TASKID, taskid);
	}

	public List<Sms> findBySuccesses(Object successes) {
		return findByProperty(SUCCESSES, successes);
	}

	public List findAll() {
		log.debug("finding all Sms instances");
		try {
			String queryString = "from Sms";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Sms merge(Sms detachedInstance) {
		log.debug("merging Sms instance");
		try {
			Sms result = (Sms) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Sms instance) {
		log.debug("attaching dirty Sms instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Sms instance) {
		log.debug("attaching clean Sms instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static SmsDAO getFromApplicationContext(ApplicationContext ctx) {
		return (SmsDAO) ctx.getBean("SmsDAO");
	}
}