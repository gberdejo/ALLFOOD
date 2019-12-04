<!-- objeto del cliente -->
<jsp:useBean id="USUARIOCLIENTE" scope="session" class="Entidades.Cliente"></jsp:useBean>
<jsp:useBean id="USUARIOCHEF" scope="session" class="Entidades.Chef"></jsp:useBean>
<c:choose>
	<c:when test ="${USUARIOCLIENTE.usuario == null}">
			    <!--Navbar -->
    <nav class="mb-1 navbar navbar-expand-lg navbar-dark secondary-color lighten-1 fixed-top scrolling-navbar">
        <a class="navbar-brand" href="#">Navbar</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent-555"
            aria-controls="navbarSupportedContent-555" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent-555">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="#">Home
                        <span class="sr-only">(current)</span>
                    </a>
                </li>
                
            </ul>
            <ul class="navbar-nav ml-auto nav-flex-icons">
                <li class="nav-item">
                    <a href="chef_pagina.jsp" class="nav-link waves-effect waves-light">1
                        <i class="fas fa-envelope"></i>
                    </a>
                </li>
                <li class="nav-item avatar dropdown">
                    <a  class="nav-link dropdown-toggle" id="navbarDropdownMenuLink-55" data-toggle="dropdown"
                        aria-haspopup="true" aria-expanded="false">
                        
                        <img src="https://mdbootstrap.com/img/Photos/Avatars/avatar-2.jpg"
                            class="rounded-circle z-depth-0" width="35px" height="35px" alt="avatar image">
                            ${USUARIOCHEF.usuario }
                    </a>
                    <div class="dropdown-menu dropdown-menu-lg-right dropdown-secondary"
                        aria-labelledby="navbarDropdownMenuLink-55">
                        <a class="dropdown-item" href="#">Perfil</a>
                        <a class="dropdown-item" href="servicio.jsp">Mis Servicios</a>
                        <a class="dropdown-item" href="#">Cartera</a>
                        <a class="dropdown-item" href="ServletChef?tipo=salir">Salir</a>
                    </div>
                </li>
            </ul>
        </div>
    </nav>
    <!--/.Navbar -->
	 </c:when>
	 <c:otherwise>
			
<!-- contentttt -->
<nav class="mb-1 navbar navbar-expand-lg navbar-dark secondary-color lighten-1 fixed-top scrolling-navbar">
        <a class="navbar-brand" href="#">Navbar</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent-555"
            aria-controls="navbarSupportedContent-555" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent-555">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="#">Home
                        <span class="sr-only">(current)</span>
                    </a>
                </li>
                
            </ul>
            <ul class="navbar-nav ml-auto nav-flex-icons">
                <li class="nav-item">
                    <a class="nav-link waves-effect waves-light">1
                        <i class="fas fa-envelope"></i>
                    </a>
                </li>
                <li class="nav-item avatar dropdown">
                    <a class="nav-link dropdown-toggle" id="navbarDropdownMenuLink-55" data-toggle="dropdown"
                        aria-haspopup="true" aria-expanded="false">
                        <img src="ServletCliente?tipo=imagen&usuario=${USUARIOCLIENTE.usuario}"
                            class="rounded-circle z-depth-0" width="35px" height="35px" alt="avatar image">
                            ${USUARIOCLIENTE.usuario}
                    </a>
                    <div class="dropdown-menu dropdown-menu-lg-right dropdown-secondary"
                        aria-labelledby="navbarDropdownMenuLink-55">
                        <a class="dropdown-item" href="ServletCliente?tipo=perfil&usuario=${USUARIOCLIENTE.usuario}">Perfil</a>
                        <a class="dropdown-item" href="usuario_cartera.jsp">Cartera</a>
                        <a class="dropdown-item" href="ServletCliente?tipo=salir">Salir</a>
                    </div>
                </li>
            </ul>
        </div>
    </nav>
	</c:otherwise>
</c:choose>