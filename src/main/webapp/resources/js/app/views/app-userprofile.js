define(['marionette', 'templates/app-templates'], function (Marionette, templates) {
	return Marionette.ItemView.extend({
		template: templates.userprofileTemplate,
		modelEvents: {
			'change': 'render'
		},
		onRender: function () {
			console.log('rendering');
		},
		events: {
			'click .btn-edit': 'onClickBtnEdit',
			'click .btn-save': 'onClickBtnSave',
			'click .btn-cancel': 'onClickBtnCancel'
		},
		onClickBtnEdit: function () {
			this.$el.addClass('editing');
		},
		onClickBtnSave: function () {
			this.model.save({
				persona: {
					personaApaterno: this.$('input[name=personaApaterno]').val(),
					personaAmaterno: this.$('input[name=personaAmaterno]').val(),
					personaPnombre: this.$('input[name=personaPnombre]').val(),
					personaSnombre: this.$('input[name=personaSnombre]').val()
					}
			});
			this.$el.removeClass('editing');
		},
		onClickBtnCancel: function () {
			this.$el.removeClass('editing');
		}
	});
});