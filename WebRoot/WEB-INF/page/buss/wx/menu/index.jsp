<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@taglib prefix="fr" uri="http://www.eframework.org/tags/form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>微信菜单</title>
<jsp:include page="/WEB-INF/include/link.jsp"></jsp:include>
<script type="text/javascript">
page.edit.height=400;
var eventData={"click":"点击推事件","view":"跳转URL","scancode_push":"扫描推消息"};
var options={
	url:"page?eq_menu_type=${empty param.menu_type?0:param.menu_type}",
	checkbox:true,
	columns:[[
			{field:'name',width:200,align:'left',halign:'center',title:'菜单名称'},
			{field:'type',width:100,align:'left',halign:'center',title:'菜单类型',formatter:function(value){
				return eventData[value];
			}},
			{field:'event_no',width:100,align:'left',halign:'center',title:'事件编号'},
			{field:'url',width:200,align:'left',halign:'center',title:'跳转URL'}        
    ]],
	toolbar:getButtons(buttons_tree_def.concat(buttons.add),buttons.tree_list.concat("add"),{
		add_root:{
			param:function(){
				return {"obj.menu_type":"${empty param.menu_type?0:param.menu_type}"};
			}
		},
		add_child:{
			param:function(){
				return {"obj.menu_type":"${empty param.menu_type?0:param.menu_type}"};
			}
		},
		add:{
			alias:"pub",
			iconCls:'icon-ok',
			text:'发布',
			handler:function(){
				$.ajax({
					url:"pub",
					data:{
						menu_type:"${empty param.menu_type?0:param.menu_type}"
					},
					dataType:"json",
					success:function(rs){
						$info(rs.msg);
					}
				});
			}
		}
	})
};
frTreeGrid(options);
</script>
</head>
<body class="easyui-layout">
	<div region="center" title="微信菜单"> 
		<table id="tg" border="false"></table>
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
