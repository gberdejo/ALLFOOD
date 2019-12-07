<%@ include file="importacion_head.jsp" %>
<body>
	<%@ include file="usuario_header.jsp" %>
	<div class="container" style="margin-top:79px;">
		<div class="card">

    <h5 class="card-header info-color white-text text-center py-4">
        <strong>Editar Perfil</strong>
    </h5>

    <!--Card content-->
    <div class="card-body px-lg-5 pt-0">
        <!-- Form -->
        <form class="text-center" style="color: #757575;" action="ServletChef" method="POST" enctype="multipart/form-data">
        			<input type="hidden" name="tipo" value="actualizarChef">
					<input type="hidden" name="codigo" value="${USUARIOCHEF.cod_chef}">
					<input type="hidden" name="chef" value="${USUARIOCHEF.usuario}">
            <!-- Name -->
            <div class="md-form mt-3">
                <input type="text"  id="materialContactFormName" 
                		class="form-control" value="${USUARIOCHEF.usuario}" disabled>
                <label for="materialContactFormName">Usuario</label>
            </div>
            <div class="md-form">
                <input type="password" name="password" id="passwordChef" class="form-control" value="${USUARIOCHEF.password}">
                <label for="passwordChef">Contraseña</label>
            </div>
            <div class="md-form">
                <input type="text" name="nombre" id="nombreChef" class="form-control" value="${USUARIOCHEF.nom_chef}">
                <label for="nombreChef">Nombres</label>
            </div>
            <div class="md-form">
                <input type="text" name="apellido" id="apellidoChef" class="form-control" value="${USUARIOCHEF.ape_chef}">
                <label for="apellidoChef">Apellidos</label>
            </div>
			<div class="custom-file">
			  <input type="file" name="imagen" class="custom-file-input" id="customFileLang" lang="es" >
			  <label class="custom-file-label" for="customFileLang">Seleccionar nueva imagen de Perfil</label>
			</div>
			<div class="md-form">
                <input type="text"id="presentacionChef" name="presentacion" class="form-control" value="${USUARIOCHEF.presentacion}">
                <label for="presentacionChef">Presentación</label>
            </div>
			<div class="md-form">
                <input type="text"id="edadChef" class="form-control" value="${USUARIOCHEF.edad} años" disabled>
                <label for="edadChef">Edad</label>
            </div>
            <div class="md-form">
                <input type="text" name="celular" id="celularChef" class="form-control"  value="${USUARIOCHEF.celular}">
                <label for="celularChef">Numero de Celular</label>
            </div>
             <div class="md-form">
                <input type="text" name="direccion" id="Direccion" class="form-control" value="${USUARIOCHEF.dieccion}">
                <label for="Direccion">Dirección</label>
            </div>

            <button class="btn btn-outline-info btn-rounded z-depth-0 my-4 waves-effect" type="submit">Guardar</button>
	         <a class="btn btn-outline-info btn-rounded z-depth-0 my-4 waves-effect" href="chef_pagina.jsp">Cancelar</a>
	
        </form>
        <!-- Form -->

    </div>

</div>
	</div>
	<%@ include file="importacion_js.jsp" %>
</body>
</html>