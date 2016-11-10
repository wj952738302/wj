<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>学生管理系统</title>
<link rel="stylesheet" type="text/css"
	href="/StudentSys_fw2/assets/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="/StudentSys_fw2/assets/css/bootstrapValidator.css" />
<script src="/StudentSys_fw2/assets/js/jquery.min.js"></script>
<script src="/StudentSys_fw2/assets/js/bootstrap.min.js"></script>
<script src="/StudentSys_fw2/sweetalert/dist/sweetalert.min.js"></script>
<script src="/StudentSys_fw2/assets/js/bootstrapValidator.js"></script>
<link rel="stylesheet" type="text/css"
	href="/StudentSys_fw2/sweetalert/dist/sweetalert.css">
<script type="text/javascript">
	$(document).ready(function() {
		$('tbody tr').click(function(e) {
			e.preventDefault();

			$('tbody tr').removeClass('success');
			$(this).addClass('success');
		});

		$('#btn_cls_del').click(function(e) {
			var name = $('a.active').text();
			var id = $('a.active').text();
			swal({
				title : "删除班级",
				text : "你确定删除 " + name + "？",
				type : "warning",
				showCancelButton : true,
				confirmButtonColor : "#DD6B55",
				confirmButtonText : "是的, 删除它!",
				cancelButtonText : "取消",
				closeOnConfirm : false
			}, function() {
			    $('input#cname').val('name')
			    $('input#ctname').val('tname')
			    
				$('form#frm_cls_del').attr("action", "/StudentSys_fw2/main/clsDel.action");
				$('form#frm_cls_del').submit();
			});
		});

		$('#btn_std_del').click(function(e) {
			var name = $('tr.success').children("#name").text();
			var id = $('tr.success').children("#id").text();
			swal({
				title : "删除学生",
				text : "你确定删除 " + name + "？",
				type : "warning",
				showCancelButton : true,
				confirmButtonColor : "#DD6B55",
				confirmButtonText : "是的, 删除它!",
				cancelButtonText : "取消",
				closeOnConfirm : false
			}, function() {
				$('input#sId').val(id);
				
				$('form#frm_std_del').attr("action","/StudentSys_fw2/main/studDel.action");
				$('form#frm_std_del').submit();
			});
		});

		$('#btn_std_add').click(function(e) {
			var exampleModalLabel = $('h4#exampleModalLabel').text("添加学生信息")
			$('input#id').val("");
			$('input#sname').val("");
			$('input#scode').val("");
			$('input#ssex_m').removeAttr("checked");
			$('input#ssex_w').removeAttr("checked");
			$('input#ssex_m').attr("checked");
			$('input#ssex_m').click();
			$('input#sbirth').val("");
			var action = $('form#frm_std').attr("action");
			$('form#frm_std').attr("action", "/StudentSys_fw2/main/studAdd.action");
		});

		$('#btn_cls_add').click(function(e) {
			var exampleModalLabel = $('h4#exampleModalLabel').text("添加班级信息")
			$('input#clsId').val("");
			$('input#cname').val("");
			$('input#ctname').val("");

			$('form#frm_cls').attr("action", "/StudentSys_fw2/main/clsAdd.action");
		});

		$('#btn_std_edit').click(function(e) {
			var exampleModalLabel = $('h4#exampleModalLabel').text("修改学生信息")
			var code = $('tr.success').children("#code").text();
			var name = $('tr.success').children("#name").text();
			var sex = $('tr.success').children("#sex").text();
			var birth = $('tr.success').children("#birth").text();
			var id = $('tr.success').children("#id").text();
			$('input#sname').val(name);
			$('input#scode').val(code);
			$('input#ssex_m').removeAttr("checked");
			$('input#ssex_w').removeAttr("checked");
			if (sex == '男') {
				$('input#ssex_m').attr("checked", "checked");
				$('input#ssex_m').click();
			} else {
				$('input#ssex_w').attr("checked", "checked");
				$('input#ssex_w').click();
			}
			$('input#sbirth').val(birth);
			$('input#stuId').val(id);
			$('form#frm_std').attr("action", "/StudentSys_fw2/main/studEdit.action");
		});

		$('#btn_cls_edit').click(function(e) {
			var exampleModalLabel = $('h4#exampleModalLabel').text("编辑班级信息")
			var name = $('a.active').text();
			var tname = $('strong#teacher').text();
			$('input#cname').val(name);
			$('input#ctname').val(tname);

			var action = $('form#frm_cls').attr("action");
			$('form#frm_cls').attr("action", "/StudentSys_fw2/main/clsEdit.action");
		});

	});
