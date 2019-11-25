<%@ include file="usuario_validacion.jsp" %>
<%@ include file="importacion_head.jsp" %>
<body>
    <!--Cabezera de Cliente -->
    <%@ include file= "usuario_header.jsp" %>
    <jsp:useBean id="CHEF" scope="session" class="Entidades.Chef"></jsp:useBean>
    
    <div class="container-fluid " style="margin-top:64.8px;">
        <div class="row	anchorow align-items-center">
            <div class="fondo-perfil-cliente1"></div>
            <div class="fondo-perfil-cliente2"></div>
            <div class="fondo-perfil-cliente3"></div>
            <div class="offset-md-1 col-md-3">
                <img alt="" src="img/avatar.jpg" width="300px" height="300px" class="rounded-circle float-right">
            </div>
            <div class="col-md-7">
                
                <c:choose>
                	<c:when test="${usuario == null }">
                		<h1>Colocar el nombre</h1>
                	</c:when>
                	<c:otherwise>
                		<h1><jsp:getProperty property="usuario" name="CHEF" /></h1>
                	</c:otherwise>
                </c:choose>
                    
                
                <h2><jsp:getProperty property="nom_chef" name="CHEF" /> 
                <jsp:getProperty property="ape_chef" name="CHEF" />(<jsp:getProperty property="edad" name="CHEF" />)</h2>
                <h4><jsp:getProperty property="dieccion" name="CHEF" /></h4>
                <h5><jsp:getProperty property="celular" name="CHEF" /></h5>
            </div>
        </div>
    </div>
    <!-- Cuerpo -->
    <div class="container mt-5">
        <div class="row">
            <div class="col-3 px-0">
                <div class="list-group" id="list-tab" role="tablist">
                    <a class="list-group-item list-group-item-action active" id="list-home-list" data-toggle="list"
                        href="#list-home" role="tab" aria-controls="home">Notificaciones</a>
                    <a class="list-group-item list-group-item-action" id="list-profile-list" data-toggle="list"
                        href="#list-profile" role="tab" aria-controls="profile">Servicios</a>
                </div>
            </div>
            <div class="col-9">
                <div class="tab-content" id="nav-tabContent">
                    <div class="tab-pane fade show active" id="list-home" role="tabpanel"
                        aria-labelledby="list-home-list">
                        <table id="tableProducto" class="table table-striped table-bordered" style="width:100%">
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
                    </div>
                    <div class="tab-pane fade" id="list-profile" role="tabpanel" aria-labelledby="list-profile-list">
                        Cupidatat quis ad sint excepteur laborum in esse qui. Et excepteur consectetur ex nisi eu do
                        cillum ad
                        laborum. Mollit et eu officia dolore sunt Lorem culpa qui commodo velit ex amet id ex. Officia
                        anim
                        incididunt laboris deserunt anim aute dolor incididunt veniam aute dolore do exercitation. Dolor
                        nisi
                        culpa ex ad irure in elit eu dolore. Ad laboris ipsum reprehenderit irure non commodo enim culpa
                        commodo veniam incididunt veniam ad.
                    </div>
                </div>
            </div>
        </div>
    </div>
    <hr>
    <div class="container">

    </div>

    <%@ include file="importacion_js.jsp" %>

</body>

</html>