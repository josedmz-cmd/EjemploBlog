package Control;

import java.util.Map;
import java.util.TreeMap;

import Logica.Blog;

public class Controladora {
	private Map<Integer, Blog> blogs;
	
	public Controladora() {
		blogs = new TreeMap<Integer, Blog>();
	}
	
	public void crearBlog(String nombre, String descripcion) {
		Blog b = new Blog(nombre, descripcion);
		blogs.put(b.getCodigo(), b);
	}
	
	public Map<Integer, String> obtenerBlogs(){
		Map<Integer, String> listaBlogs = new TreeMap<Integer, String>();
		for (Blog b : blogs.values()) {
			listaBlogs.put(b.getCodigo(), b.getNombre());
		}
		return listaBlogs;
	}
	
	public void borrarBlog(int codigoBlog) throws Exception {
		if (!blogs.containsKey(codigoBlog)) 
			throw new Exception("El código de blog no es válido.");
		blogs.remove(codigoBlog);
	}
	
	public void crearPublicacion(int codigoBlog, String titulo, String texto, String nombre) throws Exception {
		if (!blogs.containsKey(codigoBlog)) 
			throw new Exception("El código de blog no es válido.");
		Blog b = blogs.get(codigoBlog);
		b.crearPublicacion(titulo, texto, nombre);
	}
	
	public Map<Integer, String> obtenerPublicaciones(int codigoBlog){
		Map<Integer, String> listaBlogs = new TreeMap<Integer, String>();
		for (Blog b : blogs.values()) {
			listaBlogs.put(b.getCodigo(), b.getNombre());
		}
		return listaBlogs;
	}
	
	public String obtenerPublicacion(int codigoBlog, int codigoPublicacion) throws Exception {
		if (!blogs.containsKey(codigoBlog)) 
			throw new Exception("El código de blog no es válido.");
		Blog b = blogs.get(codigoBlog);
		String p = b.obtenerPublicacion(codigoPublicacion);
		return p;
	}
	
	public void agregarComentario(int codigoBlog, int codigoPublicacion, String email, String ip, String texto) throws Exception {
		if (!blogs.containsKey(codigoBlog)) 
			throw new Exception("El código de blog no es válido.");
		Blog b = blogs.get(codigoBlog);
		b.agregarComentario(codigoPublicacion, email, ip, texto);
	}
	
	public void borrarComentario(int codigoBlog, int codigoPublicacion, int pos) throws Exception {
		if (!blogs.containsKey(codigoBlog)) 
			throw new Exception("El código de blog no es válido.");
		Blog b = blogs.get(codigoBlog);
		b.borrarComentario(codigoPublicacion, pos);
	}
}
