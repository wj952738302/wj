package com.jzfactr.jd.dao;

import com.jzfactr.jd.bean.Black;
import com.jzfactr.jd.bean.Clasz;
import com.jzfactr.jd.bean.Student;
import com.jzfactr.jd.util.BaseHibernateDAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
 	* A data access object (DAO) providing persistence and search support for Student entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.jzfactr.jd.bean.Student
  * @author MyEclipse Persistence Tools 
 */
@Transactional
public class StudentDAO {
	     private static final Logger log = LoggerFactory.getLogger(StudentDAO.class);
		//property constants
	public static final String CODE = "code";
	public static final String NAME = "name";
	public static final String SEX = "sex";
	
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



    
    public void save(Student transientInstance) {
        log.debug("saving Student instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Student persistentInstance) {
        log.debug("deleting Student instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Student findById( java.lang.Integer id) {
        log.debug("getting Student instance with id: " + id);
        try {
            Student instance = (Student) getSession()
                    .get("com.jzfactr.jd.bean.Student", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List<Student> findByExample(Student instance) {
        log.debug("finding Student instance by example");
        try {
            List<Student> results = (List<Student>) getSession()
                    .createCriteria("com.jzfactr.jd.bean.Student")
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
      log.debug("finding Student instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Student as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List<Student> findByCode(Object code
	) {
		return findByProperty(CODE, code
		);
	}
	
	public List<Student> findByName(Object name
	) {
		return findByProperty(NAME, name
		);
	}
	
	public List<Student> findBySex(Object sex
	) {
		return findByProperty(SEX, sex
		);
	}
	

	public List findAll() {
		log.debug("finding all Student instances");
		try {
			String queryString = "from Student";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Student merge(Student detachedInstance) {
        log.debug("merging Student instance");
        try {
            Student result = (Student) getSession().merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Student instance) {
        log.debug("attaching dirty Student instance");
        try {
            
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Student instance) {
        log.debug("attaching clean Student instance");
        try {
                      	getSession().buildLockRequest(LockOptions.NONE).lock(instance);
          	            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    /**
     * 为某个班级添加多个学生
     * @param cls
     * @param studList
     */
    public void save(Clasz cls,List<Student> studList)
    {
    	for(Student std:studList)
    	{
    		std.setClasz(cls);
    		getSession().save(std);
    	}
    }
    
    public void deleteById(int id)
    {
    	String hql="delete from Student student where student.id=?";
    	Query query=getSession().createQuery(hql);
		query.setInteger(0, id);
		query.executeUpdate();
    }
    /**
     * 删除某个班级的学生
     * @param claId
     */
    public void deleteByCls(int claId)
    {
    	String hql="delete from Student s where s.clasz.id=?";
    	Query query=getSession().createQuery(hql);
		query.setInteger(0, claId);
		query.executeUpdate();
    }
    public int deleteByClsName(String claszName)
    {
    	   String hql="from Clasz cls where cls.name=?";
    	   Query query=getSession().createQuery(hql);
    	   query.setString(0, claszName);
    	   Clasz cls=(Clasz)query.uniqueResult();
    	   hql="delete from Student s where s.clasz.name=?";
    	   query=getSession().createQuery(hql);
    	   query.setInteger(0, cls.getId());
    	   int num=query.executeUpdate();
    	   return num;
    }
    /**
     * 将一个班级的学生更改到另一个班级
     * @param oldClsId 原来班级id
     * @param newClsId 新的班级id
     */
    public void changeCls(int oldClsId,int newClsId)
    {
    	String hql="from Student s where s.cls.id=?";
    	Query query=getSession().createQuery(hql);
    	query.setInteger(0, oldClsId);
    	List<Student> sList=query.list();
    	Clasz newCls=(Clasz) getSession().get(Clasz.class, newClsId);
    	for(Student s:sList)
    	{
    		s.setClasz(newCls);
    		getSession().save(s);
    	}
    }
    /**
     * 通过名字查询学生信息（模糊查询）
     * @param name
     * @return
     */
    public List<Student> findByName2(String name)
    {
    	String hql="from Student s where s.name like ?";
    	Query query=getSession().createQuery(hql);
    	query.setString(0, "%"+name+"%");
    	return query.list();
    }
    /**
     * 
     * @param code
     * @return
     */
    public Student findByCode2(String code)
    {
    	String hql="from Student s where s.code=?";
    	Query query=getSession().createQuery(hql);
    	query.setString(0, code);
    	return (Student) query.uniqueResult();
    }
    public List<Student> findAllByClsId(int claszId)
    {
    	String hql="from Student s where s.clasz.id=?";
    	Query query=getSession().createQuery(hql);
    	query.setInteger(0, claszId);
    	return query.list();
    }
    public List<Student> findAllByClsName(String name)
    {
    	String hql="from Student s where s.clasz.name=?";
    	Query query=getSession().createQuery(hql);
    	query.setString(0, name);
    	return query.list();
    }
    public Clasz findClsByStudId(int studId)
    {
    	Student s=(Student)getSession().get(Student.class, studId);
    	if(s!=null)
    		return s.getClasz();
    	return null;
    }
    /**
     * 通过性别统计男女生人数
     * @param claszId
     * @return
     */
    public int[] countBySex(int claszId)
    {
    	String hql="select s.sex,count(s.id) from Student s where s.clasz.id=? group by s.sex";
    	Query query=getSession().createQuery(hql);
    	query.setInteger(0, claszId);
    	List<Object[]> objList=query.list();
    	int[] nums=new int[2];
    	if(objList!=null && objList.size()>0)
    	{
    		for(Object[] objs:objList)
    		{
    			int sex=(Integer)objs[0];
    			long count=(Long)objs[1];
    			if(sex==0)
    				nums[0]=(int)count;
    			else
    				nums[1]=(int)count;
    		}
    	}
    	return nums;
    }
    /**
     * 查询某个班级的学生的编号和性别
     * @param claszId 班级编号
     * @return key-学生的编号   value-学生的姓名
     */
    public Map<String,String> getStudentName(int claszId)
    {
    	String hql="select s.code,c.name from Student s where s.claszId=?";
    	Query query=getSession().createQuery(hql);
    	query.setInteger(0, claszId);
    	List<Object[]> objList= query.list();
    	Map<String,String> nameMap=new HashMap<String,String>();
    	for(Object[] objs:objList)
    	{
    		String code=(String)objs[0];
    		String name=(String)objs[1];
    		nameMap.put(code, name);
    	}
    		return nameMap;
    }
    /**
     * 查询某个班级的某个学生的信息
     * @param clsId
     * @param name
     * @return
     */
    public List<Student> findByName(int clsId,String name)
    {
    	String hql="from Student s where s.clasz.id=? and s.name like ?";
    	Query query=getSession().createQuery(hql);
    	query.setInteger(0, clsId);
    	query.setString(1, "%"+name+"%");
    	return query.list();
    }
    /**
     * 分页
     * @param clsId
     * @param startIndex
     * @param stopIndex
     * @return
     */
    public List<Student> findByPage(int clsId,int startIndex,int stopIndex)
    {
    	String hql="from Student s where s.clasz.id=?";
    	Query query=getSession().createQuery(hql);
    	query.setInteger(0, clsId);
    	query.setFirstResult(startIndex);
    	query.setMaxResults(stopIndex-startIndex+1);
    	return query.list();
    }

    public static void main(String[] args) {
    	ClaszDAO clsDao=new ClaszDAO();
		StudentDAO sDao=new StudentDAO();
		Clasz cls=clsDao.findById(1);
//		Student stu=sDao.findById(34);
//		System.out.println(stu.getClasz().getName());
		List<Student> sList=new ArrayList<Student>();
		Student student=new Student();
		student.setBirth(new Date());
		student.setClasz(cls);
		student.setCode("123");
		student.setName("你好");
		student.setSex(1);
		Student student1=new Student();
		student1.setBirth(new Date());
		student1.setClasz(cls);
		student1.setCode("zxzxzx");
		student1.setName("xzxzxz");
		student1.setSex(1);
		Student student2=new Student();
		student2.setBirth(new Date());
		student2.setClasz(cls);
		student2.setCode("123");
		student2.setName("你好");
		student2.setSex(1);
//		sList.add(student);
//		sList.add(student1);
//		sList.add(student2);
//		sDao.save(cls, sList);
//		sDao.save(student1);
//		System.out.println(sDao.findByPage(1, 1, 5));
//		sDao.deleteById(66);
		System.out.println(sDao.countBySex(1));
//		
//		sDao.deleteByCls(4);
//		
//		System.out.println(sDao.deleteByClsName("三年二班"));
		
		
	}
}