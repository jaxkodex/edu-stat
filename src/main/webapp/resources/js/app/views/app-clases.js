define(['marionette', 'templates/app-templates'], function (Marionette, AppTemplates) {
	return Marionette.ItemView.extend({
		template: AppTemplates.clasesTemplate
	});
});