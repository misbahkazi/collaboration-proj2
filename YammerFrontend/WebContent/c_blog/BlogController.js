myApp.controller("BlogController",function($scope,$http,$location,$rootScope,$cookieStore)
             {
	
	          $scope.blog={'blogName':'','blogContent':'','username':'','status':'','likes':0,'dislikes':0}
	          $scope.blogData;
	          
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
	        	  console.log('Displaying Blog Details');
	        	  $http.get('http://localhost:8084/YammerMiddleware/getBlog/'+blogId)
	        	  .then(function(response)
	        			  {
	        		  $scope.blog=response.data;
	        		  console.log($scope.blog);
	        			  
	          });
	          }
	          
	          
	          
	          loadBlog();
	
             }); 
 
 