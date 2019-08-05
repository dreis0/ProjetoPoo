package txtRepository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import model.Aluno;
import model.Bibliotecario;
import model.Externo;
import model.Master;
import model.Professor;
import model.TipoDeUsuario;
import model.Usuario;

public class Utils {

	public static int getNextId(String fileName) throws IOException {

		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		try {

			String currentLine = "", lastLine = "";
			while ((currentLine = reader.readLine()) != null) {
				lastLine = currentLine;
			}

			if (!lastLine.equals("")) {
				String[] dados = lastLine.split(";");
				return Integer.parseInt(dados[0]) + 1;
			}

		} finally {
			reader.close();
		}

		return 1;
	}

	public static TipoDeUsuario ToEnum(String enumAsString) {
		if (enumAsString.equals("0"))
			return TipoDeUsuario.master;
		if (enumAsString.equals("1"))
			return TipoDeUsuario.bibliotecario;
		if (enumAsString.equals("2"))
			return TipoDeUsuario.aluno;
		if (enumAsString.equals("3"))
			return TipoDeUsuario.professor;
		else
			return TipoDeUsuario.externo;
	}

	public static Usuario instance(TipoDeUsuario tipo) {
		Usuario user;
		switch (tipo) {
		case master:
			user = new Master();
			break;
		case bibliotecario:
			user = new Bibliotecario();
			break;
		case aluno:
			user = new Aluno();
			break;
		case professor:
			user = new Professor();
			break;
		default:
			user = new Externo();
			break;
		}
		return user;
	}
}
