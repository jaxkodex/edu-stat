<div class="container">
	<div class="row">
		<div class="col-sm-12 clearfix">
			<ul class="nav nav-pills custom-nav pull-right">
				<li><a href="#home">Inicio</a></li>
				<li class="active"><a href="#signup">Registrarse</a></li>
				<li><a href="#login">Iniciar sesión</a></li>
			</ul>
		</div>
	</div>
	<div class="row">
		<div class="bg-success message-box text-success hidden">
			<h4>Usuario Registrado!</h4>
			<p>Ahora puede <a href="#login">ingresar</a>.</p>
		</div>
		<div class="col-sm-6 col-sm-offset-3">
			<form>
				<div class="form-group">
					<label for="institucioneducativa">Institucion educativa</label>
					<input type="text" class="form-control input-sm" id="institucioneducativa" />
					<div id="institucioneducativa-search-results"></div>
				</div>
				<div id="user-data-signup" style="display: none;">
					<div class="form-group">
						<label for="username">Usuario</label>
						<input type="text" class="form-control input-sm" id="username" value="<%=username%>" />
					</div>
					<div class="form-group">
						<label for="password">Contraseña</label>
						<input type="password" class="form-control input-sm" id="password" />
					</div>
					<div class="form-group">
						<label for="password2">Confirme su contraseña</label>
						<input type="password" class="form-control input-sm" id="password2" />
					</div>
					<div class="form-group">
						<label for="pnombre">Primer nombre</label>
						<input type="text" class="form-control input-sm" id="pnombre" value="<%=persona.primerNombre%>" />
					</div>
					<div class="form-group">
						<label for="snombre">Segundo nombre</label>
						<input type="text" class="form-control input-sm" id="snombre" value="<%=persona.segundoNombre%>" />
					</div>
					<div class="form-group">
						<label for="apaterno">Apellido paterno</label>
						<input type="text" class="form-control input-sm" id="apaterno" value="<%=persona.aperllidoPaterno%>" />
					</div>
					<div class="form-group">
						<label for="amaterno">Apellido materno</label>
						<input type="text" class="form-control input-sm" id="amaterno" value="<%=persona.aperllidoMaterno%>" />
					</div>
					<div class="form-group">
						<label for="dni">DNI</label>
						<input type="text" class="form-control input-sm" id="dni" value="<%=persona.dni%>" />
					</div>
					<input class="btn btn-primary" type="submit" value="Registrar" />
				</div>
			</form>
		</div>
	</div>
</div>