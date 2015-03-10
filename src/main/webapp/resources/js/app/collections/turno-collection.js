/**
 * turno-collection.js by jaxkodex
 */
define(['backbone', 'models/turno-model'], function (Backbone, TurnoModel) {
	return Backbone.Collection.extend({
		url: baseUrl+'turno',
		model: TurnoModel
	});
});