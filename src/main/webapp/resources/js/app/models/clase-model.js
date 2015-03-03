// file: clase-model.js
/**
 * clase-model.js
 * Modelo de clase de lado cliente
 */
define(['backbone'], function (Backbone) {
	return Backbone.Model.extend({
		idAttribute: 'idClase',
		defaults: {
			habilitado: true,
			periodoAcademico: {},
			seccion: {},
			turno: {}
		}
	});
});