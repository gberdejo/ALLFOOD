<%@ include file="importacion_head.jsp" %>
<body>
	    <!-- cabezera--->
    <div class="contenedor">
    <header>
        <div class="contenedor-header row justify-content-between align-items-center">
            <div class="col-md-3">
                <h1>ALLFOOD</h1>
            </div>
            <div class="col-md-1">
                <input type="submit"  value="Iniciar Sesion" class="btn btn-outline-success">
            </div>
        </div>
    </header>
    <!-- cuerpo--->
    <section class="contenendor-buscador">
        <div class="row subcontenedor-buscador   justify-content-center">
            <div class="col-md-6 align-self-center ">
                <h2 class="display-2 ">Encuentra tu servicio ideal</h2>
                <h5>Busca entre cientos de profesionales de la cocina</h4>
                    <form action="#" class="caja-buscador d-flex justify-content-between">
                        <input type="text" class="buscador" placeholder="Escribe tu ocación">
                        <input type="submit" class="btn btn-outline-success" value="Buscar">
                    </form>
            </div>
        </div>
    </section>
    <!--- como se usa -->
    <section class="my-md-5 container">
        <h2 class="text-center">¿Como funciona?</h2>
        <div class="row contenedor-uso justify-content-around align-items-center mt-md-5">
            <div class="col-md-3">
                <p class="text-center" style="color: rgb(26, 168, 33);"><i class="fas fa-search-location fa-9x"></i></p>
                <span class="numero">1</span>
                <span>Descubre tu servicio ideal</span>
                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptate, quia!</p>
            </div>
            <div class="col-md-3">
                <p class="text-center" style="color: rgb(168, 26, 137);"><i class="fas fa-user-check fa-9x"></i></p>
                <span class="numero">2</span>
                <span>Haz tu reserva</span>
                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Quas, minus.</p>
            </div>
            <div class="col-md-3">
                <p class="text-center" style="color: rgb(168, 147, 26);"><i class="fas fa-glass-cheers fa-9x"></i></p>
                <span class="numero">3</span>
                <span>¡Disfruta!</span>
                <p>Lorem ipsum dolor sit, amet consectetur adipisicing elit.</p>
            </div>
        </div>
    </section>
    <div class="contenedor-aliados d-flex">
        <!-- contenedor de   alidos  -->
        <div class="container align-self-center">
            <h2>Ellos son algunos de nuestros Aliados:</h2>
            <section class="row justify-content-around align-items-center mt-md-5">
                <div class="col-md-5 p-3  aliados">
                    <!-- aliado 1-->
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
                <!-- aliado 2-->
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
    <!--  Registrar aliados    -->
    <section class="container">
        <div class="row align-items-center contenedor-reg-aliados">
            <div class="col-md-4">
                <img src="img/img2.jpg" class="img-fluid" alt="">
            </div>
            <div class="col-md-6">
                <h2>¿Quieres prestar tus servicios en la plataforma?</h2>
                <input class="btn btn-outline-primary" type="submit" value="Regístrate como Aliado">
            </div>
        </div>
    </section>

</div>



   <%@ include file="importacion_js.jsp" %>
</body>
</html>