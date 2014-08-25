/**
 * 
 */

define(['backbone', 'models/usuario-model'], function (Backbone, UsuarioModel) {
	return Backbone.Collection.extend({
		url: baseUrl+'usuario',
		model: UsuarioModel
	});
});