<?php

$host = "localhost";
$db = "devmedia";
$user = "root";
$pass = "";

try{
    $mysqli = new mysqli($host, $user, $pass, $db);
}
catch(Excepetion $e){
    $error = $e->getMessage();
    echo $error;
}

?>