<td>
    <span class="view"><%=periodoNombre%></span>
    <input type="text" class="form-control input-sm edit" name="periodoNombre" value="<%=periodoNombre%>" />
</td>
<td class="editable">
    <span class="view"><%=_.isNumber(periodoFinicio) ? moment(new Date(periodoFinicio)).format('DD/MM/YYYY') : periodoFinicio%></span>
    <input type="date" class="form-control input-sm edit" name="periodoFinicio" value="<%=_.isNumber(periodoFinicio) ? moment(new Date(periodoFinicio)).format('YYYY-MM-DD') : periodoFinicio%>" />
</td>
<td class="editable">
    <span class="view"><%=_.isNumber(periodoFfin) ? moment(new Date(periodoFfin)).format('DD/MM/YYYY') : periodoFfin%></span>
    <input type="date" class="form-control input-sm edit" name="periodoFfin" value="<%=_.isNumber(periodoFfin) ? moment(new Date(periodoFfin)).format('YYYY-MM-DD') : periodoFfin%>" />
</td>
<td class="editable">
    <span class="view"><%= periodoEstado === 'A' ? 'Periodo Abierto' : 'Inactivo'%></span>
    <select name="periodoEstado" class="form-control input-sm edit">
        <option value="A" <% if (periodoEstado === 'A') { %>selected<% } %>>Periodo Abierto</option>
        <option value="C" <% if (periodoEstado === 'C') { %>selected<% } %>>Periodo Cerrado</option>
    </select>
</td>
<td>
    <button class="btn btn-link btn-xs btn-save"><span class="glyphicon glyphicon glyphicon-floppy-disk"></span></button>
    <button class="btn btn-link btn-xs btn-delete"><span class="glyphicon glyphicon-remove"></span></button>
</td>