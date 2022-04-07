package wielkie.liczby;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        // stale reprezentujace 0,1,2,10
        System.out.println(BigInteger.ZERO);
        System.out.println(BigInteger.ONE);
        System.out.println(BigInteger.TWO);
        System.out.println(BigInteger.TEN);

        BigInteger a = new BigInteger("17");
        BigInteger b = new BigInteger("5");

        BigInteger wielkaLiczba = BigInteger.valueOf(123123);

        // dodawanie
        BigInteger suma = a.add(b);
        System.out.println("Suma " + suma);

        // odejmowanie
        BigInteger roznica = a.subtract(b);
        System.out.println("Roznica " + roznica);

        // mnozenie
        BigInteger iloczyn = a.multiply(b);
        System.out.println("Iloczyn " + iloczyn);

        // dzielenie
        BigInteger dzielenie = b.divide(a);
        System.out.println("Dzielenie " + dzielenie);

        // porownuje dwa BigInty
        // 1 jesli a>b
        // 0 jesli a=b
        // -1 jesli b<a

        System.out.println(a.compareTo(b));

        // zwraca wieksza z dwoch
        System.out.println("wieksza " + a.max(b));
        // mniejsza z dwoch
        System.out.println("mniejsza " + b.min(a));


        // reszta z dzielenia
        System.out.println("modulo " + a.mod(b));

        // wartosc bezwzgledna
        System.out.println(a.abs());

        // podnosi z do potegi int
        System.out.println(a.pow(4));

        // liczba przeciwna
        System.out.println(a.negate());

        // zwraca signum,
        // czyli 1 jesli > 0
        // 0 jesli =0
        // -1 jesli < 0
        System.out.println(a.signum());

        // pierwiastek
        System.out.println(a.sqrt());

        BigDecimal bd = new BigDecimal("-4.543");
        // laczna liczba cyfr
        System.out.println(bd.precision());

        // liczba cyfr na prawo od kropki
        System.out.println(bd.scale());

        // Stworz liste BigItnow, stworz pare obiektow BigInt, dodaj je do listy,
        // wyswietl w kolejnosci rosnacej

        List<BigInteger> listaBigInt = new ArrayList<>(Arrays.asList(
                new BigInteger("5"),
                new BigInteger("6"),
                new BigInteger("17"),
                new BigInteger("4")));
        Collections.sort(listaBigInt);
        System.out.println(listaBigInt);

        List<BigInteger> listaBigInt2 = new ArrayList<>(Arrays.asList(
                new BigInteger("5"),
                new BigInteger("6"),
                new BigInteger("17"),
                new BigInteger("4")));

        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println(najwiekszaLiczba(listaBigInt));
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println(resztaDzieleniaRowna(listaBigInt, 5, 2));
        System.out.println("#######################################");
        System.out.println(wspolneElementy(listaBigInt, listaBigInt2));
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        System.out.println(sumaNajwiekszychWartosci(Arrays.asList(listaBigInt, listaBigInt2)));
    }

    //napisz metode ktora przyjmuje jako parametr Liste BigIntow i zwraca Liste
    // liczb wiekszych od podanego parametru
    public static List<BigInteger> wiekszeNiz(List<BigInteger> lista, BigInteger parametr) { //parametr moze by podac jako int?
        List<BigInteger> wynik = new ArrayList<>();
        for (BigInteger b : lista) {
            if (b.compareTo(parametr) == 1) {
                wynik.add(b);
            }
        }
        return wynik;
    }

    // Stwórz metode która znajduje najwieksza liczbe typu BigInt na liscie
    public static BigInteger najwiekszaLiczba(List<BigInteger> lista) {
        return Collections.max(lista);

    }


    // Stworz metode ktora przyjmuje jako parametr liste bigitnow oraz dwa inty a i
    // b i zwroci liste wszystkich elementow z listy ktorych wartosc modulo a = b.

    public static List<BigInteger> resztaDzieleniaRowna(List<BigInteger> lista, int a, int b) {
        List<BigInteger> wynik = new ArrayList<>();
        for (BigInteger l : lista) {
            if (l.mod(BigInteger.valueOf(a)).compareTo(BigInteger.valueOf(b)) == 0) {
                wynik.add(l);
            }
        }
        return wynik;
    }

    // element listy=17, a = 5, b=2 17mod5 =2

    //napisz metode która zwroci wspolne elementy z dwoch list wielkich liczb
    public static List<BigInteger> wspolneElementy(List<BigInteger> a, List<BigInteger> b) {
        List<BigInteger> wynik = new ArrayList<>(a);
        wynik.retainAll(b);
        return wynik;

    }
    // Stworz metode ktora przyjmuje jako parametr liste list big intow :). Z kazdej
    // listy znajdz najwieksza wartosc i oblicz sume najwiekszych wartosci.

    public static BigInteger sumaNajwiekszychWartosci(List<List<BigInteger>> listaList) {
        BigInteger suma = new BigInteger("0");
        for (List<BigInteger> l : listaList) {
            suma = suma.add(Collections.max(l));
        }
        return suma;
    }

}
