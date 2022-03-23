package com.ozgur;

import com.ozgur.model.Fruit;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        List<char[]> airlineList = generateFruit(5);
        airlineList.forEach(System.out::println);
    }

    public static List<char[]> generateFruit(int adet){

        List<char[]> fruitList = new ArrayList<>();

        for (int i = 0; i < adet; i++) {
            RandomString randomString;
            Fruit fruit = new Fruit();

            //-------------------------

            fruit.setField1("M");

            randomString = new RandomString(1,"ABCD");
            String field2 = randomString.nextString();
            fruit.setField2(field2);

            randomString = new RandomString(7);
            String field3 = randomString.nextString();
            fruit.setField3(field3);

            randomString = new RandomString(3);
            String field4 = randomString.nextString();
            fruit.setField4(field4);

            randomString = new RandomString(4,"04ABDEF");
            String field5 = randomString.nextString();
            fruit.setField5(field5);

            randomString = new RandomString(10);
            String field6 = combineValueInOrder(getRandomCity(),randomString.nextString());
            fruit.setField6(field6);

            //----------------------


            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(generateSpace(5));
            stringBuilder.append(fruit.getField1());
            stringBuilder.append(generateSpace(10));
            stringBuilder.append(fruit.getField2());
            stringBuilder.append(fruit.getField3());
            stringBuilder.append(generateSpace(2));
            stringBuilder.append(fruit.getField4());
            stringBuilder.append(fruit.getField5());
            stringBuilder.append(generateSpace(6));
            stringBuilder.append(fruit.getField6());

//            char[] resultChars = new char[stringBuilder.length()];
//            fillCharArrayFromStringBuilder(stringBuilder, resultChars);

            char[] resultChars = createCharArrayAndFillFromStringBuilder(stringBuilder);
            fruitList.add(resultChars);
        }

        return fruitList;
    }

    public static String generateSpace(int piece){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < piece; i++) {
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }

    public static void fillCharArrayFromStringBuilder(StringBuilder stringBuilder, char[] resultChars){
        stringBuilder.getChars(0, stringBuilder.length(), resultChars, 0);
    }

    public static char[] createCharArrayAndFillFromStringBuilder(StringBuilder stringBuilder){
        char[] resultChars = new char[stringBuilder.length()];
        stringBuilder.getChars(0, stringBuilder.length(), resultChars, 0);
        return resultChars;
    }

    public static String getRandomCity(){
        String[] strings = {"ADANA", "ADIYAMAN", "AFYONKARAHISAR", "AGRI", "AKSARAY", "AMASYA", "ANKARA", "ANTALYA", "ARDAHAN", "ARTVIN", "AYDIN", "BALIKESIR", "BARTIN", "BATMAN", "BAYBURT", "BILECIK", "BINGOL", "BITLIS", "BOLU", "BURDUR", "BURSA", "CANAKKALE", "CANKIRI", "CORUM", "DENIZLI", "DIYARBAKIR", "DUZCE", "EDIRNE", "ELAZIG", "ERZINCAN", "ERZURUM", "ESKIŞEHIR", "GAZIANTEP", "GIRESUN", "GÜMÜŞHANE", "HAKKARI", "HATAY", "IGDIR", "ISPARTA", "ISTANBUL", "IZMIR", "KAHRAMANMARAS", "KARABUK", "KARAMAN", "KARS", "KASTAMONU", "KAYSERI", "KILIS", "KIRIKKALE", "KIRKLARELI", "KIRSEHIR", "KOCAELI", "KONYA", "KUTAHYA", "MALATYA", "MANISA", "MARDIN", "MERSIN", "MUGLA", "MUS", "NEVSEHIR", "NIGDE", "ORDU", "OSMANIYE", "RIZE", "SAKARYA", "SAMSUN", "SANLIURFA", "SIIRT", "SINOP", "SIVAS", "SIRNAK", "TEKIRDAG", "TOKAT", "TRABZON", "TUNCELI", "USAK", "VAN", "YALOVA", "YOZGAT", "ZONGULDAK"};
        Random random = new SecureRandom();
        String randomCity = strings[random.nextInt(strings.length)];
        return randomCity;
    }

    public static String combineValueInOrder(String value1, String value2){
        String combineValue = value1 + value2;
        return combineValue;
    }
}
