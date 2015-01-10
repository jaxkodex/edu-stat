define(['backbone'], function (Backbone) {
	return Backbone.Model.extend({
		idAttribute: 'idGrado',
		defaults: {
			gradoNombre: ''
		}
	});
});