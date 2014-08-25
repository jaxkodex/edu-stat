/**
 * 
 */

define(['marionette', 'templates/main-templates'], function (Marionette, templates) {
	return Marionette.ItemView.extend({
		template: templates.signupTemplate,
		events: {
			'submit form': 'doRegistration'
		},
		doRegistration: function (evt) {
			evt.preventDefault();
			var obj = {
					username: this.$('#username').val(),
					password: this.$('#password').val(),
					persona: {
						primerNombre: this.$('#pnombre').val(),
						segundoNombre: this.$('#snombre').val(),
						apellidoPaterno: this.$('#apaterno').val(),
						apellidoMaterno: this.$('#amaterno').val(),
						dni: this.$('#dni').val()
					}
			};
			if (obj.password != this.$('#password2').val()) {
				alert('Las contraseñas no coinciden');
				return;
			} 
			this.model.save(obj);
		}
	});
});