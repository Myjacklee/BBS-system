$(function(){
    $("#uploadBoard").click(function(){
        $.ajax({
            url:"${pageContent.request.contentPath}/board/add/${}"
        });
    });
});