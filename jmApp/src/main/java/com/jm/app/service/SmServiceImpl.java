package com.jm.app.service;

import java.io.StringReader;
import java.sql.Timestamp;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.jm.app.bean.Sms;
import com.jm.app.bean.xml.Returnsms;
import com.jm.app.dao.SmsDAO;
import com.jm.app.util.HttpClientInstance;

public class SmServiceImpl implements SmService {

//	private String contentTemp="尊敬的客户你好，你的验证码是@【玖马娱乐】"; //发送内容的模板 @用来替换的
//	
//	private String url="http://dx.ipyy.net/sms.aspx"; //短信发送的url地址
//	
//	private String account="AA00470"; //短信平台账号
//	
//	private String password="AA0047066"; //短信平台密码
	
	private String contentTemp;
	
	private String url;
	
	private String account;
	
	private String password;
	
	private SmsDAO smsDao;
	
	
	@Override
	public void sendMessage(String tel, String content) {
		// TODO Auto-generated method stub
		String realContent=contentTemp.replace("@", content);
        String smsUrl=url+"?action=send&userid=&account="+account+"&password="+password+"&mobile="+tel+"&content="+realContent+"&sendTime=&extno=";
        
        new Thread(new SmsRunnable(smsUrl,tel,content)).start();
	}



	public String getUrl() {
		return url;
	}



	public void setUrl(String url) {
		this.url = url;
	}



	public String getAccount() {
		return account;
	}



	public void setAccount(String account) {
		this.account = account;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getContentTemp() {
		return contentTemp;
	}



	public void setContentTemp(String contentTemp) {
		this.contentTemp = contentTemp;
	}

	
	
	public SmsDAO getSmsDao() {
		return smsDao;
	}



	public void setSmsDao(SmsDAO smsDao) {
		this.smsDao = smsDao;
	}



	private class SmsRunnable implements Runnable{

		private HttpClientInstance instance=new HttpClientInstance();
		
		private String smsUrl;
		private String tel;
		private String content;
		
		public SmsRunnable(String smsUrl,String tel,String content)
		{
			this.smsUrl=smsUrl;
			this.tel=tel;
			this.content=content;
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			String res=instance.sendGet(smsUrl);
			try {
				JAXBContext jaxbContext = JAXBContext.newInstance(Returnsms.class);
				Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
				StringReader sr=new StringReader(res);
				Returnsms rsms=(Returnsms)jaxbUnmarshaller.unmarshal(sr);
				Sms sms=new Sms();
				sms.setContent(content);
				sms.setTel(tel);
				sms.setMessage(rsms.getMessage());
				sms.setRemain(rsms.getRemainpoint());
				sms.setStatus(rsms.getReturnstatus());
				sms.setSuccesses(Integer.valueOf(rsms.getSuccessCounts()));
				sms.setTaskid(rsms.getTaskID());
				Date now=new Date();
				sms.setSendtime(new Timestamp(now.getTime()));
				smsDao.save(sms);
				System.out.println(rsms);
			} catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
    public static void main(String[] args) {
		
    	SmServiceImpl service=new SmServiceImpl();
    	service.sendMessage("15590078865", "1234");
	}
}
