<%@  include file="importacion_head.jsp" %>
<body>
<div class="fondo-chef">
		<div class="container w-50 ">
		
		<div class="row align-items-center" style="height:100vh;">
			<div class="col-12">
				<h1 class="text-white text-center">Inicio de Sesion como Chef</h1>
				<form action="ServletChef" >
			  <div class="form-group">
			    <label for="exampleInputEmail1" class="text-white">Email address</label>
			    <input type="text" name="usuario" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="User">
			    <% String mensaje = (String) request.getAttribute("MENSASE");
			    	if(mensaje != null){	
			    		%>
			    <small  class="form-text text-muted"><%=mensaje %></small>
			    <%} %>
			  </div>
			  <div class="form-group">
			    <label for="exampleInputPassword1"class="text-white">Contraseña</label>
			    <input type="password" name="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
			  </div>
			  <div class="form-group">
			  <button type="submit" class="btn btn-success btn-block p-2">Entrar</button>
			  </div>
			  <div class="form-group">
			  
			  </div>
			</form>
			<div class="row justify-content-between">
			  		<div class="col-6">
			  			<a class="enlace" href="index.jsp"><button class="btn btn-primary btn-block">Home</button></a>
			  		</div>
			  		<div class="col-6">
			  			<a class="enlace" href="index.jsp"><button class="btn btn-primary btn-block">Registrate</button></a>
			  		</div>
			  </div>
			  <a class="enlace"  href="usuario_login.jsp"><button class="btn btn-info btn-block p-3 mt-5">Iniciar Sesion como Cliente</button></a>
			</div>
		</div>
			
		</div>
</div>



<%@ include file="importacion_js.jsp" %>
</body>
</html>