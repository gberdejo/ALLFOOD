<%
	if(session.getAttribute("USUARIOCLIENTE")== null){
		request.setAttribute("MENSAJE", "Para ingresar debe logearse");
		pageContext.forward("/usuario_login.jsp");
	}
%>