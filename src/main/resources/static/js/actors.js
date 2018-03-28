var k_protocol = window.location.protocol;

myApp.controller('actorsCtrl',function ($scope, $http){

    var postData = {
        pageIndex: 1,
        pageSize: 12,
        hasNextPage: true,
        hasPreviousPage:false
    };
    GetAllActors();
    changeClass(postData.pageIndex);
    
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
     * @returns {null}
     */
    $scope.selectActorName=function () {
        console.log($scope.name)
        if ($scope.name==undefined) {
            return;
        }
        $http({
            method: 'GET',
            url: k_protocol+'/actorName/' + $scope.name,
            headers: {'Content-Type': 'application/x-www-form-urlencoded'}
        }).then(function successCallback(res) {
            var ob = JSON.parse(JSON.stringify(res.data));
            if(200==ob.code) {
                //电影数据
                $scope.actorList = ob.data.list;
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
     * 去信息页面
     * @param id
     */
    $scope.info=function (id) {
        window.sessionStorage.setItem("actorId", id);
        window.location.href = 'actor-info';
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

myApp.controller('actorInfoCtrl',function ($scope, $http){
    $http({
        method: 'GET',
        url: k_protocol+'/actor/'+0+window.sessionStorage.getItem("actorId"),
        headers: { 'Content-Type': 'application/x-www-form-urlencoded' }
    }).then(function successCallback(res) {
        var ob = JSON.parse(JSON.stringify(res.data));
        if(200==ob.code) {
            $scope.img = ob.data.img;
            $scope.namecn = ob.data.namecn;
            $scope.nameen = ob.data.nameen;
            $scope.story = ob.data.story;

        }
    },function errorCallback(res) {
        console.log(res);
    })
})