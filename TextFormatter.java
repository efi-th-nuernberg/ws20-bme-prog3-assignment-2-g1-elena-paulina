class TextFormatter {

	private static final String TEXT = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy "
			+ "eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et "
			+ "accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem "
			+ "ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod "
			+ "tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et "
			+ "justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est "
			+ "Lorem ipsum dolor sit amet.";

	// Instanzvariablen
	private int maxLineLength;

	public static void main(String[] args) {
		TextFormatter formatter = new TextFormatter(30);
		formatter.printLinks(TEXT);
		formatter.printRechts(TEXT);
		formatter.printBlock(TEXT);
	}

	// Konstruktor
	public TextFormatter(int maxLineLength) {
		this.maxLineLength = maxLineLength;
	}

	// Ausgabe
	public void printZeilenumbruch(String aText) {
		String formatierterTextUmbruch = macheZeilenumbruch(aText);
		System.out.println(formatierterTextUmbruch);
	}

	public void printLinks(String aText) {
		String formatierterTextLinks = formatiereLinks(aText);
		System.out.println(formatierterTextLinks);
	}

	public void printRechts(String aText) {
		String formatierterTextRechts = formatiereRechts(aText);
		System.out.println(formatierterTextRechts);
	}

	public void printBlock(String aText) {
		String formatierterTextBlock = formatiereBlocksatz(aText);
		System.out.println(formatierterTextBlock);
	}

	private String formatiereLinks(String aText) {
		int count = 0;
		String formatierterText = "";
		aText = macheZeilenumbruch(aText);
		// Array erstellen
		String[] lines = aText.split("\n");
		count = ermittleLängsteZeile(count, lines);

		// alle anderen Zeilen vor Zeichen mit Leerzeichen füllen
		for (String s : lines) {
			s = s.trim(); // trim schneidet Leerzeichen r+l ab
			int anzahlLeerzeichen = count - s.length(); // count - Inhalt
			String formatierteZeile = "";
			for (int i = 0; i < anzahlLeerzeichen; i++) {
				formatierteZeile += " ";
			}
			formatierterText = formatierterText + s + formatierteZeile + "\n";
		}
		return formatierterText;
	}

	private String formatiereRechts(String aText) {
		int count = 0;
		String formatierterText = "";
		aText = macheZeilenumbruch(aText);
		// Array erstellen
		String[] lines = aText.split("\n");
		count = ermittleLängsteZeile(count, lines);

		// alle anderen Zeilen vor Zeichen mit Leerzeichen füllen
		for (String s : lines) {
			s = s.trim(); // trim schneidet Leerzeichen r+l ab
			int anzahlLeerzeichen = count - s.length(); // count - Inhalt
			String formatierteZeile = "";
			for (int i = 0; i < anzahlLeerzeichen; i++) {
				formatierteZeile += " ";
			}
			formatierterText = formatierterText + formatierteZeile + s + "\n";
		}
		return formatierterText;
	}

	private String formatiereBlocksatz(String aText) {
		int count = 0;
		String formatierterText = "";
		aText = macheZeilenumbruch(aText);
		// Array erstellen
		String[] lines = aText.split("\n");
		// Längste Zeile ermitteln
		// Loop bis Ende erreicht -> for-each Schleife
		count = ermittleLängsteZeile(count, lines);

		// alle anderen Zeilen vor Zeichen mit Leerzeichen füllen
		for (String s : lines) {
			s = s.trim(); // trim schneidet Leerzeichen r+l ab
			int anzahlLeerzeichen = count - s.length(); // count - Inhalt
			String formatierteZeile = "";
			for (int i = 0; i < anzahlLeerzeichen; i++) {
				formatierteZeile += " ";
			}

			formatierterText = formatierterText + getBlocksatzZeile(s, formatierteZeile) + "\n";
		}
		return formatierterText;
	}

	private int ermittleLängsteZeile(int count, String[] lines) {
		for (String s : lines) {
			if (s.length() > count) {
				count = s.length();
			}
		}
		return count;
	}

	private String getBlocksatzZeile(String s, String formatierteZeile) {
		String[] split = s.split(" ");
		String letztesWort = formatierteZeile + split[split.length - 1];
		split[split.length - 1] = letztesWort;
		String zeile = "";
		for (String wort : split) {
			zeile += wort + " ";
		}
		return zeile;
	}

	private String macheZeilenumbruch(String aText) {
		int length = this.maxLineLength;
		String formatiert = "";
		String s = ""; // Zwischenspeicher

		// Splitte String nach x Zeichen
		while (true) {
			if (aText.length() > length) { // Text größer als 30?
				s = aText.substring(0, length); // (0 - 30)
				aText = aText.substring(length);
				formatiert += s; // += = formatiert = formatiert + s
				// Füge Zeilenumbruch hinzu
				formatiert += "\n";
			} else {
				formatiert += aText;
				break;
			}
		}
		// Gebe zurück
		return formatiert;
	}

	// Getter und Setter
	public int getMaxLineLength() {
		return maxLineLength;
	}

	public void setMaxLineLength(int maxLineLength) {
		this.maxLineLength = maxLineLength;
	}
}