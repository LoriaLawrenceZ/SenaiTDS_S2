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
                <h1>Cadastramento - Etapa 1 de 3</h1>
            </nav>
        </header>

        <main>
            <form method="POST" action="Etapa2.php">
                <fieldset class="fs-nome">
                    <input type="text" name="nome" id="nome" required>
                    <label for="nome">Nome:</label>
                </fieldset>

                <fieldset class="fs-email">
                    <input type="text" name="email" id="email" required>
                    <label for="email">Email:</label>
                </fieldset>

                <fieldset class="fs-data-nascimento">
                    <input type="date" name="data-nascimento" id="data-nascimento">
                    <label for="data-nascimento">Data de Nascimento:</label>
                </fieldset>

                <fieldset class="fs-sexo">
                    <select name="sexo" id="sexo">
                        <option value="0">Sexo</option>
                        <option value="M">Masculino</option>
                        <option value="F">Feminino</option>
                    </select>
                </fieldset>

                <fieldset class="fs-profissao">
                    <input type="text" name="profissao" id="profissao" required>
                    <label for="profissao">Profissao</label>
                </fieldset>

                <fieldset class="fs-submit">
                    <button type="submit">
                        <h1>PROSSEGUIR</h1>
                    </button>
                </fieldset>
            </form>
        </main>
    </body>
</html>

<?php
?>