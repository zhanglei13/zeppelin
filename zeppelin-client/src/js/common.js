/**
 * Created by zhanglei on 2016/1/12.
 */

$(document).ready(function(){
    // 组件导航栏加载
    $.ajax({
        url: "http://133.133.133.53:8080/api/module",
        type: "GET",
        dataType:"json",
        success:function(data){
            var content = "";
            var keyCount=1;
            $.each(data.body,function(key,moduleList) {
                content += "<li class=\"dropdown\"><a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">"+key+"<strong class=\"caret\"></strong></a>";
                content += "<ul class=\"dropdown-menu\">";

                $.each(moduleList, function(i, item) {
                    content += "<li><a id='module_"+keyCount+"_"+i+"' type='"+item.type+"' name='"+item.name+"'>"+item.nameCN+"</a></li>";
                });
                keyCount++;
                content += "</ul></li>";
            });
            $('#modules-nav').append(content);
            $("a[id^=module_]").click(function(){
                //first empty children under the form
                $("#modal-container-502747-form").empty();
                //console.log("http://133.133.133.53:8080/api/module/"+$(this).attr("type")+";name="+$(this).attr("name"));
                $.ajax({
                    type : "get",//请求方式
                    url : "http://133.133.133.53:8080/api/module/"+$(this).attr("type")+";name="+$(this).attr("name"),//发送请求地址
                    dataType : "json",
                    success :function(data) {
                        var status=data.status;
                        var message=data.message;
                        var bodyMap=data.body;
                        $.each(bodyMap,function(key,value){
                            var innerStr=' <input type="text" class="form-control"  name="'+key+'" id="'+key+'" placeholder="'+value+'">';
                            if(key=='driver')
                                innerStr='<select class="form-control"  name="'+key+'" id="'+key+'">'+
                                    '<option>mysql</option>'+
                                    '<option>oracle</option>'+
                                    '</select>'
                            if(key=='password')
                                innerStr=' <input type="password" class="form-control"  name="'+key+'" id="'+key+'" placeholder="'+value+'">';
                            var str='<div class="form-group">'+
                                '<label for="'+key+'" class="col-sm-2 control-label">'+value+'</label>'+
                                ' <div class="col-sm-10">'+
                                innerStr+
                                ' </div></div>';
                            $("#modal-container-502747-form").append(str);
                        });
                        $('#modal-container-502747').modal('show');
                    }
                });
            });
        }
    });


    // 组件弹窗部分
    $("#model_connect").click(function(){
        console.log($("#modal-container-502747-form").serialize());
        $.get("http://133.133.133.53:8080/api/module/execute", $("#modal-container-502747-form").serialize(), function (result) {console.log(result) }, "json");
        $('#modal-container-502747').modal('hide');
    });

});
