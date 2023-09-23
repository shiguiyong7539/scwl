function Paging(options) {
    let defaultValue = {
        total: 0,
        current: 1,
        firstText: '首页',
        prevText: '上一页',
        nextText: '下一页',
        lastText: '尾页',
        PageSize: 10,
        PageNum: 5,
        container: document.getElementsByClassName('paging')[0]
    }

    this.options = Object.assign({}, defaultValue, options);
    this.show();
    this.PageClick()
}

Paging.prototype.show = function () {
    let disable = "";
    let PageTotalNum = this.getPageTotalNum();
    this.options.container.innerHTML = "";
    if(this.options.current === 1){
        disable = 'disable'
    }
    this.createElement('first ' + disable, this.options.firstText);
    this.createElement('prev ' + disable, this.options.prevText);

    this.createNumElement();

    disable = ""
    if(this.options.current === PageTotalNum){
        disable = 'disable'
    }
    this.createElement('next ' + disable, this.options.nextText);
    this.createElement('last ' + disable, this.options.lastText);

    let span = document.createElement('span');
    let i = `<i>${this.options.current}</i>/<i>${PageTotalNum}</i>`;
    span.innerHTML = i;
    this.options.container.appendChild(span)
}

Paging.prototype.createNumElement = function() {
    let min = this.options.current - Math.floor(this.options.PageNum / 2);
    if(min < 1) {
        min = 1;
    }
    let max = min + this.options.PageNum - 1;
    let PageTotalNum = this.getPageTotalNum();
    if (max > PageTotalNum){
        max = PageTotalNum;
    }
    let active = "";
    for(let i = min; i <= max; i ++) {
        if(this.options.current === i) {
            active = 'active';
        }else{
            active = '';
        }
        this.createElement('pagingDiv ' + active, i);
    }
}


Paging.prototype.createElement = function(specialStyle, content) {
    let oDiv = document.createElement('div');
    oDiv.className = specialStyle;
    oDiv.innerHTML = content;
    this.options.container.appendChild(oDiv);
}

Paging.prototype.getPageTotalNum = function() {
    return Math.ceil(this.options.total / this.options.PageSize)
}

Paging.prototype.PageClick = function() {
    let _this = this;
    let PageTotalNum = this.getPageTotalNum();
    this.options.container.addEventListener('click', function(e) {
        if(e.target.classList.contains('first')){
            _this.toPage(1);
        } else if (e.target.classList.contains('prev')) {
            _this.toPage(_this.options.current - 1);
        } else if (e.target.classList.contains('next')) {
            _this.toPage(_this.options.current + 1);
        } else if (e.target.classList.contains('last')) {
            _this.toPage(PageTotalNum);
        } else if(e.target.classList.contains('pagingDiv')){
            _this.toPage(+e.target.innerText);
        }
    })
}

Paging.prototype.toPage = function (page){
    let PageTotalNum = this.getPageTotalNum();
    if(page < 1) {
        page = 1;
    }
    if(page > PageTotalNum){
        page = PageTotalNum;
    }
    $.ajax({
        url:'/tourist/allList',
        type:'post',
        data:({
                touristip: $("#touristip").val(),
                logintimeStart: $("#logintimeStart").val(),
                logintimeEnd: $("#logintimeEnd").val(),
                levelnumStart: $("#levelnumStart").val(),
                levelnumEnd: $("#levelnumEnd").val(),
                column1Start: $("#column1Start").val(),
                column1End: $("#column1End").val(),
                column3: $("#column3").val(),
                column2Start: $("#column2Start").val(),
                column2End: $("#column2End").val(),
                pageNum:page,
                pageSize:10
        }),
        success:function(res){console.log(res)
            var str = '';
            var num = 1;
            for (var i = 0; i < res.list.length; i++) {
                str+='<tr>' +
                    '<td nowrap>'+num+++'</td>' +
                    '<td nowrap>'+res.list[i].touristip+'</td>' +
                    '<td nowrap>'+res.list[i].logintime+'</td>' +
                    '<td nowrap>'+res.list[i].levelnum+'</td>' +
                    '<td nowrap>'+res.list[i].column1+'</td>' +
                    '<td nowrap>'+res.list[i].column2+'</td>' +
                    '</tr>';
            }
            $("#resultTbody").html(str);

        },
        error:function(){
            alert('系统异常！');
        }
    });
    this.options.current = page;
    this.show()
}