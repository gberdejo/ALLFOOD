<%@ include file="usuario_validacion.jsp" %>
<%@ include file="importacion_head.jsp" %>

<body>
        <!-- cuerpo -->
 <%@include file="usuario_header.jsp" %>
        <div class="container-fluid" style="margin-top:79px;">
        <div class="row">
        	<div class="col-md-9">
        		<div class="row">
                <div class="col-2 px-0">
                    <div class="list-group" id="list-tab" role="tablist">
                        <a class="list-group-item list-group-item-action active" id="list-home-list" data-toggle="list"
                            href="#list-home" role="tab" aria-controls="home">Home</a>
                        <a class="list-group-item list-group-item-action" id="list-profile-list" data-toggle="list"
                            href="#list-profile" role="tab" aria-controls="profile">Servicios</a>
                        <a class="list-group-item list-group-item-action" id="list-messages-list" data-toggle="list"
                            href="#list-messages" role="tab" aria-controls="messages">Chefs</a>
                        <a class="list-group-item list-group-item-action" id="list-settings-list" data-toggle="list"
                            href="#list-settings" role="tab" aria-controls="settings">Pedidos</a>
                    </div>
                </div>
                <div class="col-10">
                    <div class="tab-content" id="nav-tabContent">
                        <div class="tab-pane fade show active" id="list-home" role="tabpanel" aria-labelledby="list-home-list">
                            <h2>Ultimos Servicios Publicados</h2>
                            <div class="row">
                            	<c:forEach items="${LISTASERVICIO}" var="s">
                                        <div class="col-md-4 mb-5">
                                            <!-- Card -->
                                            <div class="card">

                                                <!-- Card image -->
                                                <div class="view overlay">
                                                    <img class="card-img-top"
                                                        src="ServletChef?tipo=imagenServicio&servicio=${s.nom_servicio}"
                                                        alt="Card image cap" >
                                                    <a href="ServletCliente?tipo=irpedido&codigo=${s.cod_servicio}">
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
                            <h2>Ultimos CHEFS Registrados</h2>
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
                                                    <h4 class="card-title"><i class="fab fa-free-code-camp"></i> ${x.usuario}</h4>
                                                    <h5 class="card-subtitle">${x.nom_chef} ${x.ape_chef}(${x.edad})</h5>
                                                    <p class="card-text"><i class="fas fa-quote-left"></i>${x.presentacion}</p>
                                                </div>
                                            </div>
                                            <!-- Card -->
                                        </div>
                                    </c:forEach>
                            </div>
                            <hr>

                        </div>
                        <div class="tab-pane fade" id="list-profile" role="tabpanel" aria-labelledby="list-profile-list">
                            <h2 class="h1">Listado de Servicios</h2>
                             <div class="row">
                            	<c:forEach items="${LISTASERVICIO}" var="s">
                                        <div class="col-md-4 mb-5">
                                            <!-- Card -->
                                            <div class="card">

                                                <!-- Card image -->
                                                <div class="view overlay">
                                                    <img class="card-img-top"
                                                        src="ServletChef?tipo=imagenServicio&servicio=${s.nom_servicio}"
                                                        alt="Card image cap" >
                                                    <a href="ServletCliente?tipo=irpedido&codigo=${s.cod_servicio}">
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
                        </div>
                        <div class="tab-pane fade" id="list-messages" role="tabpanel" aria-labelledby="list-messages-list">
                             <h2>Todos los mejores Chefs en un solo lugar<h2>
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
                                                    <h4 class="card-title"><i class="fab fa-free-code-camp"></i> ${x.usuario}</h4>
                                                    <h5 class="card-subtitle">${x.nom_chef} ${x.ape_chef}(${x.edad})</h5>
                                                    <p class="card-text"><i class="fas fa-quote-left"></i>${x.presentacion}</p>
                                                </div>
                                            </div>
                                            <!-- Card -->
                                        </div>
                                    </c:forEach>
                            </div>
                        </div>
                        <div class="tab-pane fade" id="list-settings" role="tabpanel" aria-labelledby="list-settings-list">
                           <div class="table-responsive">
                          <table id="tableProducto" class="table table-striped table-bordered" style="width:100%">
                            <thead>
                                <th>Codigo Pedido</th>
                                <th>Nombre Cliente</th>
                                <th>Nombre Chef</th>
                                <th>Nombre de servicio</th>
                                <th>Cantidad de personas</th>
                                <th>Fecha de compra</th>
                                <th>Fecha de entrega</th>
                                <th>Fecha de Publicación</th>
                                
                            </thead>
                            <tbody>
                            <c:forEach items="${LISTASERVICIOCHEF}" var="c">
                            	<tr>
                                    <td>${c.cod_servicio}</td>
                                    <td>${c.nom_servico}</td>
                                    <td>${c.platillos}</td>
                                    <td>${c.descripcion}</td>
                                    <td>${c.precio_persona}</td>
                                    <td>${c.fec_publicacion}</td>
                                </tr>
                            </c:forEach>
                                
                                
                            </tbody>

                        </table>
                        </div>
                        </div>
                    </div>
                </div>
            </div>
        	</div>
        	<div class="col-md-3 px-0">
        		 <!--Accordion wrapper-->
               <%@ include file="columna.jsp" %>
                <!-- Accordion wrapper -->
        	</div>
        </div>
            

        </div>
<%@ include file="importacion_js.jsp" %>
</body>

</html>