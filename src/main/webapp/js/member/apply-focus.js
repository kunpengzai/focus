$(function(){
    $('#file').on('click',function() {
        uploadImg("file");
    });
    $('.apply-btn').on('click',function() {
        if (validateData()) {
            $('.apply-btn').off('touchend');
            $('#apply-form').submit();
        }
    });
    $('.error-layer').on('touchstart',function(){
        $('.error-layer').hide();
    });
    $('.error-layer').on('click',function(){
        $('.error-layer').hide();
    });
});

function validateData() {
    var phoneNumber = $.trim($("#phoneNumber").val());
    if (phoneNumber == '' || phoneNumber == "请选择") {
        $(".error-msg").text("手机号不能为空");
        $(".error-layer").show();
        return false;
    }
    var reg = /^1[3|4|5|7|8][0-9]\d{4,8}$/;
    if (!reg.test(phoneNumber)) {
        $(".error-msg").text("手机号不正确");
        $(".error-layer").show();
        return false;
    }
    var weixinId = $.trim($("#weixinId").val());
    if (weixinId == '' || weixinId == "请选择") {
        $(".error-msg").text("微信号不能为空");
        $(".error-layer").show();
        return false;
    }
    var name = $.trim($("#name").val());
    if (name == '' || name == "请选择") {
        $(".error-msg").text("姓名不能为空");
        $(".error-layer").show();
        return false;
    }
    return true;
}

function selMedicalHistory(number, e) {
    var medicalHistory = $("#medicalHistory").val();
    if ($(e).first().find("img").attr("src") == "../img/member/checkbox-unsel-icon.png") {
        if (number == 1) {
            //console.log($(".eval-item-answer").find("img"));
            $(".eval-item-answer-medicalHistory").find("img").attr("src", "../img/member/checkbox-unsel-icon.png");
            $(".eval-item-answer-medicalHistory").find("span").css("color", "#4d4d4d");
            medicalHistory = "," + number;
        } else {
            //console.log($(".eval-item-answer").first());
            $(".eval-item-answer-medicalHistory").children().first().find("img").attr("src", "../img/member/checkbox-unsel-icon.png");
            $(".eval-item-answer-medicalHistory").children().first().find("span").css("color", "#4d4d4d");
            medicalHistory = medicalHistory.replace(",1", "");
            medicalHistory += "," + number;
        }
        console.log(medicalHistory);
        $(e).first().find("img").attr("src", "../img/member/checkbox-icon.png");
        $(e).first().find("span").css("color", "#24c789");
    } else {
        medicalHistory = medicalHistory.replace(","+number, "");
        console.log(medicalHistory);
        $(e).first().find("img").attr("src", "../img/member/checkbox-unsel-icon.png");
        $(e).first().find("span").css("color", "#4d4d4d");
    }
    $("#medicalHistory").val(medicalHistory);
}

function setRadioValue(paramName, number, e) {
    if ($(e).first().find("img").attr("src") == "../img/member/radio-unsel-icon.png") {
        $(".eval-item-answer-"+paramName).find("img").attr("src", "../img/member/radio-unsel-icon.png");
        $(".eval-item-answer-"+paramName).find("span").css("color", "#4d4d4d");
        $(e).first().find("img").attr("src", "../img/member/radio-icon.png");
        $(e).first().find("span").css("color", "#24c789");
        $("#"+paramName).val(number);
    }
}


function changeAvatarFile(){
    return $('#file').click();
}

function uploadImg(e) {
    document.getElementById(e).onchange = function(evt) {
        // 如果浏览器不支持FileReader，则不处理
        if (!window.FileReader) return;
        var files = evt.target.files;
        // 判断是否图片
        if (!files[0]) {
            return;
        }
//        // 判断图片格式
//        if (!(files[0].type.indexOf('image') == 0 && img.type && /\.(?:jpg|png|gif)$/.test(img.name))) {
//            alert('图片只能是jpg,gif,png');
//            return;
//        }
        for (var i = 0, f; f = files[i]; i++) {
            if (!f.type.match('image.*')) {
                continue;
            }
            var reader = new FileReader();
            reader.onload = (function (theFile) {
                return function (e) {
                    // img 元素
                    document.getElementById('logoShow').src = e.target.result;
                };
            })(f);
            reader.readAsDataURL(f);
        }
    }
}

function setSelectAddress(address) {
    console.log(address);
    $("#addr").val(address);
}

function getAreaList (){
    var result="";
    $.ajax({
        url: 'getAreaList.htm',
        type: "POST",
        dataType: "json",
        cache : false,
        async : false,
        success: function(data){
            if(data && data.flag == 0) {
                var list = JSON.parse(data.areaList);
                result = list
            }else{

            }
        },
        error:function(){
        }
    });
    return result;
}

cityData=getAreaList();
function initCityPicker(e){
    cityPicker=e;
}