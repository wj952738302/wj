package com.jm.app.dao;

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

import com.jm.app.bean.ProjectSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * ProjectSupport entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.jm.app.bean.ProjectSupport
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class ProjectSupportDAO {
	private static final Logger log = LoggerFactory
			.getLogger(ProjectSupportDAO.class);
	// property constants
	public static final String PRICE = "price";
	public static final String LIMITED = "limited";
	public static final String DESCRIPTION = "description";

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

	public void save(ProjectSupport transientInstance) {
		log.debug("saving ProjectSupport instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(ProjectSupport persistentInstance) {
		log.debug("deleting ProjectSupport instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ProjectSupport findById(java.lang.Integer id) {
		log.debug("getting ProjectSupport instance with id: " + id);
		try {
			ProjectSupport instance = (ProjectSupport) getCurrentSession().get(
					"com.jm.app.bean.ProjectSupport", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<ProjectSupport> findByExample(ProjectSupport instance) {
		log.debug("finding ProjectSupport instance by example");
		try {
			List<ProjectSupport> results = (List<ProjectSupport>) getCurrentSession()
					.createCriteria("com.jm.app.bean.ProjectSupport")
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
		log.debug("finding ProjectSupport instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from ProjectSupport as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<ProjectSupport> findByPrice(Object price) {
		return findByProperty(PRICE, price);
	}

	public List<ProjectSupport> findByLimited(Object limited) {
		return findByProperty(LIMITED, limited);
	}

	public List<ProjectSupport> findByDescription(Object description) {
		return findByProperty(DESCRIPTION, description);
	}

	public List findAll() {
		log.debug("finding all ProjectSupport instances");
		try {
			String queryString = "from ProjectSupport";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public ProjectSupport merge(ProjectSupport detachedInstance) {
		log.debug("merging ProjectSupport instance");
		try {
			ProjectSupport result = (ProjectSupport) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ProjectSupport instance) {
		log.debug("attaching dirty ProjectSupport instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ProjectSupport instance) {
		log.debug("attaching clean ProjectSupport instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ProjectSupportDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (ProjectSupportDAO) ctx.getBean("ProjectSupportDAO");
	}
}