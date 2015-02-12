define(['backbone', 'marionette',
        'templates/app-templates', 'underscore', 'moment'], function (Backbone, Marionette,
                AppTemplates, _, moment) {
    var AperturaItemView, EmptyAperturaItemView;
    
    AperturaItemView = Marionette.ItemView.extend({
        tagName: 'tr',
        events: {
			'dblclick .editable': 'editRow',
            'click .btn-delete': 'deleteMe',
            'click .btn-save': 'saveMe'
        },
        modelEvents: {
        	'invalid': 'invalidEventHandler',
        	'sync': 'render'
        },
        onRender: function () {
        	this.$el.removeClass('editing');
            if (this.model.isNew()) {
                this.$el.addClass('editing');
            }
        },
        template: AppTemplates.periodoAcademicoItemListTemplate,
        editRow: function (evt) {
			this.$el.addClass('editing');
			this.$('input').focus();
		},
		deleteMe: function (evt) {
            evt.preventDefault();
            this.model.destroy();
        },
        saveMe: function (evt) {
            evt.preventDefault();
            var obj, me;
            
            me = this;
            obj = {
                    periodoNombre: this.$('input[name=periodoNombre]').val().trim(),
                    periodoFinicio: moment(this.$('input[name=periodoFinicio]').val().trim()).toDate().getTime(),
                    periodoFfin: moment(this.$('input[name=periodoFfin]').val().trim()).toDate().getTime(),
                    periodoEstado: this.$('select[name=periodoEstado]').val()
            };
            this.model.set(obj).save({}, {
            	error: function (model, response, options) {
            		console.log(model, response, options);
            		alert('Ocurrio un error al realizar su registro');
            	}
            });
        },
        invalidEventHandler: function (model, error, options) {
        	console.log(this.model.validationError);
        	console.log(error);
        }
    });
    
    EmptyAperturaItemView = Marionette.ItemView.extend({
        tagName: 'tr',
        template: _.template('<td colspan="5" class="text-center"><em>Sin data</em></td>')
    });
    
    return Marionette.CompositeView.extend({
        events: {
            'click .aperturar-periodo': 'aperturarPeriodo'
        },
        childView: AperturaItemView,
        childViewContainer: 'tbody',
        emptyView: EmptyAperturaItemView,
        template: AppTemplates.periodoAcademicoListTemplate,
        aperturarPeriodo: function () {
            this.collection.add({});
        }
    });
});