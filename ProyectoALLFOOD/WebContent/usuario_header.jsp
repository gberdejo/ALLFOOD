<%@ include file="usuario_validacion.jsp" %>
<jsp:useBean id="USUARIOCLIENTE" scope="session" class="Entidades.Cliente"></jsp:useBean>

<nav class="mb-1 navbar navbar-expand-lg navbar-dark light-green darken-2">
  <a class="navbar-brand text-white" >ALLFOODffod</a>
  <button class="navbar-toggler disable" type="button" data-toggle="collapse" data-target="#navbarSupportedContent-555"
    aria-controls="navbarSupportedContent-555" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarSupportedContent-555">
   
    <ul class="navbar-nav ml-auto nav-flex-icons">
      <li class="nav-item">
       
      <form action="ServletCliente">
      		<input type="hidden" name="tipo" value="refrescar">
      		<input type="hidden" name="inicio" value="<jsp:getProperty property="usuario" name="USUARIOCLIENTE"/>">
      		<button type="submit" class="btn p-1"><i class="far fa-user pr-2 fa-1x" aria-hidden="true"></i>Inicio</button>
      </form>
      <!-- 
        <a href="usuario_pagina.jsp" class="nav-link waves-effect waves-light">
          <i class="fas fa-envelope"></i> Inicio
        </a>-->
      </li>
      <li class="nav-item avatar dropdown">
        <a class="nav-link dropdown-toggle" id="navbarDropdownMenuLink-55" data-toggle="dropdown"
          aria-haspopup="true" aria-expanded="false">
          <img src="img/avatar.jpg" width="24px" height="24px" class="rounded-circle z-depth-0"
            alt="avatar image"> <jsp:getProperty property="usuario" name="USUARIOCLIENTE"/>
        </a>
        <div class="dropdown-menu dropdown-menu-lg-right dropdown-secondary"
          aria-labelledby="navbarDropdownMenuLink-55">
          <a class="dropdown-item" href="#">Perfil</a>
          <a class="dropdown-item" href="usuario_cartera.jsp">Cartera</a>
          <form action="ServletCliente">
          	<input type="hidden" name="tipo" value="salir">
          	<a class="dropdown-item"><button class="btn btn-block" type="submit">Salir</button></a>
          </form>
        </div>
      </li>
    </ul>
  </div>
</nav>