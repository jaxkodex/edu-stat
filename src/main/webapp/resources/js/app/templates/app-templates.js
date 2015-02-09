/**
 * 
 */

define(function (require) {
	return {
		// Docentes
		mantenimientoDocenteListTemplate: require('tpl!templates/html/app-docentelist.tpl'),
		mantenimientoDocenteItemListTemplate: require('tpl!templates/html/app-docenteitemlist.tpl'),
		mantenimientoDocenteFormTemplate: require('tpl!templates/html/app-docenteform.tpl'),
		
		// Niveles
		mantenimientoNivelListTemplate: require('tpl!templates/html/app-nivellist.tpl'),
		
		// Grados
		mantenimientoGradoListTemplate: require('tpl!templates/html/app-gradolist.tpl'),
		
		// Secciones
		mantenimientoSeccionListTemplate: require('tpl!templates/html/app-seccionlist.tpl'),
		
		// Periodos Acad�micos
		periodoAcademicoListTemplate: require('tpl!templates/html/app-periodoacademico.tpl'),
		periodoAcademicoItemListTemplate: require('tpl!templates/html/app-periodoacademicoitem.tpl'),
		
		menuTemplate: require('tpl!templates/html/app-menu.tpl'),
		topbarTemplate: require('tpl!templates/html/app-topbar.tpl'),
		userprofileTemplate: require('tpl!templates/html/app-userprofile.tpl'),
		userhomeTemplate: require('tpl!templates/html/app-userhome.tpl'),
		ieTemplate: require('tpl!templates/html/app-ie.html')
	};
});