define(['backbone'], function (Backbone) {
	return Backbone.Model.extend({
		idAttribute: 'idNivel',
		defaults: {
			nivelNombre: ''
		},
		validate: function (attrs) {
			if (attrs.nivelNombre.trim().lenght == 0) {
				return {
					campo: nivelNombre,
					message: 'Este campo debe ser completado'
				};
			}
		}
	});
});