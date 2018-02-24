myModule.controller('modifierFormationCtrl', [
		'$scope',
		'$http',
		'$routeParams',
		function($scope, $http, $routeParams) {

			$http.get('/formation/' + $routeParams.formation).then(
					function(response) {
						$scope.formationAModifier = response.data;

					});

			$scope.modifierFormation = function() {
				var formationAModifier = $scope.formationAModifier;
				$http.put('/formation', formationAModifier);
			};

		} ]);
