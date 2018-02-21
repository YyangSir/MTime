var k_protocol = window.location.protocol;
/**
 * 电影列表
 */
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
        console.log($scope.movieName)
        if ($scope.movieName==undefined) {

            return;
        }
        $http({
            method: 'GET',
            url:k_protocol+ '/movieName/' + $scope.movieName,
            headers: {'Content-Type': 'application/x-www-form-urlencoded'}
        }).then(function successCallback(res) {
            var ob = JSON.parse(JSON.stringify(res.data));
            if(200==ob.code) {
                //电影数据
                $scope.movieList = ob.data.list;
                //设置page数量
                $scope.pageNums = ob.data.navigatepageNums;
                //是否第一页最后一页
                postData.hasNextPage = ob.data.hasNextPage;
                postData.hasPreviousPage = ob.data.hasPreviousPage;
            }else if(400==ob.code) {
                console.log(ob.message)
            }

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