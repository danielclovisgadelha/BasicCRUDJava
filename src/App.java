import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<User> user = new ArrayList();
        boolean running = true;


        while (running) {
            Random number = new Random();
            int x = number.nextInt(60);

            System.out.println("\n\n\n\f ################# MICRO SISTEMA DE CADASTRO DE FUNCIONARIO ################# ");
            System.out.println("\n\t[1] Cadastro de Funcionario");
            System.out.println("\t[2] Listagem de Func. Cadastrados");
            System.out.println("\t[3] Buscar por Funcionario");
            System.out.println("\t[4] Alterar Funcionario");
            System.out.println("\t[5] Excluir Funcionario");
            System.out.println("\t[6] Sair");
            System.out.print("\nDigite a opção desejada: ");
            String change = input.nextLine();

            switch (change) {
                case "1": {
                    System.out.println("\n ==== ==== Cadastro Simples de Funcionario ==== ====\n");
                    System.out.print("\fDigite o nome do Funcionario: ");
                    String name = input.nextLine();
                    System.out.print("\fDigite a idade do fucionario " + name + ": ");
                    int age = input.nextInt();
                    input.nextLine();
                    System.out.println("O codigo do funcionario " + name + " sera " + x);
                    User u = new User();
                    u.setName(name);
                    u.setAge(age);
                    u.setID(x);

                    user.add(u);
                    System.out.print("\nFuncionario cadastrado com sucesso!\n");
                    break;
                }
                case "2": {
                    System.out.println("\n ==== ====  Listagem de Dados  ==== ====\n");
                    System.out.println("\n\fAbaixo, todos os funcionarios cadastrados\n");
                    boolean a = false;
                    for (int i = 0; i < user.size(); i++) {
                        User fTemp = user.get(i);
                        System.out.println("\t Funcionario -> " + user.get(i).getName() + " <- na posicao -> " + i + " <- do banco de dados.");
                        System.out.println("\t Idade: " + user.get(i).getAge());
                        System.out.println("\t Codigo do funcionario: " + user.get(i).getID());
                        System.out.println("\n");
                        a = true;
                    }
                    if (a == false) {
                        System.out.println(" *--- Ops, nao ha nada aqui. ---* ");
                        break;
                    }
                    break;
                }
                case "3": {
                    System.out.println("\n ==== ==== Busca de Funcionario ==== ====\n");
                    System.out.println("Digite o nome do Funcionario: ");
                    String name = input.nextLine();

                    boolean found = false;
                    for (int i = 0; i < user.size(); i++) {
                        User fTemp = user.get(i);
                        if (name.equals(fTemp.getName())) {
                            System.out.println("\n\tFuncionario encontrado\n");
                            System.out.println("\t Nome: " + fTemp.getName());
                            System.out.println("\t Idade: " + fTemp.getAge());
                            System.out.println("\t Codigo do funcionario: " + fTemp.getID());
                            System.out.println("\n");
                            found = true;
                        }
                        if (found == false) {
                            System.out.println("\t\n  Ops, nao encontrei o que voce esta procurando. ");
                            break;
                        }
                    }
                    break;
                }
                case "4": {
                    System.out.println("\t\n ==== ==== Atualizacao de Dados ==== ====\n");
                    for (int i = 0; i < user.size(); i++) {
                        User fTemp = user.get(i);
                        System.out.println("[" + i + "]" + fTemp.getName());
                    }
                    System.out.println("\nDigite a posicao pertecente ao funcionario na qual deseja alterar dados: ");
                    int position = input.nextInt();
                    input.nextLine();

                    System.out.println("\f\nVoce esta alterando o nome do funcionario que esta na posicao " + position + ", digite agora o novo nome:  ");
                    String newName = input.nextLine();
                    System.out.println("\fAgora, atualize a idade do funcionario "+newName+" : ");
                    int newAge = input.nextInt();
                    input.nextLine();
                    System.out.println("\fAtualizacao automatica do Codigo do funcionario. Favor verificar o novo codigo.\n");


                    User u = user.get(position);
                    u.setName(newName);
                    u.setAge(newAge);
                    u.setID(x);
                    System.out.println("\fDados aterados com sucesso!\n");
                    break;
                }
                case "5": {
                    System.out.println("\t\n ==== ==== Exclusao de Dados ==== ====\n");
                    for (int i = 0; i < user.size(); i++) {
                        User fTemp = user.get(i);
                        System.out.println("[" + i + "]" + fTemp.getName());
                    }
                    System.out.println("\nDigite o numero pertencente a posicao do funcionario na qual deseja excluir dados: ");
                    int position = input.nextInt();
                    input.nextLine();

                    user.remove(position);

                    System.out.println("\fFuncionario removido com sucesso!");
                    break;
                }
                case "6": {
                    running = false;
                    System.out.println("\n\n *--* Obrigado por utilizar este CRUD  *__* ");
                    System.out.println("                Até Logo ");
                    break;
                }
            }
        }
    }
}