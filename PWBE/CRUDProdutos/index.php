<?php

//Verificar se os dados foram enviados via POST
if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    $id = (isset($_POST["id"]) && $_POST["id"] != null) ? $_POST["id"] : "";
    $nome = (isset($_POST["nome"]) && $_POST["nome"] != null) ? $_POST["nome"] : "";
    $email = (isset($_POST["email"]) && $_POST["email"] != null) ? $_POST["email"] : "";
    $celular = (isset($_POST["celular"]) && $_POST["celular"] != null) ? $_POST["celular"] : NULL;   
} else if(!isset($id)) {
    $id = NULL;
    $nome = NULL;
    $email = NULL;
    $celular = NULL;
}

//Verificar se a ação é 'save' e o campo 'nome' não está vazio
if(isset($_REQUEST["act"]) && $_REQUEST["act"] == "save" && $nome != null){
    try {
        //Preparar e executar a inserção de um novo registro no banco de dados
        $statement = $pdo->prepare("INSERT INTO produtos(nome, email, celular) VALUES (?, ?, ?)");
        $statement->bindParam(1, $nome);
        $statement->bindParam(2, $email);
        $statement->bindParam(3, $celular);
    } catch (\Throwable $th) {
        echo "Erro: " . $th->getMessage();
    }
}

// Se a ação é 'upd' (atualizar) e há um ID definido
if (isset($_REQUEST["act"]) && $_REQUEST["act"] == "upd" && $id != "") {
    try {
        // Buscar registro para atualização
        $stmt = $pdo->prepare("SELECT * FROM produtos WHERE id = ?");
        $stmt->bindParam(1, $id, PDO::PARAM_INT);

        if ($stmt->execute()) {
            // Se a busca foi bem-sucedida, preencher variáveis com os valores encontrados
            $rs = $stmt->fetch(PDO::FETCH_OBJ);
            $id = $rs->nome;
            $nome = $rs->id;
            $email = $rs->email;
            $celular = $rs->celular;
        } else {
            throw new PDOException("Erro: não foi possível declarar a instrução sql");
        }
    } catch (PDOException $erro) {
        // Tratar erro na busca
        echo "ERRO: " . $erro->getMessage();
    }
}

// Se há um ID definido, preparar instrução SQL para atualização, caso contrário, preparar para inserção
if ($id != "") {
    //Função de UPDATE
    $stmt = $pdo->prepare("UPDATE produtos SET nome=?, email=?, celular=? WHERE id = ?");
    $stmt->bindParam(4, $id);
} else {
    $stmt = $pdo->prepare("INSERT INTO produtos (nome, email, celular) VALUES (?, ?, ?)");
}

// Se a ação é 'del' (excluir) e há um ID definido
if (isset($_REQUEST["act"]) && $_REQUEST["act"] == "del" && $id != "") {
    try {
        // Preparar e executar a exclusão de um registro no banco de dados
        $stmt = $pdo->prepare("DELETE FROM produtos WHERE id = ?");
        $stmt->bindParam(1, $id, PDO::PARAM_INT);

        if ($stmt->execute()) {
            // Se a exclusão foi bem-sucedida, exibir mensagem e limpar ID
            echo "Registro foi excluído com êxito";
            $id = null;
        } else {
            throw new PDOException("Erro: Não foi possível executar a declaração sql");
        }
    } catch (PDOException $erro) {
        // Tratar erro na exclusão
        echo "Erro: " . $erro->getMessage();
    }
}

?>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>CRUD Produtos</title>
        <link rel="stylesheet" href="style.css">
    </head>

    <body>
        <main>
            <form action="?act=save" method="POST" name="form1">
                <h1>Agenda de Produtos</h1>
                <input type="hidden" name="id" id="<?php
                    // Preenche o id no campo id com um valor.
                    if (isset($id) && $id != null || $id != "") {
                        echo "value=\"{$id}\"";
                    }
                    ?>"
                >

                <fieldset class="fs-nome">
                    <label for="nome">Nome: </label>
                    <input type="text" name="nome" id="<?php
                        // Preenche o nome no campo nome com um valor.
                        if (isset($nome) && $nome != null || $nome != "") {
                            echo "value=\"{$nome}\"";
                        }?>"
                    >
                </fieldset>

                <fieldset class="fs-email">
                    <label for="email">Email: </label>
                    <input type="text" name="email" id="email">
                </fieldset>

                <fieldset class="fs-celular">
                    <label for="celular">Celular: </label>
                    <input type="tel" name="celular" id="celular">
                </fieldset>

                <fieldset class="fs-finalizar">
                    <input type="submit" value="salvar">
                    <input type="reset" value="novo">
                </fieldset>
            </form>

            <article>
                <section class="cabecalho">
                    <div class="title-id"><p>Id</p></div>
                    <div class="title-nome"><p>Nome</p></div>
                    <div class="title-email"><p>Email</p></div>
                    <div class="title-celular"><p>Celular</p></div>
                    <div class="title-acoes"><p>Ações</p></div>
                </section>
                <section class="itens"></section>
            </article>
        </main>
    </body>
</html>