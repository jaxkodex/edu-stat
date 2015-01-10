/**
 * 
 */

define(['marionette', 
        'templates/main-templates', 
        'underscore',
        'backbone'], function (Marionette, templates, _, Backbone) {
	var resultItemView = Marionette.ItemView.extend({
		template: _.template('<b><%=institucionEducativaNombre%></b>'),
		events: {
			'click': 'onClick'
		},
		onClick: function (evt) {
			this.model.collection.trigger('select', this.model);
		}
	});
	var resultView = Marionette.CompositeView.extend({
		template: _.template(''),
		childView: resultItemView,
		collectionEvents: {
			'select': 'pickSchool'
		},
		pickSchool: function (model) {
			this.trigger('select', model);
		},
		onBeforeRender: function () {
			this.$el.animate({'left': '-200px', 'opacity': '0'}, {
				duration: 200	
			});
		},
		onRender: function () {
			this.$el.css('display', 'block').animate({'left': '0px', 'opacity': '1'}, {
				duration: 200	
			});
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
				
				this.resultsView.on('select', function (model) {
					me.selectSchool(model);
				});
			}
			if (this.fetchXhr != null && this.fetchXhr.readyState > 0 && this.fetchXhr.readyState < 4) {
				this.fetchXhr.abort();
			}
			this.resultsView.$el.css({ display: 'block'}).animate({'left': '0px', 'opacity': '1'}, {
				duration: 200	
			});
			this.fetchXhr = this.options.institucionEducativaCollection.fetch({
				data: {
					q: this.$('#institucioneducativa').val()
				}
			});
		},
		selectSchool: function (model) {
			var me = this, $userDataForm = this.$('#user-data-signup');
			this.$('#institucioneducativa').val(model.get('institucionEducativaNombre'));
			this.institucionEducativa = model;
			this.resultsView.$el.css('position', 'relative')
				.animate({'left': '-200px', 'opacity': '0'}, {
					duration: 200,
					complete: function () {
						me.resultsView.$el.css('display', 'none');
						$userDataForm.css({
							position: 'relative',
							display: 'block',
							left: '-200px',
							opacity: '0'
						}).animate({'left': '0px', 'opacity': '1'}, {
							duration: 200
						});
					}
				});
		},
		doRegistration: function (evt) {
			evt.preventDefault();
			var $ie_name = this.$('#institucioneducativa'), institucionEducativa = {}, me = this;
			if (_.isUndefined(this.institucionEducativa) && $ie_name.val() != '') {
				institucionEducativa = {
						institucionEducativaNombre: $ie_name.val()
				};
			} else {
				institucionEducativa = this.institucionEducativa.toJSON();
			}
			var obj = {
					username: this.$('#username').val(),
					password: this.$('#password').val(),
					persona: {
						primerNombre: this.$('#pnombre').val(),
						segundoNombre: this.$('#snombre').val(),
						apellidoPaterno: this.$('#apaterno').val(),
						apellidoMaterno: this.$('#amaterno').val(),
						dni: this.$('#dni').val()
					},
					institucionEducativa: institucionEducativa
			};
			if (obj.password != this.$('#password2').val()) {
				alert('Las contraseñas no coinciden');
				return;
			}
			this.model.save(obj, {
				success: function () {
					me.$('form').parent().animate({'left': '-200px', 'opacity': '0'}, {
						duration: 200,
						complete: function () {
							me.$('form').parent().css('display', 'none');
							me.$('.bg-success').removeClass('hidden');
						}
					});
				}
			});
		}
	});
});