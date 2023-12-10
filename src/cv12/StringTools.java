package src.cv12;

public final class StringTools {

    public StringTools() {}
    public static boolean jePalindrom(String a){
        a = a.toLowerCase();
        int delka = a.length();
        for(int i = 0; i<=delka/2; i++){
            if(a.charAt(i) != a.charAt(delka-1-i)){
                return false;
            }
        }
        return true;
    }
    private static final char[] cifry = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
    public static long prevodDoDesitkove(String str, byte soustava){
        long suma = 0;
        for (int i = str.length()-1; i >= 0 ; i--) {
            suma = suma + ((long) indexOf(cifry, str.charAt(i)) * (long)Math.pow(soustava,str.length()-1-i));
        }
        return suma;
    }
    private static int indexOf(char[] a,char n){
        for (int i = 0; i < a.length ; i++) {
            if(a[i] == n){
                return i;
            }
        }
        return -1;
    }

    public static String prevodZDesitkove(long cislo, byte soustava){
        StringBuilder vysledek = new StringBuilder();
        int zbytek;
        while(cislo >= 1){
            zbytek = (int)cislo%soustava;
            vysledek.append(cifry[zbytek]);
            cislo/=soustava;
        }
        return vysledek.reverse().toString();
    }

    /*
     Sifrovani textu, sifrovat pouze pismena anglicke abecedy.
     pri sifrovani aplikovat postupne posun definovany jednotlivymi znaky hesla prevedeneho na velka pismena.
     Posun je dan rozdilem znaku hesla a 'A'.
     Vsechny nepismenne znaky ignorovat, nezapisovat do vysledku.
     */
    public static String sifruj(String text, String heslo) {
        StringBuilder vysledek = new StringBuilder();
        //char[] vysledek = new char[text.length()];
        for (int i = 0, j = 0; i < text.length(); i++) {
            char c = Character.toUpperCase(text.charAt(i));
            if(Character.isLetter(c)){
                char znakHesla = Character.toUpperCase(heslo.charAt(j%heslo.length()));
                int posun = znakHesla - 'A';
                char sifra = (char) ('A' + ((c+posun)%26));
                vysledek.append(sifra);
                j++;
            }
        }
        return vysledek.toString();
    }

    public static String desifruj(String text, String heslo) {
        StringBuilder vysledek = new StringBuilder();
        //char[] vysledek = new char[text.length()];
        for (int i = 0, j = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if(Character.isLetter(c)){
                char znakHesla = Character.toUpperCase(heslo.charAt(j%heslo.length()));
                int posun = znakHesla - 'A';
                char sifra = (char) ('A' + ((c-posun)%26));
                vysledek.append(sifra);
                j++;
            }
        }
        return vysledek.toString();
    }
}
