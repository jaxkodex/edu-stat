// file: app-config-cargasiagie-form.js
define(['marionette', 'templates/app-templates'], function (Marionette, AppTemplates) {
	return Marionette.ItemView.extend({
		template: AppTemplates.cargaSiagieFormTemplate
	});
});