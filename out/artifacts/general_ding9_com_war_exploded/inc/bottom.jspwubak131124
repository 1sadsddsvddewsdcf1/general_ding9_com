<%@page contentType="text/html;charset=gbk" %><%@ page import="com.ding9.util.Environment"%>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<link href="/css3.0/tefont.css" rel="stylesheet" type="text/css">
<link href="/css3.0/te.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="/js/tecomment.js"></script>
<script language="javascript" src="/js/area.js"></script>
<script type="text/javascript">
<!--
function btmsearchformover_onsubmit()
{
  if(document.btmsearchFormover.key.value=='' || document.btmsearchFormover.key.value=="输入关键字进行搜索"){
    alert('请输入查询关键字');
    return false;
  }
  var btm_sel_prso_id_one = document.btmsearchFormover.btm_sel_prso_id_one.value;
    document.btmsearchFormover.action="http://search.ding9.com/search.do";
  return true;
}

function btmsearchmerchant_onsubmit() {
  if(btmtrim(document.btmsearchFormover.makey.value)=='' || document.btmsearchFormover.makey.value=='输入关键字进行搜索'){
    alert('请输入查询关键字');
    return false;
  }
  document.btmsearchFormover.btmselectp.value=document.btmsearchFormover.btmprovince.value;
  document.btmsearchFormover.action="<%=Environment.getChannelSearch()%>/merchant/merchant-info.do?key=" + document.btmsearchFormover.makey.value + "&selectc=" + document.btmsearchFormover.btmselectc.value + "&selectp=" + document.btmsearchFormover.btmselectp.value;
  return true;
}

function btmother(obj,strtype)
{
  if(btmtrim(document.all(strtype).value)=='' || document.all(strtype).value=='输入关键字进行搜索'){
    alert('请输入查询关键字');
    return false;
  }

  obj.action="<%=Environment.getChannelSearch()%>/" + strtype + ".do?q=" + document.all(strtype).value;
  return true;
}

function searchall(obj)
{
  var strtype = document.all.searchtype.value;
  if(strtype == 'pro')
   return	btmsearchformover_onsubmit();
  else if(strtype == 'merchant')
   return	btmsearchmerchant_onsubmit();
  else
   return	btmother(obj,strtype);
}

var btmshow_word="输入关键字进行搜索";
function btmshowSearch(obj,type){
  if(type){
    if(obj.value=="")
      obj.value=btmshow_word;
    obj.style.color='gray';
  }else{
    if(obj.value==btmshow_word)
      obj.value="";
    obj.style.color='#000000';
  }
}

function btmtrim(str){
 return str.replace(/(^\s*)|(\s*$)/g, "");
}
//-->
</script>
<center>
<FORM id=btmsearchForm name=btmsearchFormover method=post onsubmit="return searchall(this)" target=_blank>
<INPUT id=searchtype type=hidden value="pro" />
<div id="end001">
 <SELECT name=relationType class="teH1" onchange=javascript:chgrelType(this.options[selectedIndex].value)>
          <OPTION value=0>商品搜索</OPTION>
                    <OPTION value=1>商家搜索</OPTION>
                    <option value=2>优惠搜索</option>
                    <option value=3>促销搜索</option>
                    <option value=4>资讯搜索</option>
                    <option value=5>评论搜索</option>
  </SELECT>
  <a id=pro style="DISPLAY: ">
    <INPUT class="teH4" size="54" type="text" id=key onblur=btmshowSearch(this,1) onfocus=btmshowSearch(this) value=输入关键字进行搜索 name=key>


       <select name="btm_sel_prso_id_one" class="teH1">

                                                  <option selected> 所有类别</option>
                                             <option value="1" >数码/电子</option>
                                                     <option value="4">成人用品</option>
                                                  <option value="6"  >手机/通讯</option>
                                                  <option value="7" >电脑/网络</option>
                                                      <option value="8">美容美体</option>
                                           <option value="12">家用电器</option>
                                           <option value="15">办公用品</option>
                      </select>

      </a>

      <a id=reltype style="DISPLAY: none">
        <input name="makey" type="text" class="teH4" onblur=btmshowSearch(this,1) onfocus=btmshowSearch(this) value="输入关键字进行搜索" size="40">
                        <input type="hidden" name="btmselectp">
              <select name="btmprovince" id="province" class=teH1>
