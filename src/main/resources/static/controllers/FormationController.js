
myModule.controller('formationCtrl', function($scope, $http) {
	 $http.get('/formation').then(function(data) {
		    $scope.formations = data;
		    
			$scope.onDelete = function(id) {
				$http.delete('/formation/suppr/'+id);
			};	
			
		  });
	 
	 
	 });