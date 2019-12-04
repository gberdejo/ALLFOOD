<%@ include file="chef_validacion.jsp" %>
<%@ include file="importacion_head.jsp" %>
<body>
    <!--Navbar -->
    <%@ include file="usuario_header.jsp" %>
    <!--/.Navbar -->

    <div class="container-fluid" style="margin-top:79px;">
        <div class="row">
            <div class="col-md-9">
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

                                                <!-- Card image -->
                                                <div class="view overlay">
                                                    <img class="card-img-top"
                                                        src="ServletChef?tipo=imagenServicio&servicio=${s.nom_servico}"
                                                        alt="Card image cap">
                                                    <a>
                                                        <div class="mask rgba-white-slight"></div>
                                                    </a>
                                                </div>
                                                <!-- Card content -->
                                                <div class="card-body">

                                                    <!-- Title -->
                                                    <h4 class="card-title">${s.nom_servico}</h4>
                                                    <hr>
                                                    <h5 class="card-subtitle"><i class="fab fa-free-code-camp"></i>
                                                        ${s.nombre_chef}</h5>
                                                    <!-- <i class="fas fa-utensils"></i>,<i class="fas fa-pepper-hot"></i> -->
                                                    <!-- Text -->
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
                                            <div class="card">
                                                <!-- Card <img src="servletperfil?accion=Imagen&codigo=${dato.codigo}" width="250px" height="250px"> image -->
                                                <div class="view overlay">
                                                    <img src="ServletChef?tipo=imagen&usuario=${x.usuario}"
                                                        height="300px">
                                                    <a href="#!">
                                                        <div class="mask rgba-white-slight"></div>
                                                    </a>
                                                </div>
                                                <div class="card-body">
                                                    <h4 class=S"card-title">${x.usuario}</h4>
                                                    <h5 class="card-subtitle">${x.nom_chef} ${x.ape_chef}(${x.edad})
                                                        </h3>
                                                        <p class="card-text">Some quick example text to build on the
                                                            card
                                                            title and make up the bulk of the card's content.</p>
                                                        <a href="ServletChef?tipo=perfil&chef=${x.usuario}">Conócelo</a>
                                                </div>
                                            </div>
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>
                            <div class="tab-pane fade" id="list-profile" role="tabpanel"
                                aria-labelledby="list-profile-list">
                                <!-- Inicio -->
                              
                             <h2 class="text-center text-primary">Mis Servicios</h2>
                             <h4>Publicar un nuevo servicio: <a href="servicio.jsp" class="btn btn-outline-default waves-effect">New</a></h4>
                              <hr>
                              <h4 class="mt-md-3">Lista de mis Servicios:</h4>
                               <table id="tableProducto" class="table table-striped table-bordered " style="width:100%">
                            <thead>
                                <th>Codigo de Servicio</th>
                                <th>Nombre de Servicio</th>
                                <th>Platillos</th>
                                <th>Descripcion</th>
                                <th>Precio por Persona</th>
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
            <div class="col-md-3 px-0">
                <!--Accordion wrapper-->
                <div class="accordion md-accordion" id="accordionEx" role="tablist" aria-multiselectable="true">

                    <!-- Accordion card -->
                    <div class="card">

                        <!-- Card header -->
                        <div class="card-header" role="tab" id="headingOne1">
                            <a data-toggle="collapse" data-parent="#accordionEx" href="#collapseOne1"
                                aria-expanded="true" aria-controls="collapseOne1">
                                <h5 class="mb-0">
                                    Top 5 de CHEFS <i class="fas fa-angle-down rotate-icon"></i>
                                </h5>
                            </a>
                        </div>

                        <!-- Card body -->
                        <div id="collapseOne1" class="collapse show" role="tabpanel" aria-labelledby="headingOne1"
                            data-parent="#accordionEx">
                            <div class="card-body">
                                <div class="row">
                                    <c:forEach items="${LISTACHEF}" var="che">
                                        <div class="col-md-12 mb-3">
                                            <!-- Card -->
                                            <div class="card">
                                                <!-- Card image -->
                                                <div class="view overlay">

                                                    <img class="card-img-top"
                                                        src="ServletChef?tipo=imagen&usuario=${che.usuario}"
                                                        alt="Card image cap">
                                                    <a href="index.jsp">
                                                        <div class="mask rgba-white-slight"></div>
                                                    </a>
                                                </div>
                                                <div class="card-body p-2">
                                                    <!-- Name -->
                                                    <h4 class="card-title">${che.usuario}</h4>
                                                    <hr>
                                                    <!-- Quotation -->
                                                    <span><i class="fas fa-quote-left"></i>${che.presentacion}</span>
                                                </div>
                                            </div>
                                            <!-- Card -->
                                        </div>
                                    </c:forEach>

                                </div>
                            </div>
                        </div>

                    </div>
                    <!-- Accordion card -->

                    <!-- Accordion card -->
                    <div class="card">

                        <!-- Card header -->
                        <div class="card-header" role="tab" id="headingTwo2">
                            <a class="collapsed" data-toggle="collapse" data-parent="#accordionEx" href="#collapseTwo2"
                                aria-expanded="false" aria-controls="collapseTwo2">
                                <h5 class="mb-0">
                                    Collapsible Group Item #2 <i class="fas fa-angle-down rotate-icon"></i>
                                </h5>
                            </a>
                        </div>

                        <!-- Card body -->
                        <div id="collapseTwo2" class="collapse" role="tabpanel" aria-labelledby="headingTwo2"
                            data-parent="#accordionEx">
                            <div class="card-body">

                            </div>
                        </div>

                    </div>
                    <!-- Accordion card -->

                    <!-- Accordion card -->
                    <div class="card">

                        <!-- Card header -->
                        <div class="card-header" role="tab" id="headingThree3">
                            <a class="collapsed" data-toggle="collapse" data-parent="#accordionEx"
                                href="#collapseThree3" aria-expanded="false" aria-controls="collapseThree3">
                                <h5 class="mb-0">
                                    Collapsible Group Item #3 <i class="fas fa-angle-down rotate-icon"></i>
                                </h5>
                            </a>
                        </div>

                        <!-- Card body -->
                        <div id="collapseThree3" class="collapse" role="tabpanel" aria-labelledby="headingThree3"
                            data-parent="#accordionEx">
                            <div class="card-body">
                                Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad
                                squid. 3
                                wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa
                                nesciunt laborum
                                eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin
                                coffee nulla
                                assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson
                                cred
                                nesciunt sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat
                                craft beer
                                farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them
                                accusamus
                                labore sustainable VHS.
                            </div>
                        </div>

                    </div>
                    <!-- Accordion card -->

                </div>
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