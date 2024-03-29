<!-- objeto del cliente -->
<jsp:useBean id="USUARIOCLIENTE" scope="session" class="Entidades.Cliente"></jsp:useBean>
<jsp:useBean id="USUARIOCHEF" scope="session" class="Entidades.Chef"></jsp:useBean>
<c:choose>
	<c:when test ="${USUARIOCLIENTE.usuario == null}">
			    <!--Navbar del chef -->
    <nav class="mb-1 navbar navbar-expand-lg navbar-dark purple-gradient fixed-top scrolling-navbar">
        <a class="navbar-brand text-white" >AllFooDPer˙</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent-555"
            aria-controls="navbarSupportedContent-555" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent-555">
          
            <ul class="navbar-nav ml-auto nav-flex-icons">
                <li class="nav-item">
                    <a href="ServletChef?tipo=inicio&chef=${USUARIOCHEF.usuario}" class="nav-link waves-effect waves-light">
                        <i class="fas fa-home"></i>Inicio
                    </a>
                </li>
                <li class="nav-item avatar dropdown">
                    <a  class="nav-link dropdown-toggle" id="navbarDropdownMenuLink-55" data-toggle="dropdown"
                        aria-haspopup="true" aria-expanded="false">
                        
                        <img src="ServletChef?tipo=imagen&usuario=${USUARIOCHEF.usuario}"
                            class="rounded-circle z-depth-0" width="35px" height="35px" alt="avatar image">
                            ${USUARIOCHEF.usuario}
                    </a>
                    <div class="dropdown-menu dropdown-menu-lg-right dropdown-secondary"
                        aria-labelledby="navbarDropdownMenuLink-55">
                        <a class="dropdown-item" href="ServletChef?tipo=perfil&chef=${USUARIOCHEF.usuario}">ir Perfil</a>
                        <a class="dropdown-item" href="chef_editar.jsp">editar Perfil</a>
                        <!--  <a class="dropdown-item" href="#">Cartera</a>-->
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
<nav class="mb-1 navbar navbar-expand-lg navbar-dark blue-gradient fixed-top scrolling-navbar">
        <a class="navbar-brand" href="#">AllFooDPer˙</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent-555"
            aria-controls="navbarSupportedContent-555" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent-555">
            
            <ul class="navbar-nav ml-auto nav-flex-icons">
                <li class="nav-item">
                    <a href="ServletCliente?tipo=inicio&usuario=${USUARIOCLIENTE.usuario}" class="nav-link waves-effect waves-light">
                        <i class="fas fa-home"></i>Inicio
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
                        
                        <a class="dropdown-item" href="ServletCliente?tipo=perfil&usuario=${USUARIOCLIENTE.usuario}">ir a Perfil</a>
                        <a class="dropdown-item" href="usuario_editar.jsp">editar Perfil</a>
                        <!--  <a class="dropdown-item" href="usuario_cartera.jsp">Cartera</a>-->
                        <a class="dropdown-item" href="ServletCliente?tipo=salir">Salir</a>
                    </div>
                </li>
            </ul>
        </div>
    </nav>
	</c:otherwise>
</c:choose>