<%@ include file="usuario_validacion.jsp" %>
<%@ include file="importacion_head.jsp" %>
<body>
	
    <!--Cabezera de Cliente -->
   <%@include file="usuario_header.jsp" %>
  
   <div class="container-fluid ">
        <div class="row	anchorow align-items-center">
            <div class="fondo-perfil-cliente1"></div>
            <div class="fondo-perfil-cliente2"></div>
            <div class="fondo-perfil-cliente3"></div>
            <div class="offset-md-1 col-md-3">
                <img alt="Aquí se supone que va la imagen del usuario" 
                src="ServletCliente?tipo=imagen&usuario=${USUARIOCLIENTE.usuario}" width="300px" height="300px" class="rounded-circle float-right">
            </div>
            <div class="col-md-7">
            
                    <h1>${USUARIOCLIENTE.usuario}</h1>
                
               
            </div>
        </div>
    </div>
   
   
    <%@ include file="importacion_js.jsp" %>

</body>

</html>