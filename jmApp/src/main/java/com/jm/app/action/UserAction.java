package com.jm.app.action;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.jm.app.bean.Prorder;
import com.jm.app.bean.User;
import com.jm.app.dao.UserDAO;
import com.jm.app.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {

	private UserService userService;
	
	private ActionContext context;
	
	private Map<String,Object> request;
	
	private Map<String,Object> session;
	
	private File image;//对应的就是表单中文件上传的那个输入域的名称，Struts2框架会封装成File类型的
	private String imageFileName;//   上传输入域FileName  文件名
	private String imageContentType;// 上传文件的MIME类型
	private Map<String,String> uploadMap; //文件上传返回信息
	
	private String name; //用户的名称
	private int sex; //用户的性别
	private User userAddress=new User(); //用户信息
	
	@Override
	public String execute() throws Exception {

		context=ActionContext.getContext();
		request=(Map) context.get("request");
		session=(Map) context.getSession();
		
        User user=(User)session.get("user");
        if(user==null)
        	return ERROR;
        else{
        	int[][] totalSumByType=userService.getSumbyType(user.getTel());
        	request.put("totalSumByType", totalSumByType);
        	int[][] totalSumByEnd=userService.getSumByEnd(user.getTel());
        	request.put("totalSumByEnd", totalSumByEnd);
        	List<Prorder> endOrderList=userService.getProrderByEnd(user.getTel(), true);
        	request.put("endOrderList", endOrderList);
        	List<Prorder> inOrderList=userService.getProrderByEnd(user.getTel(), false);
        	request.put("inOrderList", inOrderList);
        	List<Prorder> allOrderList=userService.getAllProder(user.getTel());
        	request.put("allOrderList", allOrderList);
        	Map<Integer,List<Prorder>> orderMap=userService.getProrderByStatus(user.getTel());
        	request.put("orderMap", orderMap);
        	return SUCCESS;
        }
	}
    
	public String uploadImage()
	{
		HttpSession session=ServletActionContext.getRequest().getSession();
		User user=(User)session.getAttribute("user");
		//获取服务在服务器的绝对路径
		String contextPathString = session.getServletContext().getRealPath("/");  
		//创建文件对象
		File savefile = new File(contextPathString+"/user_image",user.getTel()+".jpg"); 
		try {
			FileUtils.copyFile(image, savefile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String imgurl="/jmApp/user_image/"+user.getTel()+".jpg";
		uploadMap=new HashMap<String,String>();
		uploadMap.put("imageUrl", imgurl);
		
		userService.updateUserPic(user.getId(),imgurl);
		user.setPicture(imgurl);
		return SUCCESS;
	}
	
	public String saveInfo()
	{
		context=ActionContext.getContext();
		session=(Map) context.getSession();
		User user=(User)session.get("user");
		userService.updateUser(user.getId(), name,sex);
		user.setName(name);
		user.setSex(sex);
		
		return SUCCESS;
	}
	
    public String saveAddress()
    {
    	context=ActionContext.getContext();
		session=(Map) context.getSession();
		User user=(User)session.get("user");
		user=userService.getUser(user.getId());
		user.setAddress(userAddress.getAddress());
		user.setProvince(userAddress.getProvince());
		user.setCity(userAddress.getCity());
		user.setPostcode(userAddress.getPostcode());
		user.setConsignee(userAddress.getConsignee());
		user.setConsignTel(userAddress.getConsignTel());
		userService.updateUser(user);
		session.put("user", user);
		return SUCCESS;
    }
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public String getImageContentType() {
		return imageContentType;
	}

	public void setImageContentType(String imageContentType) {
		this.imageContentType = imageContentType;
	}

	public Map<String, String> getUploadMap() {
		return uploadMap;
	}

	public void setUploadMap(Map<String, String> uploadMap) {
		this.uploadMap = uploadMap;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public User getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(User userAddress) {
		this.userAddress = userAddress;
	}

}
