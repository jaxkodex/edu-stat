define(['backbone'], function (Backbone) {
	return Backbone.Model.extend({
		idAttribute: 'idPeriodo',
		defaults: {
			periodoFinicio: (new Date).getTime(),
			periodoFfin: (new Date).getTime(),
			periodoNombre: '',
			institucionEducativa: {}
		}
	});
});