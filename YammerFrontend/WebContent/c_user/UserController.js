myApp.controller("UserController",function($scope,$http,$location,$rootScope,$cookieStore)
             {
	         
	          $scope.user={'username':'','password':'','customerName':'','emailId':'','role':'','status':'','isOnline':''}
	
	          
	          
	          
	          	          
	          
	
	          $scope.register=function()
	          {
	        	  console.log('i am in Register Function');
	        	  
	        	  $scope.user.role='student';
	        	  $scope.user.status='A';
	        	  $scope.user.isOnline='ON';
	        	  
	        	  console.log('UserDetails are: ');
	        	  console.log($scope.user);
	        	  
	        	  $http.post('http://localhost:8084/YammerMiddleware/registerUser',$scope.user)
	        	  .then(function(response){
	        		  
	        		  console.log('Registered');
	        		  $location.path('/Login');
	        	  
	        			  
	          });
	        
	        	  
	        	  
	        	  
             }
	          
	          $scope.logincheck=function()
	          {
	        	  console.log('i am in LogIn Function');
	        	  
	        	  $http.post('http://localhost:8084/YammerMiddleware/checkLogin',$scope.user)
	        	  .then(function(response){
	        		  
	        		  console.log('Logged In Successfully');
	        		  $scope.user=response.data;
	        		  $rootScope.currentUser=response.data;
	        		  console.log($rootScope.currentUser);
	        		  $cookieStore.put('userDetail',$rootScope.currentUser);
	        		  $location.path('/Home');
	        		  
	        		  
	        	  });
	        	  
	        	  
	          }
	          
	          $scope.logout=function()
	          {
	        	  console.log('Log out function');
	        	  delete $rootScope.currentUser;
	        	  $cookieStore.remove('userDetails');
	        	  $location.path('/logout');
	          }
	          
	          
             });

