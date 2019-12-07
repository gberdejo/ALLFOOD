<%@ include file="importacion_head.jsp" %>
<body>
    <%@ include file="usuario_header.jsp" %>
    <jsp:useBean id="SERVICIO" scope="session" class="Entidades.Servicio"></jsp:useBean>
    <div class="container" style="margin-top:79px;">
    	<div class="card">
        <h5 class="card-header info-color white-text text-center py-4">
            <strong>Editar Perfil</strong>
        </h5>
        <!--Card content-->
        <div class="card-body px-lg-5 pt-0">
            <!-- Form -->
            <form class="text-center" style="color: #757575;" action="ServletChef" method="POST"
                enctype="multipart/form-data">
                <input type="hidden" name="tipo" value="EditarServicio">
                <input type="hidden" name="codigo" value="${SERVICIO.cod_servicio}">
                <input type="hidden" name="chef" value="${USUARIOCHEF.usuario}">
                <!-- Name -->
                <div class="md-form mt-3">
                    <input type="text" name="nombre" id="nombreServicio" class="form-control" value="${SERVICIO.nom_servicio}" >
                    <label for="nombreServicio">Nombre del Servicio</label>
                </div>
                <div class="md-form mt-3">
                    <input type="text" id="chef" class="form-control" value="${SERVICIO.nombre_chef}" disabled>
                    <label for="chef">Usuario Propietario</label>
                </div>
                <div class="md-form mt-3">
                    <input type="text" name="platos" id="platillos" class="form-control" value="${SERVICIO.platillos}" >
                    <label for="platillos">Platillos del Servicio</label>
                </div>
                <div class="md-form mt-3">
                    <input type="text" name="descrip" id="descripcion" class="form-control" value="${SERVICIO.descripcion}" >
                    <label for="descripcion">Descripción del Servicio</label>
                </div>
                <div class="custom-file">
                    <input type="file" name="imagen" class="custom-file-input" id="customFileLang" lang="es">
                    <label class="custom-file-label" for="customFileLang">Seleccionar una nueva imagen de Servicio</label>
                </div>
                <div class="md-form mt-3">
                    <input type="number" name="precio" id="precio" class="form-control" value="${SERVICIO.precio_persona}" >
                    <label for="precio">Precio del Servicio</label>
                </div>
                <div class="md-form mt-3">
                    <input type="text" id="fechaPublicacion" class="form-control" value="${SERVICIO.fec_publicacion}" disabled>
                    <label for="fechaPublicacion">Publicación del Servicio</label>
                </div>

                <button class="btn btn-outline-info btn-rounded z-depth-0 my-4 waves-effect"
                    type="submit">Guardar</button>
                <a class="btn btn-outline-info btn-rounded z-depth-0 my-4 waves-effect"
                    href="chef_pagina.jsp">Cancelar</a>

            </form>
            <!-- Form -->
        </div>
    </div>
    </div>
    <%@ include file="importacion_js.jsp" %>
</body>
</html>