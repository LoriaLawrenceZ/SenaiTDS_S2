export class Vaga {
  //-----===| ATRIBUTOS |===-----//
  id: number = 0;
  nome: string = '';
  foto: string = '';
  descricao: string = '';
  salario: number = 0;

  //-----===| CONSTRUTOR |===-----//
  constructor(id: number, nome: string, foto: string, descricao: string, salario: number) {
    this.id = id;
    this.nome = nome;
    this.foto = foto;
    this.descricao = descricao;
    this.salario = salario;
  }
}
