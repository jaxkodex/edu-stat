define(['web-app',
        'models/institucioneducativa-model', 'models/docente-model', 'models/nivel-model',
        'models/grado-model', 'models/periodoacademico-model',
        'models/clase-model',
        'collections/docente-collection', 'collections/nivel-collection',
        'collections/grado-collection', 'collections/periodoacademico-collection',
        'collections/turno-collection', 'collections/clase-collection',
        'views/app-ie', 'views/app-docentelist', 'views/app-docenteform', 'views/app-nivel',
        'views/app-grado', 'views/app-seccionlist', 'views/app-periodoacademico',
        'views/app-clases', 'views/app-config-fichamonitoreo', 'views/app-config-fichamonitoreo-form',
        'views/app-claseform',
        'views/app-config-cargasigie-form',
        'backbone', 'underscore'], function (app,
                InstitucionEducativaModel, DocenteModel, NivelModel,
                GradoModel, PeriodoAcademicoModel,
                ClaseModel,
                DocenteCollection, NivelCollection,
                GradoCollection, PeriodoAcademicoCollection,
                TurnoCollection, ClaseCollection,
                IeDataView, DocenteListView, DocenteFormView, NivelView,
                GradoView, SeccionListView, PeriodoAcademicoView,
                ClasesView, AppConfigFichaMonitoreoListView, AppConfigFichaMonitoreoFormView,
                ClaseFormView,
                AppConfigCargaSiagieFormView,
                Backbone, _) {
    var docenteCollection, nivelCollection, gradoCollection, 
        periodoAcademicoCollection, turnoCollection, claseCollection;
    
    gradoCollection = new GradoCollection;
    docenteCollection = new DocenteCollection;
    nivelCollection = new NivelCollection;
    periodoAcademicoCollection = new PeriodoAcademicoCollection;
    turnoCollection = new TurnoCollection;
    claseCollection = new ClaseCollection;
    
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
                	turnoCollection.fetch({
                		reset: true,
                		success: function () {
                			nivelCollection.fetch({
                				reset: true,
                				success: function () {
                                    var view = new ClasesView({
                                        model: new Backbone.Model({
                                        	periodos: periodoAcademicoCollection.toJSON(),
                                        	turnos: turnoCollection.toJSON(),
                                        	niveles: nivelCollection.toJSON()
                                        })
                                    });
                                    app.main.show(view);
                				}
                			});
                		}
                	});
                }
            });
        },
        showClaseFormView: function (idClase) {
        	var me, clase, view;
        	me = this;
        	clase = claseCollection.get(idClase);
        	if (_.isUndefined(clase)) {
        		clase = new ClaseModel({
        			idClase: idClase
        		});
        		claseCollection.add(clase);
        	}
        	clase.fetch({
        		success: function () {
        			view = new ClaseFormView;
        			app.main.show(view);
        		}
        	});
        },
        showFichaDeMonitoreoListConfigView: function () {
            var me, view;
            me = this;
            view = new AppConfigFichaMonitoreoListView;
            app.main.show(view);
            view.on('go:new:fichamonitoreo', function () {
                me.showNewFichaDeMonitoreoConfigView();
                Backbone.history.navigate('config/newfichamonitoreo');
            });
        },
        showNewFichaDeMonitoreoConfigView: function () {
            var view;
            view = new AppConfigFichaMonitoreoFormView;
            app.main.show(view);
        },
        showCargaSiagieFormView: function () {
            var view;
            view = new AppConfigCargaSiagieFormView;
            app.main.show(view);
        }
    };
});