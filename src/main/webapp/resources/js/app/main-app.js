/**
 * 
 */


define(['marionette',
        'views/main-footer'], function (Marionette, FooterView) {
	var app = new Marionette.Application ();
	
	app.addRegions({
		header: '#header',
		main: '#main',
		footer: '#footer'
	});
	
	app.addInitializer(function () {
		app.footer.show(new FooterView);
	});
	
	return window.app = app;
});