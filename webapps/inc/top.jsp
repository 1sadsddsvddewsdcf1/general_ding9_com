<%@ page language="java" contentType="text/html;charset=gbk" %>
<%@ taglib prefix="bean" uri="/WEB-INF/struts-bean.tld" %>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c"%>
<%@ page import="com.ding9.util.Environment"%>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312"/>
<link href="/css3.0/tefont.css" rel="stylesheet" type="text/css">
<link href="/css3.0/te.css" rel="stylesheet" type="text/css">
<script language=javascript type=text/javascript>
<!--
function MM_reloadPage(init) {  //reloads the window if Nav4 resized
  if (init==true) with (navigator) {if ((appName=="Netscape")&&(parseInt(appVersion)==4)) {
    document.MM_pgW=innerWidth; document.MM_pgH=innerHeight; onresize=MM_reloadPage; }}
  else if (innerWidth!=document.MM_pgW || innerHeight!=document.MM_pgH) location.reload();
}
MM_reloadPage(true);

function MM_callJS(jsStr) { //v2.0
  return eval(jsStr)
}

function MM_findObj(n, d) { //v4.01
  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
  if(!x && d.getElementById) x=d.getElementById(n); return x;
}

function MM_showHideLayers() { //v6.0
  var i,p,v,obj,args=MM_showHideLayers.arguments;
  for (i=0; i<(args.length-2); i+=3) if ((obj=MM_findObj(args[i]))!=null) { v=args[i+2];
    if (obj.style) { obj=obj.style; v=(v=='show')?'visible':(v=='hide')?'hidden':v; }
    obj.visibility=v; }
}
//-->
</script>
<script>
function hideMenu(id) {
document.getElementById("menu"+id).style.display="none";
}
</script>
<center>
<%--
<bean:define id="channel_id" name="channelId" type="int"/>
--%>
<script>
var url=document.location+"";
if(url.indexOf('local')>-1){
document.write('<iframe name="ding9topIframe" src="http://www.ding9.local/inc/top----,${channelId}.html" frameborder="0" width="100%" marginwidth="0" marginheight="0" height="130" scrolling="no"></iframe>');
}else{
document.write('<iframe name="ding9topIframe" src="http://guide.ding9.com/inc/top----,${channelId}.html" frameborder="0" width="100%" marginwidth="0" marginheight="0" height="130" scrolling="no"></iframe>');
}
</script>
<div id="menu">
<div id="menu_l"><img src="/images/menubg_03.jpg" width="8" height="33"></div>
<div id="menu_1"><a href="http://guide.ding9.com" class="teH1" >首   页</a></div>
<div id="menu_2"><a href="<%=Environment.getChannelMobile()%>"  class="teH1">手机通信</a></div>
<div id="menu_3"><a href="<%=Environment.getChannelDigital()%>"  class="teH1">数码电子</a></div>
<div id="menu_4"><a href="<%=Environment.getChannelComputer()%>" class="teH1">电脑网络</a></div>
<div id="menu_5"><a href="<%=Environment.getChannelOffice()%>" class="teH1">办公用品</a></div>
<div id="menu_6"><a href="<%=Environment.getChannelHea()%>" class="teH1">家用电器</a></div>
<div id="menu_7"><a href="<%=Environment.getChannelBeauty()%>" class="teH1">美容美体</a></div>
<div id="menu_8"><a href="<%=Environment.getChannelCoupon()%>" class="teH1">优惠券</a></div>
<div id="menu_<c:if test="${channelId==5}">m</c:if><c:if test="${channelId!=5}">9</c:if>"><a href='<%=Environment.getChannelCostume()%>' class="teH<c:if test="${channelId==5}">2</c:if><c:if test="${channelId!=5}">1</c:if>">服装服饰</a></div>
<div id="menu_<c:if test="${channelId==9}">m</c:if><c:if test="${channelId!=9}">10</c:if>"><a href="<%=Environment.getChannelHeadgear()%>" class="teH<c:if test="${channelId==9}">2</c:if><c:if test="${channelId!=9}">1</c:if>">精品饰品</a></div>
<div id="menu_12"><a href="http://search.ding9.com" class="teH1">搜索频道</a></div>
<div id="menu_11"><a href="http://gz.shoplocal.ding9.com" class="teH1">我爱逛街</a></div>
<div id="menu_13" onMouseOver="MM_showHideLayers('Layer2','','show')" onmouseout="MM_showHideLayers('Layer2','','hide')" vAlign="center" align="center" width="72"><a class="teH1">更多 </a><img src="/teimages/arrow_022.gif" width="8" height="8" border="0"></div>
<div id="menu_r"><img src="/images/menubg_08.jpg" width="8" height="33"></div>
</div><!--menu-->
<DIV id=Layer1 style="Z-INDEX:1;WIDTH:72px;POSITION:absolute;HEIGHT:23px;">
<DIV id=Layer2 onMouseOver="MM_showHideLayers('Layer2','','show')" style="Z-INDEX:1;LEFT:828px;VISIBILITY:hidden;WIDTH:72px;POSITION:absolute;TOP:-2px;HEIGHT:61px" onmouseout="MM_showHideLayers('Layer2','','hide')">
<TABLE width="100%" border=0 cellPadding=0 cellSpacing=1 bgColor=#CCCCCC>
<TBODY>

<TR><TD height="25" class=service onMouseOver="this.className='service-blank'" onmouseout="this.className='service'" bgColor=#74b920><A href="<%=Environment.getChannelPromotion()%>" class="teH1">&nbsp;促销折扣</A></TD></TR>
<TR><TD height="25" class=service onMouseOver="this.className='service-blank'" onmouseout="this.className='service'" bgColor=#74b920><A href="http://merchant.ding9.com" class="teH1">&nbsp;顶九商家</A></TD></TR>
</TBODY></TABLE></DIV></DIV><!--c02-->
<div id="c03"><!--c03_l--><!--c03_r-->
</div>
</center>
