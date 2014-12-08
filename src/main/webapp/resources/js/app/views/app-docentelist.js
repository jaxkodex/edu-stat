define(['marionette', 'templates/app-templates'], function (Marionette, AppTemplates) {
	var ItemView = Marionette.ItemView.extend({
		template: AppTemplates.mantenimientoDocenteItemListTemplate
	});
	
	return Marionette.CompositeView.extend({
		template: AppTemplates.mantenimientoDocenteListTemplate
	});
});