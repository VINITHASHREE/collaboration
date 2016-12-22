var app=angular.module("myApp",['ngRoute'])
app.config(function($routeProvider){
	console.log('entering configuration')
	$routeProvider
	.when('/login',{
		controller:'UserController',
		templateUrl:'login.html'
	})
	.when('/home',{
		templateUrl:'home.html'
	})
	.when('/register',{
		controller:'UserController',
		templateUrl:'register.html',
		/*controllerAs:'u'*/
	})
	.when('/blog',{
		controller:'BlogController',
		templateUrl:'blog.html'
	
	})
	.when('/job',{
		controller:'JobController',
		templateUrl:'job.html'
		
	})
	.when('/forum',{
		controller:'ForumController',
		templateUrl:'forum.html'
		
	})
})