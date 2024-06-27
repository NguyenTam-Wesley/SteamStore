<%@ include file="../init.jsp" %>

<aui:fieldset>
    <h1>Add Publisher</h1>
    <aui:form action="<portlet:actionURL name='addPublisher'/>" method="post" enctype="multipart/form-data">
        <aui:input name="publisherId" type="text" label="Publisher ID" />
        <aui:input name="publisherName" type="text" label="Publisher Name" />
        <aui:input name="linkWebsite" type="text" label="Website" />
        <aui:input name="publisherInfo" type="textarea" label="About" />
        <aui:button type="submit" value="Submit" />
    </aui:form>
</aui:fieldset>