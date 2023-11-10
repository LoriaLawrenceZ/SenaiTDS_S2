// Importa os módulos e classes necessárias
import { Component, OnInit } from '@angular/core';
import { Vaga } from '../../models/vaga.model';
import { VagaService } from '../../service/vagas.service';
@Component({
  selector: 'app-painel-vagas',
  templateUrl: './painel-vagas.component.html',
  styleUrls: ['./painel-vagas.component.css'],
})
export class PainelVagasComponent implements OnInit {
  // Uma instância de 'Vaga' para rastrear os dados do formulário
  public vaga: Vaga = new Vaga(0, '', '', '', 0);

  // Uma matriz para armazenar as vagas listadas
  public vagas: Vaga[] = [];

  // aplica o serviço 'VagaService' no construtor
  constructor(private _vagasService: VagaService) {}

  ngOnInit(): void {
    // Quando o componente é inicializado, lista as vagas disponíveis
    this.listarVagas();
  }

  // Lista as vagas do servidor usando o serviço 'VagaService'
  listarVagas() {
    this._vagasService.getVagas().subscribe((retornaVaga) => {
      // Mapeia os dados retornados para objetos 'Vaga'
      this.vagas = retornaVaga.map((item) => {
        return new Vaga(
          item.id,
          item.nome,
          item.foto,
          item.descricao,
          item.salario
        );
      });
    });
  }

  // Função para listar uma vaga individual no formulário para edição
  listarVaga(vaga: Vaga) {
    // A vaga clicada é definida como a vaga atual no formulário
    this.vaga = vaga;
  }

  // Função para cadastrar uma nova vaga
  cadastrar() {
    this._vagasService.cadastrarVaga(this.vaga).subscribe(
      // Após cadastrar com sucesso
      () => {
        this.vaga = new Vaga(0, '', '', '', 0); // Limpa o formulário
        this.listarVagas(); // Atualiza a lista de vagas
      },

      // Em caso de erro, exibe uma mensagem no console
      (err) => {
        console.log('Erro ao cadastrar', err);
      }
    );
  }

  // Função para atualizar uma vaga existente
  atualizar(id: number) {
    this._vagasService.atualizarVaga(id, this.vaga).subscribe(
      // Após atualizar com sucesso
      () => {
        this.vaga = new Vaga(0, '', '', '', 0); // Limpa o formulário
        this.listarVagas(); // Atualiza a lista de vagas
      },

      (err) => {
        console.log('Erro ao atualizar', err);
      }
    );
  }

  // Função para excluir uma vaga
  excluir(id: number) {
    this._vagasService.removerVaga(id).subscribe(
      // Após excluir com sucesso
      () => {
        this.vaga = new Vaga(0, '', '', '', 0); // Limpa o formulário

        this.listarVagas(); // Atualiza a lista de vagas
      },
      
      (err) => {
        console.log('Erro ao excluir', err);
      }
    );
  }
}
