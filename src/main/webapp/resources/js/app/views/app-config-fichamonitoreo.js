// file: app-config-fichamonitoreo.js
define(['marionette', 'templates/app-templates'], function (Marionette, AppTemplates) {
	return Marionette.ItemView.extend({
		events: {
			'click .btn-new': 'registrarNuevo'
		},
		template: AppTemplates.fichaMonitoreoListTemplate,
		registrarNuevo: function (evt) {
			evt.preventDefault();
			console.log('Ir a nuevo');
			this.trigger('go:new:fichamonitoreo');
		}
	});
});