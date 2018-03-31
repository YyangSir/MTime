var k_protocol = window.location.protocol;
/**
 * 电影详细信息
 */
myApp.controller('movieCtrl',function ($scope,$http) {


    $http({
        method: 'GET',
        url: k_protocol+'/movie/'+0+window.sessionStorage.getItem("movieId"),
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


            $('#readOnly-demo').raty({
                readOnly: true,
                score: ob.data.rating
            });
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
            url: k_protocol+'/actorName/' + name,
            headers: {'Content-Type': 'application/x-www-form-urlencoded'}
        }).then(function successCallback(res) {
            var ob = JSON.parse(JSON.stringify(res.data));
            if(200==ob.code) {
                window.sessionStorage.setItem("actorId", ob.data.list[0].actorid);
                window.location.href = 'actor-info';
            }else {
                $scope.message = ob.message;
                $('#actor-alert').modal()
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
        console.log('评论分数 ' + s);
        var remark= {
            "content":$scope.content,
            "score":s,
            "movieId":movieId,
            "userId":userId}
        $http({
            method: 'POST',
            url:k_protocol+'/remark',
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
            url:k_protocol+'/remark/'+0+window.sessionStorage.getItem("movieId"),
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