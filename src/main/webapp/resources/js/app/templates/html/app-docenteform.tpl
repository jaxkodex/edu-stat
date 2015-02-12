<h3>Docente</h3>
<br />
<form>
	(*) Es un campo obligatorio
	<div class="row">
		<div class="col-sm-12">
			<div class="form-group">
				<label class="control-label" for="persona-personaDni">DNI (*)</label>
				<input class="form-control input-sm" type="text" name="persona-personaDni" id="persona-personaDni" maxlength="8" value="<%=persona.personaDni%>" />
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-6">
			<div class="form-group">
				<label class="control-label" for="persona-personaApaterno">Apellido Paterno (*)</label>
				<input class="form-control input-sm" type="text" name="persona-personaApaterno" id="persona-personaApaterno" value="<%=persona.personaApaterno%>" />
			</div>
		</div>
		<div class="col-sm-6">
			<div class="form-group">
				<label class="control-label" for="persona-personaAmaterno">Apellido Materno (*)</label>
				<input class="form-control input-sm" type="text" name="persona-personaAmaterno" id="persona-personaAmaterno" value="<%=persona.personaAmaterno%>" />
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-6">
			<div class="form-group">
				<label class="control-label" for="persona-personaPnombre">Primer Nombre (*)</label>
				<input class="form-control input-sm" type="text" name="persona-personaPnombre" id="persona-personaPnombre" value="<%=persona.personaPnombre%>" />
			</div>
		</div>
		<div class="col-sm-6">
			<div class="form-group">
				<label class="control-label" for="persona-personaSnombre">Segundo Nombre</label>
				<input class="form-control input-sm" type="text" name="persona-personaSnombre" id="persona-personaSnombre" value="<%=persona.personaSnombre%>" />
			</div>
		</div>
	</div>
	<div class="clearfix">
		<button type="submit" class="btn btn-primary">Guardar</button>
	</div>
</form>