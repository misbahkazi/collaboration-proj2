myApp.controller("ForumController",function($scope,$http,$location,$rootScope,$cookieStore)
             {
	
	          $scope.forum={'forumName':'','forumContent':'','username':'','status':''}
	          $scope.forumData;
	          
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
	        	  console.log('Display Forum Details');
	        	  $http.get('http://localhost:8084/YammerMiddleware/getForum/'+forumId)
	        	  .then(function(response)
	        			  {
	        		  $scope.forum=response.data;
	        		  console.log($scope.forum);
	        			  
	          });
	          }
	          
	          
	          
	          loadForum();
	
             }); 
 
 