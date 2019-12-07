 <div class="accordion md-accordion" id="accordionEx" role="tablist" aria-multiselectable="true">
                    <!-- Accordion card -->
                    <div class="card">

                        <!-- Card header -->
                        <div class="card-header" role="tab" id="headingOne1">
                            <a data-toggle="collapse" data-parent="#accordionEx" href="#collapseOne1"
                                aria-expanded="true" aria-controls="collapseOne1">
                                <h5 class="mb-0">
                                    Top 5 de CHEFS <i class="fas fa-angle-down rotate-icon"></i>
                                </h5>
                            </a>
                        </div>

                        <!-- Card body -->
                        <div id="collapseOne1" class="collapse show" role="tabpanel" aria-labelledby="headingOne1"
                            data-parent="#accordionEx">
                            <div class="card-body">
                                <div class="row">
                                    <c:forEach items="${LISTATOPCHEF}" var="c">
                                        <div class="col-md-12 mb-3">
                                            <!-- Card -->
                                            <div class="card border border-warning">
                                                <!-- Card image -->
                                                <div class="view overlay">

                                                    <img class="card-img-top"
                                                        src="ServletChef?tipo=imagen&usuario=${c.usuario}"
                                                        alt="Card image cap">
                                                    <a href="ServletChef?tipo=perfil&chef=${c.usuario}">
                                                        <div class="mask rgba-white-slight"></div>
                                                    </a>
                                                </div>
                                                <div class="card-body p-2">
                                                    <!-- Name -->
                                                    <h1 class="yellow-text"><i class="fas fa-award"></i>${c.podio}</h1>
                                                    <h4 class="card-title">Chef: ${c.usuario}</h4>
                                                    <hr>
                                                    <!-- Quotation -->
                                                    <span><i class="fas fa-quote-left"></i>${c.presentacion}</span>
                                                </div>
                                            </div>
                                            <!-- Card -->
                                        </div>
                                    </c:forEach>

                                </div>
                            </div>
                        </div>

                    </div>
                    <!-- Accordion card -->

                    <!-- Accordion card -->
                    
                    <!-- Accordion card -->

                    <!-- 
                    <div class="card">

                        <div class="card-header" role="tab" id="headingThree3">
                            <a class="collapsed" data-toggle="collapse" data-parent="#accordionEx"
                                href="#collapseThree3" aria-expanded="false" aria-controls="collapseThree3">
                                <h5 class="mb-0">
                                    Collapsible Group Item #3 <i class="fas fa-angle-down rotate-icon"></i>
                                </h5>
                            </a>
                        </div>

                        <div id="collapseThree3" class="collapse" role="tabpanel" aria-labelledby="headingThree3"
                            data-parent="#accordionEx">
                            <div class="card-body">
                                En Desarrollo
                            </div>
                        </div>

                    </div> -->

                </div>