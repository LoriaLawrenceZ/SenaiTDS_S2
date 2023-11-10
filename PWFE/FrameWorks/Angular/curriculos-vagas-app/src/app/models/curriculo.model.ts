export class Curriculo {
  //-----===| ATRIBUTOS |===-----//
  id: number = 0;
  nome: string = '';
  foto: string = '';
  descricao: string = '';
  salario: number = 0;
  escolaridade: string = '';
  experiencia: string = '';

  //-----===| CONSTRUTOR |===-----//
  constructor(id: number, nome: string, foto: string, descricao: string, salario: number, escolaridade: string, experiencia: string) {
    this.id = id;
    this.nome = nome;
    this.foto = foto;
    this.descricao = descricao;
    this.salario = salario;
    this.escolaridade = escolaridade;
    this.experiencia = experiencia;
  }
}
