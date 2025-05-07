package projeto_final_bloco_01.repository;

public interface MattoszLabelRepository {
	
	public void procurarArtista(String artista);
	public void procurarAlbum(String titulo);
	public void listarAlbums();
	public void cadastrarAlbum();
	public void atualizarAlbum();
	public void deletarAlbum(String titulo);
	
}
