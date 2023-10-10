<?php

$continuar = "S";

do {
    echo "-----------------------------------\n";

    echo "Insira um primeiro número:";
    $num1 = readline();

    echo "Insira um segundo número:";
    $num2 = readline();

    echo "Escolha uma operação matemática!\n1 - Soma\n2 - Subtração\n3 - Multiplicação\n4 - Divisão\n5 - Potência\n6 - Raiz Quadrada\n";
    $opcao = readline();

    switch ($opcao) {
        case 1:
            echo "Resultado: ". ($num1 + $num2) ."\n";
            break;

        case 2:
            echo "Resultado: ". ($num1 - $num2) ."\n";
            break;

        case 3:
            echo "Resultado: ". ($num1 * $num2) ."\n";
            break;
        
        case 4:
            echo "Resultado: ". ($num1 / $num2) ."\n";
            break;

        case 5:
            $potencia = $num1;
            for ($i=1; $i < $num2; $i++) { 
                $potencia *= $num1;
            }
            echo "Resultado: ". ($potencia) ."\n";

            break;

        case 6:
            echo "Resultado:\nRaiz quadrada de ". $num1 ." é: ". sqrt($num1) ."\n";
            echo "Raiz quadrada de ". $num2 ." é: ". sqrt($num2) ."\n";
            break;

        default:
            echo "Insira um valor válido da próxima vez!";
            break;
    }
    echo "-----------------------------------\nDeseja continuar?\n[S] - Sim | [N] - Não\n";
    $continuar = readline();
} while ($continuar == "S");