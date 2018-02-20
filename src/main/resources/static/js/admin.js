
/**
 * 上传电影
 */
app.controller('upMovieCtrl',function ($scope, $http) {

    //收集电影信息
    $scope.movie = {};
    var img;

    $scope.uploadMovie=function () {
        //图片处理
        var fd = new FormData();
        var files = document.querySelector('input[name="files"]').files;
        for (var i=0; i<files.length; i++) {
            fd.append("img", files[i]);
        }

        //复选框类型处理
        var temp=" ";
        for(attr in $scope.movie.type){
            temp +=$scope.movie.type[attr]+" "
        }
        $scope.movie.type = temp.toString();

        //上传图片
        $http({
            method: 'POST',
            url:'http://localhost/upload/movie',
            data:fd,
            headers: {'Content-Type':undefined},
            transformRequest: angular.identity
        }).then(function successCallback(res) {
            var ob = JSON.parse(JSON.stringify(res.data));
            $scope.movie.img = ob.data;
            console.log("电影图片：" + $scope.movie.img);

            if(200==ob.code) {
                //上传电影信息
                $http({
                    method: 'POST',
                    url:'http://localhost/movie',
                    data:$.param($scope.movie),
                    headers: { 'Content-Type': 'application/x-www-form-urlencoded' }
                }).then(function successCallback(res) {
                    var ob = JSON.parse(JSON.stringify(res.data));

                    if(200==ob.code) {
                        $scope.message = ob.data;
                        $('#admin-alert').modal()
                    }else {
                        $scope.message="电影上传失败";
                        $('#admin-alert').modal()
                    }

                }, function errorCallback(res) {
                    $scope.message="上传失败";
                    $('#admin-alert').modal()
                    console.log(res);
                })
            }
        },function errorCallback(res) {
            $scope.message = "图片上传失败";
            console.log(res);
        })

    }
});

/**
 * 上传演员
 */
app.controller('upActorCtrl',function ($scope, $http) {
    //收集演员信息
    $scope.actor = {};

    $scope.uploadActor=function () {
        var fd = new FormData();
        var files = document.querySelector('input[name="files"]').files;
        for (var i=0; i<files.length; i++) {
            fd.append("img", files[i]);
        }

        //传图
        $http({
            method: 'POST',
            url:'http://localhost/upload/actor',
            data:fd,
            headers: {'Content-Type':undefined},
            transformRequest: angular.identity
        }).then(function successCallback(res) {
            var ob = JSON.parse(JSON.stringify(res.data));
            $scope.actor.img = ob.data;
            console.log($scope.actor.img)

            //传信息
            $http({
                method: 'POST',
                url:'http://localhost/actor',
                data:$.param($scope.actor),
                headers: { 'Content-Type': 'application/x-www-form-urlencoded' }
            }).then(function successCallback(res) {
                var ob = JSON.parse(JSON.stringify(res.data));

                if(200==ob.code) {
                    $scope.message = ob.data;
                    $('#actor-alert').modal()
                }else {
                    $scope.message = "信息上传失败";
                    $('#actor-alert').modal()
                }
            },function errorCallback(res) {
                console.log(res)
            })
            
        },function errorCallback(res) {
            $scope.message = "图片上传失败";
            console.log(res);
        })
    }
})
