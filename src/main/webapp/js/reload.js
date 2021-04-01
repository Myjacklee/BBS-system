// 处理在浏览器中返回使用页面缓存的问题
if(window.name != "noReload"){
    window.name = "noReload";
    location.reload();
} else {
    window.name = "";
}