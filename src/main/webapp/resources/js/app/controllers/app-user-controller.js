define(['web-app',
        'views/app-userhome',
        'views/app-userprofile'], function (app, 
        		UserHomeView, UserProfileView) {
	
	return {
		showStartPage: function () {
			var view = new UserHomeView();
			app.main.show(view);
			view.$('#chart-1').highcharts({
				chart: {
					width: view.$('#chart-1').width()
				},
		        title: {
		            text: 'Número de docentes con buena calificación',
		            x: -20 //center
		        },
		        subtitle: {
		            text: 'Última actualización: 20/12/2014',
		            x: -20
		        },
		        xAxis: {
		            categories: ['Mar', 'Abr', 'May', 'Jun',
		                'Jul', 'Ago', 'Sep', 'Oct', 'Nov', 'Dic']
		        },
		        yAxis: {
		            title: {
		                text: 'Cantidad de Docentes'
		            },
		            plotLines: [{
		                value: 0,
		                width: 1,
		                color: '#808080'
		            }]
		        },
		        tooltip: {
		            valueSuffix: '#'
		        },
		        legend: {
		            layout: 'vertical',
		            align: 'right',
		            verticalAlign: 'middle',
		            borderWidth: 0
		        },
		        series: [{
		            name: 'Docentes',
		            data: [7.0, 6.9, 9.5, 10.5, 8.2, 11.5, 11.2, 8.5, 13.3, 18.3, 13.9, 9.6]
		        }]
		    });
			view.$('#chart-2').highcharts({
				chart: {
					width: view.$('#chart-1').width()
				},
		        title: {
		            text: 'Promedio de calificación docente',
		            x: -20 //center
		        },
		        subtitle: {
		        	text: 'Última actualización: 20/12/2014',
		            x: -20
		        },
		        xAxis: {
		            categories: ['Mar', 'Abr', 'May', 'Jun',
		 		                'Jul', 'Ago', 'Sep', 'Oct', 'Nov', 'Dic']
		        },
		        yAxis: {
		            title: {
		                text: 'Calificación Monitoreo'
		            },
		            plotLines: [{
		                value: 0,
		                width: 1,
		                color: '#808080'
		            }]
		        },
		        tooltip: {
		            valueSuffix: '#'
		        },
		        legend: {
		            layout: 'vertical',
		            align: 'right',
		            verticalAlign: 'middle',
		            borderWidth: 0
		        },
		        series: [{
		            name: 'Promedio Monitoreo',
		            data: [14, 18, 15, 16, 16, 14, 13, 15, 16, 16]
		        }]
		    });
			view.$('#chart-3').highcharts({
				chart: {
					width: view.$('#chart-3').width()
				},
		        title: {
		            text: 'Calificación estudiante promedio',
		            x: -20 //center
		        },
		        subtitle: {
		        	text: 'Última actualización: 20/12/2014',
		            x: -20
		        },
		        xAxis: {
		            categories: ['Mar', 'Abr', 'May', 'Jun',
			 		                'Jul', 'Ago', 'Sep', 'Oct', 'Nov', 'Dic']
		        },
		        yAxis: {
		            title: {
		                text: 'Calificación'
		            },
		            plotLines: [{
		                value: 0,
		                width: 1,
		                color: '#808080'
		            }]
		        },
		        tooltip: {
		            valueSuffix: ''
		        },
		        legend: {
		            layout: 'vertical',
		            align: 'right',
		            verticalAlign: 'middle',
		            borderWidth: 0
		        },
		        series: [{
		            name: 'Calificación',
		            data: [11, 14, 15, 17, 16, 18, 14, 16, 13, 15]
		        }]
		    });
			view.$('#chart-4').highcharts({
				chart: {
					width: view.$('#chart-4').width()
				},
		        title: {
		            text: 'Cantidad de estudiantes restrasados',
		            x: -20 //center
		        },
		        subtitle: {
		        	text: 'Última actualización: 20/12/2014',
		            x: -20
		        },
		        xAxis: {
		            categories: ['Mar', 'Abr', 'May', 'Jun',
			 		                'Jul', 'Ago', 'Sep', 'Oct', 'Nov', 'Dic']
		        },
		        yAxis: {
		            title: {
		                text: 'Estudiantes'
		            },
		            plotLines: [{
		                value: 0,
		                width: 1,
		                color: '#808080'
		            }]
		        },
		        tooltip: {
		            valueSuffix: '°C'
		        },
		        legend: {
		            layout: 'vertical',
		            align: 'right',
		            verticalAlign: 'middle',
		            borderWidth: 0
		        },
		        series: [{
		            name: 'Estudiantes',
		            data: [25, 10, 14, 17, 18, 10, 11, 12, 11, 10]
		        }]
		    });
		},
		showProfile: function () {
			var view = new UserProfileView({
				model: app.collections.userCollection.at(0)
			});
			app.main.show(view);
		}
	};
});