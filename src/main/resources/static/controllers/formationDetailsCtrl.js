myModule.controller('formationDetailsCtrl', function($scope, $http,
		$routeParams) {

	$http.get("/formation/" + $routeParams.formation).then(
			function(response) {

				$scope.formations = response.data;
				console.log(response.data);
			});
})