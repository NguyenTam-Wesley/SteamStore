<%@ include file="/init.jsp" %>

<portlet:renderURL var="menuPublisher">
	<portlet:param name="mvcRenderCommandName" value="menu_publisher"/>
</portlet:renderURL>

<portlet:renderURL var="menuGame">
	<portlet:param name="mvcRenderCommandName" value="menu_game"/>
</portlet:renderURL>

<a href="${menuPublisher}">Publisher</a>

<a href="${menuGame}">Game</a>