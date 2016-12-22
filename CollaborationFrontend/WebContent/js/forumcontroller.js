app.controller('ForumController',function($scope,$location,ForumService){
	$scope.forum={forumid:'',forumcomment:'',forumdate:'',forumtitle:'',username:''};
	$scope.saveForum=function(){
		console.log('entering save forum in forum controller')
		ForumService.saveForum($scope.forum)
		.then(function(response){
			console.log("successfully inserted forum details");
			alert("Posted forum successfully");
			$location.path("/home");
		},function(respone){
			console.log("failure " +response.status);
			$location.path("/forum");
		})
	}
})