/**
 * 
 */

define(['backbone', 'jquery'], function (Backbone, $) {
	var Search = function (options) {
		var me = this;
		this.options = options;
		
		this.$el = $(options.el);
		
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
		console.log('Result size: '+this.collection.size());
	};
	
	return Search;
});