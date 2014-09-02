/**
 * 
 */

define(['backbone'], function (Backbone) {
	return Backbone.Model.extend({
		urlRoot: baseUrl+'session',
		idAttribute: 'username',
		defaults: {
			username: ''
		}
	});
})