define(['marionette', 'templates/app-templates', 'highcharts'], function (Marionette, templates) {
	return Marionette.ItemView.extend({
		template: templates.userhomeTemplate
	});
});