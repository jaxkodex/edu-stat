/**
 * turno-model.js by jaxkodex
 * modelo backbone para turno (Mañana/tarde)
 */
define (['underscore', 'backbone'], function (_, Backbone) {
	return Backbone.Model.extend({
        idAttribute: 'idTurno',
        defaults: {
        	turnoName: ''
        },
        validate: function (attrs, options) {
        	if (_.isUndefined(attrs.turnoName) || attrs.turnoName.trim() === '') {
        		return {
            		field: 'turnoName',
            		error: 'El campo nombre es obligatorio'
        		}
        	}
        }
	});
});