package Logica;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

public class Publicacion {
	private static int consecutivo = 1;
	private int codigo;
	private LocalDateTime fechaPublicacion;
	private String titulo;
	private String nombreCreador;
	private String texto;
	private List<Comentario> comentarios;
	
	public Publicacion(String titulo, String texto, String nombreCreador) {
		codigo = consecutivo++;
		this.titulo = titulo;
		this.texto = texto;
		this.nombreCreador = nombreCreador;
		fechaPublicacion = LocalDateTime.now();
		comentarios = new ArrayList<Comentario>();
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getNombreCreador() {
		return nombreCreador;
	}

	public void setNombreCreador(String nombreCreador) {
		this.nombreCreador = nombreCreador;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public int getCodigo() {
		return codigo;
	}

	public LocalDateTime getFechaPublicacion() {
		return fechaPublicacion;
	}
	
	public String toString() {
		String resultado = titulo + "\n\n";
		resultado += "Creador por: " + nombreCreador + " - ";
		resultado += fechaPublicacion.toString() + "\n\n";
		resultado += texto + "\n\n";
		resultado += "Comentarios: \n";
		if (comentarios.isEmpty()) {
			resultado += "No hay comentarios.";
		} else {
			for (Comentario c : comentarios) {
				resultado += c.toString() + "\n";
			}
		}
		return resultado;
	}
	
	public void agregarComentario (String email, String ip, String texto) {
		Comentario c = new Comentario(email, ip, texto);
		comentarios.add(c);
	}
	
	public void borrarComentario(int pos) throws Exception{
		if (pos < 0 || pos >= comentarios.size())
			throw new Exception("Comentario no válido.");
		comentarios.remove(pos);
	}
}
