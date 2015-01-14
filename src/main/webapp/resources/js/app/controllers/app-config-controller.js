define(['web-app',
        'models/institucioneducativa-model', 'models/docente-model', 'models/nivel-model',
        'models/grado-model',
        'collections/docente-collection', 'collections/nivel-collection',
        'collections/grado-collection', 
        'views/app-ie', 'views/app-docentelist', 'views/app-docenteform', 'views/app-nivel',
        'views/app-grado', 'views/app-seccionlist'], function (app,
        		InstitucionEducativaModel, DocenteModel, NivelModel,
        		GradoModel,
        		DocenteCollection, NivelCollection,
        		GradoCollection,
        		IeDataView, DocenteListView, DocenteFormView, NivelView,
        		GradoView, SeccionListView) {
	var docenteCollection, nivelCollection, gradoCollection;
	
	gradoCollection = new GradoCollection;
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
			gradoCollection.reset();
			nivelCollection.fetch({
				reset: true,
				success: function () {
					if (nivelCollection.size() < 1) {
						alert('No hay información de niveles, por favor, configure los niveles.');
						return;
					}
					gradoCollection.fetch({
						reset: true,
						data: {
							idNivel: nivelCollection.at(0).get('idNivel')
						},
						success: function () {
							var view = new GradoView({
								nivelCollection: nivelCollection,
								gradoCollection: gradoCollection
							});
							app.main.show(view);
						}
					});
				}
			});
		},
		showSeccionView: function () {
			var view = new SeccionListView;
			app.main.show(view);
		}
	};
});