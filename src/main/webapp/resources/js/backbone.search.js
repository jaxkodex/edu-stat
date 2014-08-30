/**
 * 
 */

define(['backbone', 'jquery', 'underscore'], function (Backbone, $, _) {
	var Search = function (options) {
		var me = this;
		this.options = options;
		
		this.$el = $(options.el);
		this.$renderEl = $(options.renderEl);
		
		this.$el.on('keyup', function (evt) {
			me.search(me.$el.val());
		});
		
		this.collection = new (Backbone.Collection.extend({
			model: options.collection.model,
			url: options.collection.url
		}))();
		this.query = '';
		this.callback = options.callback;
		
		$(this).on('search:select', function (selectedObject) {
			this.callback(selectedObject);
		});
		
		this.fetchXhr = null;
	};
	
	Search.prototype.search = function (query) {
		var me = this;
		this.query = query;
		
		if (this.fetchXhr != null && this.fetchXhr.readyState > 0 && this.fetchXhr.readyState < 4) {
			this.fetchXhr.abort();
		}
		
		this.fetchXhr = this.collection.fetch({
			data: {
				query: query
			},
			success: function () {
				me.showResults();
			}
		});
	};
	
	Search.prototype.showResults = function () {
		var me = this, container = document.createDocumentFragment();
		this.collection.each(function (val) {
			if (!_.isUndefined(me.options.template)) {
				var div = $('<div>');
				container.appendChild(div.append($(me.options.template(val.toJSON()))[0])[0]);
			}
		});
		this.$renderEl.empty().append(container);
	};
	
	return Search;
});