define(['web-app',
        'models/institucioneducativa-model', 'models/docente-model', 'models/nivel-model',
        'models/grado-model', 'models/periodoacademico-model',
        'collections/docente-collection', 'collections/nivel-collection',
        'collections/grado-collection', 'collections/periodoacademico-collection', 
        'views/app-ie', 'views/app-docentelist', 'views/app-docenteform', 'views/app-nivel',
        'views/app-grado', 'views/app-seccionlist', 'views/app-periodoacademico',
        'views/app-clases',
        'backbone'], function (app,
        		InstitucionEducativaModel, DocenteModel, NivelModel,
        		GradoModel, PeriodoAcademicoModel,
        		DocenteCollection, NivelCollection,
        		GradoCollection, PeriodoAcademicoCollection,
        		IeDataView, DocenteListView, DocenteFormView, NivelView,
        		GradoView, SeccionListView, PeriodoAcademicoView,
        		ClasesView,
        		Backbone) {
	var docenteCollection, nivelCollection, gradoCollection, periodoAcademicoCollection;
	
	gradoCollection = new GradoCollection;
	docenteCollection = new DocenteCollection;
	nivelCollection = new NivelCollection;
	periodoAcademicoCollection = new PeriodoAcademicoCollection;
	
	return {
		showIePage: function () {
			var view = new IeDataView({
				model: new InstitucionEducativaModel(userData.institucionEducativa)
			});
			app.main.show(view);
		},
		showPeriodoAcademico: function () {
			periodoAcademicoCollection.fetch({
				reset: true,
				success: function () {
					var view = new PeriodoAcademicoView({
						model: new InstitucionEducativaModel(userData.institucionEducativa),
						collection: periodoAcademicoCollection
					});
					app.main.show(view);
				}
			});
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
			var model, view, me;
			me = this;
			model = new DocenteModel;
			docenteCollection.add(model);
			view = new DocenteFormView({
				model: model
			});
			view.on('docente:saved', function () {
				me.showDocenteList();
				Backbone.history.navigate('config/docentes');
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
		},
		showClasesView: function () {
			periodoAcademicoCollection.fetch({
				reset: true,
				success: function () {
					var view = new ClasesView;
					app.main.show(view);
				}
			});
		}
	};
});