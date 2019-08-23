/**
 * angularjs��ҳ�ؼ�
 * Created by CHEN on 2016/11/1.
 */
angular.module('myModule', []).directive('myPagination', function () {
    return {
        restrict: 'EA',
        replace: true,
        scope: {
            option: '=pageOption'
        },
        template: '<ul class="pagination">' +
        '<li ng-click="pageClick(p)" ng-repeat="p in page " class="{{option.curr==p?\'active\':\'\'}}">' +
        '<a href="javascript:;">{{p}}</a>' +
        '</li>' +
        '</ul>',
        link: function ($scope) {

            if (!$scope.option.curr || isNaN($scope.option.curr) || $scope.option.curr == 'undefined' || $scope.option.curr < 1) $scope.option.curr = 1;
            if (!$scope.option.all || isNaN($scope.option.all) || $scope.option.all < 1) $scope.option.all = 1;
            if ($scope.option.curr > $scope.option.all) $scope.option.curr = $scope.option.all;
            if (!$scope.option.count || isNaN($scope.option.count) || $scope.option.count < 1) $scope.option.count = 10;


            $scope.page = getRange($scope.option.curr, $scope.option.all, $scope.option.count);


            $scope.pageClick = function (page) {
                if (page == '首页') {
                    page = 0;
                }
                if (page == '尾页') {
                    page = $scope.option.all;
                }
                if (page == '<') {
                    page = parseInt($scope.option.curr) - 1;
                } else if (page == '>') {
                    page = parseInt($scope.option.curr) + 1;
                }
                if (page < 1) page = 1;
                else if (page > $scope.option.all) page = $scope.option.all;

                if (page == $scope.option.curr) return;
                if ($scope.option.click && typeof $scope.option.click === 'function') {
                    $scope.option.click(page);
                    $scope.option.curr = page;
                    $scope.page = getRange($scope.option.curr, $scope.option.all, $scope.option.count);
                }
            };


            function getRange(curr, all, count) {

                curr = parseInt(curr);
                all = parseInt(all);
                count = parseInt(count);
                var from = curr - parseInt(count / 2);
                var to = curr + parseInt(count / 2) + (count % 2) - 1;
                //��ʾ��ҳ���ݴ���
                if (from <= 0) {
                    from = 1;
                    to = from + count - 1;
                    if (to > all) {
                        to = all;
                    }
                }
                if (to > all) {
                    to = all;
                    from = to - count + 1;
                    if (from <= 0) {
                        from = 1;
                    }
                }
                var range = [];
                for (var i = from; i <= to; i++) {
                    range.push(i);
                }
                range.unshift("首页")
                range.push("尾页")
                range.push('>');
                range.unshift('<');
                return range;
            }

        }
    }
});