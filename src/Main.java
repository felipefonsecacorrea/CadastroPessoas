import java.awt.image.BandCombineOp;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        ArrayList<PessoaFisica> listaPf = new ArrayList<PessoaFisica>();
        PessoaFisica metodosPf = new PessoaFisica();

        System.out.println("Bem vindo ao sistema de cadastro de pessoa fisica e juridica !");

        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {

            System.out.println("Escolha uma Opção:");
            System.out.println("1- Pessoa Fisica");
            System.out.println("2- Pessoa Juridica");
            System.out.println("3- Sair");

            opcao = scanner.nextInt();


            switch (opcao) {

                case 1:

                    int opcaoPf;
                    do {
                        System.out.println("Escolha uma Opção: ");
                        System.out.println("1- Cadastrar pessoa Fisica");
                        System.out.println("2- Listar pessoa Fisica");
                        System.out.println("0- Voltar ao menu anterior");
                        opcaoPf = scanner.nextInt();

                        switch (opcaoPf) {
                            case 1:
                                PessoaFisica novaPf = new PessoaFisica();
                                Endereco enderecoPf = new Endereco();

                                System.out.println("Digite o nome da pessoa fisica:");
                                novaPf.nome = scanner.next();

                                System.out.println("Digite o CPF da pessoa fisica:");
                                novaPf.cpf = scanner.next();

                                System.out.println("Digite o rendimento: (Digite somente numeros !)");
                                novaPf.rendimento = scanner.nextInt();

                                System.out.println("Digte a data da nascimento (DD/MM/AAAA)");
                                LocalDate date = LocalDate.parse(scanner.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                                Period periodo = Period.between(date, LocalDate.now());

                                novaPf.dataNasc = date;

                                if (periodo.getYears() >= 18) {
                                    System.out.println("A pessoa é Maior de idade");
                                } else {
                                    System.out.println("A pessoa é Menor de idade");
                                }


                                /////////////////////////////////////////////////
                                System.out.println("ENDEREÇO)");

                                System.out.println("Este endereço é comercial ? [S/N]");
                                String endCom = scanner.next();

                                System.out.println("Digite o numero do seu endereço: ");
                                enderecoPf.numero = scanner.next();

                                System.out.println("Digite o logradouro:");
                                enderecoPf.logradouro = scanner.next();

                                if (endCom.equalsIgnoreCase("S")) {
                                    enderecoPf.enderecoComercial = true;
                                } else {
                                    enderecoPf.enderecoComercial = false;
                                }


                                listaPf.add(novaPf);
                            break;

                            case 2:
                                if(listaPf.size() > 0) {
                                    for (PessoaFisica cadaPf : listaPf){
                                        System.out.println();
                                        System.out.println("Nome: "+cadaPf.nome);
                                        System.out.println("CPF: "+cadaPf.cpf);
                                        System.out.println("Nome: "+cadaPf.nome);
                                        System.out.println("Endereço: "+cadaPf.endereco.logradouro+ " , "+cadaPf.endereco.numero);
                                        System.out.println("Data Nascimento: "+cadaPf.dataNasc.format( DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                                        System.out.println("Imposto a ser Pago "+ metodosPf.calcularImposto(cadaPf.rendimento));
                                        System.out.println("Digite 0 para Continuar: ");
                                        scanner.nextInt();
                                    }
                                opcaoPf = scanner.nextInt();

                                }else{
                                    System.out.println("Lista Vazia !");
                                }
                            break;

                            case 0:
                                System.out.println("obrigado,volte sempre !");
                                break;

                            default:
                                System.out.println("Opção invalidade !");
                                break;
                        }
                    }while (opcaoPf != 0) ;
                break;

                case 2:
                    break;

                case 0:
                    break;

                default:
                    break;
            }
        } while (opcao != 0);
    }
}