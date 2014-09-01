<div class="container">
	<div class="row">
		<div class="col-sm-12 clearfix">
			<ul class="nav nav-pills custom-nav pull-right">
				<li><a href="#home">Inicio</a></li>
				<li><a href="#signup">Registrarse</a></li>
				<li class="active"><a href="#login">Iniciar sesión</a></li>
			</ul>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-6 col-sm-offset-3">
			<form action="/edustat/j_spring_security_check" method="POST">
				<div class="form-group">
					<label for="username">Usuario</label>
					<input name="username" type="text" class="form-control input-sm" id="username" />
				</div>
				<div class="form-group">
					<label for="password">Contraseña</label>
					<input name="password" type="password" class="form-control input-sm" id="password" />
				</div>
				<div class="form-group">
					<div class="col-sm-12 text-right">
						<input class="btn btn-sm btn-primary" type="submit" value="Ingresar" /> o <a href="#signup">Registrate</a>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>