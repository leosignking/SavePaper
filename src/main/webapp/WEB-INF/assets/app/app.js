/**
 * Created with IntelliJ IDEA.
 * User: Furkan Bayraktar
 * Date: 7/11/14
 * Time: 12:14 PM
 * To change this template use File | Settings | File Templates.
 */

'use strict';

var app = angular.module('app', ['ngRoute']);

app.config(['$routeProvider',
    function($routeProvider) {
        $routeProvider.
        when('/', {
            templateUrl: 'home.html',
            controller: 'HomeController'
        }).
        when('/billing', {
            templateUrl: 'billing.html',
            controller: 'BillingController'
        }).
        when('/product', {
            templateUrl: 'product.html',
            controller: 'ProductController'
        }).
        otherwise({redirectTo:'/'});
    }]);

var ProductController = function($scope, Product) {
    $scope.addProduct = function(pName, pDesc, pPrice) {
        new Product({
            name: pName,
            description: pDesc,
            price: pPrice
        }).$save(function(product) {
            $scope.products.push(product);
        });
    };
};
app.controller('HomeController',
    function($scope, $routeParams, $http, $location) {

    }
);

app.controller('BillingController',
    function($scope, $routeParams, $http, $location) {

    }
);
ProductController.$inject =['$scope', 'Product'];
app.controller('ProductController',ProductController);