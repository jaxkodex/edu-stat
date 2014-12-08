define(['backbone'], function (Backbone) {
	return Backbone.Model.extend({
		idAttribute: 'idDocente',
		defaults: {
			username: '',
			persona: {
				personaPnombre: '',
				personaSnombre: '',
				personaApaterno: '',
				personaAmaterno: '',
				dni: ''
			}
		},
		validate: function (attrs, options) {
			var errors, errorCount;
			errors = {};
			errorCount = 0;
			if (!_.isUndefined(attrs.persona)) {
				if (_.isUndefined(attrs.persona.personaPnombre) || 
						_.isEmpty(attrs.persona.personaPnombre)) {
					errors['personaPnombre'] = 'Debe registrar el primer nombre';
					errorCount++;
				}
				if (_.isUndefined(attrs.persona.personaApaterno) || 
						_.isEmpty(attrs.persona.personaApaterno)) {
					errors['personaPnombre'] = 'Debe registrar el apellido paterno';
					errorCount++;
				}
				if (_.isUndefined(attrs.persona.personaAmaterno) || 
						_.isEmpty(attrs.persona.personaAmaterno)) {
					errors['personaPnombre'] = 'Debe registrar el apellido materno';
					errorCount++;
				}
			} else {
				errors['persona'] = 'El usuario debe pertenecer a una persona';
				errorCount++;
			}
			if (errorCount > 0) {
				return errors;
			}
		}
	});
})