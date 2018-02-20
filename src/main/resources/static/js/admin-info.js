/**
 * 管理员登陆
 */
app.controller('adminLoginCtrl',function ($scope, $http) {
    $scope.admin = {};
    $scope.login=function () {
        $http({
            method: 'POST',
            url: 'http://localhost/admin/login',
            data:$.param($scope.admin),
            headers: { 'Content-Type': 'application/x-www-form-urlencoded' }
        }).then(function successCallback(res) {
            var ob = JSON.parse(JSON.stringify(res.data));
            if(200==ob.code){
                console.log("登陆成功");
                window.sessionStorage.setItem("admin-name", ob.data[0].name);
                window.location.href = "admin-index";
            }else {
                $scope.message = ob.message;
                $('#login-alert').modal();
            }
        },function errorCallback(res) {
            console.log(res);
        })
    }
})

/**
 * 显示管理员名称
 * 退出管理员
 */
app.controller('adminInfoCtrl', function ($scope, $http) {

    //设置管理员姓名
    console.log(window.sessionStorage.getItem("admin-name"));
    $scope.adminname = window.sessionStorage.getItem("admin-name");

    $scope.exit = function () {
        console.log("退出管理员");
        //移除缓存中管理管理员
        window.sessionStorage.removeItem("admin-name");
        $http({
            method: 'GET',
            url: 'http://localhost/admin/exit',
            headers: { 'Content-Type': 'application/x-www-form-urlencoded' }
        })
        //返回登陆页面
        window.location.href = "admin-login";
    }
});
