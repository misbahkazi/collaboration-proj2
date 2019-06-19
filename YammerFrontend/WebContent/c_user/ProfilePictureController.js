myApp.controller("ProfilePictureController",function($scope,$http,$location,$rootScope,$cookieStore)
             {
	         
	          $scope.user={'username':'','password':'','customerName':'','emailId':'','role':'','status':'','isOnline':''}
	          $scope.profilePicture={'username':'','image':''}
	          $scope.profilepicture;
	          

	          $scope.uploadFile = function(){
	        	    var file = $scope.myFile;
         
         console.log('file is ' );
         console.dir(file);
         
         var uploadUrl = "http://localhost:8084/YammerMiddleware/doUpload";
         userService.uploadFileToUrl(file, uploadUrl)
         .success(function(){
         	$window.location.reload();
         })
         .error(function(){
         
	          });
}
             });     



 