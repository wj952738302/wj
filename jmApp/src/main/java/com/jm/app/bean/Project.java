package com.jm.app.bean;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.jm.app.util.DateUtil;

/**
 * Project entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "project", catalog = "jm")
public class Project implements java.io.Serializable {

	// Fields

	private Integer id;
	private Deliver deliver;
	private String title;
	private String subtitle;
	private Integer target;
	private Float converted;
	private Integer period;
	private Date start;
	private Date stop;
	private String picture;
	private String homepage;
	private String safepage;
	private String grCode;
	private Integer onlookers;
	private String carousel;
	private Integer type;
	private Set<Prorder> prorders = new HashSet<Prorder>(0);
	private Set<ProjectSupport> projectSupports = new HashSet<ProjectSupport>(0);

	//已投资金额
	@Transient
	private Integer investSum;
	
	// Constructors

	/** default constructor */
	public Project() {
	}

	/** minimal constructor */
	public Project(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Project(Integer id, Deliver deliver, String title, String subtitle,
			Integer target, Float converted, Integer period, Date start,
			Date stop, String picture, String homepage, String safepage,
			String grCode, Integer onlookers, Set<Prorder> prorders,
			Set<ProjectSupport> projectSupports) {
		this.id = id;
		this.deliver = deliver;
		this.title = title;
		this.subtitle = subtitle;
		this.target = target;
		this.converted = converted;
		this.period = period;
		this.start = start;
		this.stop = stop;
		this.picture = picture;
		this.homepage = homepage;
		this.safepage = safepage;
		this.grCode = grCode;
		this.onlookers = onlookers;
		this.prorders = prorders;
		this.projectSupports = projectSupports;
	}

	// Property accessors
	@Id @GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "deliverid")
	public Deliver getDeliver() {
		return this.deliver;
	}

	public void setDeliver(Deliver deliver) {
		this.deliver = deliver;
	}

	@Column(name = "title", length = 50)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "subtitle", length = 100)
	public String getSubtitle() {
		return this.subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	@Column(name = "target")
	public Integer getTarget() {
		return this.target;
	}

	public void setTarget(Integer target) {
		this.target = target;
	}

	@Column(name = "converted", precision = 12, scale = 0)
	public Float getConverted() {
		return this.converted;
	}

	public void setConverted(Float converted) {
		this.converted = converted;
	}

	@Column(name = "period")
	public Integer getPeriod() {
		return this.period;
	}

	public void setPeriod(Integer period) {
		this.period = period;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "start", length = 10)
	public Date getStart() {
		return this.start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "stop", length = 10)
	public Date getStop() {
		return this.stop;
	}

	public void setStop(Date stop) {
		this.stop = stop;
	}

	@Column(name = "picture", length = 100)
	public String getPicture() {
		return this.picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	@Column(name = "homepage", length = 100)
	public String getHomepage() {
		return this.homepage;
	}

	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}

	@Column(name = "safepage", length = 100)
	public String getSafepage() {
		return this.safepage;
	}

	public void setSafepage(String safepage) {
		this.safepage = safepage;
	}

	@Column(name = "gr_code", length = 100)
	public String getGrCode() {
		return this.grCode;
	}

	public void setGrCode(String grCode) {
		this.grCode = grCode;
	}

	@Column(name = "onlookers")
	public Integer getOnlookers() {
		return this.onlookers;
	}

	@Column(name = "carousel", length = 100)
	public String getCarousel() {
		return carousel;
	}

	public void setCarousel(String carousel) {
		this.carousel = carousel;
	}

	public void setOnlookers(Integer onlookers) {
		this.onlookers = onlookers;
	}

	@Column(name = "type")
	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "project")
	public Set<Prorder> getProrders() {
		return this.prorders;
	}

	public void setProrders(Set<Prorder> prorders) {
		this.prorders = prorders;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "project")
	public Set<ProjectSupport> getProjectSupports() {
		return this.projectSupports;
	}

	public void setProjectSupports(Set<ProjectSupport> projectSupports) {
		this.projectSupports = projectSupports;
	}
	@Transient 
	public int getRemainTime()
	{
		Date now=new Date();
		return (int)((stop.getTime()-now.getTime())/(1000*60*60*24));
	}
	@Transient
	public Integer getInvestSum() {
		return investSum;
	}
	@Transient
	public void setInvestSum(Integer investSum) {
		this.investSum = investSum;
	}
	@Transient
	public Integer getInvestRate()
	{
		if(investSum==null)
			return 0;
		else
		{
			float rate=((float)investSum/target)*100;
			return (int)rate;
		}
	}
	@Transient
	public String getFormatStart()
	{
		return DateUtil.toString(start, "yyyy/MM/dd");
	}
	@Transient
	public String getFormatStop()
	{
		return DateUtil.toString(stop, "yyyy/MM/dd");
	}
	
	 @Transient
	 public String getFormatReturn()
	{
	    Calendar cal=Calendar.getInstance();
	    cal.setTime(start);
	    cal.add(Calendar.MONTH, this.period);
	    return DateUtil.toString(cal.getTime(), "yyyy/MM/dd");
	}
}