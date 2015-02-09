define(['backbone'], function (Backbone) {
	return Backbone.Model.extend({
		idAttribute: 'idSeccion',
		defaults: {
			seccionNombre: ''
		}
	});
});