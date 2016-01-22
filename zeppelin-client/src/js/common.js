/**
 * Created by zhanglei on 2016/1/12.
 */
$(document).ready(function(){
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
