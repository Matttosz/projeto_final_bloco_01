package projeto_final_bloco_01.repository;

import projeto_final_bloco_01.model.MattoszLabel;

public interface MattoszLabelRepository {
	
	public void procurarArtista(String artista);
	public void procurarAlbum(String titulo);
	public void procurarAlbumPorId(int albumId);
	public void listarAlbums();
	public void cadastrarAlbum(MattoszLabel Album);
	public void atualizarAlbum(String titulo);
	public void deletarAlbum(String titulo);
	
}
