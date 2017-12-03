
$(".submit").click(function(){

    if(checkForm()) {

        $("form").action("/BookManageSystem/RegisterServlet");

    }else{

        return false;

    }

});

function getLength(str){//求字符串长度
	return str.replace(/[^\x00-xff]/g, "xx").length;//x00-xff为所有单字节//将双字节替换成两个xx			
}
function findStr(str,n){ //判断相同字符个数
	var tmp = 0;
	for(var i=0; i<str.length; i++)
		if(str.charAt(i)==n){
			tmp++;
		}
		return tmp;
}
function get(elementId){//获取id为***的元素
	return document.getElementById(elementId);
}
		
function trim(s){
	return s.replace(/(^\s*)|(\s*$)/g,"");	//去掉空格
}		

//验证用户名
function usenameFocus(){//元素获得焦点
	var name_msg = get("nameMsg");	//获取右侧信息提示区
	name_msg.style.display="block"; //显示右侧提示信息
}

	function usenameBlur(){//元素失去焦点。
		var name_msg = get("nameMsg");	//获取右侧信息提示区
		var name = get("name");//获取文本框
		//含有非法字符
		var re = /[^\w\u4e00-\u9fa5]/g;  //\w所有大小写字母和数字 \u4e00-\u9fa5汉字
		name.value = trim(name.value);   //去掉空格
		if(re.test(name.value)){
			name_msg.innerHTML='● 含有非法字符！';
			name_msg.style.color="rgba(200,0,100,0.8)";
			return false;
		}
		//不能为空
		else if(name.value==""){
			name_msg.innerHTML='● 不能为空！';
			name_msg.style.color="rgba(200,0,100,0.8)";
			return false;
		}
		//长度超过16个字符
		else if(getLength(name.value)>10){
			name_msg.innerHTML='● 长度超过16个字符！';
			name_msg.style.color="rgba(200,0,100,0.8)";
			return false;
		}
		//长度少于6个字符
		else if(getLength(name.value)<6){
			name_msg.innerHTML='● 长度不足6个字符！';
			name_msg.style.color="rgba(200,0,100,0.8)";
			return false;
		}
		//OK
		else{
			name_msg.innerHTML='● 该用户名可以使用^ ^';
			name_msg.style.color="green";
			return true	;
		}

	}
			
	//密码
	function pwd1Focus(){//获取焦点
		var pwd1_msg =  get("pwd1Msg");
		pwd1_msg.style.display="block"; //右侧信息提示
	}
	function pwd1Blur(){//失去焦点
		var pwd1_msg = get("pwd1Msg");
		var pwd1 = get("pwd1");
		var m = findStr(pwd1.value, pwd1.value[0]);
		var re1 = /[^\d]/g; //非数字
		var re2 = /[^a-zA-Z]/g; //非字母
		//不能为空
		if(pwd1.value==""){
			pwd1_msg.innerHTML='● 密码不能为空！';
			pwd1_msg.style.color="rgba(200,0,100,0.8)";
			return false;
		}
		//不能用相同字符
		else if(m==pwd1.value.length){
			pwd1_msg.innerHTML='● 不能使用相同字符！';
			pwd1_msg.style.color="rgba(200,0,100,0.8)";
			return false;
		}
		//长度应为6-16个字符
		else if(pwd1.value.length>16||pwd1.value.length<6){
			pwd1_msg.innerHTML='● 长度应为6-16个字符！';
			pwd1_msg.style.color="rgba(200,0,100,0.8)";
			return false;
		}
		//不能全为数字
				
		else if(!re1.test(pwd1.value)){
			pwd1_msg.innerHTML='● 不能全为数字！';
			pwd1_msg.style.color="rgba(200,0,100,0.8)";
			return false;
		}
		//不能全为字母
		else if(!re2.test(pwd1.value)){
			pwd1_msg.innerHTML='● 不能全为字母！';
			pwd1_msg.style.color="rgba(200,0,100,0.8)";
			return false;
		}
		//OK
		else{
			pwd1_msg.innerHTML='● 密码可以使用^ ^';
			pwd1_msg.style.color="green";
			return true;
		}
	}
	//确认密码
	function pwd2Focus(){//获取焦点
		var pwd2_msg = get("pwd2Msg");
		pwd2_msg.style.display="block";
	}
	function pwd2Blur(){//失去焦点
		var pwd2_msg = get("pwd2Msg");
		var pwd2 = get("pwd2");
		if(pwd2.value==""){
			pwd2_msg.innerHTML='● 密码不能为空！';
			pwd2_msg.style.color="rgba(200,0,100,0.8)";
			return false;
		}
		else if(pwd2.value!=pwd1.value){
			pwd2_msg.innerHTML='● 两次输入的密码不一致！';
			pwd2_msg.style.color="rgba(200,0,100,0.8)";
			return false;
		}
		else{
			pwd2_msg.innerHTML='● 验证通过！';
			pwd2_msg.style.color="green";
			return true;
		}
	} 
	//邮箱
	function telFocus(){
		var tel_msg = get("telMsg");
		tel_msg.style.display="block";
	}
	function telBlur(){
		var tel_msg = get("telMsg");
		var tel = get("tel");
		var re3 = /^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$/g;//以1开头
		//不能为空
		if(tel.value==""){
			tel_msg.innerHTML='● 邮箱不能为空！';
			tel_msg.style.color="rgba(200,0,100,0.8)";
			return false;
		}
		//格式不正确
		else if(!re3.test(tel.value)){
			tel_msg.innerHTML='格式不正确！';
			tel_msg.style.color="rgba(200,0,100,0.8)";
			return false;
		}
		else{
			tel_msg.innerHTML='● 验证通过！';
			tel_msg.style.color="green";
			return true;
		}
	}
			
//提交时判断并弹出提示窗
function checkForm(){
	var name_flag = usenameBlur();
 	var password1_flag = pwd1Blur();
 	var password2_flag = pwd2Blur();
 	var tel_flag =telBlur();
 	var flag;
 	if(name_flag==false){
 		var name = get("name");
 		alert("请检查用户名！");
 		flag = false;
 	}
 	if(password1_flag==false){
 		var pwd1 = get("pwd1");
 		alert("密码格式不正确,请重新输入！");
 		
 		flag = false;
	}
 	if(password2_flag==false){
		var pwd2 = get("pwd2");
		alert("两次密码不一致，请重新输入！");
		 	
		 flag = false;
	}
	if(tel_flag==false){
		var tel = get("tel");
		alert("请检查电话号码！");
		flag = false;
	}
	if(flag == false)
		return false;
	else{
		//alert("注册成功！");
		//window.location.href="/BookManageSystem/DisplayServlet";
		return true;
	}
			
}	
