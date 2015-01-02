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
		jquery: '../libs/jquery-1.11.1',
		underscore: '../libs/underscore',
		backbone: '../libs/backbone',
		bootstrap: '../libs/bootstrap.min',
		marionette: '../libs/backbone.marionette',
		tpl: '../libs/tpl'
	},
	urlArgs: "bust=" + (new Date()).getTime()
});

require(['web-app',
         'backbone',
         'collections/usuario-collection',
         'views/app-menu',
         'views/app-topbar',
         'routers/app-router',
         'routers/app-config-router',
         'controllers/app-user-controller',
         'controllers/app-config-controller'], function (app, Backbone,
        		 UserCollection, 
        		 AppMenuView, AppTopbarView,
        		 AppRouter, AppConfigRouter,
        		 userController, AppConfigController) {
	app.addInitializer(function () {
		// workspace initialization
		this.collections = this.collection || {};
		this.collections.userCollection = new UserCollection([userData]);
		
		this.menuWrapper.show(new AppMenuView);
		this.topbar.show(new AppTopbarView({ model: this.collections.userCollection.at(0) }));
	});
	
	app.addInitializer(function () {
		//Initialize all routers here
		new AppRouter({controller: userController});
		new AppConfigRouter({controller: AppConfigController});
		
		Backbone.history.start();
	});
	
	app.start();
});