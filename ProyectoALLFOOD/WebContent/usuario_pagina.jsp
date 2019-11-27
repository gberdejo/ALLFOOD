<%@ include file="usuario_validacion.jsp" %>
<%@ include file="importacion_head.jsp" %>

<body>
    <div>
        <!--Cabezera de Cliente -->
        <%@ include file= "usuario_header.jsp" %>
        <!-- cuerpo -->

        <div class="container-fluid" style="margin-top:64.8px;">
            <div class="row">
                <div class="col-3 px-0">
                    <div class="list-group" id="list-tab" role="tablist">
                        <a class="list-group-item list-group-item-action active" id="list-home-list" data-toggle="list"
                            href="#list-home" role="tab" aria-controls="home">Notificaciones</a>
                        <a class="list-group-item list-group-item-action" id="list-profile-list" data-toggle="list"
                            href="#list-profile" role="tab" aria-controls="profile">Servicios</a>
                        <a class="list-group-item list-group-item-action" id="list-messages-list" data-toggle="list"
                            href="#list-messages" role="tab" aria-controls="messages">Chefs</a>
                        <a class="list-group-item list-group-item-action" id="list-settings-list" data-toggle="list"
                            href="#list-settings" role="tab" aria-controls="settings">Pedidos</a>
                    </div>
                </div>
                <div class="col-9">
                    <div class="tab-content" id="nav-tabContent">
                        <div class="tab-pane fade show active" id="list-home" role="tabpanel"
                            aria-labelledby="list-home-list">
                            <h2>Ultimos Servicios</h2>
                            <div class="row">
                                <c:forEach items="${LISTARCHEF}" var="x">
                                    <div class="col-md-4 mb-5">

                                        <div class="card">
                                            <!-- Card <img src="servletperfil?accion=Imagen&codigo=${dato.codigo}" width="250px" height="250px"> image -->
                                            <div class="view overlay">
                                                <img src="ServletChef?tipo=imagen&usuario=${x.usuario}" height="300px">
                                                <a href="#!">
                                                    <div class="mask rgba-white-slight"></div>
                                                </a>
                                            </div>
                                            <div class="card-body">
                                                <h4 class=S"card-title">${x.usuario}</h4>
                                                <h5 class="card-subtitle">${x.nom_chef} ${x.ape_chef}(${x.edad}) </h3>
                                                    <p class="card-text">Some quick example text to build on the card
                                                        title and make up the bulk of the card's content.</p>
                                                    <a
                                                        href="ServletChef?tipo=perfil&chef=${x.usuario}">Conócelo</a>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                            <hr>

                        </div>
                        <div class="tab-pane fade" id="list-profile" role="tabpanel"
                            aria-labelledby="list-profile-list">
                            Cupidatat quis ad sint excepteur laborum in esse qui. Et excepteur consectetur ex nisi eu do
                            cillum ad
                            laborum. Mollit et eu officia dolore sunt Lorem culpa qui commodo velit ex amet id ex.
                            Officia anim
                            incididunt laboris deserunt anim aute dolor incididunt veniam aute dolore do exercitation.
                            Dolor nisi
                            culpa ex ad irure in elit eu dolore. Ad laboris ipsum reprehenderit irure non commodo enim
                            culpa
                            commodo veniam incididunt veniam ad.
                        </div>
                        <div class="tab-pane fade" id="list-messages" role="tabpanel"
                            aria-labelledby="list-messages-list">
                            Ut ut do pariatur aliquip aliqua aliquip exercitation do nostrud commodo reprehenderit aute
                            ipsum
                            voluptate. Irure Lorem et laboris nostrud amet cupidatat cupidatat anim do ut velit mollit
                            consequat
                            enim tempor. Consectetur est minim nostrud nostrud consectetur irure labore voluptate irure.
                            Ipsum id
                            Lorem sit sint voluptate est pariatur eu ad cupidatat et deserunt culpa sit eiusmod
                            deserunt.
                            Consectetur et fugiat anim do eiusmod aliquip nulla laborum elit adipisicing pariatur
                            cillum.
                        </div>
                        <div class="tab-pane fade" id="list-settings" role="tabpanel"
                            aria-labelledby="list-settings-list">
                            Irure enim occaecat labore sit qui aliquip reprehenderit amet velit. Deserunt ullamco ex
                            elit nostrud
                            ut dolore nisi officia magna sit occaecat laboris sunt dolor. Nisi eu minim cillum occaecat
                            aute est
                            cupidatat aliqua labore aute occaecat ea aliquip sunt amet. Aute mollit dolor ut
                            exercitation irure
                            commodo non amet consectetur quis amet culpa. Quis ullamco nisi amet qui aute irure eu.
                            Magna labore
                            dolor quis ex labore id nostrud deserunt dolor eiusmod eu pariatur culpa mollit in irure.
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>
<%@ include file="importacion_js.jsp" %>
</body>

</html>