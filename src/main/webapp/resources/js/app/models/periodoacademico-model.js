define(['backbone', 'underscore', 'moment'], function (Backbone, _, moment) {
	var isValidDate, getDate;
	
	getMomentDate = function (obj) {
		var momentDate = null;
		if (_.isString(obj) && /\d\d\d\d-\d\d-\d\d/.test(obj)) {
			momentDate = moment(obj);
		}
		if (_.isNumber(obj)) {
			momentDate = moment(new Date(obj));
		}
		if (_.isDate(obj)) {
			momentDate = moment(obj);
		}
		return momentDate;
	};
	isValidDate = function (obj) {
		var momentDate = getMomentDate(obj);
		return momentDate === null ? false : momentDate.isValid();
	};
	
    return Backbone.Model.extend({
        idAttribute: 'idPeriodo',
        defaults: {
            periodoFinicio: (new Date).getTime(),
            periodoFfin: (new Date).getTime(),
            periodoNombre: moment(new Date).format('YYYY'),
            periodoEstado: 'A', // Let the period start as Active
            institucionEducativa: {}
        },
        validate: function (attrs, options) {
            if (_.isUndefined(attrs.periodoNombre) || attrs.periodoNombre.trim() === '') {
            	return {
            		'field': 'periodoNombre',
            		'error': 'El campo Nombre de Periodo es obligatorio'
            	};
            }
            if (!isValidDate(attrs.periodoFinicio)) {
            	return {
            		'field': 'periodoFinicio',
            		'error': 'El campo fecha inicio no es valido'
            	};
            }
            if (!isValidDate(attrs.periodoFfin)) {
            	return {
            		'field': 'periodoFfin',
            		'error': 'El campo fecha fin no es valido'
            	};
            }
            if (getMomentDate(attrs.periodoFinicio).toDate() >= getMomentDate(attrs.periodoFfin).toDate()) {
            	return {
            		'field': 'periodoFinicio',
            		'error': 'El campo fecha inicio debe ser anterior al campo fecha fin'
            	};
            }
        }
    });
});