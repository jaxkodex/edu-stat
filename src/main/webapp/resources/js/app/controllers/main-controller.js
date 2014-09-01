/**
 * 
 */


define(['main-app',
        'collections/usuario-collection', 
        'collections/institucioneducativa-collection', 
        'views/main-index', 
        'views/main-signup',
        'views/main-login'], function (app,
        		UserCollection, InstitucionEducativaCollection,
        		IndexView, 	SignupView, LoginView) {
	var userCollection = new UserCollection,
	institucionEducativaCollection = new InstitucionEducativaCollection;
	
	return {
		showSignupForm: function () {
			userCollection.reset({});
			app.main.show(new SignupView({
				institucionEducativaCollection: institucionEducativaCollection,
				model: userCollection.at(0)
			}));
		},
		showLoginForm: function () {
			userCollection.reset({});
			app.main.show(new LoginView({
				model: userCollection.at(0)
			}));
		},
		showIndex: function () {
			app.main.show(new IndexView);
		}
	};
});