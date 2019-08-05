package areas;

import model.Usuario;

public class Context {

	private static Usuario currentUser;

	public static void setCurrentUser(Usuario u) {
		currentUser = u;
	}

	public static Usuario getCurrentUser() {
		return currentUser;
	}
}
