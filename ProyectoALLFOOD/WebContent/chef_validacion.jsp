<%
	if(session.getAttribute("USUARIOCHEF")== null){
		request.setAttribute("MENSAJE", "Para ingresar debe logearse");
		pageContext.forward("/chef_login.jsp");
	}
%>