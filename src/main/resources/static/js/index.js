/**
 * 主页
 * header部分 判断用户登陆 显示头像 退出登陆
 * 从数据库查询近期电影
 */
var myApp=angular.module('indexApp', []);

/**
 * 近期电影
 */
myApp.controller('indexCtrl', function($scope, $http){
    $http({
        method: 'GET',
        url: 'http://localhost/movie/recent',
        headers: { 'Content-Type': 'application/x-www-form-urlencoded' }
    }).then(function successCallback(res) {

        $scope.movieId_0 = res.data[0].movieId;
        $scope.title_0 = res.data[0].titleCn;
        $scope.img_0 = res.data[0].img;

        $scope.movieId_1 = res.data[1].movieId;
        $scope.title_1 = res.data[1].titleCn;
        $scope.img_1 = res.data[1].img;

        $scope.movieId_2 = res.data[2].movieId;
        $scope.title_2 = res.data[2].titleCn;
        $scope.img_2 = res.data[2].img;

        $scope.movieId_3 = res.data[3].movieId;
        $scope.title_3 = res.data[3].titleCn;
        $scope.img_3 = res.data[3].img;

    },function errorCallback(res){
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
        //清除信息
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