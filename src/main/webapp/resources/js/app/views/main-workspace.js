/**
 * 
 */

define(['marionette', 'templates/main-templates'], function (Marionette, templates) {
	return Marionette.LayoutView.extend({
		template: templates.mainTemplate
	});
});