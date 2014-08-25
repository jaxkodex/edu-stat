/**
 * 
 */

define(['backbone'], function (Backbone) {
	return Backbone.Model.extend({
		idAttribute: 'username',
		defaults: {
			username: '',
			persona: {
				primerNombre: '',
				segundoNombre: '',
				apellidoPaterno: '',
				apellidoMaterno: '',
				dni: ''
			}
		}
	});
})