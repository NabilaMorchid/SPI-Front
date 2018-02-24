myModule.controller('ajoutformationCtrl', function($scope, $http) {
	
	  $scope.SendData = function () {
          var data = {};
          data.codeFormation = $scope.codeFormation;
          data.debutAccreditation = $scope.debutAccreditation;
          data.diplome =$scope.diplome;
          data.doubleDiplome = $scope.doubleDiplome;
          data.finAccreditation = $scope.finAccreditation;
          data.n0Annee = $scope.n0Annee;
          data.nomFormation = $scope.nomFormation;
          
     
          $http.post("/formation", data)
          .then(function(){
          	
          });
   
      };
});