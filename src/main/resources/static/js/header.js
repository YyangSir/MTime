
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
        window.sessionStorage.removeItem("username");
        window.sessionStorage.removeItem("img");
        window.sessionStorage.removeItem("userid");
        $http({
            method: 'GET',
            url: 'http://localhost/user/exit',
            headers: { 'Content-Type': 'application/x-www-form-urlencoded' }
        })
        isLogin();

        $('#index-alert').modal();

        $('#movies-alert').modal();

        $('#remark-alert').modal();

    }

    /**
     * 判断是否登陆
     */
    function isLogin() {
        var islogin = window.sessionStorage.getItem("username");
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