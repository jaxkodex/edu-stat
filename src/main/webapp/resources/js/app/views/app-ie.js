define(['marionette', 'templates/app-templates'], function (Marionette, templates) {
	return Marionette.ItemView.extend({
		template: templates.ieTemplate,
		events: {}
	});
});