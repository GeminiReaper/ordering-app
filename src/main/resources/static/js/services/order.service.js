(function () {
	
    let orders = function ($http) {
    	let result;
    	
    	this.GetOrders = function() {
    		return $http.get('/orders').then(
    			function success(response){
    				return response.data;
	    		},
	    		function error(){
	    			
	    		}
	    	);

    	};
    	
    	this.SaveOrder = function(data) {
    		return $http.post('/orders',data).then(
    			function success(response) {
    				return response.data;
    			},
    			function error() {
    				
    			}
    		);
    	};
    };
    
    orders.$inject = ['$http'];
	
    


    angular.module('orderService',[]).service('orders', orders);

}());