<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>电影众筹项目_电影投资项目列表 - 91玖马网</title>
	<link rel="stylesheet" type="text/css" href="bootstrap-3.3.5-dist/css/bootstrap.min.css">
	<link rel="stylesheet" href="circle_progress/css/progress.css">
	<link rel="stylesheet" href="css/style.css">
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
	<script src="bootstrap-3.3.5-dist/js/jquery.min.js"></script>
    <script src="bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="circle_progress/dist/jquery-asPieProgress.min.js"></script>
   
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
            
            <div class="collapse navbar-collapse" id="example-navbar-collapse text-center" style="margin-top: 10px">
	            <ul class="nav navbar-nav navbar-left ">
                <li><a href="index.html" style="font-size: 18px">首页</a></li>
                <li><a href="invest.html" style="font-size: 18px">影视投资</a></li>
                <li><a href="projectdelivery.html" style="font-size: 18px">项目投递</a></li>
                <!-- <li><a href="projectissue.html" style="font-size: 18px">发行</a></li> -->
                <li><a href="shangcheng.html" style="font-size: 18px">玖马商城</a></li>
                <li><a href="travel.html" style="font-size: 18px">影视旅游</a></li>
                <li><a href="list.html" style="font-size: 18px">关于</a></li>
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
  
  <div  style="background: url(img/top.jpg) no-repeat top center ;height: 360px;width: 100%">
  </div>
  <div style="background: #f5f5f5">
  <div class="container" >
  	<div style="height: 40px;margin-top: 20px">
			<i class="border-left"></i>
			<strong>项目类型</strong>
			<div class="btn-group" role="group" aria-label="...">
               <button type="button" class="btn btn-default">全部</button>
               <button type="button" class="btn btn-info">影视娱乐</button>
               <button type="button" class="btn btn-default">泛文化</button>
            </div>
   </div>
   <div style="height: 40px;margin-top: 10px">
			<i class="border-left"></i>
			<strong>项目状态</strong>
		   <div class="btn-group" role="group" aria-label="...">
               <button type="button" class="btn btn-info">全部</button>
               <button type="button" class="btn btn-default">即将开始</button>
               <button type="button" class="btn btn-default">正在众筹</button>
               <button type="button" class="btn btn-default">众筹结束</button>
               <button type="button" class="btn btn-default">完成兑付</button>
            </div>
	</div>
  </div>
  <div class="row" style="margin-left: 50px;margin-top: 20px">
    <div class="col-sm-6 col-md-4">
     <div class="thumbnail  course-list-img">
      <a href="detail.html"><img class="img_3" src="img/z2.jpg"></a>
      <div class="caption">
       <div class="row">
         <div class="col-md-7">
         	<a href="detail.html"> <h5>异能档案之霹雳快闪</h5></a>
         </div>
      	 <div class="col-md-5">
      	 	 <button class="btn btn-warning" type="button" >转化率 <span class="badge">40%</span></button>
      	 </div> 
       </div>
      </div>
       <div class="progress" style="height: 3px">
          <div class="progress-bar" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%;"></div>
       </div>
       <div class="row">
       	  <div class="col-md-4 text-center ">
       	  	 <div class="text-primary"><b>63.5%</b></div>
       	  	 <div class="text-muted"><b>已完成</b></div>
       	  </div>
       	   <div class="col-md-4 text-center ">
       	  	 <div class="text-primary"><b>45万元</b></div>
       	  	 <div class="text-muted"><b>目标金额</b></div>
       	  </div>
           <div class="col-md-4 text-center ">
       	  	 <div class="text-primary"><b>6个月</b></div>
       	  	 <div class="text-muted"><b>回报周期</b></div>
       	  </div>
        </div>
    </div>
 </div>

<div class="col-sm-6 col-md-4">
     <div class="thumbnail  course-list-img">
      <a href="detail.html"><img class="img_3" src="img/z4.jpg"></a>
      <div class="caption">
       <div class="row">
         <div class="col-md-7">
         	<a href="detail.html"> <h5>全金属裂痕（第一期）</h5></a>
         </div>
      	 <div class="col-md-5">
      	 	 <button class="btn btn-warning" type="button" >转化率 <span class="badge">40%</span></button>
      	 </div> 
       </div>
      </div>
       <div class="progress" style="height: 3px">
          <div class="progress-bar" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%;"></div>
       </div>
       <div class="row">
       	  <div class="col-md-4 text-center ">
       	  	 <div class="text-primary"><b>63.5%</b></div>
       	  	 <div class="text-muted"><b>已完成</b></div>
       	  </div>
       	   <div class="col-md-4 text-center ">
       	  	 <div class="text-primary"><b>45万元</b></div>
       	  	 <div class="text-muted"><b>目标金额</b></div>
       	  </div>
           <div class="col-md-4 text-center ">
       	  	 <div class="text-primary"><b>6个月</b></div>
       	  	 <div class="text-muted"><b>回报周期</b></div>
       	  </div>
        </div>
    </div>
 </div>

