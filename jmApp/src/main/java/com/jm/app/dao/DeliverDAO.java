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
import org.springframework.transaction.annotation.Transactional;

import com.jm.app.bean.Deliver;

/**
 * A data access object (DAO) providing persistence and search support for
 * Deliver entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.jm.app.bean.Deliver
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class DeliverDAO {
	private static final Logger log = LoggerFactory.getLogger(DeliverDAO.class);
	// property constants
	public static final String NAME = "name";
	public static final String EMAIL = "email";
	public static final String TEL = "tel";
	public static final String MONEY = "money";
	public static final String PROJECT_NAME = "projectName";
	public static final String PROJECT_TYPE = "projectType";
	public static final String PASS = "pass";
	public static final String LOGO = "logo";

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

	public void save(Deliver transientInstance) {
		log.debug("saving Deliver instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Deliver persistentInstance) {
		log.debug("deleting Deliver instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Deliver findById(java.lang.Integer id) {
		log.debug("getting Deliver instance with id: " + id);
		try {
			Deliver instance = (Deliver) getCurrentSession().get(
					"com.jm.app.bean.Deliver", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Deliver> findByExample(Deliver instance) {
		log.debug("finding Deliver instance by example");
		try {
			List<Deliver> results = (List<Deliver>) getCurrentSession()
					.createCriteria("com.jm.app.bean.Deliver")
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
		log.debug("finding Deliver instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Deliver as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Deliver> findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List<Deliver> findByEmail(Object email) {
		return findByProperty(EMAIL, email);
	}

	public List<Deliver> findByTel(Object tel) {
		return findByProperty(TEL, tel);
	}

	public List<Deliver> findByMoney(Object money) {
		return findByProperty(MONEY, money);
	}

	public List<Deliver> findByProjectName(Object projectName) {
		return findByProperty(PROJECT_NAME, projectName);
	}

	public List<Deliver> findByProjectType(Object projectType) {
		return findByProperty(PROJECT_TYPE, projectType);
	}

	public List<Deliver> findByPass(Object pass) {
		return findByProperty(PASS, pass);
	}

	public List<Deliver> findByLogo(Object logo) {
		return findByProperty(LOGO, logo);
	}

	public List findAll() {
		log.debug("finding all Deliver instances");
		try {
			String queryString = "from Deliver";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Deliver merge(Deliver detachedInstance) {
		log.debug("merging Deliver instance");
		try {
			Deliver result = (Deliver) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Deliver instance) {
		log.debug("attaching dirty Deliver instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Deliver instance) {
		log.debug("attaching clean Deliver instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static DeliverDAO getFromApplicationContext(ApplicationContext ctx) {
		return (DeliverDAO) ctx.getBean("DeliverDAO");
	}
}