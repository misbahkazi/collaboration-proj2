myApp.controller("BlogCommentController",function($scope,$http,$location,$rootScope,$cookieStore)
             {
	          
	        $scope.blogComment={'commentId':0,'blogId':0,'commentText':'','commentDate':'','username':''};
	        
	        $scope.blogComments;
	        $scope.blogInfo;
	       
	        $scope.blog={'blogName':'','blogContent':'','username':'','status':'','likes':0,'dislikes':0}
	        
	        
	        $scope.addComment=function()
	        {
	        	$scope.blogComment.blogId=$rootScope.blogInfo.blogId;
	        	$scope.blogComment.username=$rootScope.currentUser.username;
	        	
	        	$http.post('http://localhost:8084/YammerMiddleware/addBlogComment',$scope.blogComment)
	        	.then(function(response)
	        			{
	        		      console.log('Adding Blog Comments');
	        		      console.log(response.data);
	        		
	        			});
	        }
	    
	        
	        
	        $scope.deleteBlogComment=function(commentId)
	          {
	        	  console.log('BlogComment Deleted');
	        	  $http.get('http://localhost:8084/YammerMiddleware/deleteBlogComment/'+commentId)
	        	  .then(function(response)
	        			  {
	        			  
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
	        
	        function loadBlogComments()
	        {
	        	$http.get('http://localhost:8084/YammerMiddleware/getBlogComment/'+$rootScope.blogInfo.blogId)
	        	.then(function(response)
	            {
	        		
	        		$scope.blogComments=response.data;
	        	});
	        }
	 
	        loadBlogComments();
             });
	