<%@ include file="usuario_validacion.jsp" %>
<%@ include file="importacion_head.jsp" %>
<body>
	
    <!--Cabezera de Cliente -->
   <%@include file="usuario_header.jsp" %>
  
   <div class="container-fluid " style="margin-top:79px;">
        <div class="row	anchorow align-items-center">
            <div class="fondo-perfil-cliente1"></div>
            <div class="offset-md-1 col-md-4">
                <img alt="Aquí se supone que va la imagen del usuario" 
                src="ServletCliente?tipo=imagen&usuario=${USUARIOCLIENTE.usuario}"  class="img-fluid z-depth-3 img-thumbnail">
            </div>
            <div class="col-md-6">
            
                <h1><i class="fab fa-free-code-camp"></i> ${USUARIOCLIENTE.usuario}</h1>
                <h2>${USUARIOCLIENTE.nom_cli} ${USUARIOCLIENTE.ape_cli} (${USUARIOCLIENTE.edad})</h2>
            </div>
        </div>
        <!--  -->
    </div>
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
                            <c:forEach items="${x}" var="c">
                            	<tr>
                                    <td>${x}</td>
                                    <td>${x}</td>
                                    <td>${x}</td>
                                    <td>${x}</td>
                                    <td>${x}</td>
                                    <td>${x}</td>
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
   
   
    <%@ include file="importacion_js.jsp" %>

</body>

</html>