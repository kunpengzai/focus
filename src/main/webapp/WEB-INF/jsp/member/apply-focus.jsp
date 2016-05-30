<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../layout/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <script>
        var phoneWidth = parseInt(window.screen.width);
        var phoneScale = phoneWidth / 640;
        document.write('<meta name="viewport" content="width=540, initial-scale = ' + phoneScale + ', maximum-scale = ' + phoneScale + ', user-scalable=no target-densitydpi=device-dpi">');
    </script>
    <meta charset="utf-8"/>
    <meta name="format-detection" content="telephone=no">
    <meta name="apple-mobile-web-app-capable" content="yes" />
    <meta name="apple-mobile-web-app-status-bar-style" content="black" />
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta name="keywords" content="Focus减肥俱乐部" />
    <meta name="description" content="Focus减肥俱乐部" />
    <link rel="shortcut icon" href="<%=path%>/img/favicon.ico">
    <title>我要报名</title>
    <link rel="stylesheet" href="<%=path%>/css/member/apply-focus.css?t=20151206021"/>
</head>
<body>
    <div class="main">
    <c:choose>
        <c:when test="${product != null}">
        <form id="apply-form" role="form" enctype="multipart/form-data" action="apply-data.htm" method="post">
            <div class="apply-interval"></div>
            <div class="head-part">
                <span>${product.title}</span>
            </div>
            <div class="apply-head-item">
                <span>参与要求</span><span class="item-right">${product.applyCondition}</span>
            </div>
            <div class="apply-head-item">
                <span>报名费用</span><span class="item-sec">原始价格：<fmt:formatNumber value="${product.originalPrice}" pattern="#,##0.##"/>元</span><span class="item-th">体验价：</span><span class="item-fo"><fmt:formatNumber value="${product.actualPrice}" pattern="#,##0.##"/>元</span>
            </div>
            <div class="apply-head-item">
                <span>报名须知</span><span class="item-right">为了让营养师更准确的为你服务，</span>
            </div>
            <div class="apply-head-item">
                <span class="item-right-2">请准确填写如下信息；</span>
            </div>
            <div class="apply-head-item">
                <span class="item-right-2">Focus俱乐部对本活动由最终解释权。</span>
            </div>

            <div class="apply-data-info">
                <div class="apply-data-item">
                    <span class="input-left">手机号码</span>
                    <span class="input-right">
                        <input id="phoneNumber" name="phoneNumber" type="tel" maxlength="11" size="12" height="100px" placeholder="请填写">
                    </span>
                </div>
                <div class="apply-data-item">
                    <span class="input-left">微信号</span>
                    <span class="input-right">
                        <input id="weixinId" name="weixinId" type="text" maxlength="50" size="50" height="100px" placeholder="请填写">
                    </span>
                </div>
                <div class="apply-data-item">
                    <span class="input-left">姓名</span>
                    <span class="input-right">
                        <input id="name" name="name" type="text" maxlength="50" size="50" height="100px" placeholder="请填写">
                    </span>
                </div>
                <div class="apply-data-item">
                    <span class="input-left">性别</span>
                    <span class="input-right input-right-2">
                        <select id="gender" name="gender">
                            <option value="0" selected></option>
                            <option value="1">男</option>
                            <option value="2">女</option>
                        </select>
                    </span>
                    <span class="select-icon"><img src="../img/member/select-icon.png"></span>
                </div>
                <div class="apply-data-item">
                    <span class="input-left">地区</span>
                    <span class="input-right input-right-2" style="padding-right: 10px;">
                        <input id="addr" name="addr" type="text" maxlength="100" size="100" height="100px">
                    </span>
                    <span class="select-icon"><img src="../img/member/select-icon.png"></span>
                </div>
                <div class="apply-data-item" style="border: none;">
                    <span class="input-left">生日</span>
                    <span class="input-right-3">
                        <input id="birth" name="birth" type="date" maxlength="10" size="12" height="100px">
                    </span>
                    <span class="select-icon select-icon-2"><img src="../img/member/select-icon.png"></span>
                </div>
            </div>

            <div class="apply-data-info-2">
                <div class="apply-data-item-2">
                    <span class="item-2-input-left">身高</span>
                    <span class="item-2-input-left-input">
                        <input id="height" name="height" type="tel" maxlength="6" size="6" height="100px">cm
                    </span>
                    <span class="select-icon"><img src="../img/member/select-icon.png"></span>
                    <span class="item-2-input-right">体重</span>
                    <span class="item-2-input-left-input">
                        <input id="weight" name="weight" type="tel" maxlength="6" size="6" height="100px">kg
                    </span>
                    <span class="select-icon"><img src="../img/member/select-icon.png"></span>
                </div>
                <div class="apply-data-item-2 apply-data-item-3">
                    <span class="input-left">目标体重</span>
                    <span class="input-right input-right-4">
                        <input id="targetWeight" name="targetWeight" type="tel" maxlength="6" size="6" height="100px">kg
                    </span>
                    <span class="select-icon"><img src="../img/member/select-icon-2.png"></span>
                </div>
            </div>

            <div class="eval-item">
                <img src="../img/member/item-icon.png">
                <span>有无以下病史？（可多选）</span>
            </div>
            <input id="medicalHistory" name="medicalHistory" type="hidden">
            <div class="eval-item-answer eval-item-answer-medicalHistory">
                <div class="answer-item-part" onclick="selMedicalHistory(1,this);">
                    <div class="answer-item">
                        <span>没有</span>
                        <img src="../img/member/checkbox-unsel-icon.png">
                    </div>
                </div>
                <div class="answer-item-part" onclick="selMedicalHistory(2,this);">
                    <div class="answer-item">
                        <span>高血压</span>
                        <img src="../img/member/checkbox-unsel-icon.png">
                    </div>
                </div>
                <div class="answer-item-part" onclick="selMedicalHistory(3,this);">
                    <div class="answer-item">
                        <span>高血糖</span>
                        <img src="../img/member/checkbox-unsel-icon.png">
                    </div>
                </div>
                <div class="answer-item-part" onclick="selMedicalHistory(4,this);">
                    <div class="answer-item">
                        <span>甲状腺</span>
                        <img src="../img/member/checkbox-unsel-icon.png">
                    </div>
                </div>
                <div class="answer-item-part" onclick="selMedicalHistory(5,this);">
                    <div class="answer-item">
                        <span>月经不调</span>
                        <img src="../img/member/checkbox-unsel-icon.png">
                    </div>
                </div>
                <div class="answer-item-part" onclick="selMedicalHistory(6,this);">
                    <div class="answer-item">
                        <span>贫血</span>
                        <img src="../img/member/checkbox-unsel-icon.png">
                    </div>
                </div>
                <div class="answer-item-part" onclick="selMedicalHistory(7,this);">
                    <div class="answer-item" style="border: none;">
                        <span>其他。届时请主动与营养师沟通。</span>
                        <img src="../img/member/checkbox-unsel-icon.png">
                    </div>
                </div>
            </div>

            <div class="eval-item">
                <img src="../img/member/item-icon.png">
                <span>有无节食减肥的经历？</span>
            </div>
            <input id="dietExperience" name="dietExperience" type="hidden">
            <div class="eval-item-answer eval-item-answer-dietExperience">
                <div class="answer-item-part" onclick="setRadioValue('dietExperience', 1,this);">
                    <div class="answer-item">
                        <span>没有</span>
                        <img src="../img/member/radio-unsel-icon.png">
                    </div>
                </div>
                <div class="answer-item-part" onclick="setRadioValue('dietExperience', 2,this);">
                    <div class="answer-item">
                        <span>有，三个月之内有过</span>
                        <img src="../img/member/radio-unsel-icon.png">
                    </div>
                </div>
                <div class="answer-item-part" onclick="setRadioValue('dietExperience', 3,this);">
                    <div class="answer-item" style="border: none;">
                        <span>有，但好久之前了（三个月之前）</span>
                        <img src="../img/member/radio-unsel-icon.png">
                    </div>
                </div>
            </div>

            <div class="eval-item">
                <img src="../img/member/item-icon.png">
                <span>有无吃减肥药减肥的经历？</span>
            </div>
            <input id="dietPillExperience" name="dietPillExperience" type="hidden">
            <div class="eval-item-answer eval-item-answer-dietPillExperience">
                <div class="answer-item-part" onclick="setRadioValue('dietPillExperience', 1,this);">
                    <div class="answer-item">
                        <span>没有</span>
                        <img src="../img/member/radio-unsel-icon.png">
                    </div>
                </div>
                <div class="answer-item-part" onclick="setRadioValue('dietPillExperience', 2,this);">
                    <div class="answer-item">
                        <span>有，吃过酵素</span>
                        <img src="../img/member/radio-unsel-icon.png">
                    </div>
                </div>
                <div class="answer-item-part" onclick="setRadioValue('dietPillExperience', 3,this);">
                    <div class="answer-item">
                        <span>有，吃过左旋肉碱</span>
                        <img src="../img/member/radio-unsel-icon.png">
                    </div>
                </div>
                <div class="answer-item-part" onclick="setRadioValue('dietPillExperience', 4,this);">
                    <div class="answer-item">
                        <span>有，喝过减肥茶</span>
                        <img src="../img/member/radio-unsel-icon.png">
                    </div>
                </div>
                <div class="answer-item-part" onclick="setRadioValue('dietPillExperience', 5,this);">
                    <div class="answer-item" style="border: none;">
                        <span>有，其他减肥药</span>
                        <img src="../img/member/radio-unsel-icon.png">
                    </div>
                </div>
            </div>

            <div class="eval-item">
                <img src="../img/member/item-icon.png">
                <span>饮用含糖饮料的频率？</span>
            </div>
            <input id="sugaredDrinkRate" name="sugaredDrinkRate" type="hidden">
            <div class="eval-item-answer eval-item-answer-sugaredDrinkRate">
                <div class="answer-item-part" onclick="setRadioValue('sugaredDrinkRate', 1,this);">
                    <div class="answer-item">
                        <span>基本不喝这些饮料</span>
                        <img src="../img/member/radio-unsel-icon.png">
                    </div>
                </div>
                <div class="answer-item-part" onclick="setRadioValue('sugaredDrinkRate', 2,this);">
                    <div class="answer-item">
                        <span>每周3次以下</span>
                        <img src="../img/member/radio-unsel-icon.png">
                    </div>
                </div>
                <div class="answer-item-part" onclick="setRadioValue('sugaredDrinkRate', 3,this);">
                    <div class="answer-item">
                        <span>每周4-6次</span>
                        <img src="../img/member/radio-unsel-icon.png">
                    </div>
                </div>
                <div class="answer-item-part" onclick="setRadioValue('sugaredDrinkRate', 4,this);">
                    <div class="answer-item" style="border: none;">
                        <span>每周7次以上</span>
                        <img src="../img/member/radio-unsel-icon.png">
                    </div>
                </div>
            </div>

            <div class="eval-item">
                <img src="../img/member/item-icon.png">
                <span>跟朋友/同事经常聚餐吗？</span>
            </div>
            <input id="dineTogether" name="dineTogether" type="hidden">
            <div class="eval-item-answer eval-item-answer-dineTogether">
                <div class="answer-item-part" onclick="setRadioValue('dineTogether', 1,this);">
                    <div class="answer-item">
                        <span>基本不参加任何聚餐</span>
                        <img src="../img/member/radio-unsel-icon.png">
                    </div>
                </div>
                <div class="answer-item-part" onclick="setRadioValue('dineTogether', 2,this);">
                    <div class="answer-item">
                        <span>一个月1-2次</span>
                        <img src="../img/member/radio-unsel-icon.png">
                    </div>
                </div>
                <div class="answer-item-part" onclick="setRadioValue('dineTogether', 3,this);">
                    <div class="answer-item">
                        <span>一个月3-6次</span>
                        <img src="../img/member/radio-unsel-icon.png">
                    </div>
                </div>
                <div class="answer-item-part" onclick="setRadioValue('dineTogether', 4,this);">
                    <div class="answer-item" style="border: none;">
                        <span>一个月7次以上</span>
                        <img src="../img/member/radio-unsel-icon.png">
                    </div>
                </div>
            </div>

            <div class="eval-item">
                <img src="../img/member/item-icon.png">
                <span>减肥的主要目的？</span>
            </div>
            <input id="loseWeightTarget" name="loseWeightTarget" type="hidden">
            <div class="eval-item-answer eval-item-answer-loseWeightTarget">
                <div class="answer-item-part" onclick="setRadioValue('loseWeightTarget', 1,this);">
                    <div class="answer-item">
                        <span>减肥，太胖了</span>
                        <img src="../img/member/radio-unsel-icon.png">
                    </div>
                </div>
                <div class="answer-item-part" onclick="setRadioValue('loseWeightTarget', 2,this);">
                    <div class="answer-item">
                        <span>增肌，塑形</span>
                        <img src="../img/member/radio-unsel-icon.png">
                    </div>
                </div>
                <div class="answer-item-part" onclick="setRadioValue('loseWeightTarget', 3,this);">
                    <div class="answer-item" style="border: none;">
                        <span>保持体形</span>
                        <img src="../img/member/radio-unsel-icon.png">
                    </div>
                </div>
            </div>

            <div class="eval-item">
                <img src="../img/member/item-icon.png">
                <span>平时喜欢吃油腻的食物吗？</span>
            </div>
            <input id="oilyFood" name="oilyFood" type="hidden">
            <div class="eval-item-answer eval-item-answer-oilyFood">
                <div class="answer-item-part" onclick="setRadioValue('oilyFood', 1,this);">
                    <div class="answer-item">
                        <span>我讨厌油腻的食物</span>
                        <img src="../img/member/radio-unsel-icon.png">
                    </div>
                </div>
                <div class="answer-item-part" onclick="setRadioValue('oilyFood', 2,this);">
                    <div class="answer-item">
                        <span>一般，还好</span>
                        <img src="../img/member/radio-unsel-icon.png">
                    </div>
                </div>
                <div class="answer-item-part" onclick="setRadioValue('oilyFood', 3,this);">
                    <div class="answer-item" style="border: none;">
                        <span>比较油腻</span>
                        <img src="../img/member/radio-unsel-icon.png">
                    </div>
                </div>
            </div>

            <div class="eval-item">
                <img src="../img/member/item-icon.png">
                <span>上传一张近照（本人），用于制作学员卡（可选项）</span>
            </div>
            <div class='logo' onclick="changeAvatarFile();">
                <img id='logoShow' src='../img/member/upload-pic.png'>
                <input type="file" id="file" class='file' name="imageFile" accept="image/*"/>
            </div>

            <div class='apply-btn'>
                <span>提交</span>
            </div>
        </form>
        </c:when>
        <c:otherwise>
            <div class="apply-no-data">活动不存在，或已结束！</div>
        </c:otherwise>
    </c:choose>
    </div>
    <div class="error-layer">
        <div class="error-msg"></div>
    </div>
</body>
<script src="<%=path%>/js/jquery-1.9.1.min.js"></script>
<%--<script src="<%=path%>/coach/mui/js/mui.min.js"></script>
<script src="<%=path%>/coach/mui/js/mui.picker.js"></script>
<script src="<%=path%>/coach/mui/js/mui.poppicker.js"></script>--%>
<script src="<%=path%>/js/member/apply-focus.js?t=20151206011"></script>
</html>