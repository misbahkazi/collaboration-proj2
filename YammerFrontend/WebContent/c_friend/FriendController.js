myApp.controller("FriendController",function($scope,$http,$location,$rootScope)
		{
	$scope.friend={'friendId':0,'username':'','friendUsername':'','status':''};
	$scope.User={'username':'','password':'','customerName':'','emailId':'','role':'','status':'','isOnline':''};
	
	$scope.friendList;
	$scope.pendingFriendList;
	$scope.suggestedFriendList;
	
	function showFriendList()
	{
		console.log('Iam in showFriendlist');
		console.log($rootScope.currentUser.username);
		$http.get('http://localhost:8084/Yammermiddleware/showFriend/'+$rootScope.currentUser.username)
		.then(function(response){
			$scope.friendList=response.data;
			console.log($scope.friendList);
		});
	}
	
	function showPendingFriendList()
	{
		console.log('Iam in showPendingFriendlist');
		console.log($rootScope.currentUser.username);
		$http.get('http://localhost:8084/Yammermiddleware/showPendingFriendList/'+$rootscope.currentUser.username)
		.then(function(response){
			$scope.friendList=response.data;
			console.log($scope.pendingFriendList);
		});
	}
	
	function showSuggestedFriendList()
	{
		console.log('Iam in showSuggestedFriendlist');
		console.log($rootScope.currentUser.username);
		$http.get('http://localhost:8084/Yammermiddleware/showSuggestedFriendList/'+$rootscope.currentUser.username)
		.then(function(response){
			$scope.friendList=response.data;
			console.log($scope.suggestedFriendList);
		});
	}
	
	showFriendList();
	showPendingFriendList();
	showSuggestedFriendList();
	
	
		});