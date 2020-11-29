
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<%--transfer conversational state of client to java Bean : setter  --%>
<jsp:setProperty property="*" name="vendor_bean"/>

<%-- redirect client to next page in the Next request --%>
<%--  response.sendRedirect(response.encodeRedirectURL( session.getAttribute("vendor_bean").valudateUser().concat(".jsp"))) --%>

<c:redirect url="${sessionScope.vendor_bean.validateUser()}.jsp"/>

