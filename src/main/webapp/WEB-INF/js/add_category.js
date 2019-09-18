/* 显示添加窗口 */
function show_add_category(){
    var add_sort = document.getElementsByClassName("add_sort")[0];
    var cover = document.getElementsByClassName("cover")[0];
    add_sort.style.display = "block";
    cover.style.display = "block";
    add_sort.style.left = (document.body.scrollWidth - add_sort.scrollWidth) / 2 + "px";
    add_sort.style.top = "100px";
}
function close_add(){
    var add_sort = document.getElementsByClassName("add_sort")[0];
    var cover = document.getElementsByClassName("cover")[0];
    add_sort.style.display = "none";
    cover.style.display = "none";
}
function add_category() {
    var categoryname =$("#add_category_name").val();
    var categorysynopsis =$("#add_category_intro").val();
    console.log(categoryname);
    console.log(categorysynopsis);
    $.ajax({
        type: "post",
        url: "../category/addCategory",
        dataType: "json",
        contentType: "application/x-www-form-urlencoded",
        data: {
            "categoryname": categoryname,
            "categorysynopsis":categorysynopsis
        },
        success:function(datas){
            console.log(datas.status);
            if(datas.status==200){
                //响应成功
                $(".add_sort").hide();
                $(".cover").hide();
                var innerLi="";
                innerLi=innerLi+"<div class=\"info_table\" id=\"div"+datas.data.id+"\"><ul><li>"+datas.data.id+"</li><li>"+datas.data.categoryName+"</li><li>"+datas.data.categorySynopsis+"</li><li>"+datas.data.createTime+"</li><li>"+datas.data.updateTime+"</li><li><a href=\"javascript:void(0)\" onclick=\"deleteCategory("+datas.data.id+")\" >删除</a></li></ul></div>";
                $("#add_").append(innerLi);
                alert("添加成功！");
            }else{
                //响应失败
                alert("添加失败！");
            }
        }
    })
}