define(['web-app',
        'models/institucioneducativa-model', 'models/docente-model',
        'collections/docente-collection',
        'views/app-ie', 'views/app-docentelist', 'views/app-docenteform'], function (app,
        		InstitucionEducativaModel, DocenteModel,
        		DocenteCollection,
        		IeDataView, DocenteListView, DocenteFormView) {
	var docenteCollection = new DocenteCollection;
	
	return {
		showIePage: function () {
			var view = new IeDataView({
				model: new InstitucionEducativaModel(userData.institucionEducativa)
			});
			app.main.show(view);
		},
		showDocenteList: function () {
			docenteCollection.fetch({
				reset: true,
				data: {
					idIe: userData.institucionEducativa.idIe
				},
				success: function () {
					var view = new DocenteListView({
						collection: docenteCollection
					});
					app.main.show(view);
				}
			});
		},
		showNewDocenteForm: function () {
			var model = new DocenteModel;
			docenteCollection.add(model);
			var view = new DocenteFormView({
				model: model
			});
			app.main.show(view);
		}
	};
});