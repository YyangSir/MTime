/* 管理员页面的操作 */

var app=angular.module('adminApp', []);
/**
 * 显示管理员名称
 * 退出管理员
 */
app.controller('adminInfoCtrl', function ($scope, $http) {

    //设置管理员姓名
    console.log(window.sessionStorage.getItem("name"));
    $scope.adminname = window.sessionStorage.getItem("name");

    $scope.exit = function () {
        console.log("退出管理员");
        //移除缓存中管理管理员
        window.sessionStorage.removeItem("name");
        //返回登陆页面
        window.location.href = "tologin";
    }
});

/**
 * 上传电影
 */
app.controller('upMovieCtrl',function ($scope, $http) {
    //收集电影信息
    $scope.movie = {};
    var img;

    $scope.uploadMovie=function () {
        var fd = new FormData();
        var files = document.querySelector('input[name="files"]').files;
        for (var i=0; i<files.length; i++) {
            fd.append("img", files[i]);
        }

        //上传图片
        $http({
            method: 'POST',
            url:'http://localhost/movie/uploadImg',
            data:fd,
            headers: {'Content-Type':undefined},
            transformRequest: angular.identity
        }).then(function successCallback(res) {
            var ob = JSON.parse(JSON.stringify(res.data));
            if("success"==ob.msg&&ob.movieImg!=null) {
                console.log("电影图片上传成功");
                //上传电影信息
                $http({
                    method: 'POST',
                    url:'http://localhost/movie/upload',
                    data:$.param($scope.movie),
                    headers: { 'Content-Type': 'application/x-www-form-urlencoded' }
                }).then(function successCallback(res) {
                    if("success"==ob.msg) {
                        console.log("电影信息上传成功");
                        $('#admin-alert').modal()

                    }
                }, function errorCallback(res) {
                    console.log("上传失败");
                    console.log(res);
                })
            }
        },function errorCallback(res) {
            console.log("图片上传失败");
            console.log(res);
        })

    }
});

/**
 * 查询电影
 */
app.controller('moviesCtrl',function ($scope, $http){
    console.log("查询电影")

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
     * 删除电影
     * @param id
     */
    $scope.deletemovie=function (id) {
        $('#movie-confirm').modal({
            relatedTarget: this,
            onConfirm: function(options) {
                $http({
                    method:'DELETE',
                    url: 'http://localhost/movie/delete_'+id,
                    headers: {'Content-Type': 'application/x-www-form-urlencoded'}
                }).then(function successCallback(res) {
                    var ob = JSON.parse(JSON.stringify(res.data));
                    if("success"==ob.msg) {
                        console.log("删除成功");
                        $('#movie-alert').modal();
                        GetAllMovies();
                    }
                },function errorCallback(res) {
                    console.log(res);
                })
            },
            // closeOnConfirm: false,
            onCancel: function() {

            }
        });
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

});

app.controller('remarkCtrl',function ($scope, $http) {
    var postData = {
        pageIndex: 1,
        pageSize: 6,
        hasNextPage: true,
        hasPreviousPage:false
    };
    GetAllRemarks();

    /**
     * 获取评论
     * @constructor
     */
    function GetAllRemarks() {
        $http({
            method: 'POST',
            url: 'http://localhost/remark/all',
            data: $.param(postData),
            headers: {'Content-Type': 'application/x-www-form-urlencoded'}
        }).then(function successCallback(res) {
            console.log(res.data.list)
            //评论数据
            $scope.remarkList = res.data.list;
            //设置page数量
            $scope.pageNums = res.data.navigatepageNums;
            //是否第一页最后一页
            postData.hasNextPage = res.data.hasNextPage;
            postData.hasPreviousPage = res.data.hasPreviousPage;
        },function errorCallback(res) {
            console.log(res);
        });
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

    /**
     * 删除评论
     * @param id
     */
    $scope.deleteremark=function (id) {

        $('#delete-confirm').modal({
            relatedTarget: this,
            onConfirm: function(options) {
                $http({
                    method:'DELETE',
                    url: 'http://localhost/remark/delete_'+id,
                    headers: {'Content-Type': 'application/x-www-form-urlencoded'}
                }).then(function successCallback(res) {
                    var ob = JSON.parse(JSON.stringify(res.data));
                    if("success"==ob.msg) {
                        $('#remark-alert').modal();
                        GetAllRemarks();
                    }
                },function errorCallback(res) {
                    console.log(res);
                })
            },
            // closeOnConfirm: false,
            onCancel: function() {

            }
        });

    }
})