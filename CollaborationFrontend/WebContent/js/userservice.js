app.factory('UserService',function($http){
	var userService=this;
	var BASE_URL="http://localhost:8010/collaborationBackend/"
	userService.authenticate=function(user){
		return $http.post(BASE_URL + "/login",user);
	}
	
	userService.registerUser=function(user){
		return $http.post(BASE_URL + "user",user);
	}
	
	return userService;
})