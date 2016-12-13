<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@taglib prefix="fr" uri="http://www.eframework.org/tags/form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册用户</title>
<jsp:include page="/WEB-INF/include/link.jsp"></jsp:include>
<script type="text/javascript">
function uiStatus(value, row){
	var rs = '';
	try {
		var val = "row." + this.field;
		if (eval(val) == 1) {
			rs = "审核通过";
		}else if(eval(val) == 2){
			rs="审核不通过";
		}else{
			rs="审核中";
		}
	} catch (err) {
	}
	return rs;
}
page.edit.height=400;
var audit=["audit_pass","audit_unpass"];
var status=${status};
if(status==1){
	audit=["audit_unpass"];
}else if(status==2){
	audit=["audit_pass"];
}
var options={
	url:"page?eq_status=${status}",
	columns:[[
			{field: 'ck', checkbox: true},
			{field:'name',width:100,align:'left',halign:'center',title:'姓名'},
			{field:'nick_name',width:100,align:'left',halign:'center',title:'昵称'},
			{field:'mobile',width:100,align:'left',halign:'center',title:'电话'},
			{field:'role_id',width:100,align:'center',halign:'center',title:'申请角色',formatter:function(value){
				if(value==1){
					return "物料厂家";
				}else if(value==2){
					return "稽查单位";
				}
			}},
			{field:'fac_name',width:150,align:'left',halign:'center',title:'物料厂家'},
			{field:'inspection_name',width:150,align:'left',halign:'center',title:'稽查单位'},
			{field:'job',width:100,align:'left',halign:'center',title:'岗位'},
			{field:'status',width:100,align:'center',halign:'center',title:'审核状态',formatter:uiStatus}          
    ]],
	toolbar:getButtons(buttons_def.concat(buttons_audit),["search"].concat(audit),{
		add:{
			url:'/buss/account/info/add?_id='+getParam("_id")
		},
		edit:{
			url:'/buss/account/info/edit?_id='+getParam("_id")
		},
		audit_pass:{
			handler:function(){
				var rows=$("#dg").datagrid("getChecked");
				if(rows.length==0){
					$info("请选择一条数据");
				}
				var idsArr = [];
				$.each(rows,function(){
					idsArr.push(this.id);
				});
				var data = {
					ids : idsArr
				};
				if (idsArr.length > 0) {
					$.post("batchPass", $.param(data,true), function(data) {
								var rs=data;
								if (rs.rs == 'error') {
									$error(rs.tip);
								}else{
									$info("审核成功");
								}
								$("#dg").datagrid("reload");
							});
				}
			}
		},
		audit_unpass:{
			handler:function(){
			var rows=$("#dg").datagrid("getChecked");
				if(rows.length==0){
					$info("请选择一条数据");
				}
				var idsArr = [];
				$.each(rows,function(){
					idsArr.push(this.id);
				});
				var data = {
					ids : idsArr
				};
				if (idsArr.length > 0) {
					$.post("batchUnPass", $.param(data,true), function(data) {
								var rs=data;
								if (rs.rs == 'error') {
									$error(rs.tip);
								}else{
									$info("审核成功");
								}
								$("#dg").datagrid("reload");
							});
				}
			}
		}
	})
};
frDataGrid(options);
</script>
</head>
<body class="easyui-layout">
	<div region="center" title="注册用户"> 
		<table id="dg" border="false"></table>
    </div>
	<fr:SearchForm id="sf">
		<div class="search-item">
			<div class="searchtitle">姓名:</div> 
			<div class="searchinput">
				<input name="like_bussAccountInfo.name" class="easyui-textbox fr-search-form-val" style="width:110px">
			</div>
		</div>
		<div class="search-item">
			<div class="searchtitle">电话:</div> 
			<div class="searchinput">
				<input name="like_bussAccountInfo.mobile" class="easyui-textbox fr-search-form-val" style="width:110px">
			</div>
		</div>
	</fr:SearchForm>
</body>
</html>
