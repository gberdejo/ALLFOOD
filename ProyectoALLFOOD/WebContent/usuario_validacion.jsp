<%
	if(session.getAttribute("USUARIO")== null){
		request.setAttribute("MENSAJE", "Para ingreqwdqdqdwqdsar debe logearse");
		pageContext.forward("/usuario_login.jsp");
	}
%>