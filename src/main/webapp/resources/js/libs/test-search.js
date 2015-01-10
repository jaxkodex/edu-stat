require.config({
	shim: {
		underscore: {
			exports: '_'
		},
		backbone: {
			deps: ['underscore', 'jquery'],
			exports: 'Backbone'
		},
		bootstrap: {
			deps: ['jquery'],
			exports: '$.fn.popover'
		},
		marionette: {
			deps: ['jquery', 'underscore', 'backbone'],
			exports: 'Marionette'
		}
	},
	paths: {
		jquery: 'jquery-1.11.1',
		underscore: 'underscore',
		backbone: 'backbone',
		bootstrap: 'bootstrap.min',
		marionette: 'backbone.marionette',
		tpl: 'tpl'
	}
});

require(['backbone.search'], function (Search) {
	var UsuarioModel = Backbone.Model.extend({});
	var UsuarioCollection = Backbone.Collection.extend({
		url: 'public/api/usuario',
		model: UsuarioModel
	});
	var s = new Search({
		el: '#testme',
		renderEl: '#testme_results',
		collection: new UsuarioCollection,
		callback: function (data) {
			console.log('This a test callback');
		},
		template: _.template('<b><%=username%></b>')
	});
});