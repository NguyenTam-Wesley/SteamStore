<%@ include file="../init.jsp" %>

<aui:fieldset>
    <h1>Edit Game</h1>
    <aui:form action="<portlet:actionURL name='editGame'/>" method="post" enctype="multipart/form-data">
        <aui:input name="appId" type="number" label="App ID" />
        <aui:input name="title" type="text" label="Title" />
        <aui:select name="publisherName" label="Publisher Name">
            <aui:option value="Valve" label="Valve" />
            <aui:option value="PlayStation PC LLC" label="PlayStation PC LLC" />
            <aui:option value="Bandai Namco Entertainment" label="Bandai Namco Entertainment" />
            <aui:option value="CD PROJEKT RED" label="CD PROJEKT RED" />
        </aui:select>
        <aui:input name="releaseDate" type="date" label="Release Date" />
        <aui:input name="price" type="number" step="0.01" label="Price" />
        <aui:input name="aboutDescription" type="textarea" label="About Description" />
        <aui:button type="submit" value="Submit" />
    </aui:form>
</aui:fieldset>