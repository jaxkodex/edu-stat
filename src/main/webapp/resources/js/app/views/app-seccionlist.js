define(['underscore', 'marionette', 'templates/app-templates', 
        'collections/nivel-collection', 'collections/grado-collection', 
        'collections/seccion-collection'], function (_, Marionette, templates, 
        		NivelCollection, GradoCollection, SeccionCollection) {
	var NivelListView, NivelItemListView,
		GradoListView, GradoItemListView;
	
	GradoItemListView = Marionette.ItemView.extend({
		template: _.template('<%=gradoNombre%>')
	});
	
	GradoListView = Marionette.CompositeView.extend({
		template: _.template(''),
		childView: GradoItemListView
	});
	
	NivelItemListView = Marionette.ItemView.extend({
		events: {
			'click .nivelNombre': 'selectNivel'
		},
		template: _.template('<span class="nivelNombre"><%=nivelNombre%></span>'),
		selectNivel: function () {
			this.model.trigger('select:nivel', {
				model: this.model
			});
		}
	});
	
	NivelListView = Marionette.CompositeView.extend({
		template: _.template(''),
		childView: NivelItemListView,
		collectionEvents: {
			'select:nivel': 'handleNivelChange'
		},
		handleNivelChange: function (args) {
			this.trigger('set:nivel', args);
		}
	});
	
	return Marionette.LayoutView.extend({
		template: templates.mantenimientoSeccionListTemplate,
		initialize: function () {
			this.nivelCollection = new NivelCollection;
			this.gradoCollection = new GradoCollection;
			this.seccionCollection = new SeccionCollection;
			
			this.nivelListView = new NivelListView({
				collection: this.nivelCollection
			});
			
			this.gradoListView = new GradoListView ({
				collection: this.gradoCollection
			});
		},
		regions: {
			'niveles': '#nivel-list-region',
			'grados': '#grado-list-region',
			'secciones': '#seccion-list-region'
		},
		onBeforeShow: function () {
			var me;
			
			me = this;
			this.getRegion('niveles').show(this.nivelListView);
			this.getRegion('grados').show(this.gradoListView);
			
			this.nivelListView.on('set:nivel', function (args) {
				me.gradoCollection.fetch({
					data: {
						idNivel: args.model.get('idNivel')
					}
				});
			});
			
			this.nivelCollection.fetch({
				success: function () {
					if (me.nivelCollection.size() < 1) {
						return;
					}
					me.gradoCollection.fetch({
						data: {
							idNivel: me.nivelCollection.at(0).get('idNivel')
						}
					});
				}
			});
		}
	});
});