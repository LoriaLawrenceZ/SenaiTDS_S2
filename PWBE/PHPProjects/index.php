<?php
    ?>
        <head>
            <link rel="stylesheet" href="universal.css">
        </head>

        <body>
            <form method="POST" action="recebe_dados.php">
                <fieldset class="fs-username">
                    <input type="text" name="username" id="username" required>
                    <label for="username" class="username-label">Username:</label>
                </fieldset>

                <fieldset class="fs-cpf">
                    <input type="text" name="cpf" id="cpf" required>
                    <label for="cpf" class="cpf-label">CPF:</label>
                </fieldset>

                <fieldset class="fs-cidade">
                    <select name="cidade" id="cidade">
                        <option value="">Cidade</option>
                        <option value="SP">São Paulo</option>
                        <option value="ES">Espírito Santo</option>
                        <option value="RJ">Rio de Janeiro</option>
                        <option value="MG">Minas Gerais</option>
                    </select>
                </fieldset>

                <fieldset class="fs-email">
                    <input type="text" name="email" id="email" required>
                    <label for="email" class="email-label">E-mail:</label>
                </fieldset>

                <fieldset class="fs-senha">
                    <input type="text" name="senha" id="senha" required>
                    <label for="senha" class="senha-label">Senha:</label>
                </fieldset>

                <fieldset class="fs-submit">
                    <input type="submit" name="submit" id="submit" value="CADASTRAR">
                </fieldset>
            </form>
        </body>

    <?php
?>