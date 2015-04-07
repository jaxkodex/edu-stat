define (['marionette', 'tpl!templates/html/app-claseform.tpl'], function (Marionette, claseFormTemplate) {
	return Marionette.CompositeView.extend({
		template: claseFormTemplate
	});
});