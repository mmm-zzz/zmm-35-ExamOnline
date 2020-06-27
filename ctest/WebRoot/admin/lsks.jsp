<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ckbj.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		body{
			margin: 0;
			padding: 0;
		}
		#div1{
		   margin:0px;
		   padding:0px;
		   width:100%;
		   height:99%;  
		   font-size:14px;
		   position:absolute;
		   text-align: center;
		}
		#div2{
			margin:0 0 0 150px;
			padding:0px;
			width:500px;
			border: 1px solid #F0F0F0;
		}
		.divtitle{
			height: 40px;
			line-height: 40px;
			color: #3180D8;
			font-family: "Microsoft YaHei";
			border-bottom: 1px dotted #ededed;
		}
		table{
			border:0px;
			margin:0px;
			padding:0px;
			width:100%;
			text-align: center;
			font-size: 14px;
			color:#6D6D6D;
		}
		tr{
			margin:0px;
			padding:0px;
		}
		td{
			margin:0px;
			padding:0px;
			border-bottom: 1px solid #F0F0F0;
		}
		#div2 a:link,#div2 a:visited{
			color:#1183C2;
			text-decoration:none;
		}
		#div2 a:hover{
			color:#df4011;
		}
	</style>
  </head>
  
  <body>
	<div class="divtitle">
		<strong>历史考试：</strong>
    </div>
    <div id="div1">
  	  <div id="div2">
   		<table border="0px" cellspacing="0px">
   			<tr style="background-color: #DEEFFF">
   				<td style="height: 40px;width: 100px;">考场控制表ID</td>
   				<td style="height: 40px;width: 100px;">考场状态</td>
   				<td style="height: 40px;width: 100px;">考试方式</td>
				<td style="height: 40px;width: 100px;">试卷ID</td>
				<td style="height: 40px;width: 200px;">考试名称</td>
				<td style="height: 40px;width: 200px;">考试时间</td>
   			</tr>
   			<s:iterator value="listlsks" var="lsks">
   				<tr>
   				<td style="height: 40px;width: 100px;"><s:property value="#lsks.tcid"/></td>
   				<td style="height: 40px;width: 100px;">  				
   				<s:if test="%{#lsks.state==0}">
        		<div style="color: red;">关闭</div>
    			</s:if>
    			<s:else>
        		<div style="color: blue;">开启</div>
    			</s:else>   				
   				</td>
   				<td style="height: 40px;width: 100px;">
   				<s:if test="%{#lsks.mode==2}">
        		随机试卷
    			</s:if>
    			<s:else>
        		指定试卷
    			</s:else>   
   				</td>
   				<td style="height: 40px;width: 100px;"><s:property value="#lsks.questionPaper.qpid"/></td>
   				<td style="height: 40px;width: 200px;"><s:property value="#lsks.tname"/></td>
   				<td style="height: 40px;width: 200px;"><s:property value="#lsks.tdate"/></td>

   			</tr>
   			</s:iterator>
   		</table>
   		</div>
  	</div>
  </body>
</html>