</script>
<%-- <script type="text/javascript">
	$(document).ready(function() {
		$('#frm_std').bootstrapValidator({
			feedbackIcons : {
				valid : 'glyphicon glyphicon-ok',
				invalid : 'glyphicon glyphicon-remove',
				validating : 'glyphicon glyphicon-refresh'
			},
			fields : {
				scode : {
					group : '.form-group',
					validators : {
						notEmpty : {
							message : '学生编号不允许为空'
						}
					}
				},

				sname : {
					group : '.form-group',
					validators : {
						notEmpty : {
							message : '学生姓名不允许为空'
						},
						stringLength : {
							min : 2,
							max : 5,
							message : '姓名做少2个，最对5个'
						},

					}
				},
				sbirth : {
					group : '.form-group',
					validators : {
						date : {
							format : 'YYYY-MM-DD',
							message : '按照格式yyyy-mm-dd输入'
						},
						notEmpty : {
							message : '学生生日不允许为空'
						}
					}
				},
			}

		});
		$('#resetbtn').click(function() {
			$('#frm_std').data('bootstrapValidator').resetForm(true);
		});

	});
</script> --%>
<%-- <script type="text/javascript">
	$(document).ready(function() {
		$('#frm_cls').bootstrapValidator({
			feedbackIcons : {
				valid : 'glyphicon glyphicon-ok',
				invalid : 'glyphicon glyphicon-remove',
				validating : 'glyphicon glyphicon-refresh'
			},
			fields : {
				cname : {
					group : '.form-group',
					validators : {
						notEmpty : {
							message : '班名不允许为空'
						},
						stringLength : {
							min : 4,
							max : 5,
							message : '班名字符做少4个，最多5个'
						},

					}
				},
				ctname : {
					group : '.form-group',
					validators : {
						notEmpty : {
							message : '教师名字不允许为空'
						},
						stringLength : {
							min : 2,
							max : 5,
							message : '教师名字做少2个，最多5个'
						},

					}
				},

			}

		});

	});
