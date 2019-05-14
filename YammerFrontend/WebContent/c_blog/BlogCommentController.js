myApp.controller("BlogCommentController",function($scope,$http,$location,$rootScope,$cookieStore)
             {
	          
	        $scope.blogComment={'commentId':0,'blogId':0,'commentText':'','commentDate':'','username':''};
	        
	        $scope.blogComments;
	        $scope.blogInfo;
	       
	        $scope.blog={'blogName':'','blogContent':'','username':'','status':'','likes':0,'dislikes':0}
	        
	        
	     /*   $scope.addComment=function()
	        {
	        	$scope.blogComment.blogId=$rootScope.blogInfo.blogId;
	        	$scope.blogComment.username=$rootScope.currentUser.username;
	        	
	        	$http.post('http://localhost:8084/YammerMiddleware/addBlogComment',$scope.blogComment)
	        	.then(function(response)
	        			{
	        		      console.log('Adding Blog Comments');
	        		      console.log(response.data);
	        		
	        			});
	        }*/
	        $scope.addComment = function(blogId) {
	    		console.log('Entered into the addBlogComment method');
	    		$scope.blogComment.username=$rootScope.currentUser.username;
	    		$scope.blogComment.blogId=blogId;
	    		$http.post("http://localhost:8084/YammerMiddleware/addBlogComment",
	    						$scope.blogComment).then(function(response) {
	    					console.log('Adding Blog Comments');
	    					 $window.alert("Commented successfully");
	    					 $window.location.reload();
	    					 $location.path("/SingleBlog"); 
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
	        
	        function loadBlogComments()
	        {
	        	$http.get('http://localhost:8084/YammerMiddleware/getBlogComments/'+$rootScope.blogInfo.blogId)
	        	.then(function(response)
	            {
	        		
	        		$scope.blogComments=response.data;
	        	});
	        }
	 
	        loadBlogComments();
             });
	