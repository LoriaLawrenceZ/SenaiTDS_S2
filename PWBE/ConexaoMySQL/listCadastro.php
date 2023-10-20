<?php

require_once(conexao.php);

//Código SQL
$sql_code = "SELECT * FROM cadastros;";
//Executando o código sql no banco de dados
$sql_query = $mysqli->query($sql_code) or die("Falha na execução do códigomSQL: ".$mysqli->error);

// Fazendo if para evitar erros (como array não inicializado)
if ($sql_query->num_rows == 0) {
    $pedidos = null
}
else {
    while($pedido = $sql_query->fetch_assoc()){
        $pedidos[] = $pedido;
    }
}
