<%@ include file="importacion_head.jsp" %>
<body>
<%@ include file="usuario_header.jsp" %>
   <jsp:useBean id="OBJSERVICIO" scope="session" class="Entidades.Servicio"></jsp:useBean>
	<div class="container-fluid" style="margin-top:79px;">
		<div class="row justify-content-center">
			<div class="col-md-5 pb-sm-3">
				<!-- Card -->
                <div class="card booking-card">

                    <!-- Card image -->
                    <div class="view overlay">
                        <img class="card-img-top"
                            src="ServletChef?tipo=imagenServicio&servicio=${OBJSERVICIO.nom_servicio}"
                            alt="Card image cap">
                        <a href="#!">
                            <div class="mask rgba-white-slight"></div>
                        </a>
                    </div>

                    <!-- Card content -->
                    <div class="card-body">

                        <!-- Title -->
                        <h4 class="card-title font-weight-bold">${OBJSERVICIO.nom_servicio} <strong>$${OBJSERVICIO.precio_persona}</strong></h4>
                        <p class="lead"><strong>${OBJSERVICIO.nombre_chef}</strong></p>
                        <!-- Data -->
                        <ul class="list-unstyled list-inline rating mb-0">
                            <li class="list-inline-item mr-0"><i class="fas fa-star amber-text"> </i></li>
                            <li class="list-inline-item mr-0"><i class="fas fa-star amber-text"></i></li>
                            <li class="list-inline-item mr-0"><i class="fas fa-star amber-text"></i></li>
                            <li class="list-inline-item mr-0"><i class="fas fa-star amber-text"></i></li>
                            <li class="list-inline-item"><i class="fas fa-star-half-alt amber-text"></i></li>
                            <li class="list-inline-item">
                                <p class="text-muted">4.5 (413)</p>
                            </li>
                        </ul>
                        <p class="mb-2">${OBJSERVICIO.platillos}</p>
                        <!-- Text -->
                        <p class="card-text">${OBJSERVICIO.descripcion}</p>
                    </div>

                </div>
                <!-- Card -->
			</div>
			<div class="col-md-5">
					<div class="card">
				
				    <h5 class="card-header info-color white-text text-center py-4">
				        <strong>Completar para la Compra</strong>
				    </h5>
				
				    <!--Card content-->
				    <div class="card-body px-lg-5 pt-0">
				
				        <!-- Form -->
				        <form class="text-center" style="color: #757575;" action="ServletCliente">
							<input type="hidden" name="tipo" value="compra">
				            <input type="hidden" name="codigoCliente" value="${USUARIOCLIENTE.cod_cli}">
							<input type="hidden" name="codigoServicio" value="${OBJSERVICIO.cod_servicio}">
				            <!-- E-mail -->
				          
							<div class="md-form">
	                        <input type="number" id="numberExample" name="cantidad" class="form-control">
	                        <label for="numberExample">Cantidad de personas</label>
	                   		</div>
	                   		
	                   		<div class="md-form">
	                        <input type="text" id="precioTotal" name="total" class="form-control">
	                        <label for="precioTotal">Total </label>
	                   		</div>
	                   		
				            <div class="md-form">
	                        <input type="text" id="direccion" name="direccion" class="form-control">
	                        <label for="direccion">Dirección de Entrega</label>
	                   		</div>
				            
						    <input type="text" id="picker" name="fecha" class="form-control">
						
							
				
				            <!-- Sign up button -->
				            <button class="btn btn-outline-info btn-rounded btn-block my-4 waves-effect z-depth-0" type="submit">Comprar</button>    
				            <hr>
				
				            <!-- Terms of service -->
				            <p>Cuando hagas click en
				                <em>Comprar</em> tu aceptas nuestros
				                <a class="text-primary" target="_blank">Terminos de Servicio</a>
				
				        </form>
				        <!-- Form -->
				
				    </div>
				
				</div>
			</div>
		</div>
	</div>
<br><br>
<br>
<br>
<br>
<br>
<br>
<br>
<%@ include file="importacion_js.jsp" %>
<script>
    	$(document).ready(function(){
    		 $('#picker').datetimepicker({
                 timepicker : true,
                 datepicker: true,
                 format:'Y-m-d H:i',
                 value:'2019-12-04 10:31',
                 yearStart:2019,
                 yearEnd:2020
                 
             });
    		 $('#precioTotal').click(function(){
    			 var cantidad = $("input[name='cantidad']").val();
    			 var precio = ${OBJSERVICIO.precio_persona};
    			 var suma = cantidad * precio;
    			 console.log("el total es: ",suma);
    			 $(this).val(suma);
    		 });
    	});
    </script>
</body>
</html>