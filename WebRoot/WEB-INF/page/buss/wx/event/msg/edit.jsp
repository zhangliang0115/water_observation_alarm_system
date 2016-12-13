<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@taglib prefix="fr" uri="http://www.eframework.org/tags/form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>微信事件回复消息</title>
<jsp:include page="/WEB-INF/include/link.jsp"></jsp:include>
</head>
<body class="easyui-layout">
	<div data-options="region:'center',border:false">
		<fr:form>
			<div class="easyui-panel"
				data-options="title:'基本信息', iconCls:'eicon-group' ,collapsible:false,fit:false,border:false">
				<fr:table>
					<tr>
						<td class="l">事件编号</td>
						<td class="r"><fr:input path="event_no" class="easyui-textbox col1" required="true"/></td>
						<td class="l">事件名称</td>
						<td class="r"><fr:input path="name" class="easyui-textbox col1" required="true" /></td>
						<td class="l"></td>
						<td class="r"></td>
					</tr>
					<tr>
						<td class="l">回复消息模板</td>
						<td class="r" colspan="5"><fr:textarea path="reply_msg" class="easyui-validatebox col5" required="true" rows="4"/> </td>
					</tr>

				</fr:table>
			</div>
			<fr:hidden path="id" />
		</fr:form>
	</div>
	</body>
</html>
