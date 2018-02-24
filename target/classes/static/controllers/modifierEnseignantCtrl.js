myModule.controller('modifierEnseignantCtrl', [
		'$scope',
		'$http',
		'$routeParams',
		function($scope, $http, $routeParams) {

			$http.get('/enseignant/' + $routeParams.noEnseignant).then(
					function(response) {
						$scope.enseignantAModifier = response.data;

					});

			$scope.modifierEnseignant = function() {
				var enseignantAModifier = $scope.enseignantAModifier;
				console.log(enseignantAModifier);
				$http.put('/enseignant', enseignantAModifier);
			};

		} ]);
