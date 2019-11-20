<%@ include file="importacion_head.jsp" %>
<body>
<div class="container">
<form class="text-center border border-light p-5" action="ServletChef">
<input type="hidden" name="tipo" value="registro" >
    <p class="h4 mb-4">Registro de Chef</p>
	<!-- User and password -->
		<!-- usuario -->
		<% String texto =(String) request.getAttribute("MENSAJEREGISTRO");
			if(texto != null){
			%>
			<span class="text-muted" ><%=texto %></span>
			<% }%>
			<div class="form-group">
			<input type="text" name="usuario" class="form-control" placeholder="Usuario">
			</div>
		<!-- contraseña -->
			<div class="form-group mb-5">
	    	<input type="password" name="password"  class="form-control" placeholder="Contraseña" aria-describedby="defaultRegisterFormPasswordHelpBlock">
	    	<small  class="form-text text-left text-muted "></small>
			</div>
	    
		<div class="form-group">
		    <!-- nombres -->
	            <input type="text" name="nombre" class="form-control" placeholder="Nombres">
	    </div>
	    <div class="form-group">
	    	<!-- apellidos -->
	            <input type="text" name="apellido" class="form-control" placeholder="Apellidos">
		   
	    </div>
		
	    <div class="form-row mb-3">
	        <div class="col">
	        	<input type="number" name="edad" class="form-control" placeholder="Edad" min="18">
	            
	        </div>
	        <div class="col">
	         <input type="text" name="celular" class="form-control" placeholder="Numero de celular" aria-describedby="defaultRegisterFormPhoneHelpBlock">
	   
	           
	        </div>
	    </div>
	    <div class="form-group">
	        	<input type="text" name="direccion" placeholder="Dirección" class="form-control">
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
        <a class="text-primary" target="_blank">términos de servicio</a>

</form>
</div>


<%@ include file="importacion_js.jsp" %>
</body>
</html>