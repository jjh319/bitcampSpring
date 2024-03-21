
$(function () {

    $('#writeBtn').click(function () {

        $('#nameDiv').empty();
        $('#idDiv').empty();
        $('#pwdDiv').empty();

        if ($('#name').val() == '')
            $('#nameDiv').text('이름 입력');
        else if ($('#id').val() == '')
            $('#idDiv').text('아이디 입력');
        else if ($('#pwd').val() == '')
            $('#pwdDiv').text('비밀번호 입력');


    }) // 유효성 검사

})


$('#id').focusout(function(){
    if($('#id').val() == '')
        $('#idDiv').html('아이디를 입력하세요.');
    else
        $.ajax({
            type: 'post',
            url: '/springWeb/user/checkId',
            data: 'id=' + $('#id').val(),
            dataType: 'text',
            success: function(data){
                alert(data.trim());

                if(data.trim() == 'exist')
                    $('#idDiv').html('사용 불가능').css('color', 'red');
                else if(data.trim() == 'non_exist'){
                    $('#idDiv').html('사용 가능').css('color', 'blue');
                    $('#check').val($('#id').val());
                }
            },
            error: function(e){
                console.log(e);
            }
        });
});
