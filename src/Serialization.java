import java.io.*;
import java.util.*;

public class Serialization {
	final static String COMMA_DELIMITER = ";";

	public Serialization() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) throws NotSerializableException {
		Appartamento a1 = new Appartamento("codice", "ubicazione",
				"area di competenza", "descrizione via", "civico", "codice via","posti abitativi","posti letto","municipio","longit","latit","location");

		try {
			FileOutputStream fileOut = new FileOutputStream("Appartamento.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(a1);
			out.close();
			fileOut.close();
		} catch (IOException i) {
			i.printStackTrace();
		}

		Appartamento a2 = null;
		try {
			FileInputStream fileIn = new FileInputStream("Appartamento.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			a2 = (Appartamento) in.readObject();
			in.close();
			fileIn.close();
		} catch (IOException i) {
			i.printStackTrace();
			return;
		} catch (ClassNotFoundException c) {
			System.out.println("Appartamento class not found");
			c.printStackTrace();
			return;
		}

		List<List<String>> records = new ArrayList<>();
		Vector<Appartamento> v = new Vector<Appartamento>();
		try (BufferedReader br = new BufferedReader(new FileReader("UnivPm.csv"))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] values = line.split(COMMA_DELIMITER);
				System.out.println(values.length);
				records.add(Arrays.asList(values));
				v.add(new Appartamento(values[0], values[1], values[2], values[3], values[4],
						values[5],values[6],values[7],values[8],values[9], values[10],values[11]));
			}
			br.close();
		} catch (IOException i) {
			i.printStackTrace();
			return;
		}
		for (Appartamento item : v) {
			System.out.println(v.toString());
		}

		List<List<String>> records2 = new ArrayList<>();
		try (Scanner s = new Scanner(new File("UnivPm.csv"));) {
			while (s.hasNextLine()) {
				records2.add(getRecordFromLine(s.nextLine()));
			}
			s.close();
		} catch (IOException i) {
			i.printStackTrace();
			return;
		}
	}

	private static List<String> getRecordFromLine(String line) {
		List<String> values = new ArrayList<String>();
		try (Scanner rowScanner = new Scanner(line)) {
			rowScanner.useDelimiter(COMMA_DELIMITER);
			while (rowScanner.hasNext()) {
				values.add(rowScanner.next());
			}
		}
		return values;
	}

}