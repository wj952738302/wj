package com.jm.app.bean.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Returnsms {
	
	private String returnstatus; //返回状态值：成功返回Success 失败返回：Faild
	
	private String message; //相关的错误描述
	
	private String remainpoint; //返回余额
	
	private String taskID; //返回本次任务的序列ID
	
	private String successCounts; //成功短信数：当成功后返回提交成功短信数

	@XmlElement  
	public String getReturnstatus() {
		return returnstatus;
	}

	public void setReturnstatus(String returnstatus) {
		this.returnstatus = returnstatus;
	}
	@XmlElement  
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	@XmlElement  
	public String getRemainpoint() {
		return remainpoint;
	}

	public void setRemainpoint(String remainpoint) {
		this.remainpoint = remainpoint;
	}
	@XmlElement  
	public String getTaskID() {
		return taskID;
	}

	public void setTaskID(String taskID) {
		this.taskID = taskID;
	}
	@XmlElement  
	public String getSuccessCounts() {
		return successCounts;
	}

	public void setSuccessCounts(String successCounts) {
		this.successCounts = successCounts;
	}

	@Override
	public String toString() {
		return "Returnsms [returnstatus=" + returnstatus + ", message="
				+ message + ", remainpoint=" + remainpoint + ", taskID="
				+ taskID + ", successCounts=" + successCounts + "]";
	}
	
}
