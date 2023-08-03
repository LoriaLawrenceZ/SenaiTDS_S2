import javax.swing.JOptionPane;

import Cadastro.Cachorro;
import Cadastro.Gato;
import Cadastro.OutrosAnimais;
import Horario.Agenda;

public class Main {
    public static void main(String[] args) {
        Agenda agenda[] = new Agenda[10];
        Cachorro cachorros[] = new Cachorro[10];
        Gato gatos[] = new Gato[10];
        OutrosAnimais outros[] = new OutrosAnimais[10];

        int contCachorros = 0;
        int contGatos = 0;
        int contOutros = 0;
        int contAgenda = 0;

        boolean ligado = true;

        JOptionPane.showMessageDialog(null, "Seja bem-vindo ao consultório!");

        while (ligado) {
            int escolha = Integer.parseInt(JOptionPane.showInputDialog("1 - Cadastro\n2 - Agendamento\n3 - Sair"));

            switch (escolha) {
                case 1:
                    int acao1 = Integer.parseInt(JOptionPane.showInputDialog("1 - Gato\n2 - Cachorro\n3 - Outros\n4 - Sair"));

                    switch (acao1) {
                        case 1:
                            gatos[contGatos] = new Gato();

                            // Preencher Atributos
                            gatos[contGatos].setNome(JOptionPane.showInputDialog("Informe o nome do gato:"));
                            gatos[contGatos].setPeso(Double.parseDouble(JOptionPane.showInputDialog("Informe o peso do gato:")));

                            contGatos++;
                            break;

                        case 2:
                            cachorros[contCachorros] = new Cachorro();

                            // Preencher Atributos
                            cachorros[contCachorros].setNome(JOptionPane.showInputDialog("Informe o nome do cachorro:"));
                            cachorros[contCachorros].setPeso(Double.parseDouble(JOptionPane.showInputDialog("Informe o peso do cachorro:")));

                            contCachorros++;
                            break;

                        case 3:
                            outros[contOutros] = new OutrosAnimais();

                            // Preencher Atributos
                            outros[contOutros].setNome(JOptionPane.showInputDialog("Informe o nome do animal:"));
                            outros[contOutros].setPeso(Double.parseDouble(JOptionPane.showInputDialog("Informe o peso do animal:")));

                            contOutros++;
                            break;

                        default:
                            break;
                    }

                    break;

                case 2:
                    boolean ocupado = false;

                    String data = JOptionPane.showInputDialog("Qual a data de sua consulta?\n[xx/xx]");
                    String hora = JOptionPane.showInputDialog("Qual a hora de sua consulta?\n[xx:xx]");

                    String dataHora = data + hora;

                    for (int i = 0; i < contAgenda; i++) {
                        if(dataHora.equalsIgnoreCase(agenda[i].getAgendamento())){
                            ocupado = true;

                            break;
                        }
                    }

                    if(ocupado){
                        JOptionPane.showMessageDialog(null, "Não será possível realizar uma consulta neste horário pois já foi reservado.");
                    }
                    else{
                        agenda[contAgenda] = new Agenda();
                        
                        agenda[contAgenda].setCliente(JOptionPane.showInputDialog("Informe o nome do cliente:"));
                        agenda[contAgenda].setData(data);
                        agenda[contAgenda].setHorario(hora);
                        agenda[contAgenda].setVeterinario(JOptionPane.showInputDialog("Informe o nome do veterinário:"));

                        contAgenda++;
                    }

                    break;

                default:
                    ligado = false;
                    break;
            }
        }
    }
}
