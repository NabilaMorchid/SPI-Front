'use strict';

var myModule = angular.module('myModule',['ngRoute'])

.config(function ($routeProvider) {
	$routeProvider
		.when('/formation', {
			templateUrl: 'views/formation.html',
			controller: 'formationCtrl'
		})
	.when('/formationDetails/:formation', {
		templateUrl: 'views/formationDetails.html',
		controller: 'formationDetailsCtrl'
	})
	.when('/ajoutFormation', {
			templateUrl: 'views/ajoutFormation.html',
			controller: 'ajoutformationCtrl'
		})
		
		.when('/modifierFormation/:formation', {
			templateUrl: './views/modifierFormation.html',
			controller: 'modifierFormationCtrl'
		})
		.when('/enseignant', {
			templateUrl: './views/enseignant.html',
			controller: 'enseignantCtrl'
		})
		.when('/enseignantDetails/:noEnseignant', {
			templateUrl: './views/enseignantDetails.html',
			controller: 'enseignantDetailsCtrl'
		})
		.when('/ajoutEnseignant', {
			templateUrl: './views/AjoutEnseignant.html',
			controller: 'ajoutEnseignantCtrl'
		})
		.when('/modifierEnseignant/:noEnseignant', {
			templateUrl: './views/modifierEnseignant.html',
			controller: 'modifierEnseignantCtrl'
		})
		.when('/', {
			templateUrl: './views/statistiques.html',
			controller: 'Index'
		})
		.otherwise({redirectTo : '/'});
	
	

		
});



		  
		  
		  
