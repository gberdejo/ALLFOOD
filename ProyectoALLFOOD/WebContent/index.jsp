<%@ include file="importacion_head.jsp" %>
<body style="position:relative">
    <!-- cabezera de la pagina--->
    <div class="contenedor">

        <!--Navbar -->
        <div>
            <nav class="mb-1 navbar navbar-expand-lg navbar-dark light-green darken-1 fixed-top scrolling-navbar">
                <a class="navbar-brand" href="#">ALLFOOD</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse"
                    data-target="#navbarSupportedContent-4" aria-controls="navbarSupportedContent-4"
                    aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent-4">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item  dropdown">
                        	 <a class="nav-link dropdown-toggle" id="navbarDropdownMenuLink-4" data-toggle="dropdown"
					          aria-haspopup="true" aria-expanded="false">
					          <i class="fas fa-user-plus"></i> Registrate </a>
					        <div class="dropdown-menu dropdown-menu-right dropdown-info" aria-labelledby="navbarDropdownMenuLink-4">
					          <a class="dropdown-item" href="usuario_registra.jsp"> Cliente </a>
					          <a class="dropdown-item" href="chef_registro.jsp"> Chef </a>
					        </div>
                            <!--  <a class="nav-link" href="usuario_registra.jsp">
                                <i class="fas fa-user-plus"></i> Registrate
                                <span class="sr-only">(current)</span>
                            </a>-->
                        </li>
                        <li class="nav-item  dropdown">
                        	 <a class="nav-link dropdown-toggle" id="navbarDropdownMenuLink-4" data-toggle="dropdown"
					          aria-haspopup="true" aria-expanded="false">
					          <i class="fas fa-sign-in-alt"></i> Inicia Sesión </a>
					        <div class="dropdown-menu dropdown-menu-right dropdown-info" aria-labelledby="navbarDropdownMenuLink-4">
					          <a class="dropdown-item" href="usuario_login.jsp"> Cliente </a>
					          <a class="dropdown-item" href="chef_login.jsp"> Chef </a>
					        </div>
                            <!--  <a class="nav-link" href="usuario_registra.jsp">
                                <i class="fas fa-user-plus"></i> Registrate
                                <span class="sr-only">(current)</span>
                            </a>-->
                        </li>
                        
                         <!-- <li class="nav-item">
                            <a class="nav-link" href="usuario_login.jsp">
                                <i class="fas fa-sign-in-alt"></i> Inicia Sesion </a>
                        </li>-->
                        
                    </ul>
                </div>
            </nav>

        </div>

        <!-- cuerpo--->
        <section class="carrucel-central">
            <!--Carousel Wrapper-->
            <div id="carousel-example-2" class="carousel slide carousel-fade" data-ride="carousel">
                <!--Indicators-->
                <ol class="carousel-indicators">
                    <li data-target="#carousel-example-2" data-slide-to="0" class="active"></li>
                    <li data-target="#carousel-example-2" data-slide-to="1"></li>
                    <li data-target="#carousel-example-2" data-slide-to="2"></li>
                </ol>
                <!--/.Indicators-->
                <!--Slides-->
                <div class="carousel-inner" role="listbox">
                    <div class="carousel-item active">
                        <div class="view">
                            <img class="d-block w-100" src="img/banner3.jpg" alt="First slide">
                            <div class="mask rgba-black-light"></div>
                        </div>
                        <div class="carousel-caption">
                            <h3 class="h1-responsive">Encuentra tu servicio ideal</h3>
                            <p>First text</p>
                        </div>
                    </div>
                    <div class="carousel-item">
                        <!--Mask color-->
                        <div class="view">
                            <img class="d-block w-100" src="img/banner7.jpg" alt="Second slide">
                            <div class="mask rgba-black-strong"></div>
                        </div>
                        <div class="carousel-caption">
                            <h3 class="h1-responsive">Todo lo que buscabas en un solo lugar</h3>
                            <p>Secondary text</p>
                        </div>
                    </div>
                    <div class="carousel-item">
                        <!--Mask color-->
                        <div class="view">
                            <img class="d-block w-100" src="img/banner8.jpg" alt="Third slide">
                            <div class="mask rgba-black-slight"></div>
                        </div>
                        <div class="carousel-caption">
                            <h3 class="h1-responsive">Para ese momento especial</h3>
                            <p>Third text</p>
                        </div>
                    </div>
                </div>
                <!--/.Slides-->
                <!--Controls-->
                <a class="carousel-control-prev" href="#carousel-example-2" role="button" data-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="carousel-control-next" href="#carousel-example-2" role="button" data-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
                <!--/.Controls-->
            </div>
        </section>

       

        <section class="my-md-5 container">
            <h2 class="text-center green-text display-4">¿Como funciona?</h2>
            <div class="row contenedor-uso justify-content-around align-items-center mt-md-5">
                <div class="col-md-3">
                    <!-- Card -->
                    <div class="card">

                        <!-- Card image -->
                        <div class="view overlay">
                            <img class="card-img-top"
                                src="https://mdbootstrap.com/img/Mockups/Lightbox/Thumbnail/img%20(67).jpg"
                                alt="Card image cap">
                            <a href="#!">
                                <div class="mask rgba-white-slight"></div>
                            </a>
                        </div>

                        <!-- Card content -->
                        <div class="card-body">

                            <!-- Title -->
                            <h4 class="card-title green-text">1. Busca un Chef</h4>
                            <!-- Text -->
                            <p class="card-text">Some quick example text to build on the card title and make up the bulk
                                of the card's content.</p>
                        </div>
                    </div>
                    <!-- Card -->
                </div>
                <div class="col-md-3">
                     <div class="card">

                        <!-- Card image -->
                        <div class="view overlay">
                            <img class="card-img-top"
                                src="https://mdbootstrap.com/img/Mockups/Lightbox/Thumbnail/img%20(67).jpg"
                                alt="Card image cap">
                            <a href="#!">
                                <div class="mask rgba-white-slight"></div>
                            </a>
                        </div>

                        <!-- Card content -->
                        <div class="card-body">

                            <!-- Title -->
                            <h4 class="card-title green-text">2. Haz tu reserva!</h4>
                            <!-- Text -->
                            <p class="card-text">Some quick example text to build on the card title and make up the bulk
                                of the card's content.</p>
                        </div>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="card">

                        <!-- Card image -->
                        <div class="view overlay">
                            <img class="card-img-top"
                                src="https://mdbootstrap.com/img/Mockups/Lightbox/Thumbnail/img%20(67).jpg"
                                alt="Card image cap">
                            <a href="#!">
                                <div class="mask rgba-white-slight"></div>
                            </a>
                        </div>

                        <!-- Card content -->
                        <div class="card-body">

                            <!-- Title -->
                            <h4 class="card-title green-text">3. Disfruta!</h4>
                            <!-- Text -->
                            <p class="card-text">Some quick example text to build on the card title and make up the bulk
                                of the card's content.</p>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!--  
        <div class="contenedor-aliados d-flex">
             contenedor de   alidos 
            <div class="container align-self-center">
                <h2>Ellos son algunos de nuestros Aliados:</h2>
                <section class="row justify-content-around align-items-center mt-md-5">
                    <div class="col-md-5 p-3  aliados">
                        aliado 1
                        <div class="row">
                            <div class="col-md-3">
                                <div class="face">
                                    <img src="img/face.jpg" alt="">
                                </div>
                            </div>
                            <div class="col-md-9">
                                <h5><strong>Lorenzo Palacios Quispe</strong></h6>
                                    <ul class="estrellas">
                                        <li><i class="fas fa-star"></i></li>
                                        <li><i class="fas fa-star"></i></li>
                                        <li><i class="fas fa-star"></i></li>
                                        <li><i class="fas fa-star"></i></li>
                                        <li><i class="fas fa-star"></i></li>
                                    </ul>
                                    <span>80 Servicios Cumplidos</span>
                            </div>
                        </div>
                        <h6 class="py-md-2">Especialidades: </h6>
                        <div class="row">
                            <div class="col-md-4 text-center">
                                <i class="fas fa-birthday-cake fa-3x "></i>
                                <span>cumpleaños</span>
                            </div>
                            <div class="col-md-4 text-center">
                                <i class="fas fa-user-graduate fa-3x"></i>
                                <span>Graduacion</span>
                            </div>
                            <div class="col-md-4 text-center">
                                <i class="fas fa-laugh-squint fa-3x"></i><br>
                                <span>Party</span>
                            </div>
                        </div>
                    </div>
                    
                    <div class="col-md-5 p-3 aliados">
                        <div class="row">
                            <div class="col-md-3">
                                <div class="face">
                                    <img src="img/img3.jpg" alt="">
                                </div>
                            </div>
                            <div class="col-md-9">
                                <h5><strong>Lorenzo Palacios Quispe</strong></h6>
                                    <ul class="estrellas">
                                        <li><i class="fas fa-star"></i></li>
                                        <li><i class="fas fa-star"></i></li>
                                        <li><i class="fas fa-star"></i></li>
                                        <li><i class="fas fa-star"></i></li>
                                        <li><i class="fas fa-star"></i></li>
                                    </ul>
                                    <span>80 Servicios Cumplidos</span>
                            </div>
                        </div>
                        <h6 class="py-md-2">Especialidades: </h6>
                        <div class="row">
                            <div class="col-md-4 text-center">
                                <i class="fas fa-birthday-cake fa-3x "></i>
                                <span>cumpleaños</span>
                            </div>
                            <div class="col-md-4 text-center">
                                <i class="fas fa-user-graduate fa-3x"></i>
                                <span>Graduacion</span>
                            </div>
                            <div class="col-md-4 text-center">
                                <i class="fas fa-laugh-squint fa-3x"></i><br>
                                <span>Party</span>
                            </div>
                        </div>
                    </div>
                </section>
            </div>
        </div> 
        -->
        <!--  Registrar aliados    -->
        <section class="container">
            <div class="row align-items-center contenedor-reg-aliados justify-content-center">
                <div class="col-md-4">
                    <img src="img/img2.jpg" class="img-fluid" alt="">
                </div>
                <div class="col-md-5">
                    <h2>¿Quieres prestar tus servicios en la plataforma?</h2>
                    <a class="enlace" href="chef_registro.jsp"><button class="btn btn-outline-success  p-3 ">Registrate
                            como Chef</button></a>
                </div>
            </div>
        </section>
        <!-- Footer -->
