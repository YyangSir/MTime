/**
 * 我的界面
 * 查询用户信息
 * 查询用户电影
 */
var myApp = angular.module('myApp', []);
myApp.controller('userCtrl',function ($scope,$http) {

    GetUserInfo();

    function GetUserInfo() {
        $http({
            method: 'GET',
            url: 'http://localhost/user/'+0+window.sessionStorage.getItem("userid"),
            headers: { 'Content-Type': 'application/x-www-form-urlencoded' }
        }).then(function successCallback(res) {
            var ob = JSON.parse(JSON.stringify(res.data));
            if(200==ob.code){
                $scope.nickname = ob.data.nickname;
                $scope.userimg = ob.data.img;
                $scope.number = ob.data.number;
                window.sessionStorage.removeItem("img");
                window.sessionStorage.setItem("img", ob.data.img);
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
            url:'http://localhost/upload/user',
            data:fd,
            headers: {'Content-Type':undefined},
            transformRequest: angular.identity
        }).then(function successCallback(res) {
            var ob = JSON.parse(JSON.stringify(res.data));
            if(200==ob.code){
                console.log("头像上传成功");
                GetUserInfo();
            }else {
                console.log(ob.message);
                $scope.message="头像上传失败"
                $('#alert').modal()
            }
            
        },function errorCallback(res) {
            console.log(res);
            $scope.message="头像上传失败"
            $('#alert').modal()
        })
    }
})

/**
 * 我的评论
 */
myApp.controller('myRemarkCtrl',function ($scope,$http) {
    $http({
        method: 'GET',
        url: 'http://localhost/remark/my/'+0+window.sessionStorage.getItem("userid"),
        headers: { 'Content-Type': 'application/x-www-form-urlencoded' }
    }).then(function successCallback(res) {
        var ob = JSON.parse(JSON.stringify(res.data));
        if(200==ob.code) {
            $scope.remarks = ob.data;
        }

    },function errorCallback(res) {
        console.log(res);
    })
})

/**
 * 头部
 */
myApp.controller('headerCtrl', function ($scope,$http) {
    /**
     * 退出登陆
     */
    $scope.exit=function () {

        $('#my-alert').modal({
            relatedTarget: this,
            onConfirm: function(options){
                //清除信息
                window.sessionStorage.clear();
                $http({
                    method: 'GET',
                    url: 'http://localhost/user/exit',
                    headers: { 'Content-Type': 'application/x-www-form-urlencoded' }
                })
                console.log("退出登陆")
                window.location.href="/index"
            },
            // closeOnConfirm: false,
            onCancel: function() {

            }
        })

    }
});
