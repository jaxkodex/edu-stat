// file: app-clases.js
define(['marionette', 'templates/app-templates', 'underscore'], function (Marionette, AppTemplates, _) {
	return Marionette.ItemView.extend({
		template: AppTemplates.clasesTemplate,
		onRender: function () {
			var idPeriodo = this.$('#idPeriodo').val();
			if (_.isNumber(idPeriodo)) {
				// Cargar datos de las clases para el periodo 
			}
		}
	});
});