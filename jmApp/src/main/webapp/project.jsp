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
<link rel="stylesheet" href="/jmApp/css/style.css">
<style type="text/css">
.pie_progress {
	width: 120px;
}

@media all and (max-width: 768px) {
	.pie_progress {
		width: 80%;
		max-width: 300px;
	}
}
</style>
<script src="/jmApp/bootstrap-3.3.5-dist/js/jquery.min.js"></script>
<script src="/jmApp/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="/jmApp/circle_progress/dist/jquery-asPieProgress.min.js"></script>
<script type="text/javascript">
	$(document).ready(
			function() {
				$("#type-group a.btn").click(
						function(e) {
							$("#type-group a.btn").removeClass('btn-info');
							$(this).addClass('btn-info');
							var type_href = $("#type-group a.btn-info").attr(
									"href");
							var status_href = $("#status-group a.btn-info")
									.attr("href");
							var sub_status_href = status_href.split("?");
							if (sub_status_href[1] != null) {
								if (type_href.indexOf("?") > 0) {
									$("#type-group a.btn-info").attr(
											"href",
											type_href + "&"
													+ sub_status_href[1]);
								} else {
									$("#type-group a.btn-info").attr(
											"href",
											type_href + "?"
													+ sub_status_href[1]);
								}
							}

						});
				$("#status-group a.btn").click(
						function(e) {
							$("#status-group a.btn").removeClass('btn-info');
							$(this).addClass('btn-info');
							var type_href = $("#type-group a.btn-info").attr(
									"href");
							var status_href = $("#status-group a.btn-info")
									.attr("href");
							var sub_type_href = type_href.split("?");
							if (sub_type_href[1] != null) {
								if (status_href.indexOf("?") > 0) {
									$("#status-group a.btn-info").attr(
											"href",
											status_href + "&"
													+ sub_type_href[1]);
								} else {
									$("#status-group a.btn-info").attr(
											"href",
											status_href + "?"
													+ sub_type_href[1]);
								}
							}

						});
			});
</script>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div
		style="background: url(/jmApp/img/top.jpg) no-repeat top center ;height: 360px;width: 100%">
	</div>
	<div style="background: #f5f5f5">
		<div class="container">
			<div style="height: 40px;margin-top: 20px">
				<i class="border-left"></i> <strong>项目类型</strong>
				<div id="type-group" class="btn-group" role="group" aria-label="...">
					<a role="button"
						class="btn btn-default ${(param.type==null || param.type.length()==0)?'btn-info':'' }"
						href="/jmApp/jm/ProjectAction.action">全部</a> <a role="button"
						class="btn btn-default ${(param.type!=null && param.type.length()>0 && param.type.equals('0'))?'btn-info':''}"
						href="/jmApp/jm/ProjectAction.action?type=0">影视娱乐</a> <a role="button"
						class="btn btn-default ${(param.type!=null && param.type.length()>0 && param.type.equals('1'))?'btn-info':''}"
						" href="/jmApp/jm/ProjectAction.action?type=1">泛文化</a>
				</div>
			</div>
			<div style="height: 40px;margin-top: 10px">
				<i class="border-left"></i> <strong>项目状态</strong>
				<div id="status-group" class="btn-group" role="group"
					aria-label="...">
					<a role="button"
						class="btn btn-default ${(param.status==null|| param.status.length()==0)?'btn-info':'' }"
						href="/jmApp/jm/ProjectAction.action">全部</a> <a role="button"
						class="btn btn-default ${(param.status!=null && param.status.length()>0 && param.status.equals('0'))?'btn-info':''}"
						href="/jmApp/jm/ProjectAction.action?status=0">即将开始</a> <a role="button"
						class="btn btn-default ${(param.status!=null && param.status.length()>0 && param.status.equals('1'))?'btn-info':''}"
						href="/jmApp/jm/ProjectAction.action?status=1">正在众筹</a> <a role="button"
						class="btn btn-default ${(param.status!=null && param.status.length()>0 && param.status.equals('2'))?'btn-info':''}"
						href="/jmApp/jm/ProjectAction.action?status=2">众筹结束</a> <a role="button"
						class="btn btn-default ${(param.status!=null && param.status.length()>0 && param.status.equals('3'))?'btn-info':''}"
						href="/jmApp/jm/ProjectAction.action?status=3">完成兑付</a>
				</div>
			</div>
		</div>
		<div class="row" style="margin-left: 50px;margin-top: 20px">
			<c:forEach items="${proList}" var="project">
				<div class="col-sm-6 col-md-4">
					<div class="thumbnail  course-list-img">
						<a href="detail.html"><img class="img_3"
							src="/jmApp/project/${project.picture}"></a>
						<div class="caption">
							<div class="row">
								<div class="col-md-7">
									<a href="detail.html">
										<h5>${project.title}</h5>
									</a>
								</div>
								<div class="col-md-5">
									<button class="btn btn-warning" type="button">
										转化率 <span class="badge">${project.converted }%</span>
									</button>
								</div>
							</div>
						</div>
						<div class="progress" style="height: 3px">
							<div class="progress-bar" role="progressbar"
								aria-valuenow="${project.investRate}" aria-valuemin="0"
								aria-valuemax="100" style="width: ${project.investRate}%;"></div>
						</div>
						<div class="row">
							<div class="col-md-4 text-center ">
								<div class="text-primary">
									<b>${project.investRate}%</b>
								</div>
								<div class="text-muted">
									<b>已完成</b>
								</div>
							</div>
							<div class="col-md-4 text-center ">
								<div class="text-primary">
									<b>${project.target/10000}万元</b>
								</div>
								<div class="text-muted">
									<b>目标金额</b>
								</div>
							</div>
							<div class="col-md-4 text-center ">
								<div class="text-primary">
									<b>${project.period}个月</b>
								</div>
								<div class="text-muted">
									<b>回报周期</b>
								</div>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
		<jsp:include page="tailer.jsp"></jsp:include>
	</div>
</body>
</html>