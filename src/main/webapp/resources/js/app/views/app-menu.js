/**
 * 
 */

define(['marionette', 'templates/app-templates'], function (Marionette, templates) {
	return Marionette.LayoutView.extend({
		template: templates.menuTemplate
	});
});