/**
 * 
 */


define(['marionette', 'views/main-workspace'], function (Marionette, Workspace) {
	var app = new Marionette.Application ();
	
	app.addRegions({
		header: '#header',
		menu: '#menu',
		workspace: '#main',
		footer: '#footer'
	});
	
	app.addInitializer(function () {
		console.log('Initialize');
		app.workspace.show(new Workspace());
	});
	
	app.vent.on('app:index', function () {
		
	});
	
	return window.app = app;
});