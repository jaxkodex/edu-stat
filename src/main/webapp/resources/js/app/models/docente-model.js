define(['backbone'], function (Backbone) {
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
		}
	});
});