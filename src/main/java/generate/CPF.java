package generate;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class CPF {

    public static Long gerar() {
        List<Integer> digitosInicial  = randomArray();
        Integer       penultimoDigito = ajuste(somar(digitosInicial, 0, 2));
        Integer       ultimoDigito    = ajuste(somar(digitosInicial, (penultimoDigito * 2), 3));
        return Long.valueOf(join(digitosInicial) + penultimoDigito.toString() + ultimoDigito.toString());
    }

    private static String join(List<Integer> digitosInicial) {
        String joinString = "";
        for (Integer digito : digitosInicial)
            joinString = joinString + digito.toString();
        return joinString;
    }

    private static Integer ajuste(Integer soma) {
        soma = 11 - mod(soma, 11);
        return (soma >= 10) ? 0 : soma;
    }

    private static Integer mod(int dividendo, int divisor) {
        return (int) Math.round(dividendo - (Math.floor(dividendo / divisor) * divisor));
    }

    private static Integer somar(List<Integer> list, Integer soma, Integer count) {
        for (Integer i = 8; i >= 0; i--) {
            soma = (list.get(i) * count) + soma;
            count++;
        }
        return soma;
    }

    private static List<Integer> randomArray() {
        Random             rand = new Random();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (Integer i = 0; i < 9; i++)
             list.add(rand.nextInt(9));
        return list;
    }

}
