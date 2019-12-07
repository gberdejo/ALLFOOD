<%@ include file="importacion_head.jsp" %>
<body>
    <!--Cabezera de Cliente -->
    <%@ include file= "usuario_header.jsp" %>
    <jsp:useBean id="CHEFPERFIL" scope="session" class="Entidades.Chef"></jsp:useBean>
    <div class="container-fluid" style="margin-top:79px;">
        <div class="row	anchorow align-items-center">
            <div class="fondo-perfil-cliente1"></div>
            <div class="offset-md-2 col-md-3">
                <img alt="Aquí se supone que va la imagen del usuario" 
                src="ServletChef?tipo=imagen&usuario=${CHEFPERFIL.usuario}" class="img-fluid z-depth-3 img-thumbnail">
            </div>
            <div class="col-md-6">
                <h1><i class="fab fa-free-code-camp"></i> ${CHEFPERFIL.usuario}</h1>
                <h2>${CHEFPERFIL.nom_chef}
                ${CHEFPERFIL.ape_chef}(${CHEFPERFIL.edad})</h2>
                <h4>${CHEFPERFIL.dieccion}</h4>
                <h5>${CHEFPERFIL.celular}</h5>
            </div>
        </div>
    </div>
    <!-- Cuerpo -->
    <div class="container mt-5">
        <div class="row">
  <div class="col-2 px-0">
    <div class="list-group" id="list-tab" role="tablist">
      <a class="list-group-item list-group-item-action active" id="list-home-list" data-toggle="list" href="#list-home"
        role="tab" aria-controls="home">Servicios</a>
      <a class="list-group-item list-group-item-action" id="list-profile-list" data-toggle="list" href="#list-profile"
        role="tab" aria-controls="profile">Pedidos</a>
    </div>
  </div>
  <div class="col-10">
    <div class="tab-content" id="nav-tabContent">
      <div class="tab-pane fade show active" id="list-home" role="tabpanel" aria-labelledby="list-home-list">
      <div class="">
         <table id="tableProducto" class="table table-striped table-bordered table-responsive" style="width:100%">
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
                                    <td>${c.nom_servicio}</td>
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
      <div class="tab-pane fade" id="list-profile" role="tabpanel" aria-labelledby="list-profile-list">
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
 
    <%@ include file="importacion_js.jsp" %>
    <script>
$(document).ready(function(){
	$('#tablaPedido').DataTable();
})
</script>
</body>

</html>