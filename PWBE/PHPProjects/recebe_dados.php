<?php

$username = $_POST["username"];
$cpf = $_POST["cpf"];
$email = $_POST["email"];
$senha = $_POST["senha"];
$cidade = $_POST["cidade"];
$erros = 0;

if(strlen($username) < 6){
    echo"O nome de usuário deve conter ao menos 6 caracteres";
    $erros+=1;
}
if(strlen($cpf) < 11){
    echo"O cpf deve estar completo";
    $erros+=1;
}
if(!strstr($email, "@")){
    echo"Insira um email válido";
    $erros+=1;
}
if(strstr($senha, $username)){
    echo"A senha não pode conter seu nome de usuário";
    $erros+=1;
}
if($cidade == null){
    echo"O nome de usuário deve conter ao menos 6 caracteres";
    $erros+=1;
}
if($erros == 0){
    echo "Tudo em dia patrão";
}