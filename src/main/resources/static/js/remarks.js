/**
 * 评论页面
 * header部分 判断用户登陆 显示头像 退出登陆(重复部分，懒得使用路由)
 * 根据所传的id查询电影详细信息
 * 发布评论 显示电影的评论
 */
var myApp=angular.module('remarkApp', []);

/**
 * 电影详细信息
 */
myApp.controller('movieCtrl',function ($scope,$http) {

    $http({
        method: 'GET',
        url: 'http://localhost/movie/info/'+window.sessionStorage.getItem("movieId"),
        headers: { 'Content-Type': 'application/x-www-form-urlencoded' }
    }).then(function successCallback(res) {
        $scope.img = res.data[0].img;
        $scope.titleCn = res.data[0].titleCn;
        $scope.titleEn = res.data[0].titleEn;
        $scope.type = res.data[0].type;
        $scope.moviesTime = res.data[0].moviesTime;
        $scope.director = res.data[0].director;
        $scope.actors = res.data[0].actors;
        $scope.story = res.data[0].story;

    },function errorCallback(res) {
        console.log(res);
    })
})

myApp.controller('remarkCtrl',function ($scope,$http) {

    var id=window.sessionStorage.getItem("movieId");
    $scope.remark = {};
    getMovieRemark();

    /**
     * 添加评论
     */
    $scope.remark=function () {
        $http({
            method: 'POST',
            url:'http://localhost/remark/add',
            data:$.param($scope.remark,id),
            headers: { 'Content-Type': 'application/x-www-form-urlencoded' }
        }).then(function successCallback(res) {
            var ob = JSON.parse(JSON.stringify(res.data));
            if("success"==ob.msg){
                $('#successRemark-alert').modal();
                getMovieRemark();
                $scope.remark.remarkContent = "";
            }else {
                $('#errorRemark-alert').modal();
            }
        },function errorCallback(res) {
            console.log(res)
        });
    }

    /**
     * 获取电影评论
     */
    function getMovieRemark() {
        $http({
            method:'GET',
            url:'http://localhost/remark/movie_'+window.sessionStorage.getItem("movieId"),
            headers: { 'Content-Type': 'application/x-www-form-urlencoded' }
        }).then(function successCallback(res) {
            $scope.remarkList = res.data;
        },function errorCallback(res) {
            console.log(res)
        });
    }

})

/**
 * header
 */
myApp.controller('headerCtrl', function($scope, $http){
    isLogin();

    /**
     * 前往我的电影页面
     */
    $scope.myInfo=function () {
        window.location.href = "tomy";
    }

    $scope.exit=function () {
        console.log("退出登陆");
        //清楚信息
        window.sessionStorage.clear();
        isLogin();

        $('#index-alert').modal();

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