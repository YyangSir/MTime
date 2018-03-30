var k_protocol = window.location.protocol;

myApp.controller('boxCtrl', function ($scope, $http) {

   $http({
        method: 'GET',
        url: k_protocol+'/box',
        headers: { 'Content-Type': 'application/x-www-form-urlencoded' }
    }).then(function successCallback(res) {
       console.log(res)
        var ob = JSON.parse(JSON.stringify(res.data));
        if(ob.code==200){
            $scope.boxoffices=ob.data
            $scope.time=ob.data[0].time
        }

    },function errorCallback(res){
        console.log(res);
    })
});