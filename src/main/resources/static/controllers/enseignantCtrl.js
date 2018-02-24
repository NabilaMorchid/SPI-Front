
myModule.controller('enseignantCtrl', function($scope, $http) {
	 $http.get('/enseignant').then(function(data) {
		    $scope.enseignants = data;
		    
			$scope.onDelete = function(id) {
				$http.delete('/enseignant/suppr/'+id);
			};	
			
		  });
	 
	 
	 });