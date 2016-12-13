<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@taglib prefix="fr" uri="http://www.eframework.org/tags/form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>第三方用户信息</title>
<jsp:include page="/WEB-INF/include/link.jsp"></jsp:include>
<script type="text/javascript">
page.edit.height=400;
var options={
	columns:[[
			{field: 'ck', checkbox: true},
			{field:'version',width:100,align:'right',halign:'center',title:'版本号'},
			{field:'thirdparty_id',width:100,align:'right',halign:'center',title:'第三方ID'},
			{field:'thirdparty_no',width:100,align:'left',halign:'center',title:'第三方用户编号'},
			{field:'union_no',width:100,align:'left',halign:'center',title:''}            
    ]],
	toolbar:getButtons(buttons_def,buttons.list,{})
};
frDataGrid(options);
</script>
</head>
<body class="easyui-layout">
	<div region="center" title="第三方用户信息"> 
		<table id="dg" border="false"></table>
    </div>
	<fr:SearchForm id="sf">
		<div class="search-item">
			<div class="searchtitle">名称:</div> 
			<div class="searchinput">
				<input name="like_name" class="easyui-textbox fr-search-form-val" style="width:110px">
			</div>
		</div>
	</fr:SearchForm>
</body>
</html>
