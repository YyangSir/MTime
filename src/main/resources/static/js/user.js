// 对用户的操作 访问后台
// 登陆 注册
// 检查用户名

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
            //url: 'http://7a44ct.natappfree.cc/user/login',
            data:$.param($scope.user),
            headers: { 'Content-Type': 'application/x-www-form-urlencoded' }
        }).then(function successCallback(res) {
            var ob = JSON.parse(JSON.stringify(res.data));
            if("success"==ob.msg){
                console.log("登陆成功")
                //session保存
                window.sessionStorage.setItem("name", ob.name);
                window.sessionStorage.setItem("img", ob.img);
                //跳转主页或管理员
                if("admin"==ob.authority) {
                    window.location.href = 'admin';
                }else {
                    window.location.href = 'index';
                }
            }else {
                $('#login-alert').modal();
            }
        }, function errorCallback(res) {
            console.log("error");
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
                url: 'http://localhost/user/register',
                //url: 'http://7a44ct.natappfree.cc/user/register',
                data:$.param($scope.user),
                headers: { 'Content-Type': 'application/x-www-form-urlencoded' }
            }).then(function successCallback(res) {
                var ob = JSON.parse(JSON.stringify(res.data));
                if("success"==ob.msg) {
                    console.log("注册成功");
                    window.sessionStorage.setItem("name", ob.name);
                    window.sessionStorage.setItem("img", ob.img);
                    window.location.href = 'index';
                }else {
                    console.log("注册失败");
                    $('#register-alert').modal();
                }
            }, function errorCallback(res) {
                console.log("error");
                console.log(res);
            })
        }

    }
    //监测用户名重复
    $scope.$watch('user.userName',function (newValue) {
        console.log(newValue)
        $http({
            method: 'POST',
            url: 'http://localhost/user/checkname',
            //url: 'http:/7a44ct.natappfree.cc/user/checkname',
            data:$.param($scope.user),
            headers: { 'Content-Type': 'application/x-www-form-urlencoded' }
        }).then(function successCallback(res) {
            var ob = JSON.parse(JSON.stringify(res.data));
            if("success"==ob.msg) {
                console.log("用户名重复");
                classChanged();
                isName = false;
            }else {
                console.log("用户名可用");
                classChange();
                if(newValue!=null){
                    isName = true;
                }
            }
        },function errorCallback(res) {
            console.log("error");
            console.log(res);
        })
    })

    //改变输入框状态
    function classChanged() {
        $scope.classicon='am-icon-times';
        $scope.classinput='am-form-field';
    }
    function classChange() {
        $scope.classicon='am-hide';
        $scope.classinput='';
    }
})
