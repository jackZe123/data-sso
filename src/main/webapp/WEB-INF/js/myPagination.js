var global = { categoryid: ""};
function myPagination(_ref) {
    var pageSize = _ref.pageSize,
        dataTotal = _ref.dataTotal,
        pageAmount = _ref.pageAmount,
        pageTotal =   parseInt(dataTotal / pageAmount)+1,
        // pageTotal = _ref.pageTotal,
        curPage = _ref.curPage,
        id = _ref.id,
        getPage = _ref.getPage,
        showPageTotalFlag = _ref.showPageTotalFlag,
        showSkipInputFlag = _ref.showSkipInputFlag;


    this.pageSize = pageSize || 5; //分页个数
    this.pageTotal = pageTotal; //总共多少页
    this.pageAmount = pageAmount; //每页多少条
    this.dataTotal = dataTotal; //总共多少数据
    this.curPage = curPage || 1; //初始页码
    this.ul = document.createElement('ul');
    this.id = id;
    this.getPage = getPage;
    this.showPageTotalFlag = showPageTotalFlag || false; //是否显示数据统计
    this.showSkipInputFlag = showSkipInputFlag || false; //是否支持跳转
    this.init();
};

// 给实例对象添加公共属性和方法
myPagination.prototype = {
    init: function init() {
        var pagination = document.getElementById(this.id);
        pagination.innerHTML = '';
        this.ul.innerHTML = '';
        pagination.appendChild(this.ul);
        var that = this;
        //首页
        that.firstPage();
        //上一页
        that.lastPage();
        //分页
        that.getPages().forEach(function (item) {
            var li = document.createElement('li');
            if (item == that.curPage) {
                li.className = 'active';
            } else {
                li.onclick = function () {
                    that.curPage = parseInt(this.innerHTML);
                    that.init();
                    // that.getPage(that.curPage);
                    var categoryid = global.categoryid;
                    var pageIndex =that.curPage;
                    var pageSize = 9;
                    console.log(pageIndex);
                    console.log(pageSize);
                    $.ajax({
                        type: "post",
                        url: "../video/getImgByPage",
                        dataType: "json",
                        contentType: "application/x-www-form-urlencoded",
                        data: {
                            "categoryid":categoryid,
                            "pageIndex": pageIndex,
                            "pageSize":pageSize
                        },
                        success: function (datas) {
                            console.log("data: ", datas);
                            var curWwwPath = window.document.location.href;
                            var pathName = window.document.location.pathname;
                            var pos = curWwwPath.indexOf(pathName);
                            var localhostPath = curWwwPath.substring(0,pos);
                            var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
                            var html = "";
                            var dataArr = datas.data;
                            for (var i = 0; i < dataArr.length; i++) {
                                html += '   <div class="video_item" id="video_show">\n' +
                                    '            <a href="'+localhostPath+projectName+'/video/getVideoMessageByVideoId?videoid=' + dataArr[i].videoid + '" target="_Blank">\n' +
                                    '                <img  src="'+localhostPath+projectName+'/img/' + dataArr[i].imgurl + '">\n' +
                                    '            </a>\n' +
                                    '        </div>';
                            }
                            document.getElementsByClassName('left_img_url')[0].innerHTML = html;
                        }
                    })



                };
            }
            li.innerHTML = item;
            that.ul.appendChild(li);
        });
        //下一页
        that.nextPage();
        //尾页
        that.finalPage();

        //是否支持跳转
        if (that.showSkipInputFlag) {
            that.showSkipInput();
        }
        //是否显示总页数,每页个数,数据
        if (that.showPageTotalFlag) {
            that.showPageTotal();
        }
    },
    //首页
    firstPage: function firstPage() {
        var that = this;
        var li = document.createElement('li');
        li.innerHTML = '首页';
        this.ul.appendChild(li);
        li.onclick = function () {
            var val = parseInt(1);
            that.init();
            var categoryid = global.categoryid;
            var pageIndex =1;
            var pageSize = 9;
            console.log(pageIndex);
            console.log(pageSize);
            $.ajax({
                type: "post",
                url: "../video/getImgByPage",
                dataType: "json",
                contentType: "application/x-www-form-urlencoded",
                data: {
                    "categoryid":categoryid,
                    "pageIndex": pageIndex,
                    "pageSize":pageSize
                },
                success: function (datas) {
                    console.log("data: ", datas);
                    var curWwwPath = window.document.location.href;
                    var pathName = window.document.location.pathname;
                    var pos = curWwwPath.indexOf(pathName);
                    var localhostPath = curWwwPath.substring(0,pos);
                    var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
                    var html = "";
                    var dataArr = datas.data;
                    for (var i = 0; i < dataArr.length; i++) {
                        html += '   <div class="video_item" id="video_show">\n' +
                            '            <a href="'+localhostPath+projectName+'/video/getVideoMessageByVideoId?videoid=' + dataArr[i].videoid + '" target="_Blank">\n' +
                            '                <img  src="'+localhostPath+projectName+'/img/' + dataArr[i].imgurl + '">\n' +
                            '            </a>\n' +
                            '        </div>';
                    }
                    document.getElementsByClassName('left_img_url')[0].innerHTML = html;
                }
            })

        };
    },
    //上一页
    lastPage: function lastPage() {
        var that = this;
        var li = document.createElement('li');
        li.innerHTML = '<';
        if (parseInt(that.curPage) > 1) {
            li.onclick = function () {
                that.curPage = parseInt(that.curPage) - 1;
                that.init();
                var categoryid = global.categoryid;
                var pageIndex =that.curPage;
                var pageSize = 9;
                console.log(pageIndex);
                console.log(pageSize);
                $.ajax({
                    type: "post",
                    url: "../video/getImgByPage",
                    dataType: "json",
                    contentType: "application/x-www-form-urlencoded",
                    data: {
                        "categoryid":categoryid,
                        "pageIndex": pageIndex,
                        "pageSize":pageSize
                    },
                    success: function (datas) {
                        console.log("data: ", datas);
                        var curWwwPath = window.document.location.href;
                        var pathName = window.document.location.pathname;
                        var pos = curWwwPath.indexOf(pathName);
                        var localhostPath = curWwwPath.substring(0,pos);
                        var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
                        var html = "";
                        var dataArr = datas.data;
                        for (var i = 0; i < dataArr.length; i++) {
                            html += '   <div class="video_item" id="video_show">\n' +
                                '            <a href="'+localhostPath+projectName+'/video/getVideoMessageByVideoId?videoid=' + dataArr[i].videoid + '" target="_Blank">\n' +
                                '                <img  src="'+localhostPath+projectName+'/img/' + dataArr[i].imgurl + '">\n' +
                                '            </a>\n' +
                                '        </div>';
                        }
                        document.getElementsByClassName('left_img_url')[0].innerHTML = html;
                    }
                })
            };
        } else {
            li.className = 'disabled';
        }
        this.ul.appendChild(li);
    },
    //分页
    getPages: function getPages() {
        var pag = [];
        if (this.curPage <= this.pageTotal) {
            if (this.curPage < this.pageSize) {
                //当前页数小于显示条数
                var i = Math.min(this.pageSize, this.pageTotal);
                while (i) {
                    pag.unshift(i--);
                }
            } else {
                //当前页数大于显示条数
                var middle = this.curPage - Math.floor(this.pageSize / 2),
                    //从哪里开始
                    i = this.pageSize;
                if (middle > this.pageTotal - this.pageSize) {
                    middle = this.pageTotal - this.pageSize + 1;
                }
                while (i--) {
                    pag.push(middle++);
                }
            }
        } else {
            console.error('当前页数不能大于总页数');
        }
        if (!this.pageSize) {
            console.error('显示页数不能为空或者0');
        }
        return pag;
    },
    //下一页
    nextPage: function nextPage() {
        var that = this;
        var li = document.createElement('li');
        li.innerHTML = '>';
        if (parseInt(that.curPage) < parseInt(that.pageTotal)) {
            li.onclick = function () {
                that.curPage = parseInt(that.curPage) + 1;
                that.init();
                var categoryid = global.categoryid;
                var pageIndex =that.curPage;
                var pageSize = 9;
                console.log(pageIndex);
                console.log(pageSize);
                $.ajax({
                    type: "post",
                    url: "../video/getImgByPage",
                    dataType: "json",
                    contentType: "application/x-www-form-urlencoded",
                    data: {
                        "categoryid":categoryid,
                        "pageIndex": pageIndex,
                        "pageSize":pageSize
                    },
                    success: function (datas) {
                        console.log("data: ", datas);
                        var curWwwPath = window.document.location.href;
                        var pathName = window.document.location.pathname;
                        var pos = curWwwPath.indexOf(pathName);
                        var localhostPath = curWwwPath.substring(0,pos);
                        var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
                        var html = "";
                        var dataArr = datas.data;
                        for (var i = 0; i < dataArr.length; i++) {
                            html += '   <div class="video_item" id="video_show">\n' +
                                '            <a href="'+localhostPath+projectName+'/video/getVideoMessageByVideoId?videoid=' + dataArr[i].videoid + '" target="_Blank">\n' +
                                '                <img  src="'+localhostPath+projectName+'/img/' + dataArr[i].imgurl + '">\n' +
                                '            </a>\n' +
                                '        </div>';
                        }
                        document.getElementsByClassName('left_img_url')[0].innerHTML = html;
                    }
                })
            };
        } else {
            li.className = 'disabled';
        }
        this.ul.appendChild(li);
    },
    //尾页
    finalPage: function finalPage() {
        var that = this;
        var li = document.createElement('li');
        li.innerHTML = '尾页';
        this.ul.appendChild(li);
        li.onclick = function () {
            var yyfinalPage = that.pageTotal;
            var val = parseInt(yyfinalPage);
            that.curPage = val;
            that.getPage(that.curPage);
            that.init();
        };
    },
    //是否支持跳转
    showSkipInput: function showSkipInput() {
        var that = this;
        var li = document.createElement('li');
        li.className = 'totalPage';
        var span1 = document.createElement('span');
        span1.innerHTML = '跳转到';
        li.appendChild(span1);
        var input = document.createElement('input');
        input.setAttribute("type","number");
        input.onkeydown = function (e) {
            var oEvent = e || event;
            if (oEvent.keyCode == '13') {
                var val = parseInt(oEvent.target.value);
                if (typeof val === 'number' && val <= that.pageTotal) {
                    that.curPage = val;
                    that.getPage(that.curPage);
                }else{
                    alert("跳转页数不能大于总页数 !")
                }
                that.init();
            }
        };
        li.appendChild(input);
        var span2 = document.createElement('span');
        span2.innerHTML = '页';
        li.appendChild(span2);
        this.ul.appendChild(li);
    },
    //是否显示总页数,每页个数,数据
    showPageTotal: function showPageTotal() {
        var that = this;
        var li = document.createElement('li');
        li.innerHTML = '共&nbsp' + that.pageTotal + '&nbsp页';
        li.className = 'totalPage';
        this.ul.appendChild(li);
        var li2 = document.createElement('li');
        li2.innerHTML = '每页&nbsp' + that.pageAmount + '&nbsp条';
        li2.className = 'totalPage';
        this.ul.appendChild(li2);
        var li3 = document.createElement('li');
        li3.innerHTML = '合计&nbsp' + that.dataTotal + '&nbsp条数据';
        li3.className = 'totalPage';
        this.ul.appendChild(li3);
    }
};
function getImgurl(categoryid){
    global.categoryid=categoryid;
    $.ajax({
        type: "post",
        url: "../video/getImgByCategoryId",
        dataType: "json",
        contentType: "application/x-www-form-urlencoded",
        data: {
            "categoryid":categoryid
        },
        success: function (datas) {
            console.log("data: ", datas);
            var curWwwPath = window.document.location.href;
            var pathName = window.document.location.pathname;
            var pos = curWwwPath.indexOf(pathName);
            var localhostPath = curWwwPath.substring(0,pos);
            var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
            var html = "";
            var dataArr = datas.data.getVideoImgResponses;
            for (var i = 0; i < dataArr.length; i++) {
                html += '   <div class="video_item" id="video_show">\n' +
                    '            <a href="'+localhostPath+projectName+'/video/getVideoMessageByVideoId?videoid=' + dataArr[i].videoid + '" target="_Blank">\n' +
                    '                <img  src="'+localhostPath+projectName+'/img/' + dataArr[i].imgurl + '">\n' +
                    '            </a>\n' +
                    '        </div>';
            }
            document.getElementsByClassName('left_img_url')[0].innerHTML = html;
            var datacount = datas.data.videocount;
            new myPagination({
                id: 'pagination',
                curPage:1, //初始页码
                pageTotal: 20, //总页数
                pageAmount: 9,  //每页多少条
                dataTotal: datacount, //总共多少条数据
                pageSize: 5, //可选,分页个数
                showPageTotalFlag:true, //是否显示数据统计
                showSkipInputFlag:true, //是否支持跳转
            })
        }
    })
}
