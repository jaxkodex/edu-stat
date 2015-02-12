define(['backbone', 'underscore'], function (Backbone, _) {
	return Backbone.Model.extend({
		idAttribute: 'username',
		defaults: {
			persona: {
				personaPnombre: '',
				personaSnombre: '',
				personaApaterno: '',
				personaAmaterno: '',
				dni: ''
			}
		},
		validate: function (attrs, options) {
			console.log('persona', attrs.persona);
			if (_.isUndefined(attrs.persona)) {
				return {
					field: 'persona',
					error: 'Debe definir una persona'
				};
			}
			if (_.isUndefined(attrs.persona.personaDni) || _.isEmpty(attrs.persona.personaDni.trim()) || attrs.persona.personaDni.trim().length != 8) {
				return {
					field: 'persona-personaDni',
					error: 'El dni es un campo obligatorio y debe tener 8 caracteres.'
				};
			}
			if (_.isUndefined(attrs.persona.personaPnombre) || _.isEmpty(attrs.persona.personaPnombre.trim())) {
				return {
					field: 'persona-personaPnombre',
					error: 'El primer nombre es un campo obligatorio.'
				};
			}
			if (_.isUndefined(attrs.persona.personaApaterno) || _.isEmpty(attrs.persona.personaApaterno.trim())) {
				return {
					field: 'persona-personaApaterno',
					error: 'El apellido paterno es un campo obligatorio.'
				};
			}
			if (_.isUndefined(attrs.persona.personaAmaterno) || _.isEmpty(attrs.persona.personaAmaterno.trim())) {
				return {
					field: 'persona-personaAmaterno',
					error: 'El apellido materno es un campo obligatorio.'
				};
			}
		}
	});
});