define(['marionette', 'templates/app-templates',
        'models/persona-model', 'collections/persona-collection'], 
        function (Marionette, AppTemplates,
        		PersonaModel, PersonaCollection) {
	var personaCollection = new PersonaCollection;
	
	return Marionette.ItemView.extend({
		events: {
			'blur #persona-personaDni': 'onBlurDniField',
			'submit': 'save'
		},
		template: AppTemplates.mantenimientoDocenteFormTemplate,
		onBlurDniField: function () {
			var dni, model, me;
			me = this;
			dni = $('#persona-personaDni').val();
			personaCollection.reset();
			model = new PersonaModel;
			model.set('personaDni', dni);
			personaCollection.add(model);
			model.fetch({
				success: function (responseModel, response, options) {
					var focusedElId = '';
					focusedElId = $(document.activeElement).prop('id');
					me.model.set('persona', model.toJSON());
					me.render();
					$('#'+focusedElId).focus();
				},
				error: function (responseModel, response, options) {
					var focusedElId = '';
					focusedElId = $(document.activeElement).prop('id');
					model = new PersonaModel;
					model.set('personaDni', dni);
					me.model.set('persona', model.toJSON());
					me.render();
					$('#'+focusedElId).focus();
				}
			});
		},
		save: function (evt) {
			evt.preventDefault();
			this.model.save();
		}
	});
});