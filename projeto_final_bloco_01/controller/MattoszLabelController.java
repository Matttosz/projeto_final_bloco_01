package projeto_final_bloco_01.controller;

import java.util.ArrayList;
import java.util.Scanner;

import projeto_final_bloco_01.model.MattoszLabel;
import projeto_final_bloco_01.repository.MattoszLabelRepository;

public class MattoszLabelController implements MattoszLabelRepository {

	Scanner read = new Scanner(System.in);
	private ArrayList<MattoszLabel> listaAlbum = new ArrayList<>();
	boolean encontrado = false;
	int controleAlbum = 0;
	
	@Override
	public void procurarAlbumPorId(int albumId) {
        var colecao = buscarNaCollection(albumId);
		
		
		if(colecao != null)
		{
			colecao.visualizar();
		}	
		else 
		{
			System.out.printf("\n A conta não foi encontrada!");
		}	
		
	}
	
	@Override
	public void procurarArtista(String artista) {
		for (MattoszLabel album : listaAlbum) 
		{ 
	        if (album.getArtista().toLowerCase().contains(artista.toLowerCase())) 
	        {
	            album.visualizar();
	            encontrado = true;
	        }
	    }
	    if (!encontrado) 
	    {
	        System.out.println("Nenhum artista com nome parecido a '" + artista + "' foi encontrado.");
	    }
		
	}

	@Override
	public void procurarAlbum(String titulo) {
		for (MattoszLabel album : listaAlbum) 
		{ 
	        if (album.getTitulo().toLowerCase().contains(titulo.toLowerCase())) 
	        {
	            album.visualizar();
	            encontrado = true;
	        }
	    }
	    if (!encontrado) 
	    {
	        System.out.println("Nenhum album com nome parecido a '" + titulo + "' foi encontrado.");
	    }
		
	}

	@Override
	public void listarAlbums() {
		for (var colecao : listaAlbum)
		{
			colecao.visualizar();
		}
		
	}

	@Override
	public void cadastrarAlbum(MattoszLabel album) 
	{
		listaAlbum.add(album);		
        System.out.println("||================||");
		System.out.println("||Conta Adicionada||");		
        System.out.println("||================||");
		
	}

	@Override
	public void atualizarAlbum(String titulo) {
		    
		    MattoszLabel album = buscarNaCollectionTitulo(titulo);
		    
		    if (album != null) {
		        System.out.println("Álbum encontrado! O que você deseja atualizar?");
		        
		        System.out.println("1 - Título");
		        System.out.println("2 - Artista");
		        System.out.println("3 - Gênero");
		        System.out.println("4 - Nacionalidade");
		        System.out.println("5 - Estoque");
		        System.out.println("6 - Valor");
		        System.out.println("7 - Ano de Lançamento");
		        
		        System.out.print("Escolha uma opção para atualizar: ");
		        int escolha = read.nextInt();
		        read.nextLine();

		        switch (escolha) {
		            case 1:
		                System.out.print("Digite o novo título: ");
		                String novoTitulo = read.nextLine();
		                album.setTitulo(novoTitulo);
		                break;
		            case 2:
		                System.out.print("Digite o novo nome do artista: ");
		                String novoArtista = read.nextLine();
		                album.setArtista(novoArtista);
		                break;
		            case 3:
		                System.out.print("Digite o novo gênero: ");
		                String novoGenero = read.nextLine();
		                album.setGenero(novoGenero);
		                break;
		            case 4:
		                System.out.print("Digite a nova nacionalidade: ");
		                String novaNacionalidade = read.nextLine();
		                album.setNacional(novaNacionalidade);
		                break;
		            case 5:
		                System.out.print("Digite a nova quantidade em estoque: ");
		                int novoEstoque = read.nextInt();
		                album.setEstoque(novoEstoque);
		                break;
		            case 6:
		                System.out.print("Digite o novo valor: ");
		                int novoValor = read.nextInt();
		                album.setValor(novoValor);
		                break;
		            case 7:
		                System.out.print("Digite o novo ano de lançamento: ");
		                int novoLancamento = read.nextInt();
		                album.setLancamento(novoLancamento);
		                break;
		            default:
		                System.out.println("Opção inválida!");
		                return;
		        }
		        System.out.println("Álbum atualizado com sucesso!");
		        album.visualizar(); 
		    } else {
		        System.out.println("Álbum não encontrado!");
		    }		
	}
	@Override
	public void deletarAlbum(String titulo) {
		for (int remover = 0; remover < listaAlbum.size(); remover++) {
	        if (listaAlbum.get(remover).getTitulo() == titulo ) 
	        {
	            listaAlbum.remove(remover);
	            System.out.println("album com titulo " + titulo + " foi removido com sucesso.");
	            encontrado = true;
	        break;
	        }
	    }
	    if (!encontrado) 
	    {
	        System.out.println("album com titulo " + titulo + " não foi encontrado.");
	    }	
		
	}
	public int gerarId() 
	{
		return ++ controleAlbum;
	}
	public MattoszLabel buscarNaCollection(int numero) 
	{
		for ( var colecao : listaAlbum) 
		{
			if(colecao.getAlbumId() == numero)
				return colecao;
		}
		return null;

}public MattoszLabel buscarNaCollectionTitulo(String titulo) 
{
	for ( var colecao : listaAlbum) 
	{
		if(colecao.getTitulo() == titulo)
			return colecao;
	}
	return null;

}

	
}
