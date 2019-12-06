<%@ include file="chef_validacion.jsp" %>
<%@ include file="importacion_head.jsp" %>
<body>
    <!--Navbar -->
    <%@ include file="usuario_header.jsp" %>
    <!--/.Navbar -->

    <div class="container-fluid" style="margin-top:79px;">
        <div class="row">
            <div class="col-md-10">
                <div class="row">
                    <div class="col-2 px-0">
                        <div class="list-group" id="list-tab" role="tablist">
                            <a class="list-group-item list-group-item-action active" id="list-home-list"
                                data-toggle="list" href="#list-home" role="tab" aria-controls="home">Home</a>
                            <a class="list-group-item list-group-item-action" id="list-profile-list" data-toggle="list"
                                href="#list-profile" role="tab" aria-controls="profile">Servicio</a>
                            <a class="list-group-item list-group-item-action" id="list-messages-list" data-toggle="list"
                                href="#list-messages" role="tab" aria-controls="messages">Messages</a>
                         
                        </div>
                    </div>
                    <div class="col-10">
                        <div class="tab-content" id="nav-tabContent">
                            <div class="tab-pane fade show active" id="list-home" role="tabpanel"
                                aria-labelledby="list-home-list">
                                <h2>Ultimos Servicios</h2>
                                <div class="row">
                                    <c:forEach items="${LISTASERVICIO}" var="s">
                                        <div class="col-md-4 mb-5">
                                            <!-- Card -->
                                            <div class="card">
                                                <div class="view overlay">
                                                    <img class="card-img-top"
                                                        src="ServletChef?tipo=imagenServicio&servicio=${s.nom_servicio}"
                                                        alt="Card image cap">
                                                    <a>
                                                        <div class="mask rgba-white-slight"></div>
                                                    </a>
                                                </div>
                                                <div class="card-body">
                                                    <h4 class="card-title">${s.nom_servicio}</h4>
                                                    <hr>
                                                    <h5 class="card-subtitle"><i class="fab fa-free-code-camp"></i>
                                                        ${s.nombre_chef}</h5>
                                                    <span>${s.platillos}</span>
                                                    <p class="card-text">${s.descripcion}</p>
                                                </div>
                                            </div>
                                            <!-- Card -->
                                        </div>
                                    </c:forEach>
                                </div>
                                <h2>Ultimos Chef Registrados</h2>
                                <div class="row">
                                    <c:forEach items="${LISTACHEF}" var="x">
                                        <div class="col-md-4 mb-5">
                                            <!-- Card -->
                                            <div class="card">
                                                <div class="view overlay">
                                                    <img class="card-img-top"
                                                        src="ServletChef?tipo=imagen&usuario=${x.usuario}"
                                                        alt="Card image cap">
                                                    <a href="ServletChef?tipo=perfil&chef=${x.usuario}">
                                                        <div class="mask rgba-white-slight"></div>
                                                    </a>
                                                </div>
                                                <div class="card-body">
                                                    <h4 class="card-title">${x.usuario}</h4>
                                                    <h5 class="card-subtitle"><i class="fab fa-free-code-camp"></i>
                                                        ${x.nom_chef} ${x.ape_chef}(${x.edad})</h5>
                                                    <p class="card-text"><i class="fas fa-quote-left"></i>${x.presentacion}</p>
                                                </div>
                                            </div>
                                            <!-- Card -->
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>
                            <div class="tab-pane fade" id="list-profile" role="tabpanel"
                                aria-labelledby="list-profile-list">
                                <!-- Inicio -->
                              
                             <h2 class="text-center text-primary">Mis Servicios</h2>
                              <h4>Publicar un nuevo servicio: <a href="servicio.jsp" class="btn btn-outline-success waves-effect">New</a></h4>
                              <hr>
                              <h4 class="mt-md-3">Lista de mis Servicios:</h4>
                               <table id="tableProducto" class="table table-striped table-bordered table-responsive" style="width:100%">
                            <thead>
                                <th>Nombre de Servicio</th>
                                <th>Platillos Ofrecidos</th>
                                <th>Descripción del Servicio</th>
                                <th>Precio por Persona</th>
                                <th>Fecha de Publicación</th>
                                <th>Eliminar Servicio</th>
                                <th>Editar Servicio</th>
                                
                            </thead>
                            <tbody>
                            <c:forEach items="${LISTASERVICIOCHEF}" var="c">
                            	<tr>
                                    <td>${c.nom_servicio}</td>
                                    <td>${c.platillos}</td>
                                    <td>${c.descripcion}</td>
                                    <td>${c.precio_persona}</td>
                                    <td>${c.fec_publicacion}</td>
                                    <td><a href="ServletChef?tipo=eliminarServicio&codigo=${c.cod_servicio}" class="btn btn-outline-danger btn-sm btn-block waves-effect"><i class="fas fa-trash-alt fa-2x"></i></a></td>
                                    <td><a href="ServletChef?tipo=irEditarServicio&codigo=${c.cod_servicio}" class="btn btn-outline-info btn-sm btn-block waves-effect"><i class="fas fa-edit fa-2x"></i></a></td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>

                                <!-- fin -->
                            </div>
                            <div class="tab-pane fade" id="list-messages" role="tabpanel"
                                aria-labelledby="list-messages-list">
                                Ut ut do pariatur aliquip aliqua aliquip exercitation do nostrud commodo reprehenderit
                                aute ipsum
                                voluptate. Irure Lorem et laboris nostrud amet cupidatat cupidatat anim do ut velit
                                mollit consequat
                                enim tempor. Consectetur est minim nostrud nostrud consectetur irure labore voluptate
                                irure. Ipsum id
                                Lorem sit sint voluptate est pariatur eu ad cupidatat et deserunt culpa sit eiusmod
                                deserunt.
                                Consectetur et fugiat anim do eiusmod aliquip nulla laborum elit adipisicing pariatur
                                cillum.
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-2 px-0">
                <!--Accordion wrapper-->
               <%@ include file="columna.jsp" %>
                <!-- Accordion wrapper -->
            </div>
        </div>
    </div>
    <%@ include file="importacion_js.jsp" %>
    <script>
    
    	/*$(document).ready(function(){
    		('#formularioServicio').click(function(){
    			(this).preventDefault();
    		},false);
    		$('#formularioServicio').click(function(){
    		var textarea = $('#descripcion').val();
    		alert(textarea);
    		});
    	});
    	*/
    </script>
</body>

</html>