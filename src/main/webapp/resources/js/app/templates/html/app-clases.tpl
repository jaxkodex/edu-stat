<h3>Clases</h3>
<div class="row">
	<div class="col-sm-12">
		<form id="seleccionar-periodo-form" class="form-horizontal">
			<div class="form-group">
				<label for="idPeriodo" class="col-sm-2 control-label">Periodo Académico</label>
				<div class="col-sm-10">
					<select id="idPeriodo" class="form-control input-sm">
						<% _.each(items, function (val) { %>
						<option value="<%=val.idPeriodo%>"><%=val.periodoNombre%></option>
						<% }); %>
					</select>
				</div>
			</div>
			<button type="submit" class="btn btn-sm btn-primary">Cargar clases</button>
		</form>
	</div>
</div>
<div class="row">
	<div id="clases-container" class="col-sm-12"></div>
</div>