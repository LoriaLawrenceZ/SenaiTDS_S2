<?php
require_once 'conectaBD.php';
// Conectar ao BD (com o PHP)
/*
echo '<pre>';
print_r($_POST);
echo '</pre>';
die();
*/
// Verificar se está chegando dados por POST
if (!empty($_POST)) {
    // Iniciar SESSAO (session_start)
    session_start();
    try {
        // Montar a SQL
        $sql = "SELECT nome, email, telefone, data_nascimento FROM Usuarios WHERE email =
    :email AND senha = :senha";
        // Preparar a SQL (pdo)
        $statement = $mysqli->prepare($sql);
        // Definir/Organizar os dados p/ SQL
        $dados = array(
            ':email' => $_POST['email'],
            ':senha' => md5($_POST['senha'])
        );
        $statement->execute($dados);
        //$stmt->execute(array(':email' => $_POST['email'], ':senha' => $_POST['senha']));
        $result = $statement->fetch_all();
        if ($statement->num_rows == 1) { // Se o resultado da consulta SQL trouxer um registro
            // Autenticação foi realizada com sucesso
            $result = $result[0];
            // Definir as variáveis de sessão
            $_SESSION['nome'] = $result['nome'];
            $_SESSION['email'] = $result['email'];
            $_SESSION['data_nascimento'] = $result['data_nascimento'];
            $_SESSION['telefone'] = $result['telefone'];
            // Redirecionar p/ página inicial (ambiente logado)
            header("Location: index_logado.php");
        } else { // Signifca que o resultado da consulta SQL não trouxe nenhum registro
            // Falha na autenticaçao
            // Destruir a SESSAO
            session_destroy();
            // Redirecionar p/ página inicial (login)
            header("Location: index.php?msgErro=E-mail e/ou Senha inválido(s).");
        }
    } catch (mysqli_sql_exception $e) {
        die($e->getMessage());
    }
}