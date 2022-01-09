'use strict';

angular.module('myApp.orderForm', ['ngRoute','ngAnimate','ui.bootstrap','productService','orderService'])

.config(['$routeProvider', function($routeProvider) {
	$routeProvider.when('/order-form', {
		templateUrl: 'views/form-page/orderForm.html',
		controller: 'OrderFormCtrl',
		controllerAs: 'order'
	});
}])
.controller('OrderFormCtrl', ["$scope","products","orders","$window",function($scope, products, orders, $window) {
	let vm = this;

	vm.addItem = addItem;
	vm.open = open;
	vm.submit = submit;
	$scope.orderForm= {};
	
	vm.selectedProduct = {};
	vm.activeList = [];
	vm.formFlags = {
		required: true
	}
	
	products.GetProducts().then(function(data) {
		vm.productList = angular.fromJson(data);
	});
	
	
	
	function open(type) {
		if(type=== 1) { vm.calendar.opened = true; }
		else{ vm.calendar.opened2 = true;}
		
	};
	
	function addItem(product) {
		vm.activeList.push(product);
		resetProductRow();
	}
	
	function submit(form) {

		if(form.$valid && vm.activeList.length > 0) {
			
			$scope.orderForm.orderedParts = vm.activeList;
			
			orders.SaveOrder(angular.toJson($scope.orderForm)).then(function(response) {
				vm.saveResponse = response;
				console.log("Success: " + vm.saveResponse)
				window.location.assign('/#!/main');
			});
		}
		
	};
	
	function resetProductRow() {
		vm.selectedProduct = {};
	};
	
	// Calendar Picker
	vm.calendar = {
		opened: false,
		format: 'dd-MMMM-yyyy',
		opened2: false
	};
	
	vm.dateOptions = {
	    dateDisabled: disabled,
	    formatYear: 'yy',
	    minDate: new Date(),
	    startingDay: 1
	};
	  
	// Disable weekend selection
	function disabled(data) {
		var date = data.date,
		mode = data.mode;
		return mode === 'day' && (date.getDay() === 0 || date.getDay() === 6);
	};
}]);