</select>
<select name="btmselectc" id="city" class=teH1>
</select>
<script language=javascript>
InitCitySelect(document.btmsearchFormover.btmprovince,document.btmsearchFormover.btmselectc);
</script>
              <a id=pro2 style="DISPLAY: none"> <input name="cheapcard" type="text" class="teH4" value="输入关键字进行搜索" size="54" onblur=btmshowSearch(this,1) onfocus=btmshowSearch(this)>
              </a>

              <a id=pro3 style="DISPLAY: none"> <input name="promotion" type="text" class="teH4" value="输入关键字进行搜索" size="54" onblur=btmshowSearch(this,1) onfocus=btmshowSearch(this)>
              </a>

              <a id=pro4 style="DISPLAY: none"> <input name="article" type="text" class="teH4" value="输入关键字进行搜索" size="54" onblur=btmshowSearch(this,1) onfocus=btmshowSearch(this)>
              </a>

        <a id=pro5 style="DISPLAY: none"> <input name="comment" type="text" class="teH4" value="输入关键字进行搜索" size="54" onblur=btmshowSearch(this,1) onfocus=btmshowSearch(this)>
              <select name="select" class="teH1">
                 <option selected>所有类别</option>
                    <option value="1" >数码/电子</option>
                    <option value="4">成人用品</option>
                    <option value="6">手机/通讯</option>
                    <option value="7" >电脑/网络</option>
                    <option value="8">美容美体</option>
                    <option value="12">家用电器</option>
                    <option value="15">办公用品</option>
               </select>
                 </a>

    <label>
      <input name="Submit" type="submit" class="teH1" value="搜 索">
  </label>
</div>

<!--c04-->
<div class="con900_2">

<div class="teH1c">
<a href="http://guide.ding9.com/switch----,resume.htm" target="_blank" class="teH1c">关于我们</a> |
    <a href="http://guide.ding9.com/switch----,help.htm" target="_blank" class="teH1c">使用帮助</a> |
    <a href="http://guide.ding9.com/switch----,service.htm" target="_blank" class="teH1c">服务条款</a> |
    <a href="http://guide.ding9.com/switch----,technique.htm" target="_blank" class="teH1c">招贤纳士</a> |
    <a href="http://guide.ding9.com/switch----,contact.htm" target="_blank" class="teH1c">联系我们</a> |
    <a href="http://guide.ding9.com/switch----,merchant.htm" target="_blank" class="teH1c">商家加盟</a> |
    <a href="http://guide.ding9.com/switch----,comethod.htm" target="_blank" class="teH1c">网站合作</a> |
    <a href="http://guide.ding9.com/switch----,search.htm" target="_blank" class="teH1c">搜索竞价</a> |
    <a href="http://eshop.ding9.com" target="_blank" class="teH1c">顶九商城</a>
</div>
</div>
<div id="end002">
<div id="end002_l"></div>
<div id="end002_m">
  <DIV align="left" class="teH1">顶九网是购物搜索引擎，从互联网搜索商家、商品、资讯、促销等信息，为用户提供全方位导购服务，所有信息以来源网站为准。<BR>
    Copyright &copy; 2005-2007 版权所有 <a href="http://guide.ding9.com/" class="teH1c">Ding9.com</a> <a href="http://www.miibeian.gov.cn/" target="_blank" class="teH1">粤ICP备06067490号</a> </DIV>
</div>
<div id="end002_r"><a href="http://www.gzjd.gov.cn/newgzjd/baojing/110.jsp?catid=318" target="_blank"><img src="/teimages/jing.gif" width="40" height="53" border="0"></a></div>

</div>
</center>