<%@ include file="importacion_head.jsp" %>
<body>
<%@ include file="usuario_validacion.jsp" %>
<div >
	<!--Navbar -->
<nav class="mb-1 navbar navbar-expand-lg navbar-dark light-green darken-2 fixed-top scrolling-navbar">
  <a class="navbar-brand" href="#">ALLFOOD</a>
  <button class="navbar-toggler disable" type="button" data-toggle="collapse" data-target="#navbarSupportedContent-555"
    aria-controls="navbarSupportedContent-555" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarSupportedContent-555">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="usuario_pagina.jsp">Home
          <span class="sr-only">(current)</span>
        </a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Chefs</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Tipo de Comida</a>
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
          <img src="https://mdbootstrap.com/img/Photos/Avatars/avatar-2.jpg" class="rounded-circle z-depth-0"
            alt="avatar image">
        </a>
        <div class="dropdown-menu dropdown-menu-lg-right dropdown-secondary"
          aria-labelledby="navbarDropdownMenuLink-55">
          <a class="dropdown-item" href="#">Perfil</a>
          <a class="dropdown-item" href="#">Cartera</a>
          <a class="dropdown-item" href="index.jsp">Salir</a>
        </div>
      </li>
    </ul>
  </div>
</nav>
<!--/.Navbar -->
</div>
<section class="contenedor-banner-usuario ">
	
</section>
<div class="container my-5 ">
 <center><h2 class="green-text">Listado de CHEFS TOP</h2></center>
</div>
<div class="container-fluid">
<!-- Secc -->
<section class="container">
	<div class="row publicacion align-content-center">
	<div class="col-md-12">
		<div class="row">
			<div class="col-md-4">
 				<img src="img/face.jpg" class="img-fluid" alt="imagen del sevicio de comida que da el chef">
			</div>
			<div class="col-md-6">
				<h5 class="card-title">Card title</h5>
    			<p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
    			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse dui sapien, congue ut dolor et, laoreet tristique leo. Proin luctus.</p>
			</div>
			<div class="col-md-2 align-self-end ">
			<center><button class="btn btn-outline-success ">more</button></center>
			</div>
		</div>
  		
	
	</div>
	</div>
	
</section>

</div>
<%@ include file="importacion_js.jsp" %>
</body>
</html>