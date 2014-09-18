/**
 * 
 */

define(['backbone', 'models/menu-model'], function (Backbone, MenuModel) {
	return Backbone.Collection.extend({
		url: baseUrl+'menu',
		model: MenuModel
	});
});