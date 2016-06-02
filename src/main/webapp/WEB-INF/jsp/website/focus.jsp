<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../layout/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <script>
        var _hmt = _hmt || [];
        (function() {
            var hm = document.createElement("script");
            hm.src = "//hm.baidu.com/hm.js?ffef42745b108fc018b6f389af457a25";
            var s = document.getElementsByTagName("script")[0];
            s.parentNode.insertBefore(hm, s);
        })();

    /*
        (function(win,doc){
            var s = doc.createElement("script"), h = doc.getElementsByTagName("head")[0];
            if (!win.alimamatk_show) {
                s.charset = "gbk";
                s.async = true;
                s.src = "http://a.alimama.cn/tkapi.js";
                h.insertBefore(s, h.firstChild);
            };
            var o = {
                pid: "mm_27688097_12796465_48838368",/!*推广单元ID，用于区分不同的推广渠道*!/
                appkey: "23315136",/!*通过TOP平台申请的appkey，设置后引导成交会关联appkey*!/
                unid: "",/!*自定义统计字段*!/
                type: "click" /!* click 组件的入口标志 （使用click组件必设）*!/
            };
            win.alimamatk_onload = win.alimamatk_onload || [];
            win.alimamatk_onload.push(o);
        })(window,document);*/

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
    <title>Focus减肥俱乐部</title>
    <link rel="stylesheet" href="<%=path%>/css/website/index.css?t=1.0.1"/>
</head>
<body>
<!-- For weixin share-->
<div style="display: none;"><img src="../img/logo_500_500.jpg"></div>

<div class="main">
    <div class="top-part">
       <img src="../img/top-title.png">
        <div>营养师 + 健身教练 + 瘦身督导</div>
        <div>为你私人订制简单易行的减肥计划</div>
    </div>

    <div class="content-part">
        <div class="data-part">
            <span class="data-part-c1">
                <div class="data-part-t1">42天</div>
                <div class="data-part-t2">营周期</div>
            </span>
            <span class="data-part-c1 data-part-c2">
                <div class="data-part-t1">减脂肪</div>
                <div class="data-part-t2">适用人群</div>
            </span>
            <span class="data-part-c1">
                <div class="data-part-t1">5人</div>
                <div class="data-part-t2">营人数</div>
            </span>
            <span class="data-part-c1 data-part-c4">
                <div class="data-part-t1">线上</div>
                <div class="data-part-t2">指导方式</div>
            </span>
        </div>
        <div class="ctn-first-title">
            <span>健康的减肥方式</span>
        </div>
        <div class="triangle1"></div>

        <div class="line1"></div>
        <div class="yingyangshi-intro">
            <img src="../img/yingyangshi.png">
            <div class="yingyangshi-title">营养师 · 越吃越瘦</div>
            <div class="yingyangshi-content">每天在外面吃也没有关系，营养师为你私人定制饮食计划，不用节食也能瘦！</div>
        </div>
        <div class="line1"></div>
        <div class="yingyangshi-img">
            <img class="yingyangshi-img1" src="../img/yingyangshi-1.png">
            <img class="yingyangshi-img2" src="../img/yingyangshi-2.png">
        </div>

        <div class="coach-family">
            <div class="line1"></div>
            <div class="coach-family-title">健身教练 · 家庭运动</div>
            <div class="coach-family-content">没有时间去健身房也没关系，</div>
            <div class="coach-family-content coach-family-content-2">10分钟的家庭运动也可以疯狂燃烧脂肪。</div>
            <img class="coach-family-img" src="../img/coach-family.png">
            <div class="line1"></div>
            <img class="coach-family-img1" src="../img/coach-family-1.png">
            <img class="coach-family-img2" src="../img/coach-family-2.png">
            <img class="coach-family-img3" src="../img/coach-family-3.png">
            <img class="coach-family-img4" src="../img/coach-family-4.png">
        </div>

        <div class="member-info">
            <div class="line1"></div>
            <div class="yingyangshi-intro">
                <img src="../img/member-info.png">
                <div class="yingyangshi-title">减肥督导 · 学员档案</div>
                <div class="yingyangshi-content member-info-content">每日三餐打卡，控制卡路里摄入；完整的学员档案，一起见证蜕变！</div>
            </div>
            <div class="line1"></div>
            <div class="member-info-img">
                <img class="member-info-img1" src="../img/member-info-1.png">
                <img class="member-info-img2" src="../img/member-info-2.png">
                <img class="member-info-img3" src="../img/member-info-3.png">
                <img class="member-info-img4" src="../img/member-info-4.png">
            </div>
        </div>

        <div class="focus-inteval"></div>

        <div class="apply-btn-part" onclick="applyFocus();">
            <span>报名参加体验班</span>
        </div>

        <%--<div class="ctn-first-title focus-course-title">
            <span>Focus课程</span>
        </div>
        <div class="triangle1"></div>
        <div class="course-1">
            <img src="../img/course-1.png">
            <div class="course-title">Focus减脂学期班</div>
            <div class="course-content-1">6周课程；5人小班制度</div>
            <div class="course-content-1 course-content-2">适用人群：所有想减脂的同学</div>
        </div>
        <div class="course-1 course-2">
            <img src="../img/course-2.png">
            <div class="course-title">Focus丽人班</div>
            <div class="course-content-1">6月课程；一对一</div>
            <div class="course-content-1 course-content-2">适用人群：减脂；塑形；调理身体</div>
        </div>

        <div class="ctn-first-title contact-us-title">
            <span>咨询我们</span>
        </div>
        <div class="triangle1 triangle2"></div>
        
        <div class="contact-qrcode"><img src="../img/contact-qrcode-6.png"></div>

        <div class="contact-content-1">长按二维码</div>--%>
        <%--<div class="contact-content-1 contact-content-2">或者</div>
        <div class="contact-content-1 contact-content-3">手动添加微信好友：mika_life_</div>--%>
    </div>
</div>

</body>
<script src="<%=path%>/js/jquery-1.9.1.min.js"></script>
<script src="<%=path%>/js/website/index.js?t=1.0.1"></script>
</html>