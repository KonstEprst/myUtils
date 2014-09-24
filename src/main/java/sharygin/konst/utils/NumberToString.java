package sharygin.konst.utils;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.text.MessageFormat;

/**
 *
 * @author prog2
 */
public class NumberToString {

    /**
     * Конвертировать числовое представление в строковое. Действительно для чисел меньше миллиарда.
     * @return Строковое представление числа
     */
    public static String convertIntNumberToString(Integer value){
        StringBuilder sb = new StringBuilder();
        if(value >= 1_000_000 && value < 1_000_000_000){
            sb.append(stri(value/ 1_000_000, true));

            String val = getParsedValue(value, 1_000_000);

            switch(val){
                case "1":
                    sb.append("миллион ");
                    break;

                case "2":
                case "3":
                case "4":
                    sb.append("миллиона ");
                    break;

                default:
                    sb.append("миллионов ");
            }

            value = value % 1_000_000;
        }



        if(value < 1_000_000 && value > 999){
            sb.append(stri(value / 1_000, false));

            String val = getParsedValue(value, 1_000);


            switch(val){
                case "1":
                    sb.append("тысяча ");
                    break;

                case "2":
                case "3":
                case "4":
                    sb.append("тысячи ");
                    break;

                default:
                    sb.append("тысяч ");
            }

            value = value % 1_000;
        }

        sb.append(stri(value, true));

        return sb.toString();
    }

    private static String getParsedValue(int value, int divider){
        Integer tmp = value / divider;
        if(tmp > 99){
            tmp %= 100;
        }

        if(tmp > 19){
            tmp %= 10;
        }

        return tmp.toString();
    }

    private static String stri(int value, boolean flagForTwo) {
        StringBuilder sb = new StringBuilder();

        if (value >= 100) {
            sb.append(strHundreds(value));
            value = value % 100;
        }

        if(value < 100 && value >= 20){
            sb.append(strTens(value));
            value = value % 10;
        }

        if(value < 20 && value >= 10){
            sb.append(str10To19(value));
            return sb.toString();
        }

        sb.append(strUnits(value, flagForTwo));


        return sb.toString();
    }

    private static String strHundreds(int value){
        switch (value / 100) {
            case 1:
                return "сто ";

            case 2:
                return "двести ";

            case 3:
                return "триста ";

            case 4:
                return "четыреста ";

            case 5:
                return "пятьсот ";

            case 6:
                return "шестьсот ";

            case 7:
                return "семьсот ";

            case 8:
                return "восемьсот ";

            case 9:
                return "девятьсот";
        }

        return "";
    }

    private static String strUnits(int value, boolean flagForTwo){
        switch (value) {
            case 1:
                return "один ";

            case 2:
                if(flagForTwo)
                    return "два ";
                else
                    return "две ";

            case 3:
                return "три ";

            case 4:
                return "четыре ";

            case 5:
                return "пять ";

            case 6:
                return "шесть ";

            case 7:
                return "семь ";

            case 8:
                return "восемь ";

            case 9:
                return "девять ";
        }

        return "";
    }

    private static String strTens(int value){
        switch (value / 10) {
            case 1:
                return str10To19(value);

            case 2:
                return "двадцать ";

            case 3:
                return "тридцать ";

            case 4:
                return "сорок ";

            case 5:
                return "пятьдесят ";

            case 6:
                return "шестьдесят ";

            case 7:
                return "семьдесят ";

            case 8:
                return "восемьдесят ";

            case 9:
                return "девяносто ";

        }
        return "";
    }

    private static String str10To19(int value){
        switch(value){
            case 10:
                return "десять ";
            case 11:
                return "одиннадцать ";
            case 12:
                return "двенадцать ";
            case 13:
                return "тринадцать ";
            case 14:
                return "четырнадцать ";
            case 15:
                return "пятнадцать ";
            case 16:
                return "шестнадцать ";
            case 17:
                return "семнадцать ";
            case 18:
                return "восемнадцать ";
            case 19:
                return "девятнадцать ";
        }

        return "";
    }
}