 $scope.uploadFile = function(){
         var file = $scope.myFile;
         
         console.log('file is ' );
         console.dir(file);
         
         var uploadUrl = "http://localhost:8084/YammerBackend/doUpload";
         userService.uploadFileToUrl(file, uploadUrl)
         .success(function(){
         	$window.location.reload();
         })
         .error(function(){
         });;
      };
      