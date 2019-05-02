myApp.controller("JobController",function($scope,$http,$location,$rootScope)
		{
			$scope.job={'designation':'','jobExperience':'','jobDesc':'','companyName':''}
			$scope.jobData;
			$rootScope.jobInfo;
			
			
			alert('JobController')
			
			
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
				alert('adding Job')
				$http.get('http://localhost:8084/YammerMiddleware/addJob',$scope.job)
				.then(function(response)
				{
					$scope.jobData=response.data;
					console.log($scope.jobData);
				});
			}
			
			
			$scope.showJob=function(blogId)
			{
					console.log('Showing Details of Job'); 
					$http.get('http://localhost:8084/YammerMiddleware/getJob/',$scope.jobId)
					.then(function(response)
							{
								$rootscope.jobInfo=response.data;
								console.log($rootScope.job);
								$location.path('/showJob');
							});
			}
			
			$scope.updateJob=function()
			{
				console.log('I am in update Job');
				$scope.job=$rootScope.jobInfo;
				$http.get('http://localhost:8084/YammerMiddleware/updateJob/',$scope.jobId)
				.then(function(response)
						{
							console.log('Job is Updated');
							$location.path('/showJobDetail');
				});
			}
			
	loadJob();
});