<footer class="page-footer font-small light-green darken-1">

  <!-- Footer Elements -->
  <div class="container">

    <!-- Grid row-->
    <div class="row">

      <!-- Grid column -->
      <div class="col-md-12 py-5">
        <div class="mb-5 flex-center">

          <!-- Facebook -->
          <a class="fb-ic">
            <i class="fab fa-facebook-f fa-lg white-text mr-md-5 mr-3 fa-2x"> </i>
          </a>
          <!-- Twitter -->
          <a class="tw-ic">
            <i class="fab fa-twitter fa-lg white-text mr-md-5 mr-3 fa-2x"> </i>
          </a>
          <!-- Google +-->
          <a class="gplus-ic">
            <i class="fab fa-google-plus-g fa-lg white-text mr-md-5 mr-3 fa-2x"> </i>
          </a>
          <!--Linkedin -->
          <a class="li-ic">
            <i class="fab fa-linkedin-in fa-lg white-text mr-md-5 mr-3 fa-2x"> </i>
          </a>
          <!--Instagram-->
          <a class="ins-ic">
            <i class="fab fa-instagram fa-lg white-text mr-md-5 mr-3 fa-2x"> </i>
          </a>
          <!--Pinterest-->
          <a class="pin-ic">
            <i class="fab fa-pinterest fa-lg white-text fa-2x"> </i>
          </a>
        </div>
      </div>
      <!-- Grid column -->

    </div>
    <!-- Grid row-->

  </div>
  <!-- Footer Elements -->

  <!-- Copyright -->
  <div class="footer-copyright text-center py-3">© 2019 Copyright:
    <a href="https://mdbootstrap.com/education/bootstrap/"> Derechos Reservados by ZeReF</a>
  </div>
  <!-- Copyright -->

</footer>
<!-- Footer -->

    </div>


   <%@ include file="importacion_js.jsp" %>
</body>
</html>