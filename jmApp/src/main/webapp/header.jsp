<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<nav class="navbar navbar-default navbar-fixed-top"
	style="background:#FFF; color:#FFF;">
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

		<div class="collapse navbar-collapse"
			id="example-navbar-collapse text-center" style="margin-top: 10px">
			<ul class="nav navbar-nav navbar-left ">
				<li><a href="/jmApp/jm/MainAction.action"
					style="font-size: 18px">首页</a></li>
				<li><a href="/jmApp/jm/ProjectAction.action" style="font-size: 18px">影视投资</a></li>
				<li><a href="/jmApp/projectdelivery.jsp"
					style="font-size: 18px">项目投递</a></li>
				<!-- <li><a href="projectissue.html" style="font-size: 18px">发行</a></li> -->
				<li><a href="/jmApp/shangcheng.jsp" style="font-size: 18px">玖马商城</a></li>
				<li><a href="/jmApp/travel.jsp" style="font-size: 18px">影视旅游</a></li>
				<li><a href="/jmApp/list.jsp" style="font-size: 18px">关于</a></li>
			</ul>

			<ul class="nav navbar-nav navbar-right ">
				<li>
					<div class="btn-group" role="group" aria-label="..."
						style="margin-top: 10px;margin-right: 20px">
						<c:choose>
							<c:when test="${user==null}">
								<a href="/jmApp/login.jsp" class="btn btn-warning" role="button">登陆</a>
							</c:when>
							<c:otherwise>
								<a href="/jmApp/jm/UserAction.action" class="btn btn-warning" role="button">你好,${user.tel}</a>
							</c:otherwise>
						</c:choose>
					</div>
				</li>

				<li>
					<div class="btn-group" role="group" aria-label="..."
						style="margin-top: 10px">
						<c:choose>
							<c:when test="${user==null}">
								<a href="/jmApp/register.jsp" class="btn btn-default"
									role="button">注册</a>
							</c:when>
							<c:otherwise>
								<a href="/jmApp/login.jsp" class="btn btn-danger" role="button">退出</a>
							</c:otherwise>
						</c:choose>

					</div>
				</li>
			</ul>
		</div>
	</div>
</nav>