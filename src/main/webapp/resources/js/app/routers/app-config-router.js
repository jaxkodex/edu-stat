define(['marionette'], function (Marionette) {
	return Marionette.AppRouter.extend({
		appRoutes: {
			'ie': 'showIePage',
			'config/docentes': 'showDocenteList',
			'config/docente/new': 'showNewDocenteForm'
		}
	});
});