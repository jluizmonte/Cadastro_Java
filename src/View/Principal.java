package View;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import java.sql.SQLException;
import Model.Cadastro;
import entidade.Telefone;
import entidade.JpaUtil;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import javax.management.remote.JMXConnectorFactory;

public class Principal {

    static Scanner tclInt = new Scanner(System.in);
    static Scanner tcl = new Scanner(System.in);
    static Cadastro cadastro = new Cadastro();
    static Telefone telefone = new Telefone();
    static ArrayList<Cadastro> ListaC = new ArrayList<Cadastro>();
    static ArrayList<Telefone> ListaT = new ArrayList<Telefone>();

    public static void addCad() throws SQLException, InterruptedException {

        System.out.print("\n\n########################################                         ");
        System.out.println("\n<<<<< ||||| CADASTRO PESSOA |||||| >>>>>");
        System.out.println("########################################\n\n");

        System.out.print("NOME: ");
        String nome = tcl.nextLine().toUpperCase();
        System.out.println("");

        System.out.print("SEXO: ");
        String email = tcl.nextLine().toUpperCase();
        System.out.println("");

        System.out.print("TELEFONE: ");
        String telefone = tcl.nextLine();
        System.out.println("");

        System.out.print("SENHA: ");
        String senha = tcl.nextLine();
        System.out.println("");

        System.out.println("***********Telefone**********");
        System.out.println("");
        System.out.print("DDD: ");
        Integer ddd = tclInt.nextInt();
        System.out.println("");

        System.out.print("NUMERO: ");
        String numero = tcl.nextLine();
        System.out.println("");
        System.out.print("TIPO: ");
        String tipo = tcl.nextLine();
        System.out.println("");

        Cadastro cadastro = new Cadastro();

        cadastro.setNome(nome);
        cadastro.setEmail(email);
        cadastro.setSenha(senha);

        cadastro.setTelefone(new Telefone());

        cadastro.getTelefone().setDdd(ddd);
        cadastro.getTelefone().setNumero(numero);
        cadastro.getTelefone().setTipo(tipo);

        menuPrincipal();
    }

    private static void MenuPrincipal() throws InterruptedException, SQLException {
        int opcao = 0;
        while (opcao != 6) {
            System.out.println("");
            System.out.print("\n********************");
            System.out.print("\n***   CADASTRO   ****");
            System.out.print("\n********************\n");
            System.out.print("\n 1 - Cadastrar");
            System.out.print("\n 2 - Alterar");
            System.out.print("\n 3 - Remover");
            System.out.print("\n 4 - Pesquisar");
            System.out.print("\n 5 - listar");
            System.out.print("\n 6 - Sair\n");
            try {
                opcao = tclInt.nextInt();
                switch (opcao) {
                    case 1:
                        addCad();
                        MenuPrincipal();
                    case 2:
                        System.out.println("");
                        System.out.println("\n*********************************");
                        System.out.println("********* ALterar Cadastro ********");
                        System.out.println("\n*********************************");
                        System.out.println("Digite o nome do cadastor a ser alterado: ");
                        String nomePesquisa = tcl.nextLine();
                        cadastro = pesquisarCadastro(nomePesquisa);
                        if (cadastro != null) {
                            System.out.println("****** Cadastro Atual *******");
                            System.out.println(cadastro.getNome() + " - " + cadastro.getEmail() + " - " + cadastro.getTelefone() + " - " + cadastro.getSenha());
                            System.out.println("");
                            System.out.print("Deseja Alterar o cadastro: ");
                            String alterar = tcl.nextLine().toUpperCase();
                            if (alterar.equals("S")) {
                                System.out.println("");
                                alterarCadastro(cadastro);
                            } else {
                                System.out.println("");
                                voltarMenu();
                            }
                        } else {
                            System.out.print("**************** Não Existe cadastro com esse CPF *****************");
                            System.out.println("");
                            voltarMenu();
                        }
                        break;
                    case 3:
                        System.out.println("\n*********************************");
                        System.out.println("******** Remover Cadastro ********");
                        System.out.println("\n*********************************");
                        System.out.println("Digite o nome do cadastro a ser removido: ");
                        String nomeRm = tcl.nextLine();
                        cadastro = pesquisarCadastro(nomeRm);
                        if (cadastro != null) {
                            System.out.println(
                                    "******Deseja remover " + cadastro.getNome() + " - " + cadastro.getEmail() + " (S) / (N)");
                            String rm = tcl.nextLine().toUpperCase();
                            if (rm.equals("S")) {
                                removerCadastro(cadastro);
                                System.out.println("");
                                MenuPrincipal();
                            } else {
                                MenuPrincipal();
                            }
                        } else {
                            System.out.print("**************** O cadastro " + nomeRm + " não foi encontrado *****************");
                            MenuPrincipal();
                        }
                        MenuPrincipal();
                    case 4:
                        String continuarPesquisando = "N";
                        do {
                            System.out.println("\n*********************************");
                            System.out.println("******** Pesquisar Cadastro ********");
                            System.out.println("\n*********************************");
                            System.out.println("Digite o nome do cadastro a ser removido: ");
                            String nomePes = tcl.nextLine();
                            cadastro = pesquisarCadastro(nomePes);
                            if (cadastro != null) {
                                System.out.println("***** Cadastro localizado *****");
                                System.out.println(cadastro.getNome() + " - " + cadastro.getEmail());
                                System.out.println();
                            } else {
                                System.out.println(
                                        "**************** Não Existe cadatro com esse nome *****************");
                                System.out.println();
                            }

                            System.out.println("Deseja continuar pesquisando? (S / N)");
                            continuarPesquisando = tcl.nextLine().toUpperCase();
                        } while (continuarPesquisando.equals("S"));
                        MenuPrincipal();
                    case 5:
                        listarCadastro();
                        System.out.println("");
                        voltarMenu();
                    case 6:
                        break;
                }

            } catch (InputMismatchException e) {
                System.out.println("\n>>>>>>> Foi digitado uma opção incorreta <<<<<<<<<\n\n");
                System.out.println("");
                MenuPrincipal();
            }
        }

    }

