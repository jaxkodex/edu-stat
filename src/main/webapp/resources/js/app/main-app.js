/**
 * 
 */


define(['marionette', 
        'collections/usuario-collection', 
        'collections/institucioneducativa-collection', 
        'views/main-index', 
        'views/main-footer',
        'views/main-signup',
        'views/main-login'], function (Marionette, 
        		UserCollection, InstitucionEducativaCollection,
        		IndexView, FooterView, SignupView, LoginView) {
	var app = new Marionette.Application (), 
		userCollection = new UserCollection,
		institucionEducativaCollection = new InstitucionEducativaCollection;
	
	app.addRegions({
		header: '#header',
		main: '#main',
		footer: '#footer'
	});
	
	app.addInitializer(function () {
		app.main.show(new IndexView);
		app.footer.show(new FooterView);
	});
	
	app.vent.on('app:signup', function () {
		userCollection.reset({});
		app.main.show(new SignupView({
			institucionEducativaCollection: institucionEducativaCollection,
			model: userCollection.at(0)
		}));
	});
	
	app.vent.on('app:login', function () {
		userCollection.reset({});
		app.main.show(new LoginView({
			model: userCollection.at(0)
		}));
	});
	
	app.vent.on('app:index', function () {
		app.main.show(new IndexView);
	});
	
	return window.app = app;
});