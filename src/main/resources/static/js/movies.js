/**
 * 电影列表
 */
var myApp=angular.module('moviesApp', []);

myApp.controller('moviesCtrl',function ($scope, $http) {
    var postData = {
        pageIndex: 1,
        pageSize: 12,
        hasNextPage: true,
        hasPreviousPage:false
    };

    GetAllMovies();
    changeClass(postData.pageIndex);

    /**
     * 获取电影信息
     * @constructor
     */
    function GetAllMovies() {
        $http({
            method: 'POST',
            url: 'http://localhost/movie/all',
            data: $.param(postData),
            headers: {'Content-Type': 'application/x-www-form-urlencoded'}
        }).then(function successCallback(res) {
            console.log(res.data);
            //电影数据
            $scope.movieList = res.data.list;
            //设置page数量
            $scope.pageNums = res.data.navigatepageNums;
            //是否第一页最后一页
            postData.hasNextPage = res.data.hasNextPage;
            postData.hasPreviousPage = res.data.hasPreviousPage;

        }, function errorCallback(res) {
            console.log(res);
        });
    }

    /**
     * 按名字查询电影
     * @returns {null}
     */
    $scope.selectMovieName=function () {
        console.log($scope.movieName)
        $http({
            method: 'GET',
            url: 'http://localhost/movie/name_' + $scope.movieName,
            headers: {'Content-Type': 'application/x-www-form-urlencoded'}
        }).then(function successCallback(res) {
            //电影数据
            $scope.movieList = res.data.list;
            //设置page数量
            $scope.pageNums = res.data.navigatepageNums;
            //是否第一页最后一页
            postData.hasNextPage = res.data.hasNextPage;
            postData.hasPreviousPage = res.data.hasPreviousPage;
        },function errorCallback(res) {
            console.log(res);
        });
    }

    /**
     * 去评论页面
     * @param id
     */
    $scope.remark=function (id) {
        window.sessionStorage.setItem("movieId", id);
        window.location.href = 'toremark';
    }

    //选择页码
    $scope.changePage=function (num) {

        if(num==0) {
            if(postData.hasPreviousPage) {
                changeClass(--postData.pageIndex)
                GetAllMovies();
            }
        }
        else if(num==999) {
            if(postData.hasNextPage) {
                changeClass(++postData.pageIndex);
                GetAllMovies();
            }

        }
        else {
            postData.pageIndex = num;
            changeClass(postData.pageIndex);
            GetAllMovies();
        }
    }

    //选中的页码变局域蓝
    function changeClass(num) {
        $scope.show = num;
    }
})

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

        $('#movies-alert').modal();

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