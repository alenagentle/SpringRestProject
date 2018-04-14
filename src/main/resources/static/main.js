var app = angular.module("PersonManagement", []);

app.controller("PersonController", function($scope, $http) {

    $scope.persons = [];
    $scope.personDto = {
        id: 1,
        fio: "",
        age: "",
        email: "",
        skype: "",
        target: ""
    };

    _refreshPersonData();

    $scope.submitPerson = function() {

        var method = "";
        var url = "";

        if ($scope.personDto.id == -1) {
            method = "POST";
            url = '/data/person';
        } else {
            method = "PUT";
            url = '/data/person';
        }

        $http({
            method: method,
            url: url,
            data: angular.toJson($scope.personDto),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(_success, _error);
    };

    $scope.deletePerson = function(person) {
        $http({
            method: 'DELETE',
            url: '/data/person/' + person.id
        }).then(_success, _error);
    };

    $scope.editPerson = function(person) {
        $scope.personDto.id = person.id;
        $scope.personDto.fio = person.fio;
        $scope.personDto.age = person.age;
        $scope.personDto.email = person.email;
        $scope.personDto.skype = person.skype;
        $scope.personDto.target = person.target;
    };

    function _refreshPersonData() {
        $http({
            method: 'GET',
            url: '/data/persons'
        }).then(
            function(res) { // success
                $scope.persons = res.data;
            },
            function(res) { // error
                console.log("Error: " + res.status + " : " + res.data);
            }
        );
    }

    function _success(res) {
        _refreshPersonData();
        _clearPersonData();
    }

    function _error(res) {
        var data = res.data;
        var status = res.status;
        var header = res.header;
        var config = res.config;
        alert("Error: " + status + ":" + data);
    }

    function _clearPersonData() {
        $scope.personDto.id = -1;
        $scope.personDto.fio = "";
        $scope.personDto.age = "";
        $scope.personDto.skype = "";
        $scope.personDto.email = "";
        $scope.personDto.target = "";
    };
});