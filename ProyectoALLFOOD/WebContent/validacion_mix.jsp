<%
	if((session.getAttribute("USUARIOCLIENTE")== null) ||  (session.getAttribute("USUARIOCHEF")== null)){
		request.setAttribute("MENSAJE", "Para ingresar debe logearse");
		pageContext.forward("/index.jsp");
	}
%>