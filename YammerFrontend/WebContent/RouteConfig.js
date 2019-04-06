var myApp=angular.module("myApp",["ngRoute","ngCookies"]);
myApp.config(function($routeProvider)
		
   {
		   alert("I am RouteConfiguration");
		   $routeProvider.when("/",{templateUrl:"index.html"})
		  //.when("/login",{templateUrl:"c_user/Login.html"})
		   //.when("/register",{templateUrl:"c_user/Register.html"})
		   //.when("/login",{templateUrl:"c_user/Login.html"})
		   //.when("/blog",{templateUrl:"c_blog/Blog.html"})
		   //.when("/manageBlog",{templateUrl:"c_blog/ManageBlog.html"})
		  
		   
		   
		   
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
