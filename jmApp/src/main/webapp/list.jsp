<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Document</title>
	<link rel="stylesheet" type="text/css" href="bootstrap-3.3.5-dist/css/bootstrap.min.css">
	<link rel="stylesheet" href="bootstrap-3.3.5-dist/css/buttons.css">
	<link rel="stylesheet" href="circle_progress/css/progress.css">
	<link rel="stylesheet" href="css/style.css">
	<link rel="stylesheet" href="datepicker/css/bootstrap-datepicker3.css">
	<script src="bootstrap-3.3.5-dist/js/jquery.min.js"></script>
    <script src="bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
    <style type="text/css">
	.cjwt{line-height:24px;}
	.cjwt .cjwt-group{border-bottom:1px dashed #ccc;padding:10px 0;font-size:14px;margin-left: 30px;margin-top: 30px;}
	.cjwt .cjwt-title{font-size:18px;font-weight:bold;cursor:pointer;}
	.cjwt .cjwt-subtitle{font-size:14px;color:#F25904;}
	.cjwt .cjwt-group dd{padding:10px 0;}
	</style>
	<style type="text/css">
		.aqbz{text-align: left; font-size: 16px; line-height: 24px;}
		.aqbz h2{font-size: 18px;line-height:2;}
	</style>
</head>
<body>
	 <nav class="navbar navbar-default navbar-fixed-top" style="background:#FFF; color:#FFF">
    	<div class="container">
    		<div class="navbar-header" style="margin-top: 10px;margin-bottom: 10px">
               <a class="navbar-brand" href="#" style="padding-top: 0">
                   <img  src="img/91_logo.png">
               </a>
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#example-navbar-collapse">
                   <span class="sr-only">切换导航</span>
                   <span class="icon-bar"></span>
                   <span class="icon-bar"></span>
                   <span class="icon-bar"></span>
                </button>
            </div>
            
            <div class="collapse navbar-collapse" id="example-navbar-collapse text-center" style="margin-top: 10px;">
	            <ul class="nav navbar-nav navbar-left ">
	            	<li><a href="/jmApp/jm/MainAction.action" style="font-size: 18px">首页</a></li>
	            	<li><a href="/jmApp/jm/ProjectAction.action" style="font-size: 18px">影视投资</a></li>
	            	<li><a href="projectdelivery.jsp" style="font-size: 18px">项目投递</a></li>
	            	<!-- <li><a href="projectissue.html" style="font-size: 18px">发行</a></li> -->
	            	<li><a href="shangcheng.jsp" style="font-size: 18px">玖马商城</a></li>
	            	<li><a href="travel.jsp" style="font-size: 18px">影视旅游</a></li>
	            	<li><a href="list.jsp" style="font-size: 18px">关于</a></li>
	            </ul>
	            <ul class="nav navbar-nav navbar-right " >
	            	<li>
	            	  	 <div class="btn-group" role="group" aria-label="..." style="margin-top: 10px;margin-right: 20px">
                            <a href="login.html" class="btn btn-warning" role="button">登陆</a>
                         </div>
	            	</li>

	            	<li>
	            	     <div class="btn-group" role="group" aria-label="..." style="margin-top: 10px">
                            <a href="register.html" class="btn btn-default" role="button">注册</a>
                         </div>
	            	</li>
	            </ul>
	        </div> 
    </nav>
    <div style="background: #f5f5f5;overflow: hidden;margin-top: 70px;">
        <div style="float: left;margin: 30px 30px 10px 150px;background: white;border:solid 1px #e9e9e9;">
        	<ul class="nav nav-pills nav-stacked" role="tablist" style="margin-top: 20px;margin-bottom: 20px;text-align: center;font-size: 20px;">
                      <li role="presentation" class="active" style="margin: 20px 10px 20px 10px;"><a href="#media" aria-controls="media" role="tab" data-toggle="tab">媒体报道</a></li>
                      <li role="presentation" style="margin: 20px 10px 20px 10px;"><a href="#question" aria-controls="question" role="tab" data-toggle="tab">常见问题</a></li>
                      <li role="presentation" style="margin: 20px 10px 20px 10px;"><a href="#job" aria-controls="job" role="tab" data-toggle="tab">在线招聘</a></li>
                      <li role="presentation" style="margin: 20px 10px 20px 10px;"><a href="#safe" aria-controls="safe" role="tab" data-toggle="tab">安全保障</a></li>
                      <li role="presentation" style="margin: 20px 10px 20px 10px;"><a href="#guide" aria-controls="guide" role="tab" data-toggle="tab">投资指南</a></li>
                      <li role="presentation" style="margin: 20px 10px 20px 10px;"><a href="#about" aria-controls="about" role="tab" data-toggle="tab">关于玖马</a></li>
                      <li role="presentation" style="margin: 20px 10px 20px 10px;"><a href="#contact" aria-controls="contact" role="tab" data-toggle="tab">联系我们</a></li> 
                      <li role="presentation" style="margin: 20px 10px 20px 10px;"><a href="#word" aria-controls="word" role="tab" data-toggle="tab">创始人寄语</a></li>
                      <li role="presentation" style="margin: 20px 10px 20px 10px;"><a href="#older" aria-controls="older" role="tab" data-toggle="tab">往期项目</a></li>  
                      <li role="presentation" style="margin: 20px 10px 20px 10px;"><a href="#advantage" aria-controls="advantage" role="tab" data-toggle="tab">平台优势</a></li>
                      <li role="presentation" style="margin: 20px 10px 20px 10px;"><a href="#announce" aria-controls="announce" role="tab" data-toggle="tab">网站公告</a></li>  
            </ul>
        </div>
        <div  class="tab-content" style="float: left;margin: 30px 150px 10px 30px;background: white">
        	<div   role="tabpanel" class="tab-pane active" id="media" style="width: 750px;">
        	 <div class="list-group" style="margin: 30px 20px 10px 20px">
				  <a href="#" class="list-group-item">
				    <h4>玖马金融母公司新鼎明再度牵手招商银行，成立影视文化二期基金<small style="margin-left: 20px;">2015-11-9 12:34:56</small></h4>
				    
				  </a>
				  <a href="#" class="list-group-item">
				  	<h4>十月玩石“嗨”翻天 玖马金融邀你现场一起酷炫！<small style="margin-left: 20px;">2015-11-9 12:34:56</small></h4>
				  </a>
				  <a href="#" class="list-group-item">
				  	<h4>都晓导演：在玖马金融众筹 首先是不缺钱的<small style="margin-left: 20px;">2015-11-9 12:34:56</small></h4>
				  </a>
				  <a href="#" class="list-group-item">
				  	<h4>玖马金融携手大帐户 以优质资产服务优质用户<small style="margin-left: 20px;">2015-11-9 12:34:56</small></h4>
				  </a>
				  <a href="#" class="list-group-item">
				  	<h4>郑嘉颖主演的《太极宗师之太极门》在玖马金融众筹<small style="margin-left: 20px;">2015-11-9 12:34:56</small></h4>
				  </a>

				  <a href="#" class="list-group-item">
				    <h4>玖马金融重构影视众筹，保障本金更享收益<small style="margin-left: 20px;">2015-11-9 12:34:56</small></h4>
				  </a>
				  <a href="#" class="list-group-item">
				  	<h4>玩石音乐节与玖马金融签订战略合作协议<small style="margin-left: 20px;">2015-11-9 12:34:56</small></h4>
				  </a>
				  <a href="#" class="list-group-item">
				  	<h4>都晓导演：在玖马金融众筹 首先是不缺钱的<small style="margin-left: 20px;">2015-11-9 12:34:56</small></h4>
				  </a>
				  <a href="#" class="list-group-item">
				  	<h4>玖马金融众筹玩石音乐节，12%收益如何实现？<small style="margin-left: 20px;">2015-11-9 12:34:56</small></h4>
				  </a>
				  <a href="#" class="list-group-item">
				  	<h4>影视“众筹”如何不成“众愁”玖马金融登陆浙江经视教你如何分羹<small style="margin-left: 20px;">2015-11-9 12:34:56</small></h4>
				  </a>
			 </div>
        	</div>
        	<div   role="tabpanel" class="tab-pane cjwt" id="question" style="width: 750px;">
        	  <dl class="cjwt-group" id="hot" style="margin-left: 30px;margin-top: 30px;">
			     <dt class="cjwt-title">热门问题</dt>
			     <dd><p class="cjwt-subtitle">1、项目怎么样才算众筹成功，众筹成功后如何计息、失败后如何退款？</p><p></p><p>每个项目都有一个众筹成功金额，只有固定时间内募集资金超过成功金额时，项目才算众筹成功；若项目成功，从投资次日开始计息。若项目失败，资金自动退回用户的玖马账户，可通过提现的方式将资金转到绑定的银行卡中。</p><p></p><br><p class="cjwt-subtitle">2、如何修改已绑定的银行卡？</p><p></p><p>目前平台暂时不支持修改绑定银行卡；为了您的账户安全，如需修改请联系客服。</p><p></p><br><p class="cjwt-subtitle">3、项目未结束是否可以退款？</p><p></p><p>目前平台暂时不支持退款。如您有紧急的资金需求，可在项目众筹成功后一个月发起转让。</p><p></p><br><p class="cjwt-subtitle">4、投资安全性问题</p><p></p><p>玖马众筹有严格的流程化的风控体系：</p><p>专业的投资经理甄选项目，过去50多部剧零风险；</p><p>项目实际控制人连带担保，在项目上线前，我们都会评估实际控制人的征信报告；</p><p>最后一关，项目出险平台先行垫付本金；</p><p></p><br><p class="cjwt-subtitle">5、嫌项目时间长，想投短期的项目</p><p></p><p>众筹成功一个月后，如果急需资金就可以转让，一般把收益稍微打个折就很容易转让出去了，上次有同学因为急用钱想转让当天就转让出去了。</p><p></p><br><p class="cjwt-subtitle">6、关于推荐新用户</p><p></p><p>玖马众筹平台的用户多数是来自杭州银行、招商银行、阿里、腾讯、华为的小伙伴，他们以丰富的投资经历、对玖马众筹以及母公司杭州新鼎明的高度熟悉，已经把影视文化行业高速发展的红利以及稳健收益的玖马众筹平台分享给了更多小伙伴，欢迎小伙伴们把稳健收益又好玩的玖马众筹影视理财产品分享给更多的朋友们。</p><p></p><br><p class="cjwt-subtitle">7、关注注册不成功</p><p></p><p>如果在注册时收不到验证码，请联系客服解决，电话：135-8805-6269；</p><p></p><br></dd>
		      </dl>
		      <dl class="cjwt-group" id="recharge">
			    <dt class="cjwt-title">充值问题</dt>
			    <dd><p class="cjwt-subtitle">1、信用卡能不能充值？</p><p></p><p>玖马众筹只支持储蓄卡进行绑定和充值，不支持信用卡。</p><p></p><br><p class="cjwt-subtitle">2、充值多长时间到账？</p><p></p><p>充值为即时到账，如果银行提示扣款之后账户余额没有相应增加，可能是托管系统延迟或者银行掉单导致：系统延迟会在10-30分钟后到账，到账后不影响正常使用；银行掉单会在对账后1-3工作日操作退款。</p><p>充值能充多少钱？</p><p>为了保证用户银行卡资金安全，不同银行卡充值有不同的充值限额。详情参见银行卡问题类目下的银行卡限额。</p><p></p><br><p class="cjwt-subtitle">3、我的玖马众筹账户是否可以用别人的网银充值？</p><p></p><p>可以的。用户不管有没有绑定自己的银行卡，都可以用任何人的网银支付给自己充值。但是如果要提现的话必须绑定银行卡，且第一次绑定银行卡后以后更换银行卡只能绑定首次绑卡人的银行卡，首次绑卡请绑定本人的银行卡。</p><p>如何提高支付限额</p><p>（1）.请联系银行卡的发卡行客服，咨询提高银行卡充值限额的相关操作。</p><p>（2）.请联系我们玖马众筹客服135-8805-6269；，我们将为您提供提高支付限额的最佳方案。</p><p></p><br><p class="cjwt-subtitle">4、充值时会扣手续费吗？</p><p></p><p>充值对投资人是免费的，充值手续费由玖马众筹平台承担</p><p>为什么充值扣款成功但是没到账？</p><p>可能是第三方支付公司与银行系统对接不稳定导致的。出现该情况后请立即联系我们玖马众筹客服135-8805-6269，客服将第一时间为您处理。</p><p></p><br><p class="cjwt-subtitle">5、银行卡无法绑定或绑定后快捷支付不成功？</p><p></p><p>目前使用快捷支付需要进行更为严格的信息校验。建议您该卡首先开通银联在线支付业务， 然后去持卡行任意网点请柜员通过4204交易添加手机号码。</p><p>您可点击银联持卡人服务网站首页（www.95516.com）或者您也可以登录https://www.95516.com/portal/open/index.do 页面上方有个“注册”先用手机号注册账户（已有账户直接登录即可）后返回登陆后，在上方有个“帮助中心”--“付款说明”--“如何开通银联卡快速付款功能”点击到下一页面，点击“3、如何开通银联卡快速付款功能？”下方有个“点击开通银联在线支付”，下一个页面点击“在线开通”按提示输入卡号，按页面提示要求才做开通。 开通成功即可生效。您先通过上述流程尝试操作，再进行支付试试看，如果支付还不成功，请联系我们玖马众筹客服135-8805-6269；</p><p></p><br><p class="cjwt-subtitle">6、网银充值不成功？</p><p></p><p>网银充值失败原因有多方面，大致有：</p><p>1、可能是因为该浏览器不支持操作银行卡网银操作，需通过IE浏览器重新登录账号并充值。</p><p>2、未安装好相应的控件，建议下载“各银行的网银伴侣”后再进行支付。</p><p>3、上述情况都不存在，建议换一台电脑进行尝试，可能是u盾和电脑环境不太兼容。</p><p>4、充值的银行卡网银超出限额（银行设置限额和个人设置限额），银行设置限额建议更换其他银行卡网银充值。个人设置限额建议联系银行提高支付限额。</p><p>5、不清楚上述操作，也可以致电客服热线135-8805-6269咨询。</p><p></p><br></dd>
		      </dl>
		       <dl class="cjwt-group" id="cash">
			    <dt class="cjwt-title">提现问题</dt>
			    <dd><p class="cjwt-subtitle">1、提现有金额要求吗？</p><p></p><p>单笔提现金额最高50万元，最低10元起提。</p><p></p><br><p class="cjwt-subtitle">2、提现有没有手续费？</p><p></p><p>每日免费提现3次，第4次起每笔收取5元手续费；工作日24小时内到账，非工作日顺延至下一工作日；如需紧急提款，请拨打客服电话：135-8805-6269。</p><p></p><br><p class="cjwt-subtitle">3、提现多久能到账？</p><p></p><p>T+1到账机制(T为交易当日)。发起提现后的第二个工作日到账（工作日不包括周六日，及法定节假日），最快提现当日到账。</p><p></p><br></dd>
		      </dl>
		      <dl class="cjwt-group" id="bankcard">
			   <dt class="cjwt-title">银行卡问题</dt>
			   <dd><p class="cjwt-subtitle">1、可以绑定多张卡吗？</p><p></p><p>为了你的资金安全，玖马众筹账户暂时只能持绑定1张银行卡。若有绑定其他银行卡的需求，可联系我们玖马众筹客服135-8805-6269更换绑定银行卡。</p><p></p><br><p class="cjwt-subtitle">2、绑卡失败怎么办？</p><p></p><p>请检查你的银行卡信息是否填写正确。确认无误后仍无法绑定请联系我们玖马众筹客服135-8805-6269</p><p></p><br></dd>
		      </dl>
		      <dl class="cjwt-group" id="jumicoin">
			    <dt class="cjwt-title">关于玖马币</dt>
			    <dd><p class="cjwt-subtitle">1、玖马币</p><p></p><p>玖马币是由玖马众筹发放给用户的虚拟货币，主要用于聚玩商城的兑换。</p><p>获得玖马币的主要方式有：注册即送50玖马币；参与项目众筹可获1：0.01的玖马币，如投资10000元可获100玖马币；邀请好友注册并实名认证成功，邀请人即获50玖马币；参与聚玩商城的幸运大转盘即有机会获得玖马币。注意，玖马币不可以转让给其他好友使用。</p><p></p><br></dd>
		      </dl>
		      <dl class="cjwt-group" id="redpacket">
			    <dt class="cjwt-title">关于红包</dt>
			   <dd><p class="cjwt-subtitle">1、红包</p><p></p><p>红包是由玖马众筹发放给用户的福利，投资时可直接抵扣现金。获得红包的主要方式有：</p><p>注册即送30元红包；参与聚玩聚玩商城的幸运大转盘即有机会获得红包；用户生日当天赠送50元红包；其他玖马众筹实时公布的活动。注意，红包不可提现，每投资1万元最高可抵扣100元红包，如投资5万元最高可抵扣500元红包。</p><p></p><br></dd>
		     </dl>
        	</div>
        	<div   role="tabpanel" class="tab-pane aqbz" id="job" style="width: 750px;">
        	    <div style="font-size:14px;text-align:center;line-height:30px;">加入我们，马上发简历！简历请发送至：hr@jumifinance.com</div>
        	    <div class="panel panel-default">
					  <!-- Default panel contents -->
					  <div class="panel-heading" style="text-align: center;"><h4><b>技术类</b></h4></div>
					  <!-- List group -->
					  <ul class="list-group">
					    <li class="list-group-item">
					    	<a class="btn btn-primary" role="button" data-toggle="collapse" href="#h_java" aria-expanded="false" aria-controls="h_java">
                             java高级开发工程师
                            </a>
                            <div class="collapse" id="h_java">
							  <div class="well" style="margin-top: 10px;">
								<p>1、按业务需求分析和软件概要设计；</p>
								<p>2、进行软件详细设计和编码实现，确保性能、质量和安全；</p>
								<p>3、维护和升级现有软件产品，快速定位并修复现有软件缺陷；</p>
								<p>4、要求5年以上J2EE开发经验；</p>
								<p>5、扎实的Java编程基础，熟悉各种设计模式；</p>
								<p>6、熟练掌握Spring/Struts/Hibernate/Ibatis或其他主流JAVA框架；</p>
								<p>7、熟悉MySQL/Oracle/PostgreSQL数据库中的一种或多种，有数据库调优经验；</p>
								<p>8、熟悉整个软件过程，能够沟通需求、控制项目进度，有良好的文档能力。</p>
							  </div>
							</div>
					    </li>
					    <li class="list-group-item">
					    	<a class="btn btn-primary" role="button" data-toggle="collapse" href="#java" aria-expanded="false" aria-controls="java">
                             java开发工程师
                            </a>
                            <div class="collapse" id="java">
							  <div class="well" style="margin-top: 10px;">
								<p>1、协助项目经理完成项目模块需求整理；</p>
								<p>2、能够在指导下独立完成模块的开发；</p>
								<p>3、具备2年及以上工作经验；</p>
								<p>4、有二年以上JAVA开发经验，精通Java、Struts、Spring、Hibernate、JSF、ibatis等B/S开发技术；熟悉Html/flex/Jsp/Ajax/Servlet等页面语言编程，可独立或在指导下完成中小型项目各阶段模块级工作；</p>
								<p>5、熟练使用JBOSS, WebLogic, Tomcat等一种；</p>
								<p>6、熟悉数据库开发技术，至少熟悉MS SQL SERVER、ORACLE中的一项；</p>
								<p>7、对代码进行复查，并进行单元测试；</p>
								<p>8、良好的编程风格，严格遵守公司的编码规范。</p>
							  </div>
							</div>
					    </li>
					    <li class="list-group-item">
					    	 <a class="btn btn-primary" role="button" data-toggle="collapse" href="#web" aria-expanded="false" aria-controls="web">
                             web前端开发工程师
                            </a>
                            <div class="collapse" id="web">
							  <div class="well" style="margin-top: 10px;">
								<p>1.负责将美工提供的设计稿转换成静态页面，并按照要求实现各类页面的动态效果；</p>
								<p>2.配合开发工程师，完成产品前台页面脚本编码工作。负责前台javascript脚本通用组件的抽象和填写；</p>
								<p>3.计算机相关专业学历，2年及以上web前台开发经验；</p>
								<p>4.熟悉html/css等网页设计技术，熟悉页面架构及布局，能熟练运用div+css来制作符合w3c规范的静态页面；</p>
								<p>5.熟悉javascript、xml、json、dom、dhtml等前端技术，熟悉jquery等js框架，能手写符合w3c标准，兼容多种浏览器的前端页面；</p>
								<p>6.具备良好的沟通能力和团队协作能力，能够独立思考，优化产品实现方式和代码结构；</p>
								<p>7.熟悉html5/css3，有页面设计经验者优先。</p>
							  </div>
							</div>
					    </li>
					    <li class="list-group-item">
					    	 <a class="btn btn-primary" role="button" data-toggle="collapse" href="#art" aria-expanded="false" aria-controls="art">
                             美工
                            </a>
                            <div class="collapse" id="art">
							  <div class="well" style="margin-top: 10px;">
								<p>1、负责公司网站页面的整体美工创意、设计和页面的实现；</p>
								<p>2、配合网站推广工作进行美工设计；</p>
								<p>3、网站专题页面美工设计与制作；</p>
								<p>4、大学专科及以上学历，美术、广告、平面设计等相关专业，1年以上网站美工相关经验；</p>
								<p>5、熟练photoshop等平面设计软件,有较高的美术基础和审美能力，能给客户以视觉冲击，眼界开阔、敏锐、独到，富有美感、创造力、想象力，对色彩和线条等网页相关元素敏感，精通图像处理文字编辑及网页布局；</p>
								<p>6、开朗大方，有良好的语言表达能力、沟通能力及团队协作能力。</p>
							  </div>
							</div>
					    </li>
					    <li class="list-group-item">
					    	<a class="btn btn-primary" role="button" data-toggle="collapse" href="#test" aria-expanded="false" aria-controls="test">
                            测试工程师
                            </a>
                            <div class="collapse" id="test">
							  <div class="well" style="margin-top: 10px;">
								<p>1、参与互联网软件产品测试的全流程，包括参与需求分析、设计评审，制定测试计划，设计和执行测试用例，进行缺陷跟踪和软件质量分析等；</p>
								<p>2、带领其他测试开发工程师执行项目测试，包括制定测试计划，分配测试资源，构建测试环境，执行集成测试，回归测试等；</p>
								<p>3、保证被测系统的质量，并通过测试流程和方法创新，努力提升研发的质量和效率；</p>
								<p>4、2年以上开发或测试经验；有web系统测试工作经验，持续集成、持续发布经验者优先；有自动化测试经验、性能测试经验者优先；</p>
								<p>5、精通测试用例设计方法，能主动进行技术钻研；</p>
								<p>6、良好的解决问题能力、语言表达能力和综合协调能力，工作积极主动，良好的团队精神。</p>
								<p>7、熟悉c/c++/mfc编程, 一年以上开发经验优先；</p>
							  </div>
							</div>
					    </li>
					    <li class="list-group-item">
					    	<a class="btn btn-primary" role="button" data-toggle="collapse" href="#c" aria-expanded="false" aria-controls="c">
                            c/c++开发工程师
                            </a>
                            <div class="collapse" id="c">
							  <div class="well" style="margin-top: 10px;">				
								<p>1、计算机相关专业本科以上学历，有扎实的计算机基础知识；</p>
								<p>2、熟悉c/c++编程, 一年以上C编程经验，熟悉数据结构、操作系统等计算机基础；</p>
								<p>3、有一定数据库基础（Oracle、 Mysql，SQLServer至少一种），能够熟练进行编程；</p>
								<p>4、熟悉LINUX操作系统编程；</p>
								<p>5、熟悉软件技术文档的编写，具备良好的文档编制习惯和代码书写规范；</p>
								<p>6、具有强烈的工作责任心、有良好的沟通能力和团队合作精神、承压能力；</p>
								<p>7、学习能力强，优秀的逻辑思维能力与自我管理能力；</p>
							  </div>
							</div>
					    </li>
                        <li class="list-group-item">
					    	<a class="btn btn-primary" role="button" data-toggle="collapse" href="#android" aria-expanded="false" aria-controls="android">
                           Android开发工程师
                            </a>
                            <div class="collapse" id="android">
							  <div class="well" style="margin-top: 10px;">							
								<p>1、精通java语言，1年以上java相关经验；1年以上Android开发经验者优先；</p>
								<p>2、精通Android开发平台及框架原理，精通Android的基本组件使用；</p>
								<p>3、熟悉Android下网络编程，网络数据传输，JSON数据传输；</p>
								<p>4、熟悉Android下的安全技术；</p>
								<p>5、熟练使用多种常用设计模式，具扎实的编程功底和良好的编程习惯，良好的 设计文档撰写能力；</p>
								<p>6、具有强烈的工作责任心、有良好的沟通能力和团队合作精神、承压能力。</p>
							  </div>
							</div>
					    </li>
					    <li class="list-group-item">
					    	<a class="btn btn-primary" role="button" data-toggle="collapse" href="#ios" aria-expanded="false" aria-controls="ios">
                           ios开发工程师
                            </a>
                            <div class="collapse" id="ios">
							  <div class="well" style="margin-top: 10px;">							
								<p>1、本科以上学历，ios开发经验1年以上者优先；</p>
								<p>2、熟悉Objective-C编程，具备扎实的C/C++编程基础，独立开发过iOS项目；</p>
								<p>3、熟悉常用算法和数据结构，熟悉基础设计模式，熟悉MacOS，Xcode及iPhone SDK开发环境及相关开发工具；</p>
								<p>4、良好的文档撰写能力以及模型类封装能力，如：数据库设计文档、系统架构设计文档、数据接口文档等，在编码期间能撰写清晰明了的注释；</p>
								<p>5、良好的团队合作精神和沟通能力，勤奋上进；</p>
								<p>6. 喜欢钻研技术，能主动提升自己的能力；</p>
								<p>7. 能够不断优化自己的代码，完善产品体验。</p>
							  </div>
							</div>
					    </li>
					  </ul>
					</div>
					<div class="panel panel-default">
					  <!-- Default panel contents -->
					  <div class="panel-heading" style="text-align: center;"><h4><b>产品类</b></h4></div>
					  <!-- List group -->
					  <ul class="list-group">
					    <li class="list-group-item">
					    	<a class="btn btn-primary" role="button" data-toggle="collapse" href="#product" aria-expanded="false" aria-controls="product">
                             产品经理
                            </a>
                            <div class="collapse" id="product">
							  <div class="well" style="margin-top: 10px;">
								<p>1. 三年以上互联网行业用户产品的产品经理工作经验,有团队组建、管理经验者优先</p>
								<p>2. 良好的洞察力,善于利用数据分析、用户访谈、场景分析等专业手段发现潜在用户需求</p>
								<p>3. 掌握可用性设计的专业知识,并具备实际经验,能够运用信息结构、交互设计原则等知 识完成可用性高的产品设计</p>
								<p>4. 理解验证产品假设的专业方法,例如:抽象建模、随机受控试验(A/B Test)等</p>
								<p>5. 对数字敏感,优秀的定性、定量分析能力,以及严密的逻辑思维</p>
								<p>6. 具备适合自己的创新思维体系,并能结合实际的创新案例讲出你在创新过程中的思考方 法</p>
								<p>7. 敏锐的市场意识、广阔的视野,并有实际案例证明</p>
								<p>8. 出色的组织、协调能力和项目管理能力,并可提供实际工作中的成功案例</p>
								<p>9. 本科以上学历</p>
							  </div>
							</div>
					    </li>
					 </ul>
					</div>
					<div class="panel panel-default">
					  <!-- Default panel contents -->
					  <div class="panel-heading" style="text-align: center;"><h4><b>运营类</b></h4></div>
					  <!-- List group -->
					  <ul class="list-group">
					    <li class="list-group-item">
					    	<a class="btn btn-primary" role="button" data-toggle="collapse" href="#business" aria-expanded="false" aria-controls="business">
                             运营专员
                            </a>
                            <div class="collapse" id="business">
							  <div class="well" style="margin-top: 10px;">
								<p>1、有过论坛、社区、粉丝团的活动运营经验；</p>
								<p>2、根据活动需求，调集资源合作完成活动策划、软文撰写；</p>
								<p>3、根据项目阶段，输出整体的运营工作规划，完成日常的运营工作；</p>
								<p>4、熟练掌握各种办公软件；</p>
								<p>5、善于撰写各类策划文案及需求文档，善于沟通表达，能承担较强的工作压力；</p>
								<p>6、有互联网运营工作者优先，有深厚文字功底和android/ios运营工作经验的优先。</p>
							  </div>
							</div>
					    </li>
					     <li class="list-group-item">
					    	<a class="btn btn-primary" role="button" data-toggle="collapse" href="#media_business" aria-expanded="false" aria-controls="media_business">
                             新媒体运营
                            </a>
                            <div class="collapse" id="media_business">
							  <div class="well" style="margin-top: 10px;">
								<p>1、管理并运营微信、微博、贴吧等社会化媒体平台，负责日常发布内容的素材搜集、内容策划、文案撰写；</p>
								<p>2、对新媒体营销及信息有深入研究能力和敏锐的洞察力；</p>
								<p>3、快速响应社会、娱乐等网络热点话题，独立完成热点营销事件的策划和执行；</p>
								<p>4、建立有效的新媒体运营体系提升用户的活跃度，增加品牌的知名度和美誉度；</p>
								<p>5、良好的理解、沟通能力，具有比较广泛的知识储备，文字表达能力强；</p>
								<p>6、创意天马行空，风格不限；</p>
								<p>7、熟练使用PS、有过新媒体运营经验者优先。</p>
								<p>工作地点：北京、杭州、合肥（特别是北京、合肥的小伙伴们也多多关注哦）</p>
							  </div>
							</div>
					    </li>
					 </ul>
					</div>
					<div class="panel panel-default">
					  <!-- Default panel contents -->
					  <div class="panel-heading" style="text-align: center;"><h4><b>职能类</b></h4></div>
					  <!-- List group -->
					  <ul class="list-group">
					    <li class="list-group-item">
					    	<a class="btn btn-primary" role="button" data-toggle="collapse" href="#hr" aria-expanded="false" aria-controls="hr">
                             HR专员
                            </a>
                            <div class="collapse" id="hr">
							  <div class="well" style="margin-top: 10px;">
								
								<p>1、一年以上影视、互联网相关行业工作经验；</p>
								<p>2、负责团队的人才招聘，开拓、管理各种招聘渠道，与优秀的招聘渠道建立合</p>
								<p>3、作关系并密切跟踪业内各种人才的动态</p>
								<p>4、负责所有的招聘流程，为团队负责人提供合理化建议</p>
								<p>5、亲和力强，同理心高，具备良好的沟通和协调能力</p>
								<p>6、责任心强，有独立负责事情的想法和能力</p>
								<p>7、熟悉杭州当地劳动人事法规政策</p>
							
							  </div>
							</div>
					    </li>
					     <li class="list-group-item">
					    	<a class="btn btn-primary" role="button" data-toggle="collapse" href="#waiter" aria-expanded="false" aria-controls="waiter">
                            客服专员
                            </a>
                            <div class="collapse" id="waiter">
							  <div class="well" style="margin-top: 10px;">
								<p>1、负责处理日常用户产品咨询、交易咨询、订单查询、投诉退款及售后咨询等电话服务；</p>
								<p>2、负责处理日常用户投诉、发货催促和退款申请的反馈沟通；</p>
								<p>3、负责对用户进行日常电话回访和数据整理反馈。</p>
								<p>4、一年以上客服相关工作经验</p>
								<p>5、电脑操作熟练，具备良好的语言表达和沟通能力</p>
								<p>6、富有开拓精神和良好的团队合作意识</p>
							  </div>
							</div>
					    </li>
					     <li class="list-group-item">
					    	<a class="btn btn-primary" role="button" data-toggle="collapse" href="#account" aria-expanded="false" aria-controls="account">
                           资金结算专员
                            </a>
                            <div class="collapse" id="account">
							  <div class="well" style="margin-top: 10px;">
								
								<p>1、负责每日与出纳核对平台和第三方支付公司的充值、提现的资金核对；</p>
								<p>2、负责每周出具平台交易运营数据；</p>
								<p>3、负责对平台资金进行数据分析，为平台的各项策划活动提供数据性支持；</p>
								<p>4、负责月初对上月数据进行分析并出具平台月度运营报告；</p>
								<p>5、协助财务主管完成结算流程优化；</p>
								<p>6、 要求1年以上资金结算岗位工作经验；</p>
								<p>7、有P2P平台工作经验优先录取；</p>
							
							  </div>
							</div>
					    </li>
					 </ul>
					</div>
        	</div>
        	<div   role="tabpanel" class="tab-pane" id="safe" style="width: 750px;">
        	   <div class="aqbz" style="margin: 30px 20px 10px 20px">
        	   	    <h2><b>身份认证体系</b></h2>
				   <p>平台建立手机认证、实名认证、银行卡认证等全方位认证体系，且资金只能转出到已经通过本人实名认证的绑定银行账户上，确保资金万无一失。</p>
				   <br>
				   <h2><b>网络安全</b></h2>
				   <p>采用阿里云盾安全服务，采用DDoS防护、主机入侵防护、安全检查、Web防火墙等全立体的防护措施，有效防止病毒入侵和防止恶意攻击行为；</p>
				   <br>
				   <h2><b>数据安全</b></h2>
				   <p>使用阿里云服务，实时同步系统到阿里云的各个备份节点，每份数据具有多个副本，保证数据绝对安全、可靠。</p>
				   <br>
				   <h2><b>完善内控管理</b></h2>
				   <p>建立完善的内部管理机制和建立专业的管理团队，关键操作确保双岗复核，确保在任何场合和任何时间下都无法擅自篡改、删除系统的相关数据。</p>
				   <br>
				   <h2><b>专业法律支持</b></h2>
				   <p>聘请浙江凯富律师事务所作为平台法律顾问。在服务模式、产品设计、政策取向、合同协议起草审核等多方面提供专业的法律服务，保障融资方式、平台和项目的合法合规，保证投资人在平台上的所有操作都合法有效。</p>
        	   </div>
        	</div>
        	<div   role="tabpanel" class="tab-pane" id="guide" style="width: 750px;">	
        	   <div style="text-align: left; font-size: 16px; line-height: 24px;margin: 30px 20px 10px 20px">
						<h2 style="text-align: left; font-size: 24px;">电影投资项目：</h2>
						<br>
						<p>电影投资项目为封闭投资项目，投资周期与电影项目整体制作、发行的运作周期同步，在6到24个月不等，规模和风险由投资方参与的不同阶段以及风险控制策略决定。</p>
						<br>
						<h2 style="text-align: left; font-size: 20px;">资金用途：</h2>
						<p>根据参与阶段的不同分为制片专项资金，宣发专项资金，以及整体投资。</p>
						<p>其中制片资金用于剧本开发、演职员片酬、制作、后期等制片投资。</p>
						<p>宣发资金用于宣传、发行投资。</p>
						<p>整体投资的资金使用则包含上述两者。</p>
						<br>
						<h2 style="text-align: left; font-size: 20px;">投资收益：</h2>
						<p>电影的投资收益主要由院线票房分成收入、植入广告收入、电视播映权收入、网络信息传播权发行收入、其他新媒体发行收入及海外发行收入构成。</p>
						<br>
						<h2 style="text-align: left; font-size: 20px;">投资风险：</h2>
						<p>投资行为存在宏观经济风险、行业风险、发行风险。</p>
						<p>不同的投资项目，存在不同的风险水平等级。聚米众筹监督项目方，根据项目的不同特点为投资建立项目封闭运作、账户监管、版权控制、优先回款、补足责任等最大限度保障投资安全的风险控制机制。（具体每个项目的风控机制，以每个项目披露的投资文件为准）</p>

						<br> <br>

						<h2 style="text-align: left; font-size: 24px;">电视投资项目：</h2>
						<br>
						<p>电视投资项目为封闭投资项目，投资周期与电视剧整体制作、发行的运作周期同步，在6到24个月不等，规模和风险由投资方参与的不同阶段以及风险控制策略决定。</p>
						<br>
						<h2 style="text-align: left; font-size: 20px;">资金用途：</h2>
						<p>根据参与阶段的不同分为制片专项资金，宣发专项资金，以及整体投资。</p>
						<p>其中制片资金用于剧本开发、演职员片酬、制作、后期等制片投资。</p>
						<p>宣发资金用于宣传、发行投资。</p>
						<p>整体投资的资金使用则包含上述两者。</p>
						<br>
						<h2 style="text-align: left; font-size: 20px;">投资收益：</h2>
						<p>电视剧的投资收益主要由电视播映收入、植入广告收入、信息网络传播权发行收入、其他新媒体发行收入及海外发行收入构成。</p>
						<br>
						<h2 style="text-align: left; font-size: 20px;">投资风险：</h2>
						<p>投资行为存在宏观经济风险、行业风险、发行风险。
						</p><p>不同的投资项目，存在不同的风险水平等级。聚米众筹监督项目方，根据项目的不同特点为投资建立项目封闭运作、账户监管、版权控制、优先回款、补足责任等最大限度保障投资安全的风险控制机制。（具体每个项目的风控机制，以每个项目披露的投资文件为准）</p>
	            </div>
            </div>
        	<div   role="tabpanel" class="tab-pane" id="about" style="width: 750px;" >
        	   <img src="img/gyjm.jpg" alt="" style="width:700px;">
        	</div>
        	<div   role="tabpanel" class="tab-pane" id="contact">
        	    <div style="width: 750px;">
        	   	  <img src="img/address.png" alt="" style="margin: 20px;"/>
        	    </div>
        	    <div style="font-size:16px;line-height:36px;margin-left: 20px;">
					<p><span class="glyphicon glyphicon-map-marker" style="font-size:24px;" aria-hidden="true"></span>：杭州市西湖区天目山路398号尚坤大厦3楼322室     </p>
					<p><i class="glyphicon glyphicon-phone" style="font-size:24px;"></i>：0571-89731677、89731678、89731679</p>
					<p><i class="glyphicon glyphicon-earphone" style="font-size:24px;"></i>：0571-89731676</p>
					<p><i class="glyphicon glyphicon-envelope" style="font-size:24px;"></i>：jiuma@jumifinance.com</p>

				</div>
        	</div>
        	<div   role="tabpanel" class="tab-pane" id="word">
        	   <img src="img/zczc.jpg" alt="" style="width:700px;">
        	</div>
        	<div   role="tabpanel" class="tab-pane" id="older">
        	   <img src="img/wqxm.jpg" alt="" style="width:700px;">
        	</div>
        	<div   role="tabpanel" class="tab-pane" id="advantage">
        	    <img src="img/ptys.png" alt="" style="width:700px;">
        	</div>
        	<div   role="tabpanel" class="tab-pane" id="announce" style="width: 750px;">
        	      <div class="list-group" style="margin: 30px 20px 10px 20px">
				  <a href="#" class="list-group-item">
				    <h4>[全金属裂痕]回款公告<small style="margin-left: 20px;">2015-11-9 12:34:56</small></h4>
				    
				  </a>
				  <a href="#" class="list-group-item">
				  	<h4>[逗比男生]回款公告<small style="margin-left: 20px;">2015-11-9 12:34:56</small></h4>
				  </a>
				  <a href="#" class="list-group-item">
				  	<h4>[惊魂夜大事件]回款公告<small style="margin-left: 20px;">2015-11-9 12:34:56</small></h4>
				  </a>
				  <a href="#" class="list-group-item">
				  	<h4>[片场风云之冤家姐妹]回款公告<small style="margin-left: 20px;">2015-11-9 12:34:56</small></h4>
				  </a>
				  <a href="#" class="list-group-item">
				  	<h4>[监灵神探]上映公告<small style="margin-left: 20px;">2015-11-9 12:34:56</small></h4>
				  </a>

				  <a href="#" class="list-group-item">
				    <h4>[儿童总裁]回款公告<small style="margin-left: 20px;">2015-11-9 12:34:56</small></h4>
				  </a>
				  <a href="#" class="list-group-item">
				  	<h4>[逗比男生]上映公告<small style="margin-left: 20px;">2015-11-9 12:34:56</small></h4>
				  </a>
				  <a href="#" class="list-group-item">
				  	<h4>[片场风云之冤家姐妹]上映公告<small style="margin-left: 20px;">2015-11-9 12:34:56</small></h4>
				  </a>
				  <a href="#" class="list-group-item">
				  	<h4>[惊魂夜大事件]上映公告<small style="margin-left: 20px;">2015-11-9 12:34:56</small></h4>
				  </a>
				  <a href="#" class="list-group-item">
				  	<h4>有关众筹项目进度的公告<small style="margin-left: 20px;">2015-11-9 12:34:56</small></h4>
				  </a>
			 </div>
        	</div>
        </div>
    </div>
</body>
</html>

