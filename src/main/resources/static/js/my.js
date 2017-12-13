/**
 * 我的界面
 * 查询用户信息
 * 查询用户电影
 */
var app = angular.module('myApp', []);
app.controller('userCtrl',function ($scope,$http) {

    GetUserInfo();

    function GetUserInfo() {
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
                window.sessionStorage.removeItem("img");
                window.sessionStorage.setItem("img", ob.img);
            }

        },function errorCallback(res) {
            console.log(res);
        })
    }

    /**
     * 更换头像
     */
    $scope.uploadUserPhoto=function () {
        var fd = new FormData();
        var files = document.querySelector('input[name="files"]').files;
        for (var i=0; i<files.length; i++) {
            fd.append("img", files[i]);
        }

        $http({
            method: 'POST',
            url:'http://localhost/user/UserPhoto',
            data:fd,
            headers: {'Content-Type':undefined},
            transformRequest: angular.identity
        }).then(function successCallback(res) {
            var ob = JSON.parse(JSON.stringify(res.data));
            if("success"==ob.msg){
                console.log("头像上传成功");
                GetUserInfo();
            }
            
        },function errorCallback(res) {
            console.log(res);
        })
    }
})

/**
 * 我的评论
 */
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

/**
 * 头部
 */
app.controller('headerCtrl', function ($scope) {
    /**
     * 退出登陆
     */
    $scope.exit=function () {

        $('#my-alert').modal({
            relatedTarget: this,
            onConfirm: function(options){
                //清除信息
                window.sessionStorage.clear();
                console.log("退出登陆")
                window.location.href="/index"
            },
            // closeOnConfirm: false,
            onCancel: function() {

            }
        })

    }
});
