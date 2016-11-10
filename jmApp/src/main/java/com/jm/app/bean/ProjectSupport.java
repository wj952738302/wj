package com.jm.app.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * ProjectSupport entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "project_support", catalog = "jm")
public class ProjectSupport implements java.io.Serializable {

	// Fields

	private Integer id;
	private Project project;
	private Integer price;
	private Integer limited;
	private String description;

	// Constructors

	/** default constructor */
	public ProjectSupport() {
	}

	/** minimal constructor */
	public ProjectSupport(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public ProjectSupport(Integer id, Project project, Integer price,
			Integer limited, String description) {
		this.id = id;
		this.project = project;
		this.price = price;
		this.limited = limited;
		this.description = description;
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
	@JoinColumn(name = "projectid")
	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	@Column(name = "price")
	public Integer getPrice() {
		return this.price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	@Column(name = "limited")
	public Integer getLimited() {
		return this.limited;
	}

	public void setLimited(Integer limited) {
		this.limited = limited;
	}

	@Column(name = "description", length = 500)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}