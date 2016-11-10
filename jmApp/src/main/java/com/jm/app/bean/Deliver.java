package com.jm.app.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Deliver entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "deliver", catalog = "jm")
public class Deliver implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String email;
	private String tel;
	private Integer money;
	private String projectName;
	private Integer projectType;
	private Integer pass;
	private String logo;
	private Set<Project> projects = new HashSet<Project>(0);

	// Constructors

	/** default constructor */
	public Deliver() {
	}

	/** minimal constructor */
	public Deliver(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Deliver(Integer id, String name, String email, String tel,
			Integer money, String projectName, Integer projectType,
			Integer pass, String logo, Set<Project> projects) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.tel = tel;
		this.money = money;
		this.projectName = projectName;
		this.projectType = projectType;
		this.pass = pass;
		this.logo = logo;
		this.projects = projects;
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

	@Column(name = "name", length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "email", length = 50)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "tel", length = 50)
	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Column(name = "money")
	public Integer getMoney() {
		return this.money;
	}

	public void setMoney(Integer money) {
		this.money = money;
	}

	@Column(name = "projectName", length = 100)
	public String getProjectName() {
		return this.projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	@Column(name = "projectType")
	public Integer getProjectType() {
		return this.projectType;
	}

	public void setProjectType(Integer projectType) {
		this.projectType = projectType;
	}

	@Column(name = "pass")
	public Integer getPass() {
		return this.pass;
	}

	public void setPass(Integer pass) {
		this.pass = pass;
	}

	@Column(name = "logo", length = 50)
	public String getLogo() {
		return this.logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "deliver")
	public Set<Project> getProjects() {
		return this.projects;
	}

	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}

}