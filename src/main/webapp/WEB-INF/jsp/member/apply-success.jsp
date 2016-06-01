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
    <link rel="stylesheet" href="<%=path%>/css/member/apply-success.css?t=201512060205"/>
</head>
<body>
    <div class="main">
        <div class="apply-interval"></div>
        <div class="apply-success-icon">
            <img src="../img/member/apply-success.png" />
        </div>

        <div class="tips-layer">
            <span class="btn-round-div"></span>
            <span class="tips-text">我们已经成功收到您的报名申请，瘦身顾问会尽快联系您，请耐心等待。</span>
        </div>
        <div class="tips-layer">
            <div class="btn-round-div"></div>
            <span class="tips-text">Focus俱乐部对本活动有着最终解释权。</span>
        </div>

        <div class="watch-us">
            <div>长按关注我们</div>
            <div>为你制定简单易行的减脂计划</div>
        </div>
        <div class="blow-icon">
            <img src="../img/triangle.png" />
        </div>

        <div class="contact-qrcode">
            <img src="../img/member/qrcode-new.png">
        </div>
        <div class="apply-interval-2"></div>
    </div>
</body>
</html>