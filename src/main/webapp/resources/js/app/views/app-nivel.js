define(['underscore', 'marionette', 'templates/app-templates'], function (_, Marionette, AppTemplates) {
	var ItemView = Marionette.ItemView.extend({
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
		template: _.template('<td class="editable"><span class="view"><%=nivelNombre%></span><input class="form-control input-sm edit" type="text" value="<%=nivelNombre%>" /></td><td><button class="btn btn-xs btn-default delete"><span class="glyphicon glyphicon-remove"></span></button></td>'),
		editRow: function (evt) {
			this.$el.addClass('editing');
			this.$('input').focus();
		},
		save: function (evt) {
			if (evt.keyCode == 13) {
				var value = this.$('input').val();
				this.model.save({ nivelNombre: value }, { wait: true });
				this.$el.removeClass('editing');
			}
		},
		eliminar: function (evt) {
			evt.preventDefault();
			this.model.destroy();
		}
	});
	
	return Marionette.CompositeView.extend({
		childView: ItemView,
		childViewContainer: 'tbody',
		events: {
			'click .new': 'add'
		},
		template: AppTemplates.mantenimientoNivelListTemplate,
		add: function () {
			this.collection.add({});
		}
	});
});