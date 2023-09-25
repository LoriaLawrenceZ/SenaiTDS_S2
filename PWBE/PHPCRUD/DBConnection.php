<?php
    // endereco
    // nome do BD
    // usuario
    // senha
    $host = 'localhost';
    $usuario = 'root';
    $senha = '';
    $dbname = 'aulaphpcrud';

    try{
        // Criando uma nova conexão ao criar um objeto mysqli
        $mysqli = new mysqli($host, $usuario, $senha, $dbname);
    }
    catch(Exception $e){
        $error = $e->getMessage();
        echo $error;
    }
?>