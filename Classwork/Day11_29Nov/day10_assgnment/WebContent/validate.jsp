
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%--transfer conversational state of the client to javabean : setter --%>
<jsp:setProperty property="*" name="vendor_bean" />

<%--redirect client to the next page in the NEXT request --%>
<%--response.sendRedirect(response.encodeRedirectURL(session.getAttribute("vendor_bean").validateUser().concat(".jsp")) --%>
<c:redirect url="${sessionScope.vendor_bean.validateUser()}.jsp" />
