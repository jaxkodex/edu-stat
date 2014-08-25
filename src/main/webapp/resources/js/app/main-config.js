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
         'controllers/main-controller'], function (app, Backbone, Router, controller) {
	app.start();
	console.log('asasd');
	console.log(controller);
	
	new Router({controller: controller});
	
	Backbone.history.start();
});