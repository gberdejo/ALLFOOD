<%@ include file="importacion_head.jsp" %>
<body>
<div class="container">	
<a class="btn btn-outline-danger waves-effect" href="index.jsp"><i class="fas fa-house-damage"></i> Regrasar</a>
	<section>
		<!-- Default form register -->
<form class="text-center border border-light p-5" action="ServletCliente" method="POST" enctype="multipart/form-data" >
<input type="hidden" name="tipo" value="registro" >
    <p class="h4 mb-4">Registro de Cliente</p>
	<!-- User and password -->
		<!-- usuario -->
		<% String texto =(String) request.getAttribute("MENSAJEREGISTRO");
			String UsuarioConocido = (String) request.getAttribute("USUARIOCONOCIDO");
			if(texto != null){%>
			<span class="text-muted" ><%=texto%></span>
			<%}%>
			
			<div class="form-group">
			<input type="text" name="usuario" class="form-control" placeholder="Usuario">
			
			</div>
		<!-- contraseña -->
			<div class="form-group">
	    	<input type="password" name="password"  class="form-control" placeholder="Contraseña" aria-describedby="defaultRegisterFormPasswordHelpBlock">
	    	<small  class="form-text text-left text-muted mb-4">
	        	Colocar la contraseña
	    	</small>
			</div>
	    
		<div class="form-group">
		    <!-- nombres -->
	            <input type="text" name="nombre" class="form-control" placeholder="Nombres">
	    </div>
	    <div class="form-group">
	    	<!-- apellidos -->
	            <input type="text" name="apellido" class="form-control" placeholder="Apellidos">
		   
	    </div>
		
		<div class="custom-file mb-3">
			  <input type="file" name="imagen" class="custom-file-input" id="customFileLang" lang="es" >
			  <label class="custom-file-label" for="customFileLang">Seleccionar imagen </label>
		</div>
	    <div class="form-row mb-3">
	        <div class="col">
	        	<input type="number" name="edad" class="form-control" placeholder="Edad" min="18">
	            
	        </div>
	        <div class="col">
	         <input type="text" name="celular" class="form-control" placeholder="Numero de celular" aria-describedby="defaultRegisterFormPhoneHelpBlock">
	   
	           
	        </div>
	        	<input type="hidden" name="saldo" value="0">
	        
	    </div>
	

    <!-- Sign up button -->
    <button class="btn btn-info my-4 btn-block light-green darken-1" type="submit">Registrarse</button>

    <!-- Social register -->
    <p>buscanos en otras plataformas:</p>

    <a href="index.jsp" class="mx-2" role="button"><i class="fab fa-facebook-f light-blue-text"></i></a>
    <a href="#" class="mx-2" role="button"><i class="fab fa-twitter light-blue-text"></i></a>
    <a href="#" class="mx-2" role="button"><i class="fab fa-linkedin-in light-blue-text"></i></a>
    <a href="https://github.com/AEsirZeReF" class="mx-2" role="button"><i class="fab fa-github light-blue-text"></i></a>

    <hr>

    <!-- Terms of service -->
    <p>Al hacer click en
        <em>Registrarse</em> tu aceptas nuestros
        <a href="" target="_blank">términos de servicio</a>

</form>
<!-- Default form register -->
	</section>

</div>

<%@ include file="importacion_head.jsp" %>
</body>
</html>