<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@taglib prefix="fr" uri="http://www.eframework.org/tags/form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>微信事件回复消息</title>
<jsp:include page="/WEB-INF/include/link.jsp"></jsp:include>
<script type="text/javascript">
page.edit.height=250;
var options={
	columns:[[
			{field: 'ck', checkbox: true},
			{field:'event_no',width:100,align:'left',halign:'center',title:'事件编号'}   ,      
			{field:'name',width:100,align:'left',halign:'center',title:'事件名称'}
    ]],
	toolbar:getButtons(buttons_def,buttons.list,{})
};
frDataGrid(options);
</script>
</head>
<body class="easyui-layout">
	<div region="center" title="微信事件回复消息"> 
		<table id="dg" border="false"></table>
    </div>
	<fr:SearchForm id="sf">
		<div class="search-item">
			<div class="searchtitle">事件名称:</div> 
			<div class="searchinput">
				<input name="like_name" class="easyui-textbox fr-search-form-val" style="width:110px">
			</div>
		</div>
	</fr:SearchForm>
</body>
</html>
