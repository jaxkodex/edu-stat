define(['backbone', 'models/periodoacademico-model'], function (Backbone, PeriodoAcademicoModel) {
	return Backbone.Collection.extend({
		url: baseUrl+'periodoacademico',
		model: PeriodoAcademicoModel
	});
});