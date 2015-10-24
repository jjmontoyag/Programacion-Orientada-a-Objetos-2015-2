
public class Persona {
	
	private String nombre;
	private String documento;
	private String contacto;
	
	public Persona(String nombre, String documento, String contacto){
		this.nombre = nombre;
		this.documento = documento;
		this.contacto = contacto;
	}
	public String getNombre(){
		return nombre;
	}
	public String getDocumento(){
		return documento;
	}
	public String getContacto(){
		return contacto;
	}
	public String getUsuarioInfo(){
		return "Documento: " + documento + "\n"
			   + "Numero de contacto" + contacto;
	}

}
