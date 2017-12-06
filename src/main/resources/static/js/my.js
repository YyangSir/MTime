/**
 * 我的界面
 * 查询用户信息
 * 查询用户电影
 */
var app = angular.module('myApp', []);
app.controller('userCtrl',function ($scope,$http) {
    $http({
        method: 'GET',
        url: 'http://localhost/user/info/'+window.sessionStorage.getItem("userid"),
        headers: { 'Content-Type': 'application/x-www-form-urlencoded' }
    }).then(function successCallback(res) {
        var ob = JSON.parse(JSON.stringify(res.data));
        if("success"==ob.msg){
            $scope.username = ob.name;
            $scope.userimg = ob.img;
            $scope.number = ob.number;
        }

    },function errorCallback(res) {
        console.log(res);
    })

})

app.controller('myRemarkCtrl',function ($scope,$http) {
    $http({
        method: 'GET',
        url: 'http://localhost/user/remark/'+window.sessionStorage.getItem("userid"),
        headers: { 'Content-Type': 'application/x-www-form-urlencoded' }
    }).then(function successCallback(res) {
        console.log(res.data)
        $scope.remarkList = res.data;
    },function errorCallback(res) {
        console.log(res);
    })
})

app.controller('headerCtrl', function ($scope) {
    /**
     * 退出登陆
     */
    $scope.exit=function () {
        //清除信息
        window.sessionStorage.clear();
        console.log("退出登陆")
        $('#my-alert').modal();
        window.location.href="/index"
    }
});