    public static void updadeCadastro() throws InterruptedException, SQLException {
        System.out.println();
        System.out.print("\n******* P *** A *** E ******");
        System.out.print("\n**** U *** D *** T ********");
        System.out.println("");
        System.out.print("NOME: ");
        String nome = tcl.nextLine().toUpperCase();
        System.out.println("");

        System.out.print("EMAIL: ");
        String email = tcl.nextLine().toUpperCase();
        System.out.println("");

        System.out.print("SENHA: ");
        String senha = tcl.nextLine();
        System.out.println("");

        System.out.println("***********Telefone**********");
        System.out.println("");
        System.out.print("DDD: ");
        Integer ddd = tclInt.nextInt();
        System.out.println("");

        System.out.print("NUMERO: ");
        String numero = tcl.nextLine();
        System.out.println("");
        System.out.print("TIPO: ");
        String tipo = tcl.nextLine();
        System.out.println("");

        Cadastro cadastro = new Cadastro();

        cadastro.setNome(nome);
        cadastro.setEmail(email);
        cadastro.setSenha(senha);
        
        cadastro.se
        cadastro.setTelefone(new Telefone());

        cadastro.getTelefone().setDdd(ddd);
        cadastro.getTelefone().setNumero(numero);
        cadastro.getTelefone().setTipo(tipo);

        alterarCadastro(cadastro);

    }

    public static void alterarCadastro(Cadastro cadastro) throws InterruptedException, SQLException {
        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();

        tx.begin();

        manager.merge(cadastro);
        tx.commit();

        manager.close();
        System.out.println();
        System.out.println();
        System.out.println("*** Alterado com sucesso ***");
        menuPrincipal();

    }

    public static void listarCadastro() {
        Cadastro cadastro = new Cadastro();

        for (Cadastro c : ListaC) {
            System.out.print(c.getNome() + " - " + c.getEmail());

            if (cadastro.getTelefone() != null) {

                System.out.println("Fone: (" + cadastro.getTelefone().getDdd() + ") " + cadastro.getTelefone().getNumero());
            }
        }

    }

    public static Cadastro pesquisarCadastro(String nome) {

        Cadastro RetornC = null;
        EntityManager manager = JpaUtil.getEntityManager();
        RetornC = manager.find(cadastro.getClass(), nome);
        manager.close();

        return RetornC;

    }

    public static void inserirCadastro(Cadastro cadastro) throws InterruptedException, SQLException {

        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();

        tx.begin();

        manager.persist(cadastro);
        tx.commit();

        manager.close();
        System.out.println();
        System.out.println();
        System.out.println("*** Inserido com sucesso ***");

    }

    public static void removerCadastro(Cadastro nome) throws InterruptedException, SQLException {

        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();

        tx.begin();

        Cadastro cadastro = manager.find(Cadastro.class,
                 nome);

        manager.remove(cadastro);

        tx.commit();

        manager.close();

    }

    public static void voltarMenu() throws InterruptedException, SQLException {
        System.out.println("Precione qualquer tecla para voltar ao menu.");
        String qualquerTecla = tcl.nextLine();
        System.out.println();
        menuPrincipal();

    }

    private static void menuPrincipal() throws InterruptedException, SQLException {
        MenuPrincipal();
    }

}
