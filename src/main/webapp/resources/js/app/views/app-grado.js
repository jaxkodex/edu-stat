define(['marionette', 'templates/app-templates', 
        'collections/grado-collection'], function (Marionette, AppTemplates,
        		GradoCollection) {
	var NivelItemView;
	
	NivelItemView = Marionette.ItemView.extend({
		template: _.template('<%=nivelNombre%>')
	});
	
	
	return Marionette.CompositeView.extend({
		template: AppTemplates.mantenimientoGradoListTemplate,
		childViewContainer: '#niveles', 
		childView: NivelItemView
	});
});