<%@ include file="usuario_validacion.jsp" %>
<%@ include file="importacion_head.jsp" %>
<body>
	
    <!--Cabezera de Cliente -->
   <%@include file="usuario_header.jsp" %>
  <jsp:useBean id="CLIENTEPERFIL" scope="session" class="Entidades.Cliente"></jsp:useBean>
   <div class="container-fluid " style="margin-top:79px;">
        <div class="row	anchorow align-items-center">
            <div class="fondo-perfil-cliente1"></div>
            <div class="offset-md-2 col-md-3">
                <img alt="Aquí se supone que va la imagen del usuario" 
                src="ServletCliente?tipo=imagen&usuario=${CLIENTEPERFIL.usuario}"  class="img-fluid z-depth-3 img-thumbnail">
            </div>
            <div class="col-md-6">
            
                <h1><i class="fab fa-free-code-camp"></i> ${CLIENTEPERFIL.usuario}</h1>
                <h2>${CLIENTEPERFIL.nom_cli} ${CLIENTEPERFIL.ape_cli} (${CLIENTEPERFIL.edad})</h2>
            </div>
        </div>
        <!--  -->
    </div>
    <div class="container mt-5">
        <div class="row">
            <div class="col-2 px-0">
                <div class="list-group" id="list-tab" role="tablist">
                    <a class="list-group-item list-group-item-action active" id="list-home-list" data-toggle="list"
                        href="#list-home" role="tab" aria-controls="home">Pedidos</a>
                    
                </div>
            </div>
            <div class="col-10">
                <div class="tab-content" id="nav-tabContent">
                    <div class="tab-pane fade show active" id="list-home" role="tabpanel"
                        aria-labelledby="list-home-list">
                        
                          <table id="tableProducto" class="table table-striped table-bordered table-responsive" style="width:100%">
                            <thead>
                                <th>Codigo de Servicio</th>
                                <th>Nombre de Servicio</th>
                                <th>Usuario Chef</th>
                                <th>Nombres y Apellidos de Chef</th>
                                <th>Precio por Persona</th>
                                <th>Cantidad de Personas</th>
                                <th>Pago Total</th>
                                <th>Fecha de Compra</th>
                                <th>Fecha de Entrega</th>
                                 <th>Dirección de Entrega</th>
                                
                            </thead>
                            <tbody>
                            <c:forEach items="${LISTAPEDIDO}" var="c">
                            	<tr>
                                    <td>${c.codigo_servicio}</td>
                                    <td>${c.nombre_servicio}</td>
                                    <td>${c.usuario_chef}</td>
                                    <td>${c.nombre_chef} ${c.apellido_chef}</td>
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
   
   
    <%@ include file="importacion_js.jsp" %>

</body>

</html>