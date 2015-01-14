<h3>Grados</h3>
<br />
<div class="row">
    <div class="col-sm-12">
        <div role="tabpanel">
            <ul class="nav nav-tabs" role="tablist">
                <% _.each(niveles, function (value, index) { %>
                <li role="presentation" <% if (currIdNivel == value.idNivel) {%>class="active"<% } %>><a class="nivel-tab-link" href="#nivel-<%=value.idNivel%>" aria-controls="nivel-<%=value.idNivel%>" data-idnivel="<%=value.idNivel%>" role="tab" data-toggle="tab"><%=value.nivelNombre%></a></li>
                <% }); %>
            </ul>
            <div class="tab-content">
                <% _.each(niveles, function (value, index) { %>
                <div role="tabpanel" class="tab-pane<% if (currIdNivel == value.idNivel) {%> active<% } %>" id="nivel-<%=value.idNivel%>">
                    <% if (currIdNivel == value.idNivel) {%>
                    <div class="clearfix" style="margin-top: 15px;">
                        <button class="btn btn-primary btn-xs pull-right add-grado"><span class="glyphicon glyphicon-plus"></span></button>
                    </div>
                    <table class="table">
                        <thead>
                            <tr>
                                <th>Grado</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                        </tbody>
                    </table>
                    <% } %>
                </div>
                <% }); %>
            </div>
        </div>
    </div>
</div>