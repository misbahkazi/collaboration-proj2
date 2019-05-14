myApp.controller("ForumController",function($scope,$http,$location,$rootScope,$cookieStore)
             {
	
	          $scope.forum={'forumName':'','forumContent':'','username':'','status':''}
	          $scope.forumData;
	          $rootScope.forumInfo;
	          
	          $scope.forumComment={'commentId':0,'blogId':0,'commentText':'','commentDate':'','username':''};
	          
	          $scope.addForum=function()
	          {
	        	  console.log('Adding Forum');
	        	  
	        	  $scope.forum.username=$rootScope.currentUser.username;
	        	  $scope.forum.status='NA';
	        	 
	        	  
	        	  $http.post('http://localhost:8084/YammerMiddleware/addForum',$scope.forum)
	        	  .then(function(response)
	        			  {
	        		        console.log('Forum Added');  
	        		        console.log(response.data);
	        		  
	        			  });
	        	  
	        	  
	          }
	          
	          function loadForum()
	          {
	        	  console.log('Loading all Forums');
	        	  $http.get('http://localhost:8084/YammerMiddleware/getForumDetails')
	        	  .then(function(response)
	        {
	        	  console.log('Loading Forum');
	        	  $scope.forumData=response.data;
	        	  console.log($scope.forumData);
	        	  
	        	  
	          });
	      }
	          
	          
	          $scope.updateForum=function()
				{
					console.log('I am in update Forum');
					$scope.forum=$rootScope.forumInfo;
					$http.post('http://localhost:8084/YammerMiddleware/updateForum/',$scope.forum)
					.then(function(response)
							{
								console.log('Forum is Updated');
								$location.path('/showForum');
					});
				}
	          
	        
	          
	          $scope.approvedForum=function(forumId)
	          {
	        	  console.log('Forum Accepted');
	        	  $http.get('http://localhost:8084/YammerMiddleware/approvedForum/'+forumId)
	        	  .then(function(response)
	        			  {
	        			  
	          });
	          }
	          
	          $scope.rejectForum=function(forumId)
	          {
	        	  console.log('Forum Rejected');
	        	  $http.get('http://localhost:8084/YammerMiddleware/rejectForum/'+forumId)
	        	  .then(function(response)
	        			  {
	        			  
	          });
	          }
	          
	          $scope.deleteForum=function(forumId)
	          {
	        	  console.log('Forum Deleted');
	        	  $http.get('http://localhost:8084/YammerMiddleware/deleteForum/'+forumId)
	        	  .then(function(response)
	        			  {
	        			  
	          });
	          }
	          
	          $scope.showForum=function(forumId)
				{
	        	  console.log('Showing Details of Forum');
					$http.get('http://localhost:8084/YammerMiddleware/getForum/'+forumId)
					.then(function(response)
							{
								$rootScope.forumInfo=response.data;
								console.log("ShowingDetails");
								$location.path('/forumDetail');
							});
					$http.get('http://localhost:8084/YammerMiddleware/getForumComment/'+forumId)
					.then(function(response)
							{
						console.log('Status text:' + response.statusText);
						$scope.forumComments = response.data;
						console.log(response.data);
						
							});
				}
				
	          
	          
	          loadForum();
	
             }); 
 
 