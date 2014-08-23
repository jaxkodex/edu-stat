/**
 * 
 */


define(['main-app'], function (app) {
	return {
		appIndex: function () {
			app.vent.trigger('app:index');
		},
		runTestRoute: function () {
			console.log('do route plz');
		}
	};
});