<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>易买网 - 首页</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/function.js"></script>
<style type="text/css">
	#veryCode:hover{
		cursor:pointer;
	}
</style>
<script>
	var code = "";
	function changeMe(){
		var img = document.getElementById('veryCode');
		img.setAttribute("src", "servlet/VerifyCodeServlet?abc="+new Date().getTime());
		img.onload = function(){
			showCheckCode();
		}
	}
	
	function showCheckCode(){
		var xmlHttp;
		if(window.ActiveXObject){
			xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
		}else if(window.XMLHttpRequest){
			xmlHttp = new XMLHttpRequest();
		}
		
		xmlHttp.onreadystatechange = function(){
			if(xmlHttp.readyState == 4){     
	            if(xmlHttp.status == 200){
	           		code = xmlHttp.responseText;
	           	//	alert(code);
	            }
	        }
		};
		
		//设置请求参数
		xmlHttp.open("post", "servlet/GetCodeServlet", true);
		
		//发送请求(数据)
		xmlHttp.send(null);
	}
</script>
</head>
<body onLoad="changeMe()">
<%-- <%@ include file="top.jsp" %> --%>
<div id="register" class="wrap">
	<div class="shadow">
		<em class="corner lb"></em>
		<em class="corner rt"></em>
		<div class="box">
			<h1>欢迎回到易买网</h1>
			<form id="loginForm" method="post" action="dengLuServlet" onSubmit="return checkForm(this)">
				<table>
					<tr>
						<td class="field">用户名：</td>
						<td><input class="text" value="admin" type="text" name="userName" onFocus="FocusItem(this)" onBlur="CheckItem(this);" /><span></span></td>
					</tr>
					<tr>
						<td class="field">登录密码：</td>
						<td><input class="text" value="admin" type="password" id="passWord" name="passWord" onFocus="FocusItem(this)" onBlur="CheckItem(this);" /><span></span></td>
					</tr>
					<tr>
						<td class="field">验证码：</td>
						<td>
						<input class="text verycode" type="text" name="veryCode" onFocus="FocusItem(this)" onBlur="CheckItem(this);" />
						<img id="veryCode" src="" onClick="changeMe()"  /><span></span></td>
					</tr>
					<tr>
						<td>
							<input type="checkbox" name="c" value="yes" onClick="ziDongDengLu(this)">自动登录
				 			<div style="display: none;" id="d">
							 	<input type="radio" name="r" value="1">一周
							 	<input type="radio" name="r" value="2">一个月
							 	<input type="radio" name="r" value="3">三个月
				 			</div>
		 				</td>
						<td><label class="ui-green"><input type="submit" name="s" value="立即登录" /></label></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div   id="footer">
	 Copyright &copy; All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>