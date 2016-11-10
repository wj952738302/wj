package com.jm.app.bean;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Sms entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sms", catalog = "jm")
public class Sms implements java.io.Serializable {

	// Fields

	private Integer id;
	private String tel;
	private String content;
	private String status;
	private String message;
	private String remain;
	private String taskid;
	private Integer successes;
	private Timestamp sendtime;

	// Constructors

	/** default constructor */
	public Sms() {
	}

	/** full constructor */
	public Sms(String tel, String content, String status, String message,
			String remain, String taskid, Integer successes, Timestamp sendtime) {
		this.tel = tel;
		this.content = content;
		this.status = status;
		this.message = message;
		this.remain = remain;
		this.taskid = taskid;
		this.successes = successes;
		this.sendtime = sendtime;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "tel", length = 20)
	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Column(name = "content", length = 100)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "status", length = 10)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "message", length = 50)
	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Column(name = "remain", length = 10)
	public String getRemain() {
		return this.remain;
	}

	public void setRemain(String remain) {
		this.remain = remain;
	}

	@Column(name = "taskid", length = 50)
	public String getTaskid() {
		return this.taskid;
	}

	public void setTaskid(String taskid) {
		this.taskid = taskid;
	}

	@Column(name = "successes")
	public Integer getSuccesses() {
		return this.successes;
	}

	public void setSuccesses(Integer successes) {
		this.successes = successes;
	}

	@Column(name = "sendtime", length = 19)
	public Timestamp getSendtime() {
		return this.sendtime;
	}

	public void setSendtime(Timestamp sendtime) {
		this.sendtime = sendtime;
	}

}