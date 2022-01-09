(function () {
	
    let products = function ($http) {
    	let result;
    	
    	this.GetProducts = function() {
    		return $http.get('/products').then(
    			function success(response){
    				return response.data;
	    		},
	    		function error(){
	    			
	    		}
	    	);

    	};
    	
    	this.SaveOrders = function(data) {
    		return $http.post('/products',data).then(
    			function success(response) {
    				return response.data;
    			},
    			function error() {
    				
    			}
    		);
    	};
    };
    
    products.$inject = ['$http'];
	
    


    angular.module('productService',[]).service('products', products);

}());/**
 * 
 */