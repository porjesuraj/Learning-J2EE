<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:setProperty property="*" name="acct_bean"/>
<c:redirect url="${sessionScope.acct_bean.createAccount(sessionScope.vendor_bean.validatedDetails)}.jsp"/>
