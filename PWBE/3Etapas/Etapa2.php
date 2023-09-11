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
                <h1>Cadastramento - Etapa 2 de 3</h1>
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
                </fieldset>

                <fieldset class="fs-telefone">
                    <input type="text" name="telefone" id="telefone" required>
                    <label for="telefone">Telefone:</label>
                </fieldset>

                <fieldset class="fs-endereco">
                    <input type="text" name="endereco" id="endereco" required>
                    <label for="endereco">Endereço:</label>
                </fieldset>

                <fieldset class="fs-cidade">
                    <input type="text" name="cidade" id="cidade" required>
                    <label for="cidade">Cidade:</label>
                </fieldset>

                <fieldset class="fs-CEP">
                    <input type="text" name="CEP" id="CEP" required>
                    <label for="CEP">CEP:</label>
                </fieldset>

                <fieldset class="fs-submit">
                    <button type="button" class="btn-voltar">
                        <a href="Etapa1.php">
                            <h1>VOLTAR</h1>
                        </a>
                    </button>

                    <button type="submit" class="btn-prosseguir">
                        <h1>PROSSEGUIR</h1>
                    </button>
                </fieldset>
            </form>
        </main>
    </body>
</html>

<?php
?>