<div class="col-sm-6 col-md-4">
     <div class="thumbnail  course-list-img">
      <a href="detail.html"><img class="img_3" src="img/z5.jpg"></a>
      <div class="caption">
       <div class="row">
         <div class="col-md-7">
         	<a href="detail.html"> <h5>逗比男生</h5></a>
         </div>
      	 <div class="col-md-5">
      	 	 <button class="btn btn-warning" type="button" >转化率 <span class="badge">40%</span></button>
      	 </div> 
       </div>
      </div>
       <div class="progress" style="height: 3px">
          <div class="progress-bar" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%;"></div>
       </div>
       <div class="row">
       	  <div class="col-md-4 text-center ">
       	  	 <div class="text-primary"><b>63.5%</b></div>
       	  	 <div class="text-muted"><b>已完成</b></div>
       	  </div>
       	   <div class="col-md-4 text-center ">
       	  	 <div class="text-primary"><b>45万元</b></div>
       	  	 <div class="text-muted"><b>目标金额</b></div>
       	  </div>
           <div class="col-md-4 text-center ">
       	  	 <div class="text-primary"><b>6个月</b></div>
       	  	 <div class="text-muted"><b>回报周期</b></div>
       	  </div>
        </div>
    </div>
 </div>

 <div class="col-sm-6 col-md-4">
     <div class="thumbnail  course-list-img">
      <a href="detail.html"><img class="img_3" src="img/z6.jpg"></a>
      <div class="caption">
       <div class="row">
         <div class="col-md-7">
         	<a href="detail.html"> <h5>片场风云之冤家姐妹</h5></a>
         </div>
      	 <div class="col-md-5">
      	 	 <button class="btn btn-warning" type="button" >转化率 <span class="badge">40%</span></button>
      	 </div> 
       </div>
      </div>
       <div class="progress" style="height: 3px">
          <div class="progress-bar" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%;"></div>
       </div>
       <div class="row">
       	  <div class="col-md-4 text-center ">
       	  	 <div class="text-primary"><b>63.5%</b></div>
       	  	 <div class="text-muted"><b>已完成</b></div>
       	  </div>
       	   <div class="col-md-4 text-center ">
       	  	 <div class="text-primary"><b>45万元</b></div>
       	  	 <div class="text-muted"><b>目标金额</b></div>
       	  </div>
           <div class="col-md-4 text-center ">
       	  	 <div class="text-primary"><b>6个月</b></div>
       	  	 <div class="text-muted"><b>回报周期</b></div>
       	  </div>
        </div>
    </div>
 </div>

<div class="col-sm-6 col-md-4">
     <div class="thumbnail  course-list-img">
      <a href="detail.html"><img class="img_3" src="img/z8.jpg"></a>
      <div class="caption">
       <div class="row">
         <div class="col-md-7">
         	<a href="detail.html"> <h5>网络大电影：儿童总...</h5></a>
         </div>
      	 <div class="col-md-5">
      	 	 <button class="btn btn-warning" type="button" >转化率 <span class="badge">40%</span></button>
      	 </div> 
       </div>
      </div>
       <div class="progress" style="height: 3px">
          <div class="progress-bar" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%;"></div>
       </div>
       <div class="row">
       	  <div class="col-md-4 text-center ">
       	  	 <div class="text-primary"><b>63.5%</b></div>
       	  	 <div class="text-muted"><b>已完成</b></div>
       	  </div>
       	   <div class="col-md-4 text-center ">
       	  	 <div class="text-primary"><b>45万元</b></div>
       	  	 <div class="text-muted"><b>目标金额</b></div>
       	  </div>
           <div class="col-md-4 text-center ">
       	  	 <div class="text-primary"><b>6个月</b></div>
       	  	 <div class="text-muted"><b>回报周期</b></div>
       	  </div>
        </div>
    </div>
 </div>

