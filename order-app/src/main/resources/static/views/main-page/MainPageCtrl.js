'use strict';

angular.module('myApp.main', ['ngAnimate','ngRoute', 'orderService','ui.bootstrap'])
.config(['$routeProvider', function($routeProvider) {
	$routeProvider.when('/main',{
		templateUrl: 'views/main-page/main-page.html',
		controller:'MainPageCtrl',
		controllerAs: 'main'
	})
}])

.controller('MainPageCtrl', ["$scope", "orders","$uibModal","$log","$window", function($scope,orders,$uibModal,$log,$window) {
	let vm = this;
	
	orders.GetOrders().then(function(data) {
		$scope.orderList = data;
	});
	
	vm.newOrderBtn = newOrderBtn;
	
	vm.openComponentModal = function () {
	    var modalInstance = $uibModal.open({
	      animation: true,
	      component: 'modalComponent'
	    });
	
	    modalInstance.result.then(function (selectedItem) {
	      vm.selected = selectedItem;
	    }, function () {
	      $log.info('modal-component dismissed at: ' + new Date());
	    });
	};
	
	function newOrderBtn() {
		window.location.assign('/#!/order-form');
	};
	
}]);
