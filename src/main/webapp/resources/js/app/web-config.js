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

require(['web-app',
         'backbone',
         'collections/usuario-collection',
         'views/app-menu',
         'views/app-topbar',
         'routers/app-router',
         'controllers/app-user-controller'], function (app, Backbone,
        		 UserCollection, 
        		 AppMenuView, AppTopbarView,
        		 AppRouter,
        		 userController) {
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
		Backbone.history.start();
	});
	
	app.start();
});