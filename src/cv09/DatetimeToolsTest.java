package src.cv09;

public class DatetimeToolsTest {
    public static void main(String[] args) {
        String[] dny = {"sobota", "nedele","pondeli","utery","streda","ctvrtek","patek"};
        System.out.format(DatetimeTools.jePrestupny(2027)?"Zadany rok je prestupny\n":"Zadany rok neni prestupny\n");
        System.out.format(DatetimeTools.jePlatneDatum(29,2,2020) ? "Zadane datum je platne\n": "Zadane datum neni platne\n");
        System.out.format("Zadeny den je %s",dny[DatetimeTools.denTydne(24,12,2023)]);

    }
}
