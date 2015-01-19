define(['underscore', 'marionette', 'templates/app-templates', 
        'collections/nivel-collection', 'collections/grado-collection', 
        'collections/seccion-collection'], function (_, Marionette, templates, 
        		NivelCollection, GradoCollection, SeccionCollection) {
	var NivelListView, NivelItemListView,
		GradoListView, GradoItemListView,
		SeccionListView, SeccionItemListView;
	
	SeccionItemListView = Marionette.ItemView.extend({
		events: {
			'dblclick .editable': 'editRow',
			'keypress input': 'save',
			'click .delete': 'eliminar'
		},
		modelEvents: {
			'change': 'render'
		},
		className: 'row',
		template: _.template('<div style="padding-top: 4px" class="editable col-sm-12"><span class="view"><%=seccionNombre%></span><input class="form-control input-sm edit" type="text" value="<%=seccionNombre%>" /><button class="btn btn-sm btn-danger delete edit"><span class="glyphicon glyphicon-remove"></span></button></div>'),
		onRender: function () {
			if (_.isUndefined(this.model.id)) {
				this.$el.addClass('editing');
			}
		},
		editRow: function () {
			this.$el.addClass('editing');
			this.$('input').focus();
		},
		save: function (evt) {
			if (evt.keyCode == 13) {
				var value = this.$('input').val();
				this.model.save({ seccionNombre: value }, { wait: true });
				this.$el.removeClass('editing');
			}
		},
		eliminar: function (evt) {
			evt.preventDefault();
			this.model.destroy();
		}
	});
	
	SeccionListView = Marionette.CompositeView.extend({
		events: {
			'click .add-seccion': 'handleAddSeccion'
		},
		template: _.template('<div class="row"><div style="padding-top: 5px;" class="col-sm-12 clearfix"><button class="add-seccion btn btn-xs btn-primary pull-right"><span class="glyphicon glyphicon-plus"></span></button></div></div>'),
		childView: SeccionItemListView,
		handleAddSeccion: function () {
			this.collection.add({ grado: { idGrado: this.gradoModel.get('idGrado') } });
		}
	});
	
	GradoItemListView = Marionette.ItemView.extend({
		events: {
			'click .gradoNombre': 'selectGrado'
		},
		template: _.template('<div class="gradoNombre"><%=gradoNombre%></div>'),
		selectGrado: function () {
			this.model.trigger('select:grado', {
				model: this.model
			});
		}
	});
	
	GradoListView = Marionette.CompositeView.extend({
		template: _.template(''),
		collectionEvents: {
			'select:grado': 'handleGradoSelect'
		},
		childView: GradoItemListView,
		handleGradoSelect: function (args) {
			this.trigger('set:grado', args);
		}
	});
	
	NivelItemListView = Marionette.ItemView.extend({
		events: {
			'click .nivelNombre': 'selectNivel'
		},
		template: _.template('<div class="nivelNombre"><%=nivelNombre%></div>'),
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
			
			this.seccionListView = new SeccionListView ({
				collection: this.seccionCollection
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
			this.getRegion('secciones').show(this.seccionListView);
			
			this.nivelListView.on('set:nivel', function (args) {
				me.gradoCollection.fetch({
					data: {
						idNivel: args.model.get('idNivel')
					},
					success: function () {
						if (me.gradoCollection.size() < 1) {
							return;
						}
						me.seccionListView.gradoModel = me.gradoCollection.at(0);
						me.seccionCollection.fetch({
							data: {
								idGrado: me.gradoCollection.at(0).get('idGrado')
							}
						});
					}
				});
			});
			
			this.gradoListView.on('set:grado', function (args) {
				me.seccionListView.gradoModel = args.model;
				me.seccionCollection.fetch({
					data: {
						idGrado: args.model.get('idGrado')
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
						},
						success: function () {
							if (me.gradoCollection.size() < 1) {
								return;
							}
							me.seccionListView.gradoModel = me.gradoCollection.at(0);
							me.seccionCollection.fetch({
								data: {
									idGrado: me.gradoCollection.at(0).get('idGrado')
								}
							});
						}
					});
				}
			});
		}
	});
});