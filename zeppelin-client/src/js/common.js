/**
 * Created by zhanglei on 2016/1/12.
 */
var s1,s2;
$(document).ready(function(){
    // 组件导航栏加载
    $.ajax({
        url: "http://133.133.133.53:8080/api/module/modules",
        type: "GET",
        dataType:"json",
        success:function(data){
            $.each(data.body,function(key,infos) {
                $('#modules-nav').append("<li class=\"dropdown\"><a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">"+key+"<strong class=\"caret\"></strong></a>");
                $('#modules-nav').append("<ul class=\"dropdown-menu\">");
                appendModules(module);
                $('#modules-nav').append("</ul></li>");
            });
        }
    });


    // 组件弹窗部分
    $("#model_connect").click(function(){
        $.post("xxxxxx", $("#modal-container-502747-form").serialize(), function (result) {console.log(result) }, "json");
        $('#modal-container-502747').modal('hide');
    });
    $.ajax({
        type : "get",//请求方式
        url : "http://133.133.133.53:8080/api/module/input;name=FileInput",//发送请求地址
        dataType : "json",
        success :function(data) {
            var status=data.status;
            var message=data.message;
            var bodyMap=data.body;
            $.each(bodyMap,function(key,value){
                var innerStr=' <input type="text" class="form-control" id="'+key+'" placeholder="'+value+'">';
                if(key=='driver')
                    innerStr='<select class="form-control" id="'+key+'">'+
                        '<option>mysql</option>'+
                        '<option>oracle</option>'+
                        '</select>'
                if(key=='password')
                    innerStr=' <input type="password" class="form-control" id="'+key+'" placeholder="'+value+'">';
                var str='<div class="form-group">'+
                    '<label for="'+key+'" class="col-sm-2 control-label">'+value+'</label>'+
                    ' <div class="col-sm-10">'+
                    innerStr+
                    ' </div></div>';
                $("#modal-container-502747-form").append(str);
            });
        }
    });
});
