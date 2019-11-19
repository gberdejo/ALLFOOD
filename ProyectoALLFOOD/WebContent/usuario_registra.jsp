<%@ include file="importacion_head.jsp" %>
<body>
<div class="container">	
	<section>
		<!-- Default form register -->
<form class="text-center border border-light p-5" action="ServletCliente">
<input type="hidden" name="tipo" value="registro" >
    <p class="h4 mb-4">Registro</p>
	<!-- User and password -->
		<!-- user -->
		<% String texto =(String) request.getAttribute("MENSAJE"); %>
			<span class="text-muted" ><%=texto %></span>
			<div class="form-group">
			<input type="text" name="usuario" class="form-control" placeholder="Usuario">
			
			</div>
		<!-- Password -->
			<div class="form-group">
	    	<input type="password" name="password"  class="form-control" placeholder="Contraseña" aria-describedby="defaultRegisterFormPasswordHelpBlock">
	    	<small  class="form-text text-left text-muted mb-4">
	        	Colocar la contraseña
	    	</small>
			</div>
	    
		<div class="form-group">
		    <!-- First name -->
	            <input type="text" name="nombre" class="form-control" placeholder="Nombres">
	    </div>
	    <div class="form-group">
	    	<!-- Last name -->
	            <input type="text" name="apellido" class="form-control" placeholder="Apellidos">
		   
	    </div>
		
	    <div class="form-row mb-3">
	        <div class="col">
	        	<input type="number" name="edad" class="form-control" placeholder="Edad" min="18">
	            
	        </div>
	        <div class="col">
	         <input type="text" name="celular" class="form-control" placeholder="Numero de celular" aria-describedby="defaultRegisterFormPhoneHelpBlock">
	   
	           
	        </div>
	        <div class="col">
	        	<input type="number" name="saldo" placeholder="colocar saldo" class="form-control">
	        </div>
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