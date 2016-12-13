<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@taglib prefix="fr" uri="http://www.eframework.org/tags/form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册用户</title>
<jsp:include page="/WEB-INF/include/link.jsp"></jsp:include>
</head>
<body class="easyui-layout">
	<div data-options="region:'center',border:false">
		<fr:form>
			<div class="easyui-panel"
				data-options="title:'基本信息', iconCls:'eicon-group' ,collapsible:false,fit:false,border:false">
				<fr:table>
					<tr>
						<td class="l">姓名</td>
						<td class="r"><fr:input path="name" class="easyui-textbox col1" /></td>
						<td class="l">电话</td>
						<td class="r"><fr:input path="mobile" class="easyui-textbox col1" /></td>
						<td class="l">昵称</td>
						<td class="r"><fr:input path="nick_name" class="easyui-textbox col1" /></td>
					</tr>
					<tr>
						<td class="l">申请角色</td>
						<td class="r"><fr:input path="role_id" class="easyui-combobox col1" data-options="data:[{value:1,text:'物料厂家'},{value:2,text:'稽查单位'}]"/></td>
						<td class="l">岗位</td>
						<td class="r"><fr:input path="job" class="easyui-textbox col1" /></td>
						<td class="l">审核状态</td>
						<td class="r"><fr:input path="status" class="easyui-combobox col1" data-options="data:[{value:0,text:'审核中'},{value:1,text:'审核通过'},{value:2,text:'审核不通过'}]" /></td>
					</tr>
				</fr:table>
			</div>
			<fr:hidden path="id" />
		</fr:form>
	</div>
	</body>
</html>
