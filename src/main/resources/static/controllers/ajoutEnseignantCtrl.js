myModule.controller('ajoutEnseignantCtrl', function($scope, $http) {
	
	  $scope.SendData = function () {
          var data = {};
          data.noEnseignant = $scope.noEnseignant;
          data.adresse = $scope.adresse;
          data.codePostal =$scope.codePostal;
          data.emailPerso = $scope.emailPerso;
          data.emailUbo = $scope.emailUbo;
          data.mobile = $scope.mobile;
          data.nom = $scope.nom;
          data.pays = $scope.pays;
          data.prenom = $scope.prenom;
          data.sexe = $scope.sexe;
          data.telephone = $scope.telephone;
          data.type = $scope.type;
          data.ville = $scope.ville;

          
          console.log($scope.noEnseignant);
          $http.post("/enseignant", data)
          .then(function(){
          	
          });
   
      };
});