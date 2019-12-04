<%@ include file="importacion_head.jsp" %>
<body>
<h1>Es ta la pagina  del servicio</h1>
	<%@ include file="usuario_header.jsp" %>
	       <!-- Registrar Servicio -->
<div class="row justify-content-center">
    <div class="col-md-8">

        <!-- Material form register -->
        <div class="card">

            <h5 class="card-header info-color white-text text-center py-4">
                <strong>Crear un nuevo Servicio</strong>
            </h5>

            <!--Card content-->
            <div class="card-body px-lg-5 pt-0">

                <!-- Form -->
                <form class="text-center" id="formularioServicio" style="color: #757575;" action="ServletChef"
                    method="POST" enctype="multipart/form-data">
                    <input type="hidden" name="tipo" value="registraServicio">
                    <input type="hidden" name="codigoChef" value="${USUARIOCHEF.cod_chef}">
                    <input type="hidden" name="usuariochef" value="${USUARIOCHEF.usuario}">
                    <div class="md-form">
                        <input type="text" id="NombreServicio" name="nombreser" class="form-control"
                            aria-describedby="materialRegisterFormPhoneHelpBlock">
                        <label for="NombreServicio">Nombre del Servicio</label>
                        <small id="NombreServicio" class="form-text text-muted mb-4">
                            Colocar un nombre muy atractivo para los clientes
                        </small>
                    </div>
                    <div class="md-form">
                        <input type="text" id="PlatillosServicio" class="form-control" name="platillos"
                            aria-describedby="materialRegisterFormPhoneHelpBlock">
                        <label for="PlatillosServicio">Platillos del Servicio</label>
                        <small id="PlatillosServicio" class="form-text text-muted mb-4">
                            Colocar un nombre muy atractivo para los clientes
                        </small>
                    </div>

                    <div class="md-form">
                        <input id="form7" rows="3" type="text" name="descripcionser" class="md-textarea form-control">
                        <label for="form7">Descripción del Servicio</label>
                    </div>

                    <!-- E-mail -->
                    <div class="input-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text" id="inputGroupFileAddon01">Cargar</span>
                        </div>
                        <div class="custom-file">
                            <input type="file" class="custom-file-input" name="imagenser" id="inputGroupFile01"
                                aria-describedby="inputGroupFileAddon01">
                            <label class="custom-file-label" for="inputGroupFile01">Imagen</label>
                        </div>
                    </div>

                    <!-- Password -->
                    <div class="md-form">
                        <input type="number" id="numberExample" name="precioser" class="form-control">
                        <label for="numberExample">Precio por persona</label>
                    </div>
                    <!-- Terms of service -->
                    <button class="btn aqua-gradient" type="submit">Guardar</button>

                </form>
                <!-- Form -->

            </div>

        </div>
    </div>
</div>
<%@ include file="importacion_js.jsp" %>
</body>
</html>