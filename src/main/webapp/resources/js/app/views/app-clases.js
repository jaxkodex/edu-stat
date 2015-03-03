// file: app-clases.js
define(['marionette', 'underscore', 
        'templates/app-templates',
        'collections/clase-collection'], function (Marionette, _, 
		AppTemplates, ClaseCollection) {
	var ClaseListView, ClaseItemListView, ClaseEmptyListView;
	
	ClaseEmptyListView = Marionette.ItemView.extend({
		template: _.template('<div class="text-center text-muted"><i>Seleccione un periodo para comenzar.</i></div>')
	});
	
	ClaseItemListView = Marionette.ItemView.extend({
		tagName: 'tr',
		template: _.template('<td><%=turno.turnoName%></td><td><%=seccion.grado.nivel.nivelNombre%></td><td><%=seccion.grado.gradoNombre%></td><td><%=seccion.seccionNombre%></td><td><%=turno.turnoNombre%></td><td><input disabled type="checkbox" <% if (habilitado) {%>checked<% } %> /></td>')
	});
	
	ClaseListView = Marionette.CompositeView.extend({
		childView: ClaseItemListView,
		childViewContainer: 'tbody',
		emptyView: ClaseEmptyListView,
		template: AppTemplates.clasesListTemplate
	});
	
	return Marionette.ItemView.extend({
		initialize: function () {
			this.claseCollection = new ClaseCollection;
			this.claseListView = new ClaseListView({
				collection: this.claseCollection
			});
		},
		events: {
			'submit form#seleccionar-periodo-form': 'cargarClases'
		},
		template: AppTemplates.clasesTemplate,
		onRender: function () {
			this.$('#clases-container').append(this.claseListView.render().$el);
			this.$('form#seleccionar-periodo-form').trigger('submit');
		},
		cargarClases: function (evt) {
			evt.preventDefault();
			var idPeriodo = this.$('#idPeriodo').val();
			if (_.isNumber(idPeriodo*1)) {
				this.claseCollection.fetch({
					reset: true,
					data: {
						idPeriodo: idPeriodo
					}
				});
			}
		}
	});
});