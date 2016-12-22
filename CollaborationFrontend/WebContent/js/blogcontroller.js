app.controller('BlogController',function($scope,$location,BlogService){
	$scope.blog={blogid:'',blogcontent:'',blogdate:'',blogname:''};
	$scope.saveBlog=function(){
		console.log('entering save blog in blog controller')
		BlogService.saveBlog($scope.blog)
		.then(function(response){
			console.log("successfully inserted blog details");
			alert("Posted blog successfully");
			$location.path("/home");
		},function(respone){
			console.log("failure " +response.status);
			$location.path("/blog");
		})
	}
})
		
		
	/*$scope.message;
	$scope.submit=function(){
		console.log('Entering - submit function in blogcontroller')
		BlogService.authenticate($scope.blog)
		.then(function(response){
				$scope.blog=response.data;
				$location.path("/home");
		},
		function(response){//invalid user name and password - failure 
			 console.log('invalid username and password')
			  $scope.message="Invalid Username and Password";
			  $location.path("/blog");
		})
	}
	
	$scope.registerBlog=function(){
		console.log('entering registerBlog')
		BlogService.registerBlog($scope.blog)
		.then(function(response){ //success 
			console.log("registration success" + response.status)
			$location.path("/home");
		},function(response){//failure
			console.log("registration failed" + response.status)
			console.log(response.data)
			$scope.errorMessage="Registration failed...." + response.data.message
			$location.path("/blog")*/
		