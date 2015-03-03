// file: clase-collection.js
/**
 * clase-collection.js
 * Colección de elementos clase
 */
define(['backbone', 'models/clase-model'] , function (Backbone, ClaseModel) {
	return Backbone.Collection.extend({
		url: baseUrl+'clase',
		model: ClaseModel
	});
});