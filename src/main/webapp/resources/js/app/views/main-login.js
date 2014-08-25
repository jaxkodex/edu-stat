/**
 * 
 */

define(['marionette', 'templates/main-templates'], function (Marionette, templates) {
	return Marionette.ItemView.extend({
		template: templates.loginTemplate,
		events: {
			'submit form': 'doLogin'
		},
		doLogin: function (evt) {
			evt.preventDefault();
			var data = {
					username: this.$('#username').val(),
					username: this.$('#password').val()
			};
			this.model.set(data);
			console.log('Do login plz');
		}
	});
});