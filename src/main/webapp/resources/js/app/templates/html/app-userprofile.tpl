<div class="row">
	<div class="col-sm-12">
		<h2>Mis datos</h2>
		<form role="form">
			<div class="row">
				<div class="col-sm-12 clearfix">
					<div class="btn-group hidden_on_editing pull-right">
						<button type="button" class="btn btn-default btn-sm btn-edit"><span class="glyphicon glyphicon-pencil"></span> Edit</button>
					</div>
					<div class="btn-group edit pull-right">
						<button type="button" class="btn btn-default btn-sm btn-save"><span class="glyphicon glyphicon-floppy-disk"></span> Guardar</button>
						<button type="button" class="btn btn-default btn-sm btn-cancel"><span class="glyphicon glyphicon-remove"></span> Cancelar</button>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-3">
					<img src="http://placekitten.com/g/200/300" class="img-responsive" />
				</div>
				<div class="col-sm-9">
					<div class="row">
						<div class="col-sm-6">
							<label>Apellido Paterno</label>
							<input type="text" class="form-control input-sm edit" name="personaApaterno" value="<%=persona.personaApaterno%>" />
							<p class="form-control-static hidden_on_editing"><%=persona.personaApaterno%></p>
						</div>
						<div class="col-sm-6">
							<label>Apellido Materno</label>
							<input type="text" class="form-control input-sm edit" name="personaAmaterno" value="<%=persona.personaAmaterno%>" />
							<p class="form-control-static hidden_on_editing"><%=persona.personaAmaterno%></p>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-6">
							<label>Primer Nombre</label>
							<input type="text" class="form-control input-sm edit" name="personaPnombre" value="<%=persona.personaPnombre%>" />
							<p class="form-control-static hidden_on_editing"><%=persona.personaPnombre%></p>
						</div>
						<div class="col-sm-6">
							<label>Segundo Nombre</label>
							<input type="text" class="form-control input-sm edit" name="personaSnombre" value="<%=persona.personaSnombre%>" />
							<p class="form-control-static hidden_on_editing"><%=persona.personaSnombre%></p>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-12">
							<label>Correo Electrónico</label>
							<input type="text" class="form-control input-sm edit" value="" />
							<p class="form-control-static hidden_on_editing"></p>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
</div>