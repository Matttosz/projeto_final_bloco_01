package projeto_final_bloco_01.model;

import java.text.NumberFormat;

public class MattoszLabel {
	
	private String titulo;
	private String artista;
	private String genero;
	private int    valor;
	private int    estoque;
	private int    nacional;
	private int    lancamento;
	private int    albumId;
	
	public MattoszLabel(String titulo, String artista, String genero,int albumId, int valor, int estoque, int nacional,
			int lancamento) {
		super();
		this.titulo = titulo;
		this.artista = artista;
		this.genero = genero;
		this.albumId =albumId;
		this.valor = valor;
		this.estoque = estoque;
		this.nacional = nacional;
		this.lancamento = lancamento;
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getArtista() {
		return artista;
	}
	public void setArtista(String artista) {
		this.artista = artista;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	public int getEstoque() {
		return estoque;
	}
	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}
	public int getNacional() {
		return nacional;
	}
	public void setNacional(int nacional) {
		this.nacional = nacional;
	}
	public int getLancamento() {
		return lancamento;
	}
	public void setLancamento(int lancamento) {
		this.lancamento = lancamento;
	}
	public int getAlbumId() {
		return albumId;
	}

	public void setAlbumId(int albumId) {
		this.albumId = albumId;
	}
	public void visualizar() {
		
		 if (this.estoque == 0 ) {
			 System.out.println("Infelizmente Não possui um exemplar.");
		 }
		 else System.out.println(this.estoque);

		NumberFormat formatarMoeda = NumberFormat.getCurrencyInstance();

		System.out.println("=====================================");
		System.out.println("Título: " + this.titulo + " | Ano de Lançamento: " + this.lancamento);
		System.out.println("Principal Gênero :" + this.genero );
		System.out.println("principal Artista: " + this.artista);
		System.out.println("Nacionalidade: " + this.nacional);
		System.out.println("Quantidade no Estoque: " + this.estoque);		
		System.out.println("Valor por Unidade: " + formatarMoeda.format(this.valor));
	}

	
	
} 
