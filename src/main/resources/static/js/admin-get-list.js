var k_protocol = window.location.protocol;
/**
 * 电影
 */
app.controller('moviesCtrl',function ($scope, $http){
    console.log("查询电影")

    var postData = {
        pageIndex: 1,
        pageSize: 10,
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
            method: 'GET',
            url: k_protocol+'/movie?page='+postData.pageIndex+"&size="+postData.pageSize,
            headers: {'Content-Type': 'application/x-www-form-urlencoded'}
        }).then(function successCallback(res) {
            var ob = JSON.parse(JSON.stringify(res.data));
            //电影数据
            $scope.movieList = ob.data.list;
            //设置page数量
            $scope.pageNums = ob.data.navigatepageNums;

            //是否第一页最后一页
            postData.hasNextPage = ob.data.hasNextPage;
            postData.hasPreviousPage = ob.data.hasPreviousPage;

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
            url: k_protocol+'/movieName/' + $scope.movieName,
            headers: {'Content-Type': 'application/x-www-form-urlencoded'}
        }).then(function successCallback(res) {
            var ob = JSON.parse(JSON.stringify(res.data));
            //电影数据
            $scope.movieList = ob.data.list;
            //设置page数量
            $scope.pageNums = ob.data.navigatepageNums;
            //是否第一页最后一页
            postData.hasNextPage = ob.data.hasNextPage;
            postData.hasPreviousPage = ob.data.hasPreviousPage;
        },function errorCallback(res) {
            console.log(res);
        });
    }

    /**
     * 删除电影
     * @param id
     */
    $scope.deletemovie=function (id) {
        console.log("删除电影id:" + id);
        $('#movie-confirm').modal({
            relatedTarget: this,
            onConfirm: function(options) {
                $http({
                    method:'DELETE',
                    url: k_protocol+'/movie/delete/'+id,
                    headers: {'Content-Type': 'application/x-www-form-urlencoded'}
                }).then(function successCallback(res) {
                    var ob = JSON.parse(JSON.stringify(res.data));
                    if(200==ob.code) {
                        $scope.message = ob.data;
                        $('#movie-alert').modal();
                        GetAllMovies();
                    }else {
                        $scope.message = "删除失败";
                        $('#movie-alert').modal();
                    }
                },function errorCallback(res) {
                    console.log(res);
                    $scope.message = "删除失败";
                    $('#movie-alert').modal();
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

/**
 * 评论
 */
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
            method: 'GET',
            url: k_protocol+'/remark/all?page='+postData.pageIndex+"&size="+postData.pageSize,
            data: $.param(postData),
            headers: {'Content-Type': 'application/x-www-form-urlencoded'}
        }).then(function successCallback(res) {
            var ob = JSON.parse(JSON.stringify(res.data));
            if(200==ob.code) {
                //评论数据
                $scope.remarks = ob.data.list;
                //设置page数量
                $scope.pageNums = ob.data.navigatepageNums;

                //是否第一页最后一页
                postData.hasNextPage = ob.data.hasNextPage;
                postData.hasPreviousPage = ob.data.hasPreviousPage;
            }else {
                console.log(ob);
            }

        },function errorCallback(res) {
            console.log(res);
        });
    }

    //选择页码
    $scope.changePage=function (num) {

        if(num==0) {
            if(postData.hasPreviousPage) {
                changeClass(--postData.pageIndex)
                GetAllRemarks();
            }
        }
        else if(num==999) {
            if(postData.hasNextPage) {
                changeClass(++postData.pageIndex);
                GetAllRemarks();
            }

        }
        else {
            postData.pageIndex = num;
            changeClass(postData.pageIndex);
            GetAllRemarks();
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
        console.log(id)

        $('#delete-confirm').modal({
            relatedTarget: this,
            onConfirm: function(options) {
                $http({
                    method:'DELETE',
                    url: k_protocol+'/remark/delete_'+id,
                    headers: {'Content-Type': 'application/x-www-form-urlencoded'}
                }).then(function successCallback(res) {
                    var ob = JSON.parse(JSON.stringify(res.data));
                    if(200==ob.code) {
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

/**
 * 演员
 */
app.controller('actorsCtrl',function ($scope, $http) {
    var postData = {
        pageIndex: 1,
        pageSize: 10,
        hasNextPage: true,
        hasPreviousPage:false
    };

    GetAllActors();
    changeClass(postData.pageIndex);

    /**
     * 获取演员列表
     * @constructor
     */
    function GetAllActors() {
        $http({
            method: 'GET',
            url: k_protocol+'/actor?page='+postData.pageIndex+"&size="+postData.pageSize,
            headers: {'Content-Type': 'application/x-www-form-urlencoded'}
        }).then(function successCallback(res) {
            var ob = JSON.parse(JSON.stringify(res.data));
            //电影数据
            $scope.actorList = ob.data.list;
            //设置page数量
            $scope.pageNums = ob.data.navigatepageNums;

            //是否第一页最后一页
            postData.hasNextPage = ob.data.hasNextPage;
            postData.hasPreviousPage = ob.data.hasPreviousPage;

        }, function errorCallback(res) {
            console.log(res);
        });
    }

    /**
     * 按名字查询演员
     */
    $scope.selectActorName=function () {
        $http({
            method: 'GET',
            url: k_protocol+'/actorName/' + $scope.actorName,
            headers: {'Content-Type': 'application/x-www-form-urlencoded'}
        }).then(function successCallback(res) {
            var ob = JSON.parse(JSON.stringify(res.data));
            if(200==ob.code) {
                //演员数据
                $scope.actorList = ob.data.list;
                //设置page数量
                $scope.pageNums = ob.data.navigatepageNums;
                //是否第一页最后一页
                postData.hasNextPage = ob.data.hasNextPage;
                postData.hasPreviousPage = ob.data.hasPreviousPage;
            }else {
                $scope.message = ob.message;
                $('#actors-alert').modal()
            }

        },function errorCallback(res) {
            $scope.message="没有演员信息"
            $('#actors-alert').modal()
            console.log(res);
        });
    }

    /**
     * 删除演员
     * @param id
     */
    $scope.deleteactor=function (id) {
        console.log("删除演员id:" + id);
        $('#actors-confirm').modal({
            relatedTarget: this,
            onConfirm: function(options) {
                $http({
                    method:'DELETE',
                    url: k_protocol+'/actor/delete'+id,
                    headers: {'Content-Type': 'application/x-www-form-urlencoded'}
                }).then(function successCallback(res) {
                    var ob = JSON.parse(JSON.stringify(res.data));
                    if(200==ob.code) {
                        $scope.message = ob.data;
                        $('#actors-alert').modal();
                        GetAllActors();
                    }else {
                        $scope.message = "删除失败";
                        $('#actors-alert').modal();
                    }
                },function errorCallback(res) {
                    console.log(res);
                    $scope.message = "删除失败";
                    $('#actors-alert').modal();
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
                GetAllActors();
            }
        }
        else if(num==999) {
            if(postData.hasNextPage) {
                changeClass(++postData.pageIndex);
                GetAllActors();
            }

        }
        else {
            postData.pageIndex = num;
            changeClass(postData.pageIndex);
            GetAllActors();
        }
    }

    //选中的页码变局域蓝
    function changeClass(num) {
        $scope.show = num;
    }
})

/**
 * 用户列表
 */
app.controller('usersCtrl',function ($scope, $http) {
    var postData = {
        pageIndex: 1,
        pageSize: 10,
        hasNextPage: true,
        hasPreviousPage:false
    };

    GetAllUsers();

    //获取所有用户
    function GetAllUsers() {
        $http({
            method: 'GET',
            url:k_protocol+ '/user?page='+postData.pageIndex+"&size="+postData.pageSize,
            headers: {'Content-Type': 'application/x-www-form-urlencoded'}
        }).then(function successCallback(res) {
            var ob = JSON.parse(JSON.stringify(res.data));
            //设置用户数据
            $scope.userList=ob.data.list;

            //设置page数量
            $scope.pageNums = ob.data.navigatepageNums;

            //是否第一页最后一页
            postData.hasNextPage = ob.data.hasNextPage;
            postData.hasPreviousPage = ob.data.hasPreviousPage;
        },function errorCallback(res) {
            console.log(res);
        })
    }

    //搜索
    $scope.selectUserName=function () {
        $http({
            method: 'GET',
            url:k_protocol+ '/user/name/' + $scope.userName,
            headers: {'Content-Type': 'application/x-www-form-urlencoded'}
        }).then(function (res) {
            var ob = JSON.parse(JSON.stringify(res.data));
            if(200==ob.code) {
                $scope.userList = ob.data.list;
                //设置page数量
                $scope.pageNums = ob.data.navigatepageNums;
                //是否第一页最后一页
                postData.hasNextPage = ob.data.hasNextPage;
                postData.hasPreviousPage = ob.data.hasPreviousPage;
            }else {

            }
        },function (res) {
            $scope.message="没有用户信息"
            $('#users-alert').modal()
            console.log(res);
        })
    }
    //选择页码
    $scope.changePage=function (num) {

        if(num==0) {
            if(postData.hasPreviousPage) {
                changeClass(--postData.pageIndex)
                GetAllActors();
            }
        }
        else if(num==999) {
            if(postData.hasNextPage) {
                changeClass(++postData.pageIndex);
                GetAllActors();
            }

        }
        else {
            postData.pageIndex = num;
            changeClass(postData.pageIndex);
            GetAllActors();
        }
    }

    //选中的页码变局域蓝
    function changeClass(num) {
        $scope.show = num;
    }
})