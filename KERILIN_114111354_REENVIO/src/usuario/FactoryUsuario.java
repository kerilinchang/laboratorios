/* 114111365 - Kerilin Laine Andrade Chang: LAB 5 - Turma 3 */

package usuario;

import exceptions.StringInvalidaException;
import usuario.Noob;

public class FactoryUsuario {
	
	public Noob criaUsuarioNoob(String nome, String login) throws StringInvalidaException{
		return new Noob(nome, login);
	}

	public Veterano criaUsuarioVeterano(String nome, String login) throws StringInvalidaException{
		return new Veterano(nome, login);
	}
	
}
