<?php

require(listCadastro.php);

?>

<html>
    <head>
        <title>Exemplo</title>
    </head>
    <body>
        <?php foreach ($pedidos as $pedido):?>
            <p><?= $pedido['nome']?> / <?= $pedido['telefone']?></p>
        <?php endforeach; ?>
    </body>
</html>