</div>
	<div class="container" style="margin-top: 50px">
		<div class="row">
			<div class="col-md-3">
			   <div class="col-md-3" style="margin-top: 16px">
			   	   <span class="label label-warning" style="font-size: 25px">技</span>
			   </div>
               <div class="col-md-9 text-left">
               	   <h6><b>技术保障</b></h6>
               	   <h6 class="text-muted">还款保障  资金托管</h6>
               </div>
			</div>
			<div class="col-md-3">
			   <div class="col-md-3" style="margin-top: 16px">
			   	   <span class="label label-warning" style="font-size: 25px">价</span>
			   </div>
               <div class="col-md-9 text-left">
               	   <h6><b>价格保障</b></h6>
               	   <h6 class="text-muted">年化收益高于12%</h6>
               </div>
			</div>
			<div class="col-md-3">
			   <div class="col-md-3" style="margin-top: 16px">
			   	   <span class="label label-warning" style="font-size: 25px">险</span>
			   </div>
               <div class="col-md-9 text-left">
               	   <h6><b>风险保障</b></h6>
               	   <h6 class="text-muted">领投机制 公开透明</h6>
               </div>
			</div>
			<div class="col-md-3">
			   <div class="col-md-3" style="margin-top: 16px">
			   	   <span class="label label-warning" style="font-size: 25px">法</span>
			   </div>
               <div class="col-md-9 text-left">
               	   <h6><b>法律保障</b></h6>
               	   <h6 class="text-muted">凯旋律师事务所承担法律顾问</h6>
               </div>
			</div>
		</div>
	</div>
	<div class="container" style="margin-top: 10px">
		<div class="row">
			<div class="col-md-3 ">
			   <div class="col-md-9 col-md-offset-3">
			   	   <h6><b>关于我</b></h6>
                   <h6><a href="#" >创始人寄语</a></h6>
				   <h6><a href="#" >平台优势</a></h6>
				   <h6><a href="#" >媒体报道</a></h6>
				   <h6><a href="#" >往期项目</a></h6>
			   </div>
				
			</div>
            <div class="col-md-3 ">
			   <div class="col-md-9 col-md-offset-3">
			   	   <h6><b>帮助中心</b></h6>
                   <h6><a href="#" >投资指南</a></h6>
				   <h6><a href="#" >常见问题</a></h6>
				   <h6><a href="#" >在线招聘</a></h6>
			   </div>
			</div>
			<div class="col-md-3 ">
			   <div class="col-md-9 col-md-offset-3">
			   	   <h6><b>联系方式</b></h6>
                   <h6 class="text-muted">QQ群 2222222</h6>
				   <h6 class="text-muted">客户热线 400-800-900</h6>
				   <h6 class="text-muted">(周一至周日 8:00-18:00)</h6>
			   </div>
			</div>
			<div class="col-md-3 ">
			   <div class="col-md-9 col-md-offset-3">
			   	   <h6><b>关注我们</b></h6>
			   </div>
			</div>
		</div>
	</div>
	<footer id="footer">
		<div class="container text-center">
			<p class="text-muted">
			友情连接：
			<a href="http://www.cmbchina.com/" target="_blank" class="text-muted">招商银行</a>
			<a href="http://www.zhongchoutimes.com/" target="_blank" class="text-muted">众筹时代</a>
			<a href="http://www.wdzx.com/" target="_blank" class="text-muted">网贷中心</a>
			<a href="https://www.omniaccount.com/" target="_blank" class="text-muted">大账户</a>
			<a href="http://www.zhongchoujia.com/" target="_blank" class="text-muted">众筹家</a>
			<a href="http://www.zcworks.cn/webadmin/admin/main.action" target="_blank" class="text-muted">众筹工坊</a>
			<a href="http://www.xeenho.com/" target="_blank" class="text-muted">星火钱包</a>
			<a href="http://www.d3f.com/" target="_blank" class="text-muted">众筹第三方</a> 
			</p>
			<p  class="text-muted">©2016杭州91玖马信息服务有限公司all rights reserved 浙ICP备15007777号-7 </p>
			<p>
			<a href="http://www.cmbchina.com/" target="_blank"><img src="img/zsyh.png" alt="" height="20"></a>
			<a href="http://www.hzbank.com.cn/" target="_blank"><img src="img/hzyh.png" alt="" height="20"></a>
			<a href="http://www.aliyun.com/?utm_medium=text&utm_source=bdbrand&utm_campaign=bdbrand&utm_content=se_32492" target="_blank"><img src="img/aliyun.png" alt="" height="20"></a>
			<a href="http://www.newtiming.net/" target="_blank"><img src="img/xindingm.png" alt="" height="20"></a>
			<a href="http://www.wisdomfish.com/" target="_blank"><img src="img/weide.png" alt="" height="20"></a>
			<a href="http://www.timeast.net/index.html" target="_blank"><img src="img/donghua.png" alt="" height="20"></a>
			<a href="#"><img src="img/toutiao.png" alt="" height="20"></a>
		</p>
		<p>
			<a href="https://sealinfo.verisign.com/splash?form_file=fdf/splash.fdf&amp;dn=www.jumifinance.com&amp;lang=zh_cn" rel="nofollow" target="_blank"><img src="img/safy-norton.png" alt="" height="30"></a>
			<a href="http://www.itrust.org.cn/Home/Index/itrust_certifi?wm=1328207021" target="_blank" rel="nofollow"><img src="img/safy-icp.png" alt="" height="30"></a>
			<a href="http://webscan.360.cn/index/checkwebsite/url/www.jumifinance.com" target="_blank" rel="nofollow"><img src="img/safy-360.png" alt="" height="30"></a>
		</p>
		</div>
	</footer>
	</div>
</body>
</html>
