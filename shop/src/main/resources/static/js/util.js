/*获取cookie*/
//传入key
function getUserNameCookie(name) {
    //    js遍历获取cookie
    name = name.toLowerCase();
    let allcookies = document.cookie;
    let arrcookies = allcookies.split("; ");
    for(let i=0;i<arrcookies.length;i++){
        let usercookie = arrcookies[i].split("=");
        if (usercookie[0].toLowerCase() == name){
            // let username = decodeURI(usercookie[1])
            return decodeURI(usercookie[1]);
        }
    }
    return "";
}

/*表单输入框获取焦点*/
//传入标签id
function getFocus(attr) {
    setTimeout(function(){
            var d=document.getElementById(attr);
            d.focus();
    },2)
    return;
}

//获取项目url路径
function getRootPath() {
//    1、获取当前全路径
    var currFullPath = window.location.href;
//    2、获取当前相对路径
    var pathName =window.location.pathname;
    var local =currFullPath.substring(0,currFullPath.indexOf(pathName));
//    3、获取带 "/"的项目名
    var projectName = pathName.substring(0,pathName.substr(1).indexOf('/')+1);
    var rootPath = local + projectName;
    return rootPath;
}

//替换url参数
function replaceUrl(name,val,url) {
    if (url.substr(url.length-1,1) == "#"){
        url = url.substring(0,url.length-1)
    }
    var reg = "/"+name+"=[0-9]+/";
    url = url.replace(eval(reg),name+"="+val);
    return url;
}


//根据url判定显示筛选条件
function isShowCondition(url,condition,viewId) {
    var reg = "/" + condition + "/";
    if(eval(reg).test(url)){
        $(eval('\"'+'#'+viewId+'\"')).css("display","none");
    }else {
        $(eval('\"'+'#'+viewId+'\"')).css("display","block");
    }

}