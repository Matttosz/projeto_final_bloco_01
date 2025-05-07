package projeto_final_bloco_01.model;

public class Album extends MattoszLabel {
	private String melhorMusica;
	
	public Album(String titulo, String artista, String genero, int albumId , int valor, int estoque, String nacionalidade, int lancamento, String melhorMusica) {
		super(titulo, artista, genero, albumId, valor, estoque, nacionalidade, lancamento);
		this.melhorMusica = melhorMusica;
	}

	public String getMelhorMusica() {
		return melhorMusica;
	}

	public void setMelhorMusica(String melhorMusica) {
		this.melhorMusica = melhorMusica;
	}
	
	@Override
	public void visualizar() 
	{
		super.visualizar();
		System.out.println("Musica Recomendada: " + this.melhorMusica);
	}
	
}
