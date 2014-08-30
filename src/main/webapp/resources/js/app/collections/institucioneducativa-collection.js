/**
 * 
 */

define(['backbone', 'models/institucioneducativa-model'], function (Backbone, InstitucioneducativaModel) {
	return Backbone.Collection.extend({
		url: baseUrl+'institucioneducativa',
		model: InstitucioneducativaModel
	});
});