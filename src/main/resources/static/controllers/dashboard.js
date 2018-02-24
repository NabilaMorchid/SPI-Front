myModule.controller('Index', function($scope,$http,$location,$routeParams) {
	
	$http.get('/formation/count').then(function(response) {
        $scope.formations = response.data;    
    });
	
	$http.get('/enseignant/count/').then(function(response) {
        $scope.enseignants = response.data;    
    });
	
});