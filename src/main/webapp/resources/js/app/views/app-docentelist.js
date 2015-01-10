define(['marionette', 'templates/app-templates'], function (Marionette, AppTemplates) {
	var ItemView = Marionette.ItemView.extend({
		tagName: 'tr',
		template: AppTemplates.mantenimientoDocenteItemListTemplate
	});
	
	return Marionette.CompositeView.extend({
		childView: ItemView,
		childViewContainer: 'tbody',
		template: AppTemplates.mantenimientoDocenteListTemplate
	});
});