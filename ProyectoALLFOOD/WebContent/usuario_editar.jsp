<%@ include file="importacion_head.jsp" %>
<body>
<%@ include file="usuario_header.jsp"%>
<div class="container" style="margin-top:79px;">
	<!-- Material form contact -->
<div class="card">

    <h5 class="card-header info-color white-text text-center py-4">
        <strong>Editar Perfil</strong>
    </h5>

    <!--Card content-->
    <div class="card-body px-lg-5 pt-0">

        <!-- Form -->
        <form class="text-center" style="color: #757575;" action="ServletCliente" method="POST" enctype="multipart/form-data">
        			<input type="hidden" name="tipo" value="actualizarCliente">
					<input type="hidden" name="codigo" value="${USUARIOCLIENTE.cod_cli}">
					<input type="hidden" name="usuario" value="${USUARIOCLIENTE.usuario}">
            <!-- Name -->
            <div class="md-form mt-3">
                <input type="text" id="materialContactFormName" 
                		class="form-control" value="${USUARIOCLIENTE.usuario}" disabled>
                <label for="materialContactFormName">Usuario</label>
            </div>
            <div class="md-form">
                <input type="password" name="password" id="passwordCliente" value="${USUARIOCLIENTE.password}" class="form-control">
                <label for="passwordCliente">Contraseña</label>
            </div>
            <div class="md-form">
                <input type="text" name="nombre" id="nombreCliente" value="${USUARIOCLIENTE.nom_cli}" class="form-control">
                <label for="nombreCliente">Nombres</label>
            </div>
            <div class="md-form">
                <input type="text" name="apellido" id="apellidoCliente" value="${USUARIOCLIENTE.ape_cli}" class="form-control">
                <label for="apellidoCliente">Apellidos</label>
            </div>
			<div class="custom-file">
			  <input type="file" name="imagen" class="custom-file-input" id="customFileLang" lang="es">
			  <label class="custom-file-label" for="customFileLang">Seleccionar nueva imagen de Perfil</label>
			</div>
			<div class="md-form">
                <input type="text"id="edadCliente" class="form-control" value="${USUARIOCLIENTE.edad}" disabled>
                <label for="edadCliente">Edad</label>
            </div>
            <div class="md-form">
                <input type="text" name="celular" id="celularCliente" value="${USUARIOCLIENTE.celular_cli}" class="form-control" >
                <label for="celularCliente">Celular</label>
            </div>

            <button class="btn btn-outline-info btn-rounded z-depth-0 my-4 waves-effect" type="submit">Guardar</button>
	         <a class="btn btn-outline-info btn-rounded z-depth-0 my-4 waves-effect" href="usuario_pagina.jsp">Cancelar</a>
	
        </form>
        <!-- Form -->

    </div>

</div>
<!-- Material form contact -->
</div>
<%@ include file="importacion_js.jsp" %>
</body>
</html>