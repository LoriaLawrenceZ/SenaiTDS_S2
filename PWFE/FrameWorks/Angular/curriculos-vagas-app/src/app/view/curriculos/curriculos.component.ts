// Importa os módulos e classes necessárias
import { Component, OnInit } from '@angular/core';
import { curriculoService } from '../../service/curriculos.service';
import { Curriculo } from '../../models/curriculo.model';

@Component({
  selector: 'app-curriculos',
  templateUrl: './curriculos.component.html',
  styleUrls: ['./curriculos.component.css'],
})
export class curriculosComponent implements OnInit {
  public curriculos: Curriculo[] = []; // Uma matriz para armazenar as curriculos

  constructor(private _curriculosService: curriculoService) {}

  // Injeta o serviço de curriculos no construtor do componente
  ngOnInit(): void {
    // Executa a função de listagem de curriculos quando é inicializado
    this.listarcurriculos();
  }

  // Função para listar as curriculos
  listarcurriculos() {
    this._curriculosService.getCurriculos().subscribe((retornaCurriculo) => {
      this.curriculos = retornaCurriculo.map((item) => {
        // Mapeia os dados retornados para o modelo curriculo
        return new Curriculo(
          item.id,
          item.nome,
          item.foto,
          item.descricao,
          item.salario,
          item.escolaridade,
          item.experiencia
        );
      });
    });
  }
}
