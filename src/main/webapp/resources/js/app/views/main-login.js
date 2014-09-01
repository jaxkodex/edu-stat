/**
 * 
 */

define(['marionette', 'templates/main-templates'], function (Marionette, templates) {
	return Marionette.ItemView.extend({
		template: templates.loginTemplate,
	});
});