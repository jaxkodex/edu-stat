define(['backbone', 'models/persona-model'], function (Backbone, PersonaModel) {
	return Backbone.Collection.extend({
		url: baseUrl+'persona',
		model: PersonaModel
	});
});