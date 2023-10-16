<?php
require_once("\PWBE\Orientacao\Pessoa");

//Instanciando objetos
$pessoa1 = new Pessoa(1.83, "Fulano", "Oliveira");
$pessoa1->setAltura(1.82);
$pessoa2 = new Pessoa(1.67, "Ciclano", "da Silva");

var_dump($pessoa1);
var_dump($pessoa2);