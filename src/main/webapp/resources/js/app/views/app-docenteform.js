define(['marionette', 'templates/app-templates',
        'models/persona-model', 'collections/persona-collection'], 
        function (Marionette, AppTemplates,
        		PersonaModel, PersonaCollection) {
	var personaCollection = new PersonaCollection;
	
	return Marionette.ItemView.extend({
		events: {
			'blur #persona-personaDni': 'onBlurDniField',
			'keydown #persona-personaDni': 'onKeyDown',
			'submit': 'saveMe'
		},
		modelEvents: {
			'invalid': 'handleInvalidModel'
		},
		template: AppTemplates.mantenimientoDocenteFormTemplate,
		onKeyDown: function (e) {
	        if (e.shiftKey === true ) {
	            if (e.which == 9) {
	                return true;
	            }
	            return false;
	        }
	        if (e.which > 95 && e.which < 106) {
	        	return true;
	        }
	        if (e.which > 57) {
	            return false;
	        }
	        if (e.which==32) {
	            return false;
	        }
	        return true;
		},
		onBlurDniField: function () {
			var dni, model, me;
			me = this;
			dni = this.$('#persona-personaDni').val();
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
		handleInvalidModel: function (model, error, options) {
			this.$('#'+error.field).focus();
			this.$('#'+error.field).parent().addClass('has-error')
			alert(error.error);
		},
		saveMe: function (evt) {
			evt.preventDefault();
			console.log(this.$('#persona-personaPnombre').val().toUpperCase());
			var obj, me;
			obj = {
					persona: {
						personaDni: this.$('#persona-personaDni').val().toUpperCase(),
						personaAmaterno: this.$('#persona-personaAmaterno').val().toUpperCase(),
						personaApaterno: this.$('#persona-personaApaterno').val().toUpperCase(),
						personaPnombre: this.$('#persona-personaPnombre').val().toUpperCase(),
						personaSnombre: this.$('#persona-personaSnombre').val().toUpperCase()
					}
			};
			me = this;
			this.model.set(obj);
			this.model.save({}, {
				success: function () {
					me.trigger('docente:saved')
				}
			});
		}
	});
});