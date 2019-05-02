var myApp=angular.module("myApp",['ngRoute','ngCookies']);
myApp.config(function($routeProvider)
		
   {
		   alert("I am in RouteConfiguration");
		  // $routeProvider.when("/",{templateUrl:"index.html"})
		    $routeProvider.when("/Login",{templateUrl:"c_user/Login.html"})
		   .when("/register",{templateUrl:"c_user/Register.html"})
		   .when("/profilePicture",{templateUrl:"c_user/ProfilePicture.html"})
		   .when("/blog",{templateUrl:"c_blog/Blog.html"})
		   .when("/manageBlog",{templateUrl:"c_blog/ManageBlog.html"})
		   .when("/showBlog",{templateUrl:"c_blog/ShowBlog.html"})
		   .when("/updateBlog",{templateUrl:"c_blog/UpdateBlog.html"})
		   .when("/blogDetail",{templateUrl:"c_blog/BlogDetail.html"})
		   .when("/chat",{templateUrl:"c_chat/Chat.html"})
		   .when("/forum",{templateUrl:"c_forum/Forum.html"})
		   .when("/manageForum",{templateUrl:"c_forum/ManageForum.html"})
		   .when("/showForum",{templateUrl:"c_forum/ShowForum.html"})
		   .when("/updateForum",{templateUrl:"c_forum/UpdateForum.html"})
		   .when("/forumDetail",{templateUrl:"c_forum/ForumDetail.html"})
		   .when("/friendList",{templateUrl:"c_friend/FriendList.html"})
		   .when("/job",{templateUrl:"c_job/Job.html"});
		    } );




myApp.run(function($rootScope,$cookieStore){
	console.log('I am in Run Function');
	console.log($rootScope.currentUser);
	
	if($rootScope.currentUser==undefined)
		{
		console.log($cookieStore.get('userDetail'));
		$rootScope.currentuser=$cookieStore.get('userDetail');
		}
});



