define(['underscore', 'marionette', 'templates/app-templates', 
        'collections/nivel-collection', 'collections/grado-collection'], function (_, Marionette, templates, 
        		NivelCollection, GradoCollection) {
	var NivelListView, NivelItemListView;
	
	NivelItemListView = Marionette.ItemView.extend({
		template: _.template('<%=nivelNombre%>')
	});
	
	NivelListView = Marionette.CompositeView.extend({
		template: _.template(''),
		childView: NivelItemListView
	});
	
	return Marionette.LayoutView.extend({
		template: templates.mantenimientoSeccionListTemplate,
		initialize: function () {
			this.nivelCollection = new NivelCollection;
			this.gradoCollection = new GradoCollection;
			
			this.nivelListView = new NivelListView({
				collection: this.nivelCollection
			});
		},
		regions: {
			'niveles': '#nivel-list-region',
			'grados': '#grado-list-region',
			'secciones': '#seccion-list-region'
		},
		onBeforeShow: function () {
			this.getRegion('niveles').show(this.nivelListView);
			
			this.nivelCollection.fetch();
		}
	});
});