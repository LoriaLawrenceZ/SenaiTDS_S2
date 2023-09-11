<?php
?>

<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>OzzaTech</title>
        <!--LINKS-->
        <link rel="stylesheet" href="universal.css">
        <title>Desenvolvendo Websites com PHP</title>
    </head>

    <body>
        <header>
            <nav>
                <h1>Cadastramento - Etapa 3 de 3</h1>
            </nav>
        </header>

        <main>
            <form method="POST" action="Etapa3.php">
                <fieldset class="fs-hidden">
                    <input type="hidden" name="nome" value="<?= $_POST["nome"]?>">
                    <input type="hidden" name="email" value="<?= $_POST["email"]?>">
                    <input type="hidden" name="data-nascimento" value="<?= $_POST["data-nascimento"]?>">
                    <input type="hidden" name="nome" value="<?= $_POST["sexo"]?>">
                    <input type="hidden" name="nome" value="<?= $_POST["profissao"]?>">
                    <input type="hidden" name="telefone" value="<?= $_POST["telefone"]?>">
                    <input type="hidden" name="endereco" value="<?= $_POST["endereco"]?>">
                    <input type="hidden" name="cidade" value="<?= $_POST["cidade"]?>">
                    <input type="hidden" name="CEP" value="<?= $_POST["CEP"]?>">
                </fieldset>

                <fieldset class="fs-username">
                    <input type="text" name="username" id="username" required>
                    <label for="username">Username:</label>
                </fieldset>

                <fieldset class="fs-senha">
                    <input type="password" name="senha" id="senha" required>
                    <label for="senha">Senha:</label>
                </fieldset>

                <fieldset class="fs-senha-dnv">
                    <input type="password" name="senha-dnv" id="senha-dnv" required>
                    <label for="senha-dnv">Confirme a Senha:</label>
                </fieldset>

                <fieldset class="fs-submit">
                    <button type="button" class="btn-voltar">
                        <a href="Etapa2.php">
                            <h1>VOLTAR</h1>
                        </a>
                    </button>

                    <button type="submit" class="btn-finalizar">
                        <h1>FINALIZAR</h1>
                    </button>
                </fieldset>
            </form>
        </main>
    </body>
</html>

<?php
?>