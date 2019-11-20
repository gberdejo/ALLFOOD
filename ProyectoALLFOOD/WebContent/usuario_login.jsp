<%@ include file="importacion_head.jsp" %>
<body>
<div class="container">
	<section>
		<!-- Default form login -->
<form class="text-center border border-light p-5" action="ServletCliente">
	<input type="hidden" name="tipo" value="login" >
    <p class="h4 mb-4">Inicio de Sesion como Cliente</p>

	 <% String mensaje = (String) request.getAttribute("MENSASE");
			    	if(mensaje != null){	
			    		%>
	<small  class="form-text text-muted"><%=mensaje %></small>
	<%} %>
    <!-- Email -->
    <input type="text" name="usuario" class="form-control mb-4" aria-describedby="emailHelp" placeholder="User">
    <!-- Password -->
    <input type="password" name="password" id="defaultLoginFormPassword" class="form-control mb-4" placeholder="Password">

    

    <!-- Sign in button -->
    <button class="btn btn-info btn-block my-4" type="submit">Entrar</button>

    <!-- Register -->
    <p>¿No eres un Cliente aún?
        <a href="usuario_registra.jsp">Regístrate</a>
    </p>

    <!-- Social login -->
    <p>or sign in with:</p>

    <a href="#" class="mx-2" role="button"><i class="fab fa-facebook-f light-blue-text"></i></a>
    <a href="#" class="mx-2" role="button"><i class="fab fa-twitter light-blue-text"></i></a>
    <a href="#" class="mx-2" role="button"><i class="fab fa-linkedin-in light-blue-text"></i></a>
    <a href="#" class="mx-2" role="button"><i class="fab fa-github light-blue-text"></i></a>

</form>
<!-- Default form login -->
	</section>
</div>
	

<%@ include file="importacion_js.jsp" %>
</body>
</html>