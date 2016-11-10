<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>电影众筹项目_电影投资项目列表 - 91玖马网</title>
<link rel="stylesheet" type="text/css"
	href="/jmApp/bootstrap-3.3.5-dist/css/bootstrap.min.css">
<link rel="stylesheet" href="/jmApp/circle_progress/css/progress.css">
<link rel="stylesheet"
	href="/jmApp/bootstrapvalidator/css/bootstrapValidator.min.css" />
</head>
<body>
	<nav class="navbar navbar-default navbar-fixed-top"
		style="background:#FFF; color:#FFF">
		<div class="container">
			<div class="navbar-header"
				style="margin-top: 10px;margin-bottom: 10px">
				<a class="navbar-brand" href="#" style="padding-top: 0"> <img
					src="/jmApp/img/91_logo.png">
				</a>
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#example-navbar-collapse">
					<span class="sr-only">切换导航</span> <span class="icon-bar"></span> <span
						class="icon-bar"></span> <span class="icon-bar"></span>
				</button>
			</div>
	</nav>
	<div style="background: #f5f5f5">
		<div class="jumbotron"
			style="background: url(/jmApp/img/images10.png) no-repeat;height: 500px;">
			<div class=" col-md-offset-8"
				style="margin-top: 3%;background-color:black;width: 350px;height:400px;background-color: rgba(0, 0, 0, 0.3);border-radius:4px">

				<div class="container">
					<h3>
						<font color="white"> 用户登陆 
					  <c:if test="${success==0}">
			     	   (注册成功 请登陆)
			     	 </c:if>
			     	 <c:choose>
			     	    <c:when test="${success==1 }">
			     	        (该手机号码未注册)
			     	    </c:when>
			     	    <c:when test="${success==2 }">
			     	        (密码输入错误)
			     	    </c:when>
			     	 </c:choose>
						</font>
					</h3>

					 <form id="login_frm" role="form" action="/jmApp/jm/LoginAction.action">
			     	    <div class="form-group">
			     	       <input id="tel" name="tel" class="form-control" id="exampleInputEmail1" placeholder="手机号码">
			     	       <span id="tel_message"></span>
			     	    </div>
			     	 	<div class="form-group">
			     	 	     <input id="password" name="password" class="form-control" id="exampleInputEmail1" placeholder="登陆密码">
			     	 	     <span id="password_message"></span>
			     	 	</div>
			     	 	 <div class="text-right" style="margin-top: 20px">
			     	 	 	 <a href="#"><h5><font color="white">忘记密码?</font></h5></a>
			     	 	 </div>
			     	 	 <div style="margin-top: 80px">
			     	 	 </div>
			     	 	 <div class="row" style="margin-left: 4px;margin-right: 4px">
			     	 	    <!--
			     	 	 	 <button type="submit" class="btn btn-warning col-md-12"><font size="4px" ><b>立即登陆</b></font></button>
			     	 	 	 -->
			     	 	 	<button type="submit" class="btn btn-warning col-md-12" style="font-size: 18px;font-weight:bold">
								立即登陆
							</button>
			     	 	 </div>
			     	 	 <div class="row" style="margin-top: 20px;margin-left: 4px;margin-right: 4px">
			     	 	 	 <a class="btn btn-success col-md-12" href="/jmApp/register.jsp" role="button"><font size="4px" ><b>用户注册</b></font></a>
			     	 	 </div>
			     	 </form>
				</div>

			</div>
		</div>

		<div class="container">
			<div class="row" style="margin-top: 50px">
				<div class="col-md-3">
					<div class="col-md-3" style="margin-top: 16px">
						<span class="label label-warning" style="font-size: 25px">技</span>
					</div>
					<div class="col-md-9 text-left">
						<h6>
							<b>技术保障</b>
						</h6>
						<h6 class="text-muted">还款保障 资金托管</h6>
					</div>
				</div>
				<div class="col-md-3">
					<div class="col-md-3" style="margin-top: 16px">
						<span class="label label-warning" style="font-size: 25px">价</span>
					</div>
					<div class="col-md-9 text-left">
						<h6>
							<b>价格保障</b>
						</h6>
						<h6 class="text-muted">年化收益高于12%</h6>
					</div>
				</div>
				<div class="col-md-3">
					<div class="col-md-3" style="margin-top: 16px">
						<span class="label label-warning" style="font-size: 25px">险</span>
					</div>
					<div class="col-md-9 text-left">
						<h6>
							<b>风险保障</b>
						</h6>
						<h6 class="text-muted">领投机制 公开透明</h6>
					</div>
				</div>
				<div class="col-md-3">
					<div class="col-md-3" style="margin-top: 16px">
						<span class="label label-warning" style="font-size: 25px">法</span>
					</div>
					<div class="col-md-9 text-left">
						<h6>
							<b>法律保障</b>
						</h6>
						<h6 class="text-muted">凯旋律师事务所承担法律顾问</h6>
					</div>
				</div>
			</div>
		</div>
		<div class="container" style="margin-top: 10px">
			<div class="row">
				<div class="col-md-3 ">
					<div class="col-md-9 col-md-offset-3">
						<h6>
							<b>关于我</b>
						</h6>
						<h6>
							<a href="#">创始人寄语</a>
						</h6>
						<h6>
							<a href="#">平台优势</a>
						</h6>
						<h6>
							<a href="#">媒体报道</a>
						</h6>
						<h6>
							<a href="#">往期项目</a>
						</h6>
					</div>

				</div>
				<div class="col-md-3 ">
					<div class="col-md-9 col-md-offset-3">
						<h6>
							<b>帮助中心</b>
						</h6>
						<h6>
							<a href="#">投资指南</a>
						</h6>
						<h6>
							<a href="#">常见问题</a>
						</h6>
						<h6>
							<a href="#">在线招聘</a>
						</h6>
					</div>
				</div>
				<div class="col-md-3 ">
					<div class="col-md-9 col-md-offset-3">
						<h6>
							<b>联系方式</b>
						</h6>
						<h6 class="text-muted">QQ群 2222222</h6>
						<h6 class="text-muted">客户热线 400-800-900</h6>
						<h6 class="text-muted">(周一至周日 8:00-18:00)</h6>
					</div>
				</div>
				<div class="col-md-3 ">
					<div class="col-md-9 col-md-offset-3">
						<h6>
							<b>关注我们</b>
						</h6>
					</div>
				</div>
			</div>
		</div>
		<footer id="footer">
			<div class="container text-center">
				<p class="text-muted">
					友情连接： <a href="http://www.cmbchina.com/" target="_blank"
						class="text-muted">招商银行</a> <a
						href="http://www.zhongchoutimes.com/" target="_blank"
						class="text-muted">众筹时代</a> <a href="http://www.wdzx.com/"
						target="_blank" class="text-muted">网贷中心</a> <a
						href="https://www.omniaccount.com/" target="_blank"
						class="text-muted">大账户</a> <a href="http://www.zhongchoujia.com/"
						target="_blank" class="text-muted">众筹家</a> <a
						href="http://www.zcworks.cn/webadmin/admin/main.action"
						target="_blank" class="text-muted">众筹工坊</a> <a
						href="http://www.xeenho.com/" target="_blank" class="text-muted">星火钱包</a>
					<a href="http://www.d3f.com/" target="_blank" class="text-muted">众筹第三方</a>
				</p>
				<p class="text-muted">©2016杭州91玖马信息服务有限公司all rights reserved
					浙ICP备15007777号-7</p>
				<p>
					<a href="http://www.cmbchina.com/" target="_blank"><img
						src="/jmApp/img/zsyh.png" alt="" height="20"></a> <a
						href="http://www.hzbank.com.cn/" target="_blank"><img
						src="/jmApp/img/hzyh.png" alt="" height="20"></a> <a
						href="http://www.aliyun.com/?utm_medium=text&utm_source=bdbrand&utm_campaign=bdbrand&utm_content=se_32492"
						target="_blank"><img src="/jmApp/img/aliyun.png" alt=""
						height="20"></a> <a href="http://www.newtiming.net/"
						target="_blank"><img src="/jmApp/img/xindingm.png" alt=""
						height="20"></a> <a href="http://www.wisdomfish.com/"
						target="_blank"><img src="/jmApp/img/weide.png" alt=""
						height="20"></a> <a href="http://www.timeast.net/index.html"
						target="_blank"><img src="/jmApp/img/donghua.png" alt=""
						height="20"></a> <a href="#"><img
						src="/jmApp/img/toutiao.png" alt="" height="20"></a>
				</p>
				<p>
					<a
						href="https://sealinfo.verisign.com/splash?form_file=fdf/splash.fdf&amp;dn=www.jumifinance.com&amp;lang=zh_cn"
						rel="nofollow" target="_blank"><img
						src="/jmApp/img/safy-norton.png" alt="" height="30"></a> <a
						href="http://www.itrust.org.cn/Home/Index/itrust_certifi?wm=1328207021"
						target="_blank" rel="nofollow"><img
						src="/jmApp/img/safy-icp.png" alt="" height="30"></a> <a
						href="http://webscan.360.cn/index/checkwebsite/url/www.jumifinance.com"
						target="_blank" rel="nofollow"><img
						src="/jmApp/img/safy-360.png" alt="" height="30"></a>
				</p>
			</div>
		</footer>
	</div>
	<script src="/jmApp/bootstrap-3.3.5-dist/js/jquery.min.js"></script>
	<script src="/jmApp/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
	<script type="text/javascript"
		src="/jmApp/circle_progress/dist/jquery-asPieProgress.min.js"></script>
	<script src="/jmApp/bootstrapvalidator/js/bootstrapValidator.js"></script>
</body>
<script type="text/javascript">
	$(document).ready(function() {
		$('#login_frm').bootstrapValidator({

			feedbackIcons : {
				valid : 'glyphicon glyphicon-ok',
				invalid : 'glyphicon glyphicon-remove',
				validating : 'glyphicon glyphicon-refresh'
			},
			fields : {

				tel : {
					container : '#tel_message',
					validators : {
						notEmpty : {
							message : '手机号码不能为空'
						},
						regexp : {
							regexp : /^1[3|4|5|7|8][0-9]{9}$/,
							message : '手机号码输入错误'
						}
						
						
					}

				},
				password : {
					container : '#password_message',
					validators : {
						notEmpty : {
							message : '密码不能为空'
						},
						regexp : {
							regexp : /^(\w){6,20}$/,
							message : '只能输入6-20个字母、数字、下划线'
						}
					}
				}
			}
		});
	});
</script>
</html>