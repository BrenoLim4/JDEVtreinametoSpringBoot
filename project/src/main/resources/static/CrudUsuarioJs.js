function pesquisarUsuario(){
    var nome = $("#filtroNome").val();
    if(nome != null && nome.trim() != ''){
        $.ajax({
            method: "GET",
            url:    "users/buscarPorNome",
            data:   "nome=" + nome,
            success: function (response){

                $('#tableUsuarios > tbody > tr').remove();

                for(var i = 0; i < response.length; i++){
                    $('#tableUsuarios > tbody')
                    .append('<tr id="'+response[i].id+'"> <td>'+response[i].id+'</td> <td>'+response[i].nome+'</td> <td>'+response[i].login+'</td> <td> <button type="button" class="btn btn-primary" onclick="prepararEdicao('+response[i].id+')">Edit</button></td> <td><button type="button" class="btn btn-danger" onclick="excluir('+response[i].id+')">Delete</button></td></tr>')
                }
            }
        }).fail(function(xhr, status, errorThrown){
            alert("Erro ao buscar usuário: " + xhr.responseText);
        });
    }
}

function limparTabelaUsuarios(){
    $('#tableUsuarios > tbody > tr').remove()
    $('#filtroNome').val("")
}

function excluir(idUser){

    if(confirm('Confirma exclusão do Usuário?')){
        $.ajax({
            method  : "DELETE",
            url     : "users/delete",
            data    : "idUser="+idUser,
            success : function (response) {
                $('#' + idUser).remove();
                alert(response);
            }
        })
    }else{
        alert('Operação cancelada!')
    }
}

function prepararEdicao(idUser){

    $.ajax({
            method: "GET",
            url:    "users/buscarPorId",
            data:   "idUser=" + idUser,
            success: function (response){
                $("#id").val(response.id);
                $("#nome").val(response.nome);
                $("#login").val(response.login);
                $("#senha").val(response.senha);

                $('#exampleModal').modal('hide');
            }
        }).fail(function(xhr, status, errorThrown){
            alert("Erro ao buscar usuário por id: " + xhr.responseText);
        });
}

function salvarUsuario(){

    if($("#nome").val() == null || $("#nome").val() == ''){
        $("#nome").focus();
        alert('Campo nome é obrigatório!')
        return
    }
    if($("#login").val() == null || $("#login").val() == ''){
        $("#login").focus();
        alert('Campo login é obrigatório!')
        return
    }
    if($("#senha").val() == null || $("#senha").val() == ''){
        $("#senha").focus();
        alert('Campo senha é obrigatório!')
        return 
    }

    $.ajax({
        method: "POST",
        url:    "users/salvar",
        data:   JSON.stringify({
            id    : $("#id").val(),
            nome  : $("#nome").val(),
            login : $("#login").val(),
            senha : $("#senha").val()
        }),
        contentType:"application/json; charset=utf-8",
        success: function (response){
            alert("Salvo com sucesso!");
            $("#id").val(response.id);
        }
    }).fail(function(xhr, status, errorThrown){
        alert("Erro ao salvar: " + xhr.responseText);
    });
}