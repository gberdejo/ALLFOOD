<%@ include file="usuario_validacion.jsp" %>
<%@ include file="importacion_head.jsp" %>
<body>
<div >
	<!--Navbar -->
<nav class="mb-1 navbar navbar-expand-lg navbar-dark light-green darken-2">
  <a class="navbar-brand text-white" >ALLFOOD</a>
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
          <img src="img/avatar.jpg" width="24px" height="24px" class="rounded-circle z-depth-0"
            alt="avatar image">
        </a>
        <div class="dropdown-menu dropdown-menu-lg-right dropdown-secondary"
          aria-labelledby="navbarDropdownMenuLink-55">
          <a class="dropdown-item" href="#">Perfil</a>
          <a class="dropdown-item" href="#">Cartera</a>
          <form action="ServletCliente">
          	<input type="hidden" name="tipo" value="salir">
          	<a class="dropdown-item"> <button type="submit">Salir</button> </a>
          </form>
        </div>
      </li>
    </ul>
  </div>
</nav>
<!-- cuerpo -->
<div class="container-fluid">

<div class="row">
  <div class="col-3 px-0">
    <div class="list-group" id="list-tab" role="tablist">
      <a class="list-group-item list-group-item-action active" id="list-home-list" data-toggle="list" href="#list-home" role="tab" aria-controls="home">Home</a>
      <a class="list-group-item list-group-item-action" id="list-profile-list" data-toggle="list" href="#list-profile" role="tab" aria-controls="profile">Profile</a>
      <a class="list-group-item list-group-item-action" id="list-messages-list" data-toggle="list" href="#list-messages" role="tab" aria-controls="messages">Messages</a>
      <a class="list-group-item list-group-item-action" id="list-settings-list" data-toggle="list" href="#list-settings" role="tab" aria-controls="settings">Settings</a>
    </div>
  </div>
  <div class="col-9 px-0">
    <div class="tab-content" id="nav-tabContent">
      <div class="tab-pane fade show active" id="list-home" role="tabpanel" aria-labelledby="list-home-list">
      	<div class="container" style="border:1px solid black;">
      		<div class="row">
      			<!-- Card -->
      			<c:forEach items="${LISTARCHEF}" var="x">
      			<form action="" class="col-md-4 mb-5">
					<div class="card">
					  <!-- Card image -->
					  <div class="view overlay">
					    <img class="card-img-top" src="https://mdbootstrap.com/img/Mockups/Lightbox/Thumbnail/img%20(67).jpg" alt="Card image cap">
					    <a href="#!">
					      <div class="mask rgba-white-slight"></div>
					    </a>
					  </div>
					  <div class="card-body">
					    <h4 class="card-title">${x.usuario}</h4>
					    <h5 class="card-subtitle">${x.nom_chef} ${x.ape_chef}(${x.edad}) </h3>
					    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
					    <button type="submit" class="btn btn-primary">Conócelo</button>
					  </div>
					</div>
				</form>
				</c:forEach>
      		</div>
      		
      		</div>
      	</div>
      </div>
      <div class="tab-pane fade" id="list-profile" role="tabpanel" aria-labelledby="list-profile-list">lorem2</div>
      <div class="tab-pane fade" id="list-messages" role="tabpanel" aria-labelledby="list-messages-list">lorem3</div>
      <div class="tab-pane fade" id="list-settings" role="tabpanel" aria-labelledby="list-settings-list">lorem4</div>
    </div>
  </div>
</div>
</div>


</div>



<%@ include file="importacion_js.jsp" %>
</body>
</html>