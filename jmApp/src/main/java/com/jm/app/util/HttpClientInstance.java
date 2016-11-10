package com.jm.app.util;

import java.io.IOException;

import org.apache.commons.httpclient.ProtocolException;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * http客户端应用类
 * @author songwp 2016-10-08
 *
 */
public class HttpClientInstance {
	
	
		/**
		 * 发送get请求
		 * @param url 请求地址
		 * @return
		 */
		public String sendGet(String url)
		{
			 CloseableHttpClient httpclient = HttpClients.createDefault();
			 try {  
		            // 创建httpget.    
		            HttpGet httpget = new HttpGet(url);  
		            System.out.println("executing request " + httpget.getURI());  
		            // 执行get请求.    
		            CloseableHttpResponse response = httpclient.execute(httpget);  
		            try {  
		                // 获取响应实体    
		                HttpEntity entity = response.getEntity();  
		                System.out.println("--------------------------------------");  
		                // 打印响应状态    
		                System.out.println(response.getStatusLine());  
		                if (entity != null) {  
		                    // 打印响应内容长度    
		                    System.out.println("Response content length: " + entity.getContentLength());  
		                    // 打印响应内容    
		                    String res=EntityUtils.toString(entity);
		                    System.out.println("Response content: " + res); 
		                    return res;
		                }  
		                System.out.println("------------------------------------");  
		            } finally {  
		                response.close();  
		            }  
		        } catch (ClientProtocolException e) {  
		            e.printStackTrace();  
		        } catch (ProtocolException e) {  
		            e.printStackTrace();  
		        } catch (IOException e) {  
		            e.printStackTrace();  
		        } finally {  
		            // 关闭连接,释放资源    
		            try {  
		                httpclient.close();  
		            } catch (IOException e) {  
		                e.printStackTrace();  
		            }  
		        }  
			 return null;
		}

		public static void main(String[] args) {
			
			HttpClientInstance instance=new HttpClientInstance();
			String res=instance.sendGet("http://dx.ipyy.net/sms.aspx?action=send&userid=&account=AA00470&password=AA0047066&mobile=15590078865&content=%E5%B0%8A%E6%95%AC%E7%9A%84%E5%AE%A2%E6%88%B7%E4%BD%A0%E5%A5%BD%EF%BC%8C%E4%BD%A0%E7%9A%84%E9%AA%8C%E8%AF%81%E7%A0%81%E6%98%AF1234%E3%80%90%E7%8E%96%E9%A9%AC%E5%A8%B1%E4%B9%90%E3%80%91&sendTime=&extno=");
			System.out.println(res);
		}

}
