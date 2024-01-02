function fun_compare_date(preDate,nextDate,strSplit){
	if ((preDate=="") || (nextDate=="") || (strSplit=="")){
		alert ("参数不能为空值!");
		return false;
	}

	var pre=preDate.split(strSplit);
	var next=nextDate.split(strSplit);
	if ((pre.length<3) || (next.length<3)){
		alert ("错误的日期格式!");
		return false;
	}

	var str=preDate+"必须在"+nextDate+"之前!";
	if (parseInt(next[0])-parseInt(pre[0])<0){
		alert (str);
		return false;
	}else{
		if (parseInt(next[1])-parseInt(pre[1])<0){
			alert (str);
			return false;
		}else{
			if (parseInt(next[1])-parseInt(pre[1])>=0){
				if (parseInt(next[2])-parseInt(pre[2])<0){
					alert (str);
					return false;
				}
			}
		}
	}
	return true;
}

function FUN_PAGE(Page){
	var txt_start_price=document.all.txt_start_price.value;
	var txt_end_price=document.all.txt_end_price.value;
	var txt_start_rate=document.all.txt_start_rate.value;
	var txt_end_rate=document.all.txt_end_rate.value;
	var txt_prma_name=document.all.txt_prma_name.value;
	var txtTypeOne=document.all.txtTypeOne.value;
	var grade="";
	var content="";
	if (txtTypeOne!=""){
		var str=txtTypeOne.split("=");
		grade=str[0];
		content=str[1];
	}
	document.Frm.action="Merchant_Compare_Price.php?prma_name="+txt_prma_name+"&content="+content+"&grade="+grade+"&Page="+Page+"&SmallValidateId=338&start_price="+txt_start_price+"&end_price="+txt_end_price+"&start_rate="+txt_start_rate+"&end_rate="+txt_end_rate;
	document.Frm.submit();
}

function Fun_Adjust_Pic(PIC_NAME,XY){
	if (XY==1)
	XY=200;
	if (XY==2)
	XY=145;
	if (XY==3)
	XY=80;
	if (XY==4)
	XY=60;
	if(XY==5)
	XY=131;

	var PIC_X=PIC_NAME.width;
	var PIC_Y=PIC_NAME.height;

	var X_Y="X";
	var PIC_MAX=PIC_X;
	if (PIC_X-PIC_Y<0){
		PIC_MAX=PIC_Y;
		X_Y="Y";
	}
	if (PIC_MAX>XY){
		PIC_MAX=XY;
	}
	if (X_Y=="X"){
		PIC_NAME.width=PIC_MAX;
	}else{
		PIC_NAME.height=PIC_MAX;
	}
}

function Fun_Adjust_PicXY(PIC_NAME,WIDTH,HEIGHT){
	var PIC_X=PIC_NAME.width;
	var PIC_Y=PIC_NAME.height;
	
	if (PIC_X>WIDTH){
		PIC_NAME.width=WIDTH;
		PIC_NAME.height=PIC_Y-((PIC_X-WIDTH)/PIC_X)*PIC_Y;
	}
	
	PIC_X=PIC_NAME.width;
	PIC_Y=PIC_NAME.height;
	if (PIC_Y>HEIGHT){
		PIC_NAME.height=HEIGHT;
		PIC_NAME.width=PIC_X-((PIC_Y-HEIGHT)/PIC_Y)*PIC_X;
	}
}

function trim(str){
 return str.replace(/(^\s*)|(\s*$)/g, "");
}