myApp.service('ProfilePictureService',function($q,$timeout)
{
	console.log('Starting Service');
	
	var base_url="http://localhost:8084/YammerMiddleware";

fac.uploadFileToUrl = function(file, uploadUrl){
          var fd = new FormData();
          fd.append('file', file);
     
          return $http.post(uploadUrl, fd, {
           transformRequest: angular.identity,
           headers: {'Content-Type': undefined}
          });
	}
return service;
});


