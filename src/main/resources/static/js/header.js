/**
 * header部分 判断用户登陆 显示头像 退出登陆
 */
var myApp=angular.module('headerApp', []);
myApp.controller('headerCtrl', function($scope, $http){
    isLogin();

    /**
     * 根据id 前往我的电影页面
     */
    $scope.myInfo=function () {

    }

    $scope.exit=function () {
        console.log("退出登陆");
        //清楚信息
        window.sessionStorage.clear();
        isLogin();

        $('#index-alert').modal();

        $('#movie-alert').modal();

        $('#remark-alert').modal();

    }

    /**
     * 判断是否登陆
     */
    function isLogin() {
        var islogin = window.sessionStorage.getItem("name");
        if(islogin!=null) {
            $scope.passport = "am-hide";
            $scope.userinfo = "";
            headImg();
        }else {
            $scope.passport = "";
            $scope.userinfo = "am-hide";
        }
    }

    /**
     * 获取头像
     */
    function headImg() {
        $scope.img = window.sessionStorage.getItem("img");
    }
})