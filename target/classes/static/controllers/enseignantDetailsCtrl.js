 myModule.controller('enseignantDetailsCtrl', function($scope, $http,$routeParams) {
	 
	
	 $http.get('/enseignant/'+$routeParams.noEnseignant).then(function(response) {
		    $scope.enseignants = response.data;
		    
		   
		    }); 
		  
	 });

