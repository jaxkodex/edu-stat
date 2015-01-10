define(['backbone', 'models/nivel-model'], function (Backbone, NivelModel) {
	return Backbone.Collection.extend({
		url: baseUrl+'nivel',
		model: NivelModel
	});
});