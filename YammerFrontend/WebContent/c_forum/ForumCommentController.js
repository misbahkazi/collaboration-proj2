myApp.controller("ForumCommentController",function($scope,$http,$location,$rootScope,$cookieStore)
             {
	          
	        $scope.forumComment={'commentId':0,'forumId':0,'commentText':'','commentDate':'','username':''};
	        
	        $scope.forumComments;
	        $rootScope.forumInfo;
	        
	        $scope.forum={'forumName':'','forumContent':'','username':'','status':''}
	       
	        
	        $scope.addComment=function()
	        {
	        	$scope.forumComment.forumId=$rootScope.forumInfo.forumId;
	        	$scope.forumComment.username=$rootScope.currentUser.username;
	        	
	        	$http.post('http://localhost:8084/YammerMiddleware/addForumComment',$scope.forumComment)
	        	.then(function(response)
	        			{
	        		      console.log('Adding Forum Comments');
	        		      console.log(response.data);
	        		
	        			});
	        }
	        
	        $scope.deleteForumComment=function(commentId)
	          {
	        	  console.log('Forum Comment Deleted');
	        	  $http.get('http://localhost:8084/YammerMiddleware/deleteForumComment/'+commentId)
	        	  .then(function(response)
	        			  {
	        			  
	          });
	          }
	        
	        function loadForumComments()
	        {
	        	$http.get('http://localhost:8084/YammerMiddleware/getForumComment/'+$rootScope.forumInfo.forumId)
	        	.then(function(response)
	            {
	        		
	        		$scope.forumComments=response.data;
	        	});
	        }
	 
	        loadForumComments();
             });
	