/**
 * 
 */

define(['marionette', 
        'templates/main-templates', 
        'underscore'], function (Marionette, templates, _) {
	var resultItemView = Marionette.ItemView.extend({
		template: _.template('<b><%=institucionEducativaNombre%></b>'),
		events: {
			'click': 'onClick'
		},
		onClick: function (evt) {
			console.log(this.model.toJSON());
			this.model.set('institucionEducativaNombre', 'asdf');
			console.log(this.model.toJSON());
		}
	});
	var resultView = Marionette.CompositeView.extend({
		template: _.template(''),
		childView: resultItemView,
		modelEvents: {
			'change': 'pickSchool'
		},
		collectionEvents: {
			'add': 'added'
		},
		pickSchool: function () {
			console.log('This should be triggered');
			console.log(evt, args);
		},
		added: function (evt) {
			console.log('new added');
		}
	});
	
	
	return Marionette.ItemView.extend({
		initialize: function (options) {
			this.options = options;
			this.fetchXhr = null;
		},
		template: templates.signupTemplate,
		events: {
			'submit form': 'doRegistration',
			'keyup #institucioneducativa': 'onKeyupInsitutucioneducativa'
		},
		onKeyupInsitutucioneducativa: function (evt) {
			var me = this;
			if (_.isUndefined(this.resultsView)) {
				this.resultsView = new resultView({
					collection: me.options.institucionEducativaCollection
				});
				this.$('#institucioneducativa-search-results').append(this.resultsView.render().$el);
			}
			if (this.fetchXhr != null && this.fetchXhr.readyState > 0 && this.fetchXhr.readyState < 4) {
				this.fetchXhr.abort();
			}
			this.fetchXhr = this.options.institucionEducativaCollection.fetch({
				data: {
					q: this.$('#institucioneducativa').val()
				}
			});
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