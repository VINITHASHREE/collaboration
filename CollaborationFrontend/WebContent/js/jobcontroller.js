app.controller('JobController',function($scope,$location,JobService){
	$scope.job={jobid:'',companyname:'',designation:'',details:'',address:''};
	$scope.saveJob=function(){
		console.log('entering save job in job controller')
		JobService.saveJob($scope.job)
		.then(function(response){
			console.log("successfully inserted job details");
			alert("Posted job successfully");
			$location.path("/home");
		},function(respone){
			console.log("failure " +response.status);
			$location.path("/job");
		})
	}
})