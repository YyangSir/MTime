
/**
 * 电影详细信息
 */
myApp.controller('movieCtrl',function ($scope,$http) {

    $http({
        method: 'GET',
        url: 'http://localhost/movie/'+0+window.sessionStorage.getItem("movieId"),
        headers: { 'Content-Type': 'application/x-www-form-urlencoded' }
    }).then(function successCallback(res) {
        var ob = JSON.parse(JSON.stringify(res.data));
        if(200==ob.code) {
            $scope.img = ob.data.img;
            $scope.titlecn = ob.data.titlecn;
            $scope.titleen = ob.data.titleen;
            $scope.type = ob.data.type;
            $scope.moviesTime = ob.data.time;
            $scope.director = ob.data.director;
            $scope.story = ob.data.story;
            // $scope.actors = ob.data.actors;
            $scope.actors=ob.data.actors.split(" ")
        }

    },function errorCallback(res) {
        console.log(res);
    })

    /**
     * 点击演员姓名
     * @param name
     */
    $scope.actorInfo=function (name) {
        $http({
            method: 'GET',
            url: 'http://localhost/actorName/' + name,
            headers: {'Content-Type': 'application/x-www-form-urlencoded'}
        }).then(function successCallback(res) {
            var ob = JSON.parse(JSON.stringify(res.data));
            if(200==ob.code) {
                //演员数据
                $scope.actorList = ob.data.list;
            }else {
                $scope.message = ob.message;
                $('#actors-alert').modal()
            }

        },function errorCallback(res) {
            console.log(res);
        });
    }
})

/**
 * 评论
 */
myApp.controller('remarkCtrl',function ($scope,$http) {

    var movieId=window.sessionStorage.getItem("movieId");
    var userId=window.sessionStorage.getItem("userid");

    getMovieRemark();

    /**
     * 添加评论
     */
    $scope.remark=function () {
        var remark= {
            "content":$scope.content,
            "movieId":movieId,
            "userId":userId}
        $http({
            method: 'POST',
            url:'http://localhost/remark',
            data:$.param(remark),
            headers: { 'Content-Type': 'application/x-www-form-urlencoded' }
        }).then(function successCallback(res) {
            var ob = JSON.parse(JSON.stringify(res.data));
            if(200==ob.code){
                $('#successRemark-alert').modal();
                getMovieRemark();
                $scope.content = "";
            }else {
                console.log(ob)
                $('#errorRemark-alert').modal();
            }
        },function errorCallback(res) {
            console.log(res)
            $('#errorRemark-alert').modal();
        });
    }

    /**
     * 获取电影评论
     */
    function getMovieRemark() {
        $http({
            method:'GET',
            url:'http://localhost/remark/'+0+window.sessionStorage.getItem("movieId"),
            headers: { 'Content-Type': 'application/x-www-form-urlencoded' }
        }).then(function successCallback(res) {
            var ob = JSON.parse(JSON.stringify(res.data));
            if (200==ob.code){
                $scope.remarks = ob.data;
            }
        },function errorCallback(res) {
            console.log(res)
        });
    }

})