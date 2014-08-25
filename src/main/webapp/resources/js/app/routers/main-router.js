/**
 * 
 */

define(['marionette'], function (Marionette) {
	return Marionette.AppRouter.extend({
		appRoutes: {
			'signup': 'showSignupForm',
			'login': 'showLoginForm',
			'home': 'showIndex'
		}
	});
});