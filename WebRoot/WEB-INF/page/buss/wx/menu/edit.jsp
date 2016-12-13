<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@taglib prefix="fr" uri="http://www.eframework.org/tags/form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>微信菜单</title>
<jsp:include page="/WEB-INF/include/link.jsp"></jsp:include>
<script type="text/javascript">
	
	function selectModuleCallBack(row){
		$("#module_name").textbox("setValue",row.event_no+row.name);
		$("#event_no").val(row.event_no);
	}
	function selectModuleNo(){
		select({
			title:"选择事件模板",
			content: 'url:/buss/wx/event/msg/select',
			locate:'document.parent',
			data:{
				callback:selectModuleCallBack
			}
		});
	}
	
	var moduleIcons=[{
		iconCls:'icon-clear',
		handler: function(e){
			$(e.data.target).textbox('clear');
			$("#event_no").val('');
		}
	}];
	var eventData=[
		{value:"click",text:"点击推事件"},
		{value:"view",text:"跳转URL"},
		{value:"scancode_waitmsg",text:"扫描推消息"}
	];
</script>
</head>
<body class="easyui-layout">
	<div data-options="region:'center',border:false">
		<fr:form>
			<div class="easyui-panel"
				data-options="sortName:'sort',title:'基本信息', iconCls:'eicon-group' ,collapsible:false,fit:false,border:false">
				<fr:table>
					<tr>
						<td class="l">菜单名称</td>
						<td class="r"><fr:input path="name" class="easyui-textbox col1" required="true" /></td>
						<td class="l">菜单类型</td>
						<td class="r"><fr:input path="type" class="easyui-combobox col1"  data-options="editable:false,data:eventData" /></td>
						<td class="l">事件模板</td>
						<td class="r"><fr:input id="module_name"  value="${event.event_no }${event.name }"
											class="easyui-textbox col1"  data-options="editable:false,buttonIcon:'icon-search',
						prompt: '选择业务模块',
						iconWidth: 22,onClickButton:selectModuleNo,icons: moduleIcons
						"/></td>
					</tr>
					<tr>
						<td class="l">URL</td>
						<td class="r" colspan="5"><fr:input path="url" class="easyui-textbox col5"  /></td>
					</tr>
					<tr>
						<td class="l">排序</td>
						<td class="r"><fr:input path="sort" value="0" data-options="min:0" class="easyui-numberspinner col1" /></td>
					</tr>
				</fr:table>
			</div>
			<fr:hidden path="id" />
			<fr:hidden path="pid" />
			<fr:hidden path="event_no" />
			<fr:hidden path="menu_type" value="0" />
		</fr:form>
	</div>
	</body>
</html>
