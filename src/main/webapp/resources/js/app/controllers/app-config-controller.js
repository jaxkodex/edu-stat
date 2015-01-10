define(['web-app',
        'models/institucioneducativa-model', 'models/docente-model', 'models/nivel-model',
        'models/grado-model',
        'collections/docente-collection', 'collections/nivel-collection',
        'collections/grado-collection', 
        'views/app-ie', 'views/app-docentelist', 'views/app-docenteform', 'views/app-nivel',
        'views/app-grado'], function (app,
        		InstitucionEducativaModel, DocenteModel, NivelModel,
        		GradoModel,
        		DocenteCollection, NivelCollection,
        		GradoCollection,
        		IeDataView, DocenteListView, DocenteFormView, NivelView,
        		GradoView) {
	var docenteCollection, nivelCollection;
	
	docenteCollection = new DocenteCollection;
	nivelCollection = new NivelCollection;
	
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
		},
		showNivelView: function () {
			nivelCollection.fetch({
				reset: true,
				success: function () {
					var view = new NivelView({
						collection: nivelCollection
					});
					app.main.show(view);
				}
			});
		},
		showGradoView: function () {
			nivelCollection.fetch({
				reset: true,
				success: function () {
					var view = new GradoView({
						nivelCollection: nivelCollection
					});
					app.main.show(view);
				}
			});
		}
	};
});