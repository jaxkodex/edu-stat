define(['marionette', 'templates/app-templates', 
        'collections/grado-collection',
        'underscore', 'bootstrap'], function (Marionette, AppTemplates,
        		GradoCollection, _) {
	
	var ItemView;
	
	ItemView = Marionette.ItemView.extend({
		tagName: 'tr',
		events: {
			'dblclick .editable': 'editRow',
			'keypress input': 'save',
			'click .delete': 'eliminar'
		},
		modelEvents: {
			'change': 'render'
		},
		onRender: function () {
			if (_.isUndefined(this.model.id)) {
				this.$el.addClass('editing');
			}
		},
		template: _.template('<td class="editable"><span class="view"><%=gradoNombre%></span><input class="form-control input-sm edit" type="text" value="<%=gradoNombre%>" /></td><td><button class="btn btn-xs btn-danger delete"><span class="glyphicon glyphicon-remove"></span></button></td>'),
		editRow: function (evt) {
			this.$el.addClass('editing');
			this.$('input').focus();
		},
		save: function (evt) {
			if (evt.keyCode == 13) {
				var value = this.$('input').val();
				this.model.save({ gradoNombre: value }, { wait: true });
				this.$el.removeClass('editing');
			}
		},
		eliminar: function (evt) {
			evt.preventDefault();
			this.model.destroy();
		}
	});
	
	return Marionette.CompositeView.extend({
		initialize: function (opts) {
			var me;
			
			me = this;
			this.options = opts;
			this.nivelIndex = {};
			
			if (this.options.nivelCollection.size() > 0) {
				this.options.currIdNivel = this.options.nivelCollection.at(0).get('idNivel');
			}
			
			this.options.nivelCollection.each(function (val) {
				me.nivelIndex[val.get('idNivel')] = val;
			});
			
			this.collection = this.options.gradoCollection;
		},
		childView: ItemView,
		childViewContainer: 'tbody',
		events: {
			'click .nivel-tab-link': 'updateCurrentTabInfo',
			'click .add-grado': 'addGrado'
		},
		template: AppTemplates.mantenimientoGradoListTemplate,
		updateCurrentTabInfo: function (evt) {
			var $elEvt, me;
			
			me = this;
			$elEvt = $(evt.target);
			nivelArray = this.options.nivelCollection.toJSON();
			
			this.options.currIdNivel = $elEvt.data('idnivel');
			this.collection.fetch({
				data: {
					idNivel: this.options.currIdNivel
				},
				success: function () {
					me.render();
				}
			});
		},
		addGrado: function (evt) {
			evt.preventDefault();
			this.collection.add({
				nivel: {
					idNivel: this.options.currIdNivel
				}
			});
		},
		serializeData: function () {
			return {
				niveles: this.options.nivelCollection.toJSON(),
				currIdNivel: this.options.currIdNivel
			};
		}
	});
});