<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="name" required="true" %>
<span class="validation-error">${errors.from(name)}</span>
