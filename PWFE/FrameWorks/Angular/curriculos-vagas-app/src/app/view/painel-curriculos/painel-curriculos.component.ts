// Importa os módulos e classes necessárias
import { Component, OnInit } from '@angular/core';
import { Curriculo } from '../../models/curriculo.model';
import { curriculoService } from '../../service/curriculos.service';
@Component({
  selector: 'app-painel-curriculos',
  templateUrl: './painel-curriculos.component.html',
  styleUrls: ['./painel-curriculos.component.css'],
})
export class PainelcurriculosComponent implements OnInit {
  // Uma instância de 'curriculo' para rastrear os dados do formulário
  public curriculo: Curriculo = new Curriculo(0, '', '', '', 0, '', '');

  // Uma matriz para armazenar as curriculos listadas
  public curriculos: Curriculo[] = [];

  // aplica o serviço 'curriculoService' no construtor
  constructor(private _curriculosService: curriculoService) {}

  ngOnInit(): void {
    // Quando o componente é inicializado, lista as curriculos disponíveis
    this.listarCurriculos();
  }

  // Lista as curriculos do servidor usando o serviço 'curriculoService'
  listarCurriculos() {
    this._curriculosService.getCurriculos().subscribe((retornaCurriculo) => {
      // Mapeia os dados retornados para objetos 'curriculo'
      this.curriculos = retornaCurriculo.map((item) => {
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

  // Função para listar uma curriculo individual no formulário para edição
  listarCurriculo(curriculo: Curriculo) {
    // A curriculo clicada é definida como a curriculo atual no formulário
    this.curriculo = curriculo;
  }

  // Função para cadastrar uma nova curriculo
  cadastrar() {
    this._curriculosService.cadastrarCurriculo(this.curriculo).subscribe(
      // Após cadastrar com sucesso
      () => {
        this.curriculo = new Curriculo(0, '', '', '', 0, '', ''); // Limpa o formulário
        this.listarCurriculos(); // Atualiza a lista de curriculos
      },

      // Em caso de erro, exibe uma mensagem no console
      (err) => {
        console.log('Erro ao cadastrar', err);
      }
    );
  }

  // Função para atualizar uma curriculo existente
  atualizar(id: number) {
    this._curriculosService.atualizarCurriculo(id, this.curriculo).subscribe(
      // Após atualizar com sucesso
      () => {
        this.curriculo = new Curriculo(0, '', '', '', 0, '', ''); // Limpa o formulário
        this.listarCurriculos(); // Atualiza a lista de curriculos
      },

      (err) => {
        console.log('Erro ao atualizar', err);
      }
    );
  }

  // Função para excluir uma curriculo
  excluir(id: number) {
    this._curriculosService.removerCurriculo(id).subscribe(
      // Após excluir com sucesso
      () => {
        this.curriculo = new Curriculo(0, '', '', '', 0, '', ''); // Limpa o formulário

        this.listarCurriculos(); // Atualiza a lista de curriculos
      },

      (err) => {
        console.log('Erro ao excluir', err);
      }
    );
  }
}
