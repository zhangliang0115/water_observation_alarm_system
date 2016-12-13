<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@taglib prefix="fr" uri="http://www.eframework.org/tags/form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>父级菜单</title>
<jsp:include page="/WEB-INF/include/link.jsp"></jsp:include>
<script type="text/javascript">
page.edit.height=400;
function callback(){
	doSelect(openerWin);
}
function doSelect(win){
	var cur=$("#dg").datagrid("getSelected");
	if(!!cur){
		var callback=win.getData('callback');
		if(!!callback && typeof callback=="function"){
			callback(cur,win);
			win.close();
		}else{
			$error("callback未定义！");
		}
	}else{
		$warn("请选择事件模板！");
	}
}
var options={
	onDblClickRow:callback,
	singleSelect:true,
	columns:[[
			{field:'event_no',width:100,align:'left',halign:'center',title:'事件编号'}   ,    
			{field:'name',width:100,align:'left',halign:'center',title:'事件名称'}
    ]],
	toolbar:getButtons(buttons_def,["search"],{})
};
frDataGrid(options);
</script>
</head>
<body class="easyui-layout">
	<div data-options="region:'center',border:false">
	<table id="dg" border="false"></table>
		<fr:SearchForm id="sf">
		<div class="search-item">
			<div class="searchtitle">事件名称:</div> 
			<div class="searchinput">
				<input name="like_name" class="easyui-textbox fr-search-form-val" style="width:110px">
			</div>
		</div>
	</fr:SearchForm>
	</div>
</body>
</html>
