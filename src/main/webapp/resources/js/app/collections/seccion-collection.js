define(['backbone', 'models/seccion-model'], function (Backbone, SeccionModel) {
	return Backbone.Collection.extend({
		url: baseUrl+'seccion',
		model: SeccionModel
	});
});