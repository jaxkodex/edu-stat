// file: app-clases.js
define(['marionette', 'underscore', 
        'templates/app-templates',
        'collections/clase-collection'], function (Marionette, _, 
		AppTemplates, ClaseCollection) {
	var ClaseListView, ClaseItemListView, ClaseEmptyListView;
	
	ClaseEmptyListView = Marionette.ItemView.extend({
		tagName: 'tr',
		template: _.template('<td colspan="5" class="text-center text-muted"><i>Seleccione un periodo para comenzar.</i></td>')
	});
	
	ClaseItemListView = Marionette.ItemView.extend({
		tagName: 'tr',
		template: AppTemplates.clasesItemListTemplate
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
			var idPeriodo, idNivel, idTurno;
			idPeriodo = this.$('#idPeriodo').val();
			idNivel = this.$('#idNivel').val();
			idTurno = this.$('#idTurno').val();
			this.claseCollection.fetch({
				reset: true,
				data: {
					idPeriodo: idPeriodo,
					idNivel: idNivel,
					idTurno: idTurno
				}
			});
		}
	});
});