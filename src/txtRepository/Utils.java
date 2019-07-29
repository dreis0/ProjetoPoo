package txtRepository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Utils {

	public static int getLastId(String fileName) throws IOException {

		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		try {

			String currentLine = "", lastLine = "";
			while ((currentLine = reader.readLine()) != null) {
				lastLine = currentLine;
			}

			if (lastLine != "") {
				String[] dados = lastLine.split(";");
				return Integer.parseInt(dados[0]);
			}

		} finally {
			reader.close();
		}

		return 0;
	}
}
