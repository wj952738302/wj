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
import javax.persistence.Transient;

/**
 * User entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user", catalog = "jm")
public class User implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String password;
	private String tel;
	private String picture;
	private String realName;
	private String idCardNum;
	private String bankCardNum;
	private Integer sex;
	private String province;
	private String city;
	private String postcode;
	private String consignee;
	private String consignTel;
	private String address;
	private String email;
	private Set<Prorder> prorders = new HashSet<Prorder>(0);

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public User(Integer id, String name, String password, String tel,
			String picture, String realName, Integer sex, String province,
			String city, String postcode, String consignee, String consignTel,
			String address, String email, Set<Prorder> prorders) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.tel = tel;
		this.picture = picture;
		this.realName = realName;
		this.sex = sex;
		this.province = province;
		this.city = city;
		this.postcode = postcode;
		this.consignee = consignee;
		this.consignTel = consignTel;
		this.address = address;
		this.email = email;
		this.prorders = prorders;
	}

	// Property accessors
	@Id  @GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "name", length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "password", length = 50)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "tel", length = 20)
	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Column(name = "picture", length = 50)
	public String getPicture() {
		return this.picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	@Column(name = "realName", length = 50)
	public String getRealName() {
		return this.realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	@Column(name = "sex")
	public Integer getSex() {
		return this.sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	@Column(name = "province", length = 20)
	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	@Column(name = "city", length = 20)
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "postcode", length = 20)
	public String getPostcode() {
		return this.postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	@Column(name = "consignee", length = 20)
	public String getConsignee() {
		return this.consignee;
	}

	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}

	@Column(name = "consignTel", length = 20)
	public String getConsignTel() {
		return this.consignTel;
	}

	public void setConsignTel(String consignTel) {
		this.consignTel = consignTel;
	}

	@Column(name = "address", length = 50)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "email", length = 50)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name = "idCardNum", length = 50)
	public String getIdCardNum() {
		return idCardNum;
	}

	public void setIdCardNum(String idCardNum) {
		this.idCardNum = idCardNum;
	}
	
	@Column(name = "bankCardNum", length = 50)
	public String getBankCardNum() {
		return bankCardNum;
	}

	public void setBankCardNum(String bankCardNum) {
		this.bankCardNum = bankCardNum;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Prorder> getProrders() {
		return this.prorders;
	}

	public void setProrders(Set<Prorder> prorders) {
		this.prorders = prorders;
	}
    
	
	
}