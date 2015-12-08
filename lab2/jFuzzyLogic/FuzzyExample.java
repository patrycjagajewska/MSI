import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.rule.FuzzyRuleSet;

public class FuzzyExample {

	public static void main(String[] args) throws Exception {
		try {
			String fileName = args[0];
			int predkosc = Integer.parseInt(args[1]);
			int przyspieszenie = Integer.parseInt(args[2]);
			int odleglosc = Integer.parseInt(args[3]);

			FIS fis = FIS.load(fileName,false);

			//wyswietl wykresy funkcji fuzyfikacji i defuzyfikacji
			FuzzyRuleSet fuzzyRuleSet = fis.getFuzzyRuleSet();
			fuzzyRuleSet.chart();

			//zadaj wartosci wejsciowe
			fuzzyRuleSet.setVariable("predkosc", predkosc);
			fuzzyRuleSet.setVariable("przyspieszenie", przyspieszenie);
			fuzzyRuleSet.setVariable("odleglosc", odleglosc);
			//logika sterownika
		
			fuzzyRuleSet.evaluate();

			//graficzna prezentacja wyjscia
			fuzzyRuleSet.getVariable("moc").chartDefuzzifier(true);

			//System.out.println(fuzzyRuleSet);

		} catch (ArrayIndexOutOfBoundsException ex) {
			System.out.println("Niepoprawna liczba parametrow!");
			printSampleUsage();
		} catch (NumberFormatException ex) {
			System.out.println("Niepoprawny parametr!");
			printSampleUsage();
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}
	}

	private static void printSampleUsage() {
		System.out.println("java FuzzyExample string<plik_fcl> int<predkosc> int<przyspieszenie> int<odleglosc>");
	}

}