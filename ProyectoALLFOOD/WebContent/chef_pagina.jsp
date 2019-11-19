<%@ include file="importacion_head.jsp" %>
<body>
<!--Navbar-->
<nav class="navbar menu1 navbar-expand-lg navbar-dark primary-color">
  <!-- Navbar brand -->
  <a class="navbar-brand" href="#">Navbar</a>
  <!-- Collapse button -->
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#basicExampleNav"
    aria-controls="basicExampleNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <!-- Collapsible content -->
  <div class="collapse navbar-collapse" id="basicExampleNav">
    <!-- Links -->
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="#">Home
          <span class="sr-only">(current)</span>
        </a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Features</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Pricing</a>
      </li>
      <!-- Dropdown -->
      <li class="nav-item dropdown multi-level-dropdown">
        <a href="#" id="menu" data-toggle="dropdown" class="nav-link dropdown-toggle w-100">Dropdown</a>
        <ul class="dropdown-menu mt-2 rounded-0 primary-color border-0 z-depth-1">
          <li class="dropdown-item dropdown-submenu p-0">
            <a href="#" data-toggle="dropdown" class="dropdown-toggle text-white w-100">Click Me Too! </a>
            <ul class="dropdown-menu ml-2 rounded-0 primary-color border-0 z-depth-1">
              <li class="dropdown-item p-0">
                <a href="#" class="text-white w-100">Hey</a>
              </li>
              <li class="dropdown-item p-0">
                <a href="#" class="text-white w-100">Hi</a>
              </li>
              <li class="dropdown-item dropdown-submenu p-0">
                <a href="#" data-toggle="dropdown" class="dropdown-toggle text-white w-100">Hello </a>
                <ul class="dropdown-menu mr-2 rounded-0 primary-color border-0 z-depth-1 r-100 ">
                  <li class="dropdown-item p-0">
                    <a href="#" class="text-white w-100">Some</a>
                  </li>
                  <li class="dropdown-item p-0">
                    <a href="#" class="text-white w-100">Text</a>
                  </li>
                </ul>
              </li>
            </ul>
          </li>
          <li class="dropdown-item dropdown-submenu">
            <a href="#" data-toggle="dropdown" class="dropdown-toggle text-white w-100">Click me </a>
            <ul class="dropdown-menu mr-2 rounded-0  primary-color border-0 z-depth-1 r-100 ">
              <li class="dropdown-item p-0">
                <a href="#" class="text-white w-100">How</a>
              </li>
              <li class="dropdown-item p-0">
                <a href="#" class="text-white w-100">are</a>
              </li>
              <li class="dropdown-item p-0">
                <a href="#" class="text-white w-100">you </a>
              </li>
            </ul>
          </li>
        </ul>
      </li>
    </ul>
    <!-- Links -->
    <form class="form-inline">
      <div class="md-form my-0">
        <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
      </div>
    </form>
  </div>
  <!-- Collapsible content -->
</nav>
<!--/.Navbar-->


<%@ include file="importacion_js.jsp" %>
</body>
</html>