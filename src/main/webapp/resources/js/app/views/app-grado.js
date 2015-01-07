define(['marionette', 'templates/app-templates', 
        'collections/grado-collection',
        'bootstrap'], function (Marionette, AppTemplates,
        		GradoCollection) {
	
	return Marionette.ItemView.extend({
		initialize: function (opts) {
			this.options = opts;
		},
		template: AppTemplates.mantenimientoGradoListTemplate,
		serializeData: function () {
			console.log(this.options.nivelCollection.toJSON());
			return {
				niveles: this.options.nivelCollection.toJSON()
			};
		}
	});
});