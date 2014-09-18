define(['web-app',
        'views/app-userhome',
        'views/app-userprofile'], function (app, 
        		UserHomeView, UserProfileView) {
	
	return {
		showStartPage: function () {
			var view = new UserHomeView();
			app.main.show(view);
		},
		showProfile: function () {
			var view = new UserProfileView({
				model: app.collections.userCollection.at(0)
			});
			app.main.show(view);
		}
	};
});