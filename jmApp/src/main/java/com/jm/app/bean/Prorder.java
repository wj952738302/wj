package com.jm.app.bean;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.jm.app.util.DateUtil;

/**
 * Prorder entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "prorder", catalog = "jm")
public class Prorder implements java.io.Serializable {

	// Fields

	private Integer id;
	private Project project;
	private User user;
	private Integer investment;
	private Float income;
	private Date buyDate;
	private Date reportDate;
	private Integer statuses;
	private Integer assign;

	// Constructors

	/** default constructor */
	public Prorder() {
	}

	/** minimal constructor */
	public Prorder(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Prorder(Integer id, Project project, User user, Integer investment,
			Float income, Date buyDate, Date reportDate, Integer statuses) {
		this.id = id;
		this.project = project;
		this.user = user;
		this.investment = investment;
		this.income = income;
		this.buyDate = buyDate;
		this.reportDate = reportDate;
		this.statuses = statuses;
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
	@JoinColumn(name = "projectId")
	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId")
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "investment")
	public Integer getInvestment() {
		return this.investment;
	}

	public void setInvestment(Integer investment) {
		this.investment = investment;
	}

	@Column(name = "income", precision = 12, scale = 0)
	public Float getIncome() {
		return this.income;
	}

	public void setIncome(Float income) {
		this.income = income;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "buyDate", length = 10)
	public Date getBuyDate() {
		return this.buyDate;
	}

	public void setBuyDate(Date buyDate) {
		this.buyDate = buyDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "reportDate", length = 10)
	public Date getReportDate() {
		return this.reportDate;
	}

	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}

	@Column(name = "statuses")
	public Integer getStatuses() {
		return this.statuses;
	}

	public void setStatuses(Integer statuses) {
		this.statuses = statuses;
	}

	@Column(name = "assign")
	public Integer getAssign() {
		return assign;
	}

	public void setAssign(Integer assign) {
		this.assign = assign;
	}
   
	@Transient
	public String getFormatBuyDate()
	{
		return DateUtil.toString(buyDate, "yyyy/MM/dd");
	}
	@Transient
	public String getStatusName()
	{
		String name="";
		if(this.statuses==null)
			name="转化中";
		switch(this.statuses)
		{
		   case 0:
			   name="转化中";
			   break;
		   case 1:
			   name="转让中";
			   break;
		   case 2:
			   name="已转化";
			   break;
		   case 3:
			   name="已转让";
			   break;
		   case 4:
			   name="管理员待确认";
			   break;
		   case 5:
			   name="管理员已确认";
			   break;
		   default:
			   name="转化中";
 		}
		return name;
	}
}