define(['backbone', 'marionette',
        'templates/app-templates', 'moment'], function (Backbone, Marionette,
        		AppTemplates, moment) {
	var AperturaItemView = Marionette.ItemView.extend({
		tagName: 'tr',
		template: _.template('<td>1</td><td><%=_.isNumber(periodoFinicio) ? moment(new Date(periodoFinicio)).format(\'DD/MM/YYYY\') : periodoFinicio%></td><td></td><td></td>')
	});
	
    return Marionette.CompositeView.extend({
    	events: {
    		'click .aperturar-periodo': 'aperturarPeriodo'
    	},
		childView: AperturaItemView,
		childViewContainer: 'tbody',
    	template: AppTemplates.periodoAcademicoListTemplate,
    	aperturarPeriodo: function () {
    		this.collection.add({});
    	}
    });
});