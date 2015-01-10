define(['backbone', 'models/docente-model'], function (Backbone, DocenteModel) {
	return Backbone.Collection.extend({
		url: baseUrl+'docente',
		model: DocenteModel
	});
});