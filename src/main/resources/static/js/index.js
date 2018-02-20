
/**
 * 电影
 */
myApp.controller('indexCtrl', function($scope, $http){
    $http({
        method: 'GET',
        url: 'http://localhost/movie/recent',
        headers: { 'Content-Type': 'application/x-www-form-urlencoded' }
    }).then(function successCallback(res) {
        var ob = JSON.parse(JSON.stringify(res.data));
        if(ob.code==200){
            $scope.movieList=ob.data.list
        }

    },function errorCallback(res){
        console.log(res);
    })

    $http({
        method: 'GET',
        url: 'http://localhost/movie/upcoming',
        headers: { 'Content-Type': 'application/x-www-form-urlencoded' }
    }).then(function (res) {
        var ob = JSON.parse(JSON.stringify(res.data));
        if(ob.code==200){
            $scope.comingList=ob.data.list
        }
    },function (res) {
        console.log(res);
    })
    /**
     * 跳转去评论页面
     * @param id 电影id
     */
    $scope.toremark=function (id) {
        window.sessionStorage.setItem("movieId", id);
        window.location.href = 'toremark';
    }

})