/**
 * 
 */


define(['main-app'], function (app, SignupView) {
	return {
		showSignupForm: function () {
			app.vent.trigger('app:signup');
		},
		showLoginForm: function () {
			app.vent.trigger('app:login');
		},
		showIndex: function () {
			app.vent.trigger('app:index');
		}
	};
});