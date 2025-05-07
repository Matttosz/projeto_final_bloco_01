package projeto_final_bloco_01;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import projeto_final_bloco_01.controller.MattoszLabelController;
import projeto_final_bloco_01.model.Album;
import projeto_final_bloco_01.util.CoresMattoszLabel;

public class Menu {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		MattoszLabelController LabelController = new MattoszLabelController();
		
		int opcaoAlbum, valor, lancamento, estoque;
		String nomeArtista, nomeAlbum, genero, melhorMusica, nacionalidade, tipo = null, atualizar;
		
		
		while (true) {
            System.out.println(CoresMattoszLabel.ANSI_WHITE_BACKGROUND_BRIGHT);
            System.out.println(CoresMattoszLabel.ANSI_WHITE_BACKGROUND_BRIGHT + CoresMattoszLabel.TEXT_BLUE_BOLD + "=========================================");
            System.out.println(CoresMattoszLabel.ANSI_WHITE_BACKGROUND_BRIGHT + CoresMattoszLabel.TEXT_RED_BOLD  + "     Mattosz Records - Menu Principal    ");
            System.out.println(CoresMattoszLabel.ANSI_WHITE_BACKGROUND_BRIGHT + CoresMattoszLabel.TEXT_BLUE_BOLD + "=========================================");
            System.out.println(CoresMattoszLabel.ANSI_WHITE_BACKGROUND_BRIGHT + CoresMattoszLabel.TEXT_RED_BOLD  + "0 - Sair                                 ");
            System.out.println(CoresMattoszLabel.ANSI_WHITE_BACKGROUND_BRIGHT + CoresMattoszLabel.TEXT_RED_BOLD  + "1 - Adicionar um Album                   ");
            System.out.println(CoresMattoszLabel.ANSI_WHITE_BACKGROUND_BRIGHT + CoresMattoszLabel.TEXT_RED_BOLD  + "2 - Listar todos os Albuns               ");
            System.out.println(CoresMattoszLabel.ANSI_WHITE_BACKGROUND_BRIGHT + CoresMattoszLabel.TEXT_RED_BOLD  + "3 - Listar todos os Artistas             ");
            System.out.println(CoresMattoszLabel.ANSI_WHITE_BACKGROUND_BRIGHT + CoresMattoszLabel.TEXT_RED_BOLD  + "4 - Procurar um Album por Nome           ");
            System.out.println(CoresMattoszLabel.ANSI_WHITE_BACKGROUND_BRIGHT + CoresMattoszLabel.TEXT_RED_BOLD  + "5 - Atualizar Informações de um Album    ");
            System.out.println(CoresMattoszLabel.ANSI_WHITE_BACKGROUND_BRIGHT + CoresMattoszLabel.TEXT_RED_BOLD  + "6 - Deletar Album em Estoque             ");
            System.out.println(CoresMattoszLabel.ANSI_WHITE_BACKGROUND_BRIGHT + CoresMattoszLabel.TEXT_BLUE_BOLD + "=========================================");
            System.out.print(CoresMattoszLabel.ANSI_WHITE_BACKGROUND_BRIGHT   + CoresMattoszLabel.TEXT_RED_BOLD  + "\nEscolha uma opção: ");

            try {
            	opcaoAlbum = read.nextInt();
                read.nextLine(); 
            } catch (InputMismatchException e) {
                System.out.println(CoresMattoszLabel.TEXT_RED_BOLD + "\nEntrada inválida! Digite apenas números.");
                read.nextLine();
                continue;
            }

            switch (opcaoAlbum) {
                case 0:
                    System.out.println(CoresMattoszLabel.TEXT_BLUE_BOLD + "=======================================");
                    System.out.println("\nEncerrando o sistema...");
                    System.out.println(CoresMattoszLabel.TEXT_BLUE_BOLD + "=======================================");
                    sobre();
                    read.close();
                    System.exit(0);
                    break;

                case 1:
                    System.out.println(CoresMattoszLabel.TEXT_BLUE_BOLD + "=======================================");
                    System.out.println(CoresMattoszLabel.TEXT_GREEN_BOLD_BRIGHT + "\nMenu de Adição ");
                    System.out.println(CoresMattoszLabel.TEXT_BLUE_BOLD + "=======================================");

                    System.out.println("Qual o nome do Album?");
                    System.out.println("Ex: Força Bruta");
                    System.out.print("R: ");
                    nomeAlbum = read.nextLine();
                    
                    System.out.println("Qual o nome do Artista?");
                    System.out.println("Ex: Jorge Ben Jor");
                    System.out.print("R: ");
                    nomeArtista = read.nextLine();
                    
                    System.out.println("Qual o principal genero do Album?");
                    System.out.println("Ex: Samba Rock");
                    System.out.print("R: ");
                    genero = read.nextLine();
                    
                    System.out.println("Qual o ano em que foi lançado?");
                    System.out.println("Ex: 1970");
                    System.out.print("R: ");
                    lancamento = read.nextInt();
                    
                    System.out.println("Se trata de um album Brasileiro? (Sim/Não)");
                    System.out.println("Ex: Sim");
                    System.out.print("R: ");
                    nacionalidade = read.next();
                    
                    System.out.println("Qual o valor (em centavos) de cada unidade do álbum?");
                    System.out.print("R: ");
                    valor = read.nextInt();
                    
                    System.out.println("Quantas Unidades no estoque?");
                    System.out.println("Ex: 5");
                    System.out.print("R: ");
                    estoque = read.nextInt();
                    
                    System.out.println("Qual a música mais recomendada do álbum?");
                    System.out.print("R: ");
                    read.nextLine(); 
                    melhorMusica = read.nextLine();
                    String pais;
                    
                    switch (nacionalidade) {
                    
                    case "nao":
                        System.out.println("\n=======================================\n");
                        System.out.println("Qual o país de origem?");
                        pais = read.next();
                        break;

                    case "sim":
                        pais = "brasileiro";
                        break;

                    default:
                        System.out.println(CoresMattoszLabel.TEXT_RED_BOLD + "Tipo inválido. Digite 'sim' ou 'nao'.");
                        return;
                }

                LabelController.cadastrarAlbum(
                    new Album(nomeAlbum, nomeArtista, genero, LabelController.gerarId(),
                              valor, estoque, pais, lancamento, melhorMusica));
                    
                case 2:
                	System.out.println("=======================================");
                    System.out.println("\nAqui está nossa coleção em estoque:");
                    System.out.println("=======================================");
                    LabelController.listarAlbums();
                	keypress();
                	break;
                case 3:
                	System.out.println("===============================================");
                    System.out.println("\nDigite o nome do Album que deseja procurar:");
                    System.out.println("===============================================");
                    String tituloAlbum = read.nextLine();
                    LabelController.procurarAlbum(tituloAlbum);
                    keypress();
                    break;
      
                case 4:
                	 System.out.println("==================================================");
                     System.out.println("\nAtualizar Produto :");
                     System.out.println("==================================================");
                     atualizar = read.next();
                     LabelController.atualizarAlbum(atualizar);
                	keypress();
                	break;
                case 5:
                	System.out.println("============================================");
                    System.out.println("\nDigite o ID do produto que deseja deletar:");
                    System.out.println("============================================");
                    try {
                        String tituloA = read.next();
                        LabelController.deletarAlbum(tituloA);
                    } catch (InputMismatchException e) {
                        System.out.println(CoresMattoszLabel.TEXT_RED_BOLD + "ID inválido.");
                        read.nextLine();
                    }
                    keypress();
                    break;
                 
                	
                	
                    
            }
        }
    }
	 public static void sobre() 
	 	{
	        System.out.println(CoresMattoszLabel.TEXT_PURPLE_BOLD_BRIGHT + "\n=========================================================");
	        System.out.println(CoresMattoszLabel.TEXT_PURPLE_BOLD_BRIGHT + "Projeto Desenvolvido por: Muris");
	        System.out.println(CoresMattoszLabel.TEXT_PURPLE_BOLD_BRIGHT + "Generation Brasil - murilom@generation.org");
	        System.out.println(CoresMattoszLabel.TEXT_PURPLE_BOLD_BRIGHT + "https://github.com/Matttosz");
	        System.out.println(CoresMattoszLabel.TEXT_PURPLE_BOLD_BRIGHT + "===========================================================");
	    }
	 public static void keypress()
	 {
	        try {
	            System.out.println(CoresMattoszLabel.TEXT_RESET + "\nPressione Enter para continuar...");
	            System.in.read();
	        } catch (IOException e) {
	            System.out.println("Erro ao esperar tecla. Continue.");
	        }
	 }
}


