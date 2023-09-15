import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class testListaOglasa {
    ListaOglasa oglasi = new ListaOglasa();
    int brojac, i = 0;
    double DELTA = 1e-9;
    //1. Brojevi Vip mreze pocinju sa 060 i 061
    //Returns:
    //Vraca ukupan broj oglasa kod kojih oglasavac ima broj telefona koji pripada Vip mrezi.
    @Test
    public void test1(){
        for(i = 0; i < oglasi.getOglasi().size(); i++){
            if(oglasi.getOglasi().get(i).getBrojTelefona().startsWith("060") ||
                    oglasi.getOglasi().get(i).getBrojTelefona().startsWith("061"))
                brojac++;
        }
        Assert.assertEquals(brojac, oglasi.sumaKorisnikaVipMreze(), DELTA);
    }
    //2. Brojevi Telenor mreze pocinju sa 062, 063 i 069
    //Returns:
    //Vraca ykupan broj oglasa kod kojih oglasavac ima broj telefona koji pripada Telenor mrezi.
    @Test
    public void test2(){
        for(i = 0; i < oglasi.getOglasi().size(); i++){
            if(oglasi.getOglasi().get(i).getBrojTelefona().startsWith("062") ||
                    oglasi.getOglasi().get(i).getBrojTelefona().startsWith("063") ||
                    oglasi.getOglasi().get(i).getBrojTelefona().startsWith("069"))
                brojac++;
        }
        Assert.assertEquals(brojac, oglasi.sumaKorisnikaTelenorMreze(), DELTA);
    }
    //3. Brojevi Mts mreze pocinju sa 064, 065 i 066
    //Returns:
    //Vraca ykupan broj oglasa kod kojih oglasavac ima broj telefona koji pripada Mts mrezi.
    @Test
    public void test3(){
        for(i = 0; i < oglasi.getOglasi().size(); i++){
            if(oglasi.getOglasi().get(i).getBrojTelefona().startsWith("064") ||
                    oglasi.getOglasi().get(i).getBrojTelefona().startsWith("045") ||
                    oglasi.getOglasi().get(i).getBrojTelefona().startsWith("066"))
                brojac++;
        }
        Assert.assertEquals(brojac, oglasi.sumaKorisnikaMtsMreze(), DELTA);
    }
    //4. Oglasi sa fiksnom cenom su oni oglasi koji imaju vrednost true u atributu fiksnaCena.
    //Returns:
    //Double vrednost koja predstavlja prosecnu cenu.
    @Test
    public void test4(){
        double srvr, suma = 0;
        for(i = 0; i < oglasi.getOglasi().size(); i++){
            if(oglasi.getOglasi().get(i).getFiksnaCena() == true){
                brojac++;
                suma += oglasi.getOglasi().get(i).getCena();
            }
        }
        srvr = suma/brojac;
        Assert.assertEquals(srvr, oglasi.prosecnaCenaOglasaSaFiksnomCenom(), DELTA);
    }
    //5. Oglasi sa fiksnom cenom su oni oglasi koji imaju vrednost false u atributu fiksnaCena.
    //Returns:
    //Double vrednost koja predstavlja prosecnu cenu.
    @Test
    public void test5(){
        double srvr, suma = 0;
        for(i = 0; i < oglasi.getOglasi().size(); i++){
            if(oglasi.getOglasi().get(i).getFiksnaCena() == false){
                brojac++;
                suma += oglasi.getOglasi().get(i).getCena();
            }
        }
        srvr = suma / brojac;
        Assert.assertEquals(srvr, oglasi.prosecnaCenaOglasaSaNeFiksnomCenom(), DELTA);
    }
    //6. Oglas koji ima najvecu cenu.
    //Returns:
    //Vraca cenu kao Double vrednost
    @Test
    public void test6(){
        double max = oglasi.getOglasi().get(0).getCena();
        for(i = 0; i < oglasi.getOglasi().size(); i++){
            if(oglasi.getOglasi().get(i).getCena() > max)
                max = oglasi.getOglasi().get(i).getCena();
        }
        Assert.assertEquals(max, oglasi.cenaNajskupljegOglasa(), DELTA);
    }
    //7. Oglas koji ima najmanju cenu.
    //Returns:
    //Vraca cenu kao Double vrednost.
    @Test
    public void test7(){
        double min = oglasi.getOglasi().get(0).getCena();
        for(i = 0; i < oglasi.getOglasi().size(); i++){
            if(oglasi.getOglasi().get(i).getCena() < min)
                min = oglasi.getOglasi().get(i).getCena();
        }
        Assert.assertEquals(min, oglasi.cenaNajjeftinijegOglasa(), DELTA);
    }
    //8. Oglasi cija je cena veca od prosecne cene svih oglasa.
    //Returns:
    //Vraca Integer vrednost koja predstavlja broj oglasa koji imaju cenu vecu od prosecne.
    @Test
    public void test8(){
        double srvr, suma = 0;
        int brojOglasa = 0;
        for(i = 0; i < oglasi.getOglasi().size(); i++){
            brojac++;
            suma += oglasi.getOglasi().get(i).getCena();
        }
        srvr = suma/brojac;
        for(i = 0; i < oglasi.getOglasi().size(); i++){
            if(oglasi.getOglasi().get(i).getCena() > srvr)
                brojOglasa++;
        }
        Assert.assertEquals(brojOglasa, oglasi.brojOglasaIznadProsecneCene(), DELTA);
    }
    //9. Oglasi cija je cena manja od prosecne cene svih oglasa.
    //Returns:
    //Vraca Integer vrednost koja predstavlja broj oglasa koji imaju cenu manju od prosecne.
    @Test
    public void test9(){
        double srvr, suma = 0;
        int brojOglasa = 0;
        for(i = 0; i < oglasi.getOglasi().size(); i++){
            brojac++;
            suma += oglasi.getOglasi().get(i).getCena();
        }
        srvr = suma / brojac;
        for(i = 0; i < oglasi.getOglasi().size(); i++){
            if(oglasi.getOglasi().get(i).getCena() < srvr)
                brojOglasa++;
        }
        Assert.assertEquals(brojOglasa, oglasi.brojOglasaIspodProsecneCene(), DELTA);
    }
    //10. Metoda sluzi za sortiranje oglasa od najjeftinijeg do najskupljeg.
    //Returns:
    //Vraca sortiranu listu oglasa.
    @Test
    public void test10(){
        ArrayList<Oglas> actual = oglasi.sortRastucePoCeni();
        ArrayList<Oglas> expected = oglasi.getOglasi();
        for(i = 0; i < expected.size(); i++) {
            for (int j = 0; j < expected.size() - 1; j++) {
                if(expected.get(i).getCena() < expected.get(j).getCena()){
                Oglas pom = expected.get(i);
                expected.set(i, expected.get(j));
                expected.set(j, pom);
                }
            }
        }
        Assert.assertEquals(expected, actual);
    }
}