</script> --%>
</head>
<body>
	<nav class="navbar navbar-default" style="height: 60px">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#"> <img alt="Brand"
					src="/StudentSys_fw2/img/logo.png" height="35px" width="200px">
				</a>
			</div>
			<form action="/StudentSys_fw2/main/returnAction.action" method="post">
			<button type="submit" class="btn btn-warning btn-xs navbar-right"
				style="margin-top: 20px; margin-right: 20px;margin-left: 20px">退出
				</button>
				</form>
			<h5 class="navbar-text navbar-right" style="margin-top: 25px">
				<%-- <strong>你好，${sessionScope.user.name}&nbsp;&nbsp;&nbsp;&nbsp;(当前&nbsp;${onlineNum}&nbsp;人在线)</strong> --%>
				<strong>你好，<s:property value="#session.user.name"/>&nbsp;&nbsp;&nbsp;&nbsp;(当前&nbsp;<s:property value="#application.onlineNum"/>&nbsp;人在线)</strong>
			</h5>
			<button id="btn_cls_add" type="button"
				class="btn btn-info  btn-sm navbar-right" data-toggle="modal"
				data-target="#classModal"
				style="margin-top: 18px;margin-right: 50px;">添加班级</button>
			<button id="btn_cls_edit" type="button"
				class="btn btn-info  btn-sm navbar-right" data-toggle="modal"
				data-target="#classModal"
				style="margin-top: 18px;margin-right: 20px;margin-left: 20px;">编辑班级</button>
			<button id="btn_cls_del" type="button"
				class="btn btn-info  btn-sm navbar-right" style="margin-top: 18px;">删除班级</button>
		</div>
	</nav>
	<div class="container-fluid">
		<div class="row">
			<div class="container col-md-3">
				<div class="panel panel-default">
					<div class="panel-body">
						<div class="list-group">
							<%-- <c:forEach items="${nameMap}" var="entry">
								<a id="list-group-item-${entry.key }"
									href="/StudentSys_fw2/main/mainActivion.action?clsId=${entry.key}"
									class="list-group-item ${entry.key==cls.id?'active':''}">${entry.value}</a>
							</c:forEach> --%>
							<s:iterator value="nameMap">
							        <a id="list-group-item-<s:property value='key'/>"
									href="/StudentSys_fw2/main/mainActivion.action?clsId=<s:property value='key'/>"
									class="list-group-item <s:property value='key==#request.cls.id?"active":""'/>">
									<s:property value='value'/>
									</a>
							</s:iterator>
						</div>
					</div>
				</div>
			</div>
			<div class="container col-md-9">

				<div class="panel panel-default">
					<!-- Default panel contents -->
					<div class="panel-heading">
						<div class="row">
							<div class="col-md-2">
								<h4>
									<strong><s:property value="#request.cls.name"/></strong>
								</h4>
							</div>
							<div class="col-md-8">
							
								<h4>班级总共：<s:property value="%{#request.count[1] + #request.count[0]}"/>人，其中男生：<s:property value="#request.count[1]"/>人，女生：<s:property value="#request.count[0]"/>人</h4>
							</div>
							<div class="col-md-2">
								<h4>
									班主任：<strong id="teacher"><s:property value="#request.cls.t_name"/></strong>
								</h4>
							</div>
						</div>
					</div>
					<div class="panel-body">
						<div class="col-md-5">
							<form action="/StudentSys_fw2/main/mainActivion.action" class="form-inline">

								<!--  <input id="clsId" name="clsId" type="hidden" value="${cls.id}">-->
								<input id="clsId" name="clsId" type="hidden" value="<s:property value="#request.cls.id"/>">
								<div class="form-group">
									<label for="exampleInputName2">姓名</label> <input
										name="findName" type="text" class="form-control"
										id="exampleInputName2" placeholder="输入姓名">
								</div>
								<button type="submit" class="btn btn-default">查询</button>
							</form>
						</div>
						<div class="col-md-7">
							<div class="btn-group pull-right" role="group">

								<div id="btn_std_add" class="btn-group" role="group">
									<button type="button" class="btn btn-default"
										data-toggle="modal" data-target="#studentModal">添加</button>
								</div>
								<div id="btn_std_edit" class="btn-group" role="group">
									<button type="button" class="btn btn-default"
										data-toggle="modal" data-target="#studentModal">修改</button>
								</div>
								<div id="btn_std_del" class="btn-group" role="group">
									<button type="button" class="btn btn-default">删除</button>
								</div>
							</div>
						</div>
					</div>
					<!-- Table -->
					<table class="table">
						<thead>
							<tr>
								<th>#</th>
								<th>学号</th>
								<th>姓名</th>
								<th>性别</th>
								<th>出生日期</th>
							</tr>
						</thead>
						<tbody>
							<%-- <c:forEach items="${cls.students}" var="stud" varStatus="s">
								<tr class='${s.index==0 ? "success" : "" }'>
									<th id="id" hidden="hidden">${stud.id}</th>
									<th scope="row">${s.index}</th>
									<td id="code">${stud.code}</td>
									<td id="name">${stud.name}</td>
									<td id="sex">${stud.sex==0?"女":"男" }</td>
									<td id="birth">${stud.formatBirth}</td>
								</tr>
							</c:forEach> --%>
							<s:iterator value="#request.cls.students" id="stud" status="s">
							    <tr class="#s.index==0 ? 'success':''">
							        <th id="id" hidden="hidden"><s:property value="#stud.id"/></th>
							        <th scope="row"><s:property value="#s.index"/></th>
									<td id="code"><s:property value="#stud.code"/></td>
									<td id="name"><s:property value="#stud.name"/></td>
									<td id="sex"><s:property value="#stud.sex==0?'女':'男'"/></td>
									<td id="birth"><s:property value="#stud.formatBirth"/></td>
							    </tr>
							</s:iterator>
						</tbody>
					</table>
				</div>
				<%-- <div style="text-align: right;display:${pageCount==1?'none':''};">
					<nav>
						<ul class="pagination">
							<li><a href="/StudentSys_fw2/main/mainActivion.action?pageNum=1&clsId=${cls.id}">&laquo;</a></li>
							<c:forEach begin="1" end="${pageCount}" var="num" varStatus="s">
								<li class="${pageNum==num?'active':'' }"><a
									href="/StudentSys_fw2/main/mainActivion.action?pageNum=${num}&clsId=${cls.id}">${num}</a></li>
							</c:forEach>
							<li><a
								href="/StudentSys_fw2/main/mainActivion.action?pageNum=${pageCount}&clsId=${cls.id}">&raquo;</a></li>
						</ul>
					</nav>
				</div> --%>
				
				<div style="text-align: right;display:<s:property value="#request.pageCount==1?'none':''"/>;">
					<nav>
						<ul class="pagination">
							<li><a href="/StudentSys_fw2/main/mainActivion.action?pageNum=1&clsId=<s:property value="#request.cls.id"/>">&laquo;</a></li>
							<s:iterator begin="1" end="pageCount"  id="num" status="s">
						<li class="<s:property value='pageNum==num?"active":""'/>"><a
								href="/StudentSys_fw2/main/mainActivion.action?pageNum=<s:property value='#num'/>&clsId=<s:property value="#request.cls.id"/>">
								<s:property value='#num'/></a></li>>
						</s:iterator> 
							<li><a
								href="/StudentSys_fw2/main/mainActivion.action?pageNum=<s:property value="#request.pageCount"/>&clsId=<s:property value="#request.cls.id"/>">&raquo;</a></li>
						</ul>
					</nav>
				</div>

			</div>
		</div>
	</div>
	</div>
    <!--班级删除表单-->

    <form id="frm_cls_del" action="" method="post"
		style="display: none;">
		<input id="cId" name="clasz.id" type="hidden" value="<s:property value="#request.cls.id"/>">
		<input type="hidden"  id="clsname" name="clasz.name">
		<input type="hidden"  id="clstname" name="clasz.t_name"></input>
	</form>
    
	<!--班级添加修改弹出框-->
	<div class="modal fade" id="classModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="exampleModalLabel">添加班级信息</h4>
				</div>
				<form id="frm_cls" action="ClsOptServlet" method="post">
				<div class="modal-body">
					<input id="clsId" name="clasz.id" type="hidden" value="<s:property value="#request.cls.id"/>">
					<div class="form-group">
						<label for="recipient-name" class="control-label">班级名称:</label> <input
							name="clasz.name" type="text" class="form-control" id="cname">
					</div>
					<div class="form-group">
						<label for="message-text" class="control-label">班主任名称:</label> <input
							name="clasz.t_name" type="text" class="form-control" id="ctname"></input>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					<button type="submit" class="btn btn-primary">确定</button>
				</div>
				</form>
			</div>
		</div>
	</div>
	<!--学生删除表单-->

	<form id="frm_std_del" action="" method="post"
		style="display: none;">
		<input id="sId" name="student.id" type="hidden"> <input id="clsId"
			name="claszId" type="hidden" value="<s:property value="#request.cls.id"/>">
	</form>


	<!--学生添加修改弹出框-->
	<div class="modal fade" id="studentModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="exampleModalLabel">添加学生信息</h4>
				</div>
				<form id="frm_std" action="StudOptServlet" method="post">
					<input id="clsId" name="claszId" type="hidden" value="<s:property value="#request.cls.id"/>">
					<div class="modal-body">
						<input id="stuId" name="student.id" type="hidden">
						<div class="form-group">
							<label for="recipient-name" class="control-label">学生编号:</label> <input
								name="student.code" type="text" class="form-control" id="scode">
						</div>
						<div class="form-group">
							<label for="message-text" class="control-label">学生姓名:</label> <input
								name="student.name" type="text" class="form-control" id="sname"></input>
						</div>
						<div class="form-group">
							<label for="sex-text" class="control-label">学生性别:</label>
							<div id="sex-text">
								<label class="radio-inline"> <input id="ssex_m"
									name="student.sex" type="radio" value="1" checked> 男
								</label> <label class="radio-inline"> <input id="ssex_w"
									name="student.sex" type="radio" value="0"> 女
								</label>
							</div>

						</div>
						<div class="form-group">
							<label for="birth-text" class="control-label">出生日期:</label> <input
								name="student.birth" type="text" class="form-control" id="sbirth"></input>
						</div>

					</div>
					<div class="modal-footer">
						<button id="resetbtn" type="reset" class="btn btn-default"
							data-dismiss="modal">取消</button>
						<button type="submit" class="btn btn-primary">确定</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>