<?php

namespace Orientacao;

class Pessoa{
    //Atributos
    private float $altura;
    private string $nome;
    private string $sobrenome;

    //function __construct -> Construtor em php
    public function __construct(float $altura, string $nome, string $sobrenome){
        $this -> altura = $altura;
        $this -> nome = $nome;
        $this -> sobrenome = $sobrenome;
    }

    public function getAltura():float{ //tipo que retorna (:tipo)
        return $this -> altura;
    }
    public function setAltura(float $altura):void{
        $this -> altura;
    }

    public function getNome():string{ //tipo que retorna (:tipo)
        return $this -> nome;
    }
    public function setNome(string $nome):void{
        $this -> nome;
    }

    public function getSobrenome():string{ //tipo que retorna (:tipo)
        return $this -> sobrenome;
    }
    public function setSobrenome(float $sobrenome):void{
        $this -> sobrenome;
    }
}