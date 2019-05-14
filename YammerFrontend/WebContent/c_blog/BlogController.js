myApp.controller("BlogController",function($scope,$http,$location,$rootScope,$cookieStore)
             {
	
	          $scope.blog={'blogName':'','blogContent':'','username':'','status':'','likes':0,'dislikes':0}
	          $scope.blogData;
	          $rootScope.blogInfo;
	          
	         $scope.blogComment={'commentId':0,'blogId':0,'commentText':'','commentDate':'','username':''};
	       
	          
	         
	         $scope.addBlog=function()
	          {
	        	  console.log('Adding Blog');
	        	  
	        	  $scope.blog.username=$rootScope.currentUser.username;
	        	  $scope.blog.status='NA';
	        	 
	        	  
	        	  $http.post('http://localhost:8084/YammerMiddleware/addBlog',$scope.blog)
	        	  .then(function(response)
	        			  {
	        		        console.log('Blog Added');  
	        		        console.log(response.data);
	        		  
	        			  });
	        	  
	        	  
	          }
	          
	          function loadBlog()
	          {
	        	  console.log('Loading all Blogs');
	        	  $http.get('http://localhost:8084/YammerMiddleware/getBlogDetails')
	        	  .then(function(response)
	        {
	        	  console.log('Loading Blog');
	        	  $scope.blogData=response.data;
	        	  console.log($scope.blogData);
	        	  
	        	  
	          });
	      }
	          
	          
	          $scope.updateBlog=function()
				{
					console.log('I am in update Blog');
					$scope.blog=$rootScope.blogInfo;
					$http.post('http://localhost:8084/YammerMiddleware/updateBlog/',$scope.blog)
					.then(function(response)
							{
								console.log('Blog is Updated');
								$location.path('/showBlog');
					});
				}
	          
	          
	          
	          $scope.incrementLikes=function(blogId)
	          {
	        	  console.log('Increment Likes');
	        	  $http.get('http://localhost:8084/YammerMiddleware/incrementLikes/'+blogId)
	        	  .then(function(response)
	        			  {
	        			  
	          });
	          }
	          
	          $scope.incrementDislikes=function(blogId)
	          {
	        	  console.log('Increment Dislikes');
	        	  $http.get('http://localhost:8084/YammerMiddleware/incrementDislikes/'+blogId)
	        	  .then(function(response)
	        			  {
	        			  
	          });
	          }
	          
	          $scope.approvedBlog=function(blogId)
	          {
	        	  console.log('Blog Accepted');
	        	  $http.get('http://localhost:8084/YammerMiddleware/approvedBlog/'+blogId)
	        	  .then(function(response)
	        			  {
	        			  
	          });
	          }
	          
	          $scope.rejectBlog=function(blogId)
	          {
	        	  console.log('Blog Rejected');
	        	  $http.get('http://localhost:8084/YammerMiddleware/rejectBlog/'+blogId)
	        	  .then(function(response)
	        			  {
	        			  
	          });
	          }
	          
	          $scope.deleteBlog=function(blogId)
	          {
	        	  console.log('Blog Deleted');
	        	  $http.get('http://localhost:8084/YammerMiddleware/deleteBlog/'+blogId)
	        	  .then(function(response)
	        			  {
	        			  
	          });
	          }
	          
	          
	          $scope.showBlog=function(blogId)
				{
						console.log('Showing Details of Blog');
						$http.get('http://localhost:8084/YammerMiddleware/getBlog/'+blogId)
						.then(function(response)
								{
									$rootScope.blogInfo=response.data;
									console.log("ShowingDetails");
									$location.path('/blogDetail');
								});
						$http.get('http://localhost:8084/YammerMiddleware/getBlogComment/'+blogId)
						.then(function(response)
								{
							console.log('Status text:' + response.statusText);
							$scope.blogComments = response.data;
							console.log(response.data);
							
								});
						
				}
				
				
	          loadBlog();
             }); 
 
 