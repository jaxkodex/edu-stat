define(['backbone', 'models/grado-model'], function (Backbone, GradoModel) {
	return Backbone.Collection.extend({
		url: baseUrl+'grado',
		model: GradoModel
	});
});