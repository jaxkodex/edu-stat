<h3>Clases</h3>
<div class="row">
	<div class="col-sm-12">
		<form id="seleccionar-periodo-form" class="form-horizontal">
			<div class="form-group">
				<label for="idPeriodo" class="col-sm-2 control-label">Periodo Académico:</label>
				<div class="col-sm-10">
					<select id="idPeriodo" class="form-control input-sm">
						<% _.each(periodos, function (val) { %>
						<option value="<%=val.idPeriodo%>"><%=val.periodoNombre%></option>
						<% }); %>
					</select>
				</div>
			</div>
			<div class="form-group">
			    <label for="idNivel" class="col-sm-2 control-label">Nivel:</label>
                <div class="col-sm-4">
                    <select id="idNivel" class="form-control input-sm">
                        <% _.each(niveles, function (val) { %>
                        <option value="<%=val.idNivel%>"><%=val.nivelNombre%></option>
                        <% }); %>
                    </select>
                </div>
                <label for="idTurno" class="col-sm-2 control-label">Turno:</label>
                <div class="col-sm-4">
                    <select id="idTurno" class="form-control input-sm">
                        <% _.each(turnos, function (val) { %>
                        <option value="<%=val.idTurno%>"><%=val.turnoName%></option>
                        <% }); %>
                    </select>
                </div>
			</div>
			<div class="clearfix">
			    <button type="submit" class="btn btn-sm btn-primary pull-right">Cargar clases</button>
			</div>
		</form>
	</div>
</div>
<br />
<div class="row">
	<div id="clases-container" class="col-sm-12"></div>
</div>