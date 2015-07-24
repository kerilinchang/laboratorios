package usuario;

import usuario.Noob;

public class FactoryUsuario {
	
	public Noob criaUsuarioNoob(String nome, String login){
		return new Noob(nome, login);
	}

	public Veterano criaUsuarioVeterano(String nome, String login){
		return new Veterano(nome, login);
	}
	
}
