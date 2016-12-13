<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@taglib prefix="fr" uri="http://www.eframework.org/tags/form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>第三方用户信息</title>
<jsp:include page="/WEB-INF/include/link.jsp"></jsp:include>
</head>
<body class="easyui-layout">
	<div data-options="region:'center',border:false">
		<fr:form>
			<div class="easyui-panel"
				data-options="title:'基本信息', iconCls:'eicon-group' ,collapsible:false,fit:false,border:false">
				<fr:table>
					<tr>
						<td class="l">版本号</td>
						<td class="r"><fr:input path="version" class="easyui-numberbox col1" /></td>
						<td class="l">第三方ID</td>
						<td class="r"><fr:input path="thirdparty_id" class="easyui-numberbox col1" /></td>
						<td class="l">第三方用户编号</td>
						<td class="r"><fr:input path="thirdparty_no" class="easyui-textbox col1" /></td>
					</tr>
					<tr>
						<td class="l"></td>
						<td class="r"><fr:input path="union_no" class="easyui-textbox col1" /></td>
					</tr>

				</fr:table>
			</div>
			<fr:hidden path="id" />
		</fr:form>
	</div>
	</body>
</html>
