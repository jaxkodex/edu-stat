

define(['marionette', 'templates/app-templates'], function (Marionette, templates) {
	return Marionette.ItemView.extend({
		template: templates.topbarTemplate,
		events: {
			'click li': 'onClickMenu'
		},
		onClickMenu: function (evt) {
			var target = evt.target.tagName == 'li' ? $(evt.target) : $(evt.target).parent();
			this.$el.find('li').removeClass('active');
			target.addClass('active');
		}
	});
});