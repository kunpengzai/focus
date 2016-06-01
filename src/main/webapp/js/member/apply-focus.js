$(function() {
    $('#file').on('click',function() {
        uploadImg("file");
    });
    $('.apply-btn').on('click',function() {
        if (validateData()) {
            var medicalHistory = $.trim($("#medicalHistory").val());
            $("#medicalHistory").val(medicalHistory.substr(1));
            $('.apply-btn').off('touchend');
            $('#apply-form').submit();
        }
    });
    $('.error-layer').on('touchstart',function() {
        $('.error-layer').hide();
    });
    $('.error-layer').on('click',function() {
        $('.error-layer').hide();
    });
});

function validateData() {
    var phoneNumber = $.trim($("#phoneNumber").val());
    if (phoneNumber == '' || phoneNumber == "请选择") {
        errorMsg("请填写手机号");
        return false;
    }
    var reg = /^1[3|4|5|7|8][0-9]\d{4,8}$/;
    if (!reg.test(phoneNumber)) {
        errorMsg("手机号不正确");
        return false;
    }
    var weixinId = $.trim($("#weixinId").val());
    if (weixinId == '' || weixinId == "请选择") {
        errorMsg("请填写微信号");
        return false;
    }
    var name = $.trim($("#name").val());
    if (name == '' || name == "请选择") {
        errorMsg("请填写姓名");
        return false;
    }
    var gender = $.trim($("#gender").val());
    if (gender == 0) {
        errorMsg("请选择性别");
        return false;
    }

    var addr = $.trim($("#addr").val());
    if (addr == '') {
        errorMsg("请选择地区");
        return false;
    }

    var birth = $.trim($("#birth").val());
    if (birth == '') {
        errorMsg("请填写生日");
        return false;
    }

    var height = $.trim($("#height").val());
    if (height == '') {
        errorMsg("请填写身高");
        return false;
    }
    var reg2 = /^\d{1,3}$/;
    if (!reg2.test(height)) {
        errorMsg("身高不正确");
        return false;
    }

    var weight = $.trim($("#weight").val());
    if (weight == '') {
        errorMsg("请填写体重");
        return false;
    }
    var reg3 = /^\d{1,6}(.\d{0,2})?$/;
    if (!reg3.test(weight)) {
        errorMsg("体重不正确");
        return false;
    }

    var targetWeight = $.trim($("#targetWeight").val());
    if (targetWeight == '') {
        errorMsg("请填写目标体重");
        return false;
    }
    if (!reg3.test(targetWeight)) {
        errorMsg("目标体重不正确");
        return false;
    }

    var medicalHistory = $.trim($("#medicalHistory").val());
    if (medicalHistory == '') {
        errorMsg("请选择“有无病史”");
        return false;
    }

    var dietExperience = $.trim($("#dietExperience").val());
    if (dietExperience == '') {
        errorMsg("请选择“有无节食减肥的经历”");
        return false;
    }

    var dietPillExperience = $.trim($("#dietPillExperience").val());
    if (dietPillExperience == '') {
        errorMsg("请选择“有无吃减肥药减肥的经历”");
        return false;
    }

    var sugaredDrinkRate = $.trim($("#sugaredDrinkRate").val());
    if (sugaredDrinkRate == '') {
        errorMsg("请选择“饮用含糖饮料的频率”");
        return false;
    }

    var dineTogether = $.trim($("#dineTogether").val());
    if (dineTogether == '') {
        errorMsg("请选择“跟朋友/同事经常聚餐吗”");
        return false;
    }

    var loseWeightTarget = $.trim($("#loseWeightTarget").val());
    if (loseWeightTarget == '') {
        errorMsg("请选择“减肥的主要目的”");
        return false;
    }

    var oilyFood = $.trim($("#oilyFood").val());
    if (oilyFood == '') {
        errorMsg("请选择“平时喜欢吃油腻的食物吗”");
        return false;
    }
    return true;
}

function errorMsg(content) {
    $(".error-msg").text(content);
    $(".error-layer").show();
    setTimeout(function() {
        $(".error-msg").text("");
        $(".error-layer").hide();
    }, 500);
}

function selCheckBoxValue(paramName,number, e) {
    var paramValue = $("#"+paramName).val();
    if ($(e).first().find("img").attr("src") == "../img/member/checkbox-unsel-icon.png") {
        if (number == 1) {
            $(".eval-item-answer-"+paramName).find("img").attr("src", "../img/member/checkbox-unsel-icon.png");
            $(".eval-item-answer-"+paramName).find("span").css("color", "#4d4d4d");
            paramValue = "," + number;
        } else {
            $(".eval-item-answer-"+paramName).children().first().find("img").attr("src", "../img/member/checkbox-unsel-icon.png");
            $(".eval-item-answer-"+paramName).children().first().find("span").css("color", "#4d4d4d");
            paramValue = paramValue.replace(",1", "");
            paramValue += "," + number;
        }
        console.log(paramValue);
        $(e).first().find("img").attr("src", "../img/member/checkbox-icon.png");
        $(e).first().find("span").css("color", "#24c789");
    } else {
        paramValue = paramValue.replace(","+number, "");
        console.log(paramValue);
        $(e).first().find("img").attr("src", "../img/member/checkbox-unsel-icon.png");
        $(e).first().find("span").css("color", "#4d4d4d");
    }
    $("#"+paramName).val(paramValue);
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

function changeAvatarFile() {
    return $('#file').click();
}

function uploadImg(e) {
    document.getElementById(e).onchange = function(evt) {
        // 如果浏览器不支持FileReader，则不处理
        if (!window.FileReader) return;
        var files = evt.target.files;
        // 判断是否图片
        if (!files[0]) return;
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
                    document.getElementById('logoShow').src = e.target.result;// img 元素
                };
            })(f);
            reader.readAsDataURL(f);
        }
    }
}

function setSelectAddress(pId, pName, cId, cName) {
    $("#provinceId").val(pId);
    $("#provinceName").val(pName);
    $("#cityId").val(cId);
    $("#cityName").val(cName);
    $("#addr").val(pName+cName);
}

function getAreaList() {
    var result="";
    $.ajax({
        url: 'getAreaList.htm',
        type: "POST",
        dataType: "json",
        cache : false,
        async : false,
        success: function(data) {
            if (data && data.flag == 0) {
                var list = JSON.parse(data.areaList);
                result = list
            } else {
            }
        },
        error:function() {
        }
    });
    return result;
}

cityData = getAreaList();

function initCityPicker(e) {
    cityPicker = e;
}