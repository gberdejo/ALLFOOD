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
                                href="#list-profile" role="tab" aria-controls="profile">Mis Servicios</a>
                            <a class="list-group-item list-group-item-action" id="list-messages-list" data-toggle="list"
                                href="#list-messages" role="tab" aria-controls="messages">Mis Pedidos</a>
                         
                        </div>
                    </div>
                    <div class="col-10">
                        <div class="tab-content" id="nav-tabContent">
                            <div class="tab-pane fade show active" id="list-home" role="tabpanel" aria-labelledby="list-home-list">
                                <h2>Ultimos Servicios Publicados</h2>
                            <div class="row">
                            	<c:forEach items="${LISTASERVICIOULTIMOS}" var="s">
                                        <div class="col-md-4 mb-5">
                                            <!-- Card -->
                                            <div class="card">

                                                <!-- Card image -->
                                                <div class="view overlay">
                                                    <img class="card-img-top"
                                                        src="ServletChef?tipo=imagenServicio&servicio=${s.nom_servicio}"
                                                        alt="Card image cap" >
                                                    <a >
                                                        <div class="mask rgba-white-slight"></div>
                                                    </a>
                                                </div>
                                                <!-- Card content -->
                                                <div class="card-body">

                                                    <!-- Title -->
                                                    <h4 class="card-title"><i class="fas fa-drumstick-bite"></i> ${s.nom_servicio}</h4>
                                                    <h5 class="card-subtitle"><i class="fab fa-free-code-camp"></i> ${s.nombre_chef}</h5>
                                                    <span>Platillo: ${s.platillos}</span>
                                                    <p class="card-text">Descripción: ${s.descripcion}</p>
                                                </div>
                                            </div>
                                            <!-- Card -->
                                        </div>
                                    </c:forEach>
                            </div>
                            <hr>
                            <h2>Ultimos CHEFS Registrados</h2>
                            <div class="row">
                                <c:forEach items="${LISTACHEFULTIMOS}" var="x">
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
                                                    <h4 class="card-title"><i class="fab fa-free-code-camp"></i> ${x.usuario}</h4>
                                                    <h5 class="card-subtitle">${x.nom_chef} ${x.ape_chef}(${x.edad})</h5>
                                                    <p class="card-text"><i class="fas fa-quote-left"></i>${x.presentacion}</p>
                                                     <p class="card-text">${x.dieccion}</p>
                                                     <p class="card-text">${x.celular}</p>
                                                    <a class="btn btn-outline-info btn-rounded btn-sm z-depth-0 float-right waves-effect" href="ServletChef?tipo=perfil&chef=${x.usuario}">Conócelo</a>
                                                </div>
                                            </div>
                                            <!-- Card -->
                                        </div>
                                    </c:forEach>
                            </div>
                            <hr>
                            <h2>Ultimos Clientes Registrados</h2>
                            <div class="row">
                                <c:forEach items="${LISTACLIENTE}" var="x">
                                        <div class="col-md-4 mb-5">
                                            <!-- Card -->
                                            <div class="card">
                                                <div class="view overlay">
                                                    <img class="card-img-top"
                                                        src="ServletCliente?tipo=imagen&usuario=${x.usuario}"
                                                        alt="Card image cap">
                                                    <a href="ServletChef?tipo=perfil&chef=${x}">
                                                        <div class="mask rgba-white-slight"></div>
                                                    </a>
                                                </div>
                                                <div class="card-body">
                                                    <h4 class="card-title"><i class="fas fa-utensils"></i></i> ${x.usuario}</h4>
                                                    <h5 class="card-subtitle">${x.nom_cli} ${x.ape_cli} (${x.edad})</h5>
                                                    <p class="card-text">${x.celular_cli}</p>
                                                    <a class="btn btn-outline-info btn-rounded btn-sm z-depth-0 float-right waves-effect" href="ServletCliente?tipo=perfil&usuario=${x.usuario}">Conócelo</a>
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
                            <div class="tab-pane fade" id="list-messages" role="tabpanel" aria-labelledby="list-messages-list">
                                <h2>Lista de Pedidos</h2>
                                
                          <table id="tablaPedido" class="table table-striped table-bordered table-responsive"  style="width:100%">
                            <thead>
                                <th>Codigo de Servicio</th>
                                <th>Nombre de Servicio</th>
                                <th>Usuario Chef</th>
                                <th>Nombres y Apellidos de Cliente</th>
                                <th>Precio por Persona</th>
                                <th>Cantidad de Personas</th>
                                <th>Pago Total</th>
                                <th>Fecha de Compra</th>
                                <th>Fecha de Entrega</th>
                                 <th>Dirección de Entrega</th>
                                
                            </thead>
                            <tbody>
                            <c:forEach items="${LISTAPEDIDOSCHEF}" var="c">
                            	<tr>
                                    <td>${c.codigo_servicio}</td>
                                    <td>${c.nombre_servicio}</td>
                                    <td>${c.usuario_chef}</td>
                                    <td>${c.nombre_cliente} ${c.apellido_cliente}</td>
                                    <td>${c.precio_persona}</td>
                                    <td>${c.cantidad_personas}</td>
                                    <td>${c.pago_total}</td>
                                    <td>${c.fecha_compra}</td>
                                    <td>${c.fecha_entrega}</td>
                                    <td>${c.direccion_entrega}</td>
                                </tr>
                            </c:forEach>
                                
                                
                            </tbody>

                        </table>
                        
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-2 px-0">
               <%@ include file="columna.jsp" %>
            </div> 
        </div>
    </div>
    <%@ include file="importacion_js.jsp" %>
    <script>
$(document).ready(function(){
	$('#tablaPedido').DataTable();
})
</script>
</body>

</html>