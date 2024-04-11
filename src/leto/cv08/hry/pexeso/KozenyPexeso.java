package hry.pexeso;

public class KozenyPexeso implements HraPexeso {
    private final int pocetDvojic;
    private final int pocetHracu;
    private int aktualniHrac;
    private int[] bodyHracu;
    private int[] herniPole;
    private int predchoziOtocenaKarta;
    private boolean konecHry;
    public KozenyPexeso(int pocetDvojic, int pocetHracu) {
        this.pocetDvojic = pocetDvojic;
        this.pocetHracu = pocetHracu;
        bodyHracu = new int[pocetHracu];
        aktualniHrac = 0;
        //herniPole = PexesoTools.getPolePexeso(pocetDvojic);
        herniPole = getTestovaciPexeso();
        konecHry = false;
        predchoziOtocenaKarta = -1;
    }
    //Remove this method from the class after the test
    public int[] getTestovaciPexeso(){
        return new int[]{1, 1, 2, 2};
    }

    @Override
    public int getPocetKaret() {
        return pocetDvojic * 2;
    }

    @Override
    public int getPocetDvojic() {
        return pocetDvojic;
    }

    @Override
    public int getPocetHracu() {
        return pocetHracu;
    }

    @Override
    public int getHrajeHrac() {
        return aktualniHrac+1;
    }

    @Override
    public int getPocetDvojicKaretVeHre() {
        int zbyleDvojice = 0;
        for (int i:herniPole) {
            if(i > 0) zbyleDvojice++;
        }
        return zbyleDvojice/2;
    }

    @Override
    public int[] getPoleKaretMask() {
        int[] pole = new int[herniPole.length];
        for(int i = 0; i < herniPole.length; i++)
        {
            if(herniPole[i] > 0) pole[i] = 0;
            else pole[i] = -1;
        }
        return pole;
    }

    @Override
    public int otocKartu(int indexKarty) {
        if(indexKarty >= herniPole.length || indexKarty < 0) throw new ChybneCisloHraceException(indexKarty);
        if(konecHry) throw new NedovolenyPozadavekException();
        if(predchoziOtocenaKarta == -1)
        {
            if(herniPole[indexKarty] > 0){
                predchoziOtocenaKarta = indexKarty;
                return herniPole[indexKarty];
            }
                else return herniPole[indexKarty];

        }
        else if (indexKarty == predchoziOtocenaKarta){
            predchoziOtocenaKarta = -1;
            return -indexKarty;
        }


        else{
            if(herniPole[predchoziOtocenaKarta] == herniPole[indexKarty])
            {
                int katraReturn = herniPole[indexKarty];
                bodyHracu[aktualniHrac]++;
                herniPole[predchoziOtocenaKarta] = -herniPole[predchoziOtocenaKarta];
                herniPole[indexKarty] = -herniPole[indexKarty];
                predchoziOtocenaKarta = -1;
                if(getPocetDvojicKaretVeHre() == 0) konecHry = true;
                return katraReturn;
            }
            else{
                predchoziOtocenaKarta = -1;
                aktualniHrac = (aktualniHrac+1) % pocetHracu;
                return -indexKarty;
            }
        }
    }

    @Override
    public boolean isKonecHry() {
        return konecHry;
    }

    @Override
    public int getCisloVyherce() {
        if(konecHry){
            int max = 0;
            int maxIndex = 0;
            for(int i = 0; i < bodyHracu.length; i++)
            {
                if(bodyHracu[i] > max)
                {
                    max = bodyHracu[i];
                    maxIndex = i;
                }
            }
//            for(int i = 0; i < bodyHracu.length; i++)
//            {
//                if(bodyHracu[i] == max && i != maxIndex) throw new NedovolenyPozadavekException();
//            }
            return maxIndex+1; //vse se vraci o 1 vetsi, kvuli tomue ze indexy zacinaji od 0 a my cislujeme hrace od 1
        }
        else throw new NedovolenyPozadavekException();
    }

    @Override
    public int[] getPoradiHracu() {
        int[] indexes = new int[pocetHracu];
        for(int i = 0; i < pocetHracu; i++)
        {
            indexes[i] = i;
        }
        for(int i = 0; i < pocetHracu; i++)
        {
            for(int j = i+1; j < pocetHracu; j++)
            {
                if(bodyHracu[indexes[i]] < bodyHracu[indexes[j]])
                {
                    int temp = indexes[i];
                    indexes[i] = indexes[j];
                    indexes[j] = temp;
                }
            }
        }
        return indexes;
    }

    @Override
    public int getPocetBoduHrace(int cisloHrace) {
        return bodyHracu[cisloHrace-1]; // kvuli tomue ze indexy zacinaji od 0 a my cislujeme hrace od 1
    }
}
