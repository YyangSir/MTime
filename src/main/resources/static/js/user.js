/**
 * 登陆提交
 */
var app = angular.module('loginApp', []);
app.controller('loginCtrl', function($scope, $http) {
    $scope.user = {};
    $scope.login=function () {
        $http({
            method: 'POST',
            url: 'http://localhost/user/login',
            data:$.param($scope.user),
            headers: { 'Content-Type': 'application/x-www-form-urlencoded' }
        }).then(function successCallback(res) {
            var ob = JSON.parse(JSON.stringify(res.data));
            if(200==ob.code){
                console.log("登陆成功")
                //session保存
                window.sessionStorage.setItem("username", ob.data.nickname);
                window.sessionStorage.setItem("img", ob.data.img);
                window.sessionStorage.setItem("userid", ob.data.userid);

                console.log(window.sessionStorage.getItem("username"));

                if(window.sessionStorage.getItem("movieId")>0) {
                    window.location.href = 'toremark';
                }else window.location.href = 'index';

            }else {
                $scope.message = ob.message;
                $('#login-alert').modal();
            }
        }, function errorCallback(res) {
            console.log(res);
        });
    }
});

/**
 * 注册部分
 */
var app = angular.module('registerApp', []);
app.controller('registerCtrl',function ($scope, $http) {
    $scope.user = {};//获取数据
    //检查用户名是否可以注册
    var isName = false;

    //注册
    $scope.register=function () {
        //用户名可用进行注册
        if(isName){
            $http({
                method: 'POST',
                url: 'http://localhost/user',
                data:$.param($scope.user),
                headers: { 'Content-Type': 'application/x-www-form-urlencoded' }
            }).then(function successCallback(res) {
                var ob = JSON.parse(JSON.stringify(res.data));
                if(200==ob.code) {
                    console.log("注册成功");
                    window.sessionStorage.setItem("username", ob.data.nickname);
                    window.sessionStorage.setItem("img", ob.data.img);
                    window.sessionStorage.setItem("userid", ob.data.userid);
                    window.location.href = 'index';
                }else {
                    console.log("注册失败");
                    $('#register-alert').modal();
                }
            }, function errorCallback(res) {
                console.log(res);
            })
        }

    }
    //监测用户名重复
    $scope.$watch('user.nickname',function (newValue) {
        console.log(newValue)
        $http({
            method: 'POST',
            url: 'http://localhost/user/checkname',
            data:$.param($scope.user),
            headers: { 'Content-Type': 'application/x-www-form-urlencoded' }
        }).then(function successCallback(res) {
            var ob = JSON.parse(JSON.stringify(res.data));
                if(200==ob.code) {
                    $scope.isName="am-icon-check am-success"
                    isName = true;
                }else {
                    $scope.isName="am-icon-times am-warning"
                    isName=false
                }
            });
        },function errorCallback(res) {
            console.log(res);
        })
    })


