myApp.controller("FriendController",function($scope,$http,$location,$rootScope)
		{
	$scope.friend={'friendId':0,'username':'','friendusername':'','status':''};
	$scope.user={'username':'','password':'','customerName':'','emailId':'','role':'','status':'','isOnline':''};
	
	$scope.friendList;
	$scope.pendingFriendList;
	$scope.suggestedFriendList;
	
	function showFriendList()
	{
		console.log('Iam in showFriendlist');
		console.log($rootScope.currentUser.username);
		$http.get('http://localhost:8084/YammerMiddleware/showFriendList/'+$rootScope.currentUser.username)
		.then(function(response){
			$scope.friendList=response.data;
			console.log($scope.friendList);
		});
	}
	
	function showPendingFriendList()
	{
		console.log('Iam in showPendingFriendlist');
		console.log($rootScope.currentUser.username);
		$http.get('http://localhost:8084/YammerMiddleware/showPendingFriendList/'+$rootScope.currentUser.username)
		.then(function(response){
			$scope.pendingFriendList=response.data;
			console.log($scope.pendingFriendList);
		});
	}
	
	function showSuggestedFriendList()
	{
		console.log('Iam in showSuggestedFriendlist');
		console.log($rootScope.currentUser.username);
		$http.get('http://localhost:8084/YammerMiddleware/showSuggestedFriendList/'+$rootScope.currentUser.username)
		.then(function(response){
			$scope.suggestedFriendList=response.data;
			console.log($scope.suggestedFriendList);
		});
	}
	
	
	$scope.unfriend=function(friendId)
	{
		console.log('Unfriend Implementation');
		$http.get('http://localhost:8084/YammerMiddleware/deleteFriendRequest/'+friendId)
		.then(function(response){
			$scope.log('Friend Deleted');
		});
	}
	$scope.accept=function(friendId)
	{
		console.log('Acceptfriend Implementation');
		$http.get('http://localhost:8084/YammerMiddleware/acceptFriendRequest/'+friendId)
		.then(function(response){
			
			$scope.log('Friend Request Accepted');
		});
	}
	$scope.friendRequest=function(fusername)
	{
		$scope.friend.username=$rootScope.currentUser.username;
		$scope.friend.friendusername=fusername;
		$http.post('http://localhost:8084/YammerMiddleware/sendFriendRequest',$scope.friend)
		.then(function(response){
			$scope.log('Friend Request Sent');
		});
	}
	
	
	showFriendList();
	showPendingFriendList();
	showSuggestedFriendList();
	
	
		});




