/**
 * 
 */


define(['marionette'], function (Marionette) {
	var app = new Marionette.Application ();
	
	app.addRegions({
		menuWrapper: '#menu-wrapper',
		main: '#main',
		topbar: '#top-bar'
	});
	
	return window.app = app;
});