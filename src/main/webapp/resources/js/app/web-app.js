/**
 * 
 */


define(['marionette'], function (Marionette) {
	var app = new Marionette.Application ();
	
	app.addRegions({
		menuwrapper: '#menu-wrapper',
		main: '#main'
	});
	
	app.addInitializer(function () { 
	});
	
	return window.app = app;
});