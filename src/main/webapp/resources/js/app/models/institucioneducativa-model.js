/**
 * 
 */

define(['backbone'], function (Backbone) {
	return Backbone.Model.extend({
		idAttribute: 'idInstitucionEducativa',
		defaults: {
			idInstitucionEducativa: '',
			institucionEducativaCodigo: '',
			institucionEducativaNombre: ''
		}
	});
})