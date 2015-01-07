<h3>Grados</h3>
<br />
<div class="row">
    <div class="col-sm-12">
        <div role="tabpanel">
            <ul class="nav nav-tabs" role="tablist">
                <% _.each(niveles, function (value, index) { %>
                <li role="presentation" <% if (index == 0) {%>class="active"<% } %>><a href="#nivel-<%=value.idNivel%>" aria-controls="nivel-<%=value.idNivel%>" role="tab" data-toggle="tab"><%=value.nivelNombre%></a></li>
                <% }); %>
            </ul>
            <div class="tab-content">
                <% _.each(niveles, function (value, index) { %>
                <div role="tabpanel" class="tab-pane<% if (index == 0) {%> active<% } %>" id="nivel-<%=value.idNivel%>">
                    <%=value.nivelNombre%>
                </div>
                <% }); %>
            </div>
        </div>
    </div>
</div>