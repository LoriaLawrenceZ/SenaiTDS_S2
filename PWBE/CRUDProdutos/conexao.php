<?php

$dsn = "mysql:host=localhost;dbname=crudprodutos";
$username = "root";
$password = "senaisp";

try {
    $pdo = new PDO($dsn, $username, $password);
    $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
    $pdo->setAttribute(PDO::ATTR_DEFAULT_FETCH_MODE, PDO::FETCH_ASSOC);
    $pdo->exec("set names utf8");
} catch (\Throwable $th) {
    echo "Erro:". $th->getMessage();
}

?>