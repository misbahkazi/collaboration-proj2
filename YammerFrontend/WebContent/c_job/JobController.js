myApp.controller("JobController",function($scope,$http,$location,$rootScope,$cookieStore)
		{
			$scope.job={'designation':'','username':'','lastDate':'','qualification':'','jobDesc':'','status':''}
			$scope.jobData;
			$rootScope.jobInfo;
			
		
			function loadJob()
			{
				console.log('Loading All Jobs');
				$http.get('http://localhost:8084/YammerMiddleware/getJobDetails')
				.then(function(response)
				{
					console.log('Loading Job');
					$scope.jobData=response.data;
					console.log($scope.jobData);
				});
			}
			
			function addJob()
			{
				 console.log('Adding Job');
		       	  
		       	  $scope.job.username=$rootScope.currentUser.username;
		       	  $scope.job.status='P';
		       	 
		       	  
		       	  $http.post('http://localhost:8084/YammerMiddleware/addJob',$scope.job)
		       	  .then(function(response)
		       			  {
		       		        console.log('Job Added');  
		       		        console.log(response.data);
				});
			}
			
			  $scope.deleteJob=function(jobId)
	          {
	        	  console.log('Job Deleted');
	        	  $http.get('http://localhost:8084/YammerMiddleware/deleteJob/'+jobId)
	        	  .then(function(response)
	        			  {
	        			  
	          });
	          }
			
			$scope.updateJob=function()
			{
				console.log('I am in update Job');
				$scope.job=$rootScope.jobInfo;
				$http.post('http://localhost:8084/YammerMiddleware/updateJob/',$scope.job)
				.then(function(response)
						{
							console.log('Job is Updated');
							$location.path('/showJob');
				});
			}
			  
	loadJob();
});