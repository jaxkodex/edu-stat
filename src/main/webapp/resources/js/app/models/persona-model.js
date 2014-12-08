define(['backbone'], function (Backbone) {
	return Backbone.Model.extend({
		idAttribute: 'personaDni',
		defaults: {
			personaPnombre: '',
			personaSnombre: '',
			personaApaterno: '',
			personaAmaterno: '',
			personaDni: ''
		}
	});
});