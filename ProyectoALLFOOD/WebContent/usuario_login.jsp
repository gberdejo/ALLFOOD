<%@ include file="importacion_head.jsp" %>
<body>
	
	
<div>
		<div class="container">
			<form action="ServletLogin">
			  <div class="form-group">
			    <label for="exampleInputEmail1">Email address</label>
			    <input type="text" name="usuario" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="User">
			    <% String mensaje = (String) request.getAttribute("MENSASE");
			    	if(mensaje != null){	
			    		%>
			    <small  class="form-text text-muted"><%=mensaje %></small>
			    <%} %>
			  </div>
			  <div class="form-group">
			    <label for="exampleInputPassword1">Contraseña</label>
			    <input type="password" name="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
			  </div>
			  <button type="submit" class="btn btn-primary">Entrar</button>
			</form>
		</div>
	</div>
<%@ include file="importacion_js.jsp" %>
</body>
</html>