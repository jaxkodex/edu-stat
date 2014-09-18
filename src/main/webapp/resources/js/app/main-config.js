/**
 * 
 */

require.config({
	shim: {
		underscore: {
			exports: '_'
		},
		backbone: {
			deps: ['underscore', 'jquery'],
			exports: 'Backbone'
		},
		bootstrap: {
			deps: ['jquery'],
			exports: '$.fn.popover'
		},
		marionette: {
			deps: ['jquery', 'underscore', 'backbone'],
			exports: 'Marionette'
		}
	},
	paths: {
		jquery: '../jquery-1.11.1',
		underscore: '../underscore',
		backbone: '../backbone',
		bootstrap: '../bootstrap.min',
		marionette: '../backbone.marionette',
		tpl: '../tpl'
	}
});

require(['main-app', 
         'backbone', 
         'routers/main-router', 
         'controllers/main-controller'], function (app, Backbone, MainRouter, mainController) {
	app.addInitializer(function () {
		new MainRouter({controller: mainController});
		
		Backbone.history.start();
	});
	
	app.start();
});