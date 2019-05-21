
document.writeln("<div class=\'topbar\'>");
document.writeln("  <div class=\'container\'>");
document.writeln("    <div class=\'row\'>");
document.writeln("      <div class=\'col-md-12\'>");
document.writeln("        <ul class=\'social_top pull-right\'>");
document.writeln("          <li><a href=\'/login/login\'>登录</a></li>");
document.writeln("          <li><a href=\'/login/sign-up\'>注册</a></li>");
document.writeln("        </ul>");
document.writeln("      </div>");
document.writeln("    </div>");
document.writeln("  </div>");
document.writeln("</div>");
document.writeln("<!--Header-->");
document.writeln("<header>");
document.writeln("  <nav class=\'navbar navbar-default navbar-fixed white no-background bootsnav\'>");
document.writeln("    <div class=\'container\'>");
document.writeln("       <div class=\'search_btn btn_common\'><i class=\'icon-icons185\'></i></div>");
document.writeln("      <div class=\'navbar-header\'>");
document.writeln("        <button type=\'button\' class=\'navbar-toggle\' data-toggle=\'collapse\' data-target=\'#navbar-menu\'>");
document.writeln("          <i class=\'fa fa-bars\'></i>");
document.writeln("        </button>");
document.writeln("        <!-- <a class=\'navbar-brand\' href=\'index.html\'><img src=\'images/logo-white.png\' alt=\'logo\' class=\'logo logo-display\'>");
document.writeln("        <img src=\'images/logo.png\' class=\'logo logo-scrolled\' alt=\'\'>");
document.writeln("        </a> -->");
document.writeln("      </div>");
document.writeln("      <div class=\'collapse navbar-collapse\' id=\'navbar-menu\'>");
document.writeln("        <ul class=\'nav navbar-nav navbar-right\' data-in=\'fadeInDown\' data-out=\'fadeOut\'>");
document.writeln("			<li><a href=\'/index\'>首页</a></li>");
document.writeln("      <li><a href=\'/courses\'>课程</a></li>");
document.writeln("      <li><a href=\'/exam\'>笔试</a></li>");
document.writeln("      <li><a href=\'/personal/index\'>个人</a></li>");
document.writeln("			<li><a href=\'/contact\'>联系我们</a></li>");
document.writeln("        </ul>");
document.writeln("      </div>");
document.writeln("    </div>");
document.writeln("  </nav>");
document.writeln("</header>");
document.writeln("\n" +
    "<script src=\"/js/jquery-2.2.3.js\"></script>\n" +
    "<script>\n" +
    "var uid; var nickname;   " +
    "$(document).ready(function () {\n" +
    "       $.get('/getUserInfo',function (data) {\n" +
    "           //console.log(data);\n" +
    "           data = JSON.parse(data);//如果已经登录了\n" +
    "           if(data.errorCode==='00'){\n" +
    "               uid = data.returnObject.uid;" +
    "nickname = data.returnObject.nickname;" +
    "               let $ul = $('div.topbar').find('ul.social_top,pull-right');" +
    "$ul.empty();" +
    "       $ul.append(\"<li>欢迎您，\"+nickname+\"</li>\");" +
    "       $ul.append(\"<li><a href='/logout'>退出</a></li>\");" +
    "           }\n" +
    "       }) ;\n" +
    "    });\n" +
    "</script>");
