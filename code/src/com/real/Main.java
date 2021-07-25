package com.real;

/**
 * package: com.real
 * date: 2019/4/3 20:51
 *
 * @author smallcase
 * @since JDK 1.8
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner	sc = new Scanner(System.in);
        ArrayList<String> listcorrect1 = new ArrayList<>();
        ArrayList<String> listcorrect2 = new ArrayList<>();
        TreeSet<String> listcorrect3 = new TreeSet<>();
        ArrayList<String> listerror = new ArrayList<>();
        while(sc.hasNext()) {
            String line = sc.nextLine();
            String regex = "[a-zA-Z0-9]+";

            if(line.matches(regex)){
                if(!listcorrect1.contains(line)) {
                    listcorrect1.add(line);
                    String line2 = change(line,10);
                    listcorrect2.add(line2);
                    listcorrect3.add(line2);
                }
            }else {
                listerror.add(line);
            }

        }
        String resultc1 = listcorrect1.toString();
        int lenc = resultc1.length();
        resultc1 = resultc1.substring(1,lenc - 1);
        resultc1 = resultc1.replaceAll(",", "");
        System.out.println(resultc1);
        //Êä³ö´íÎó½á¹û
        String resulte1 = listerror.toString();
        int lene = resulte1.length();
        resulte1 = resulte1.substring(1,lene - 1);
        resulte1 = resulte1.replaceAll(",", "");
        System.out.println(resulte1);
        //ÕýÈ·½á¹ûÑ­»·ÒÆÎ»
        String resultc2 = listcorrect2.toString();
        resultc2 = resultc2.substring(1,lenc - 1);
        resultc2 = resultc2.replaceAll(",", "");
        System.out.println(resultc2);
        //ÅÅÐòºóµÄÕýÈ·½á¹û
        String resultc3 = listcorrect3.toString();
        resultc3 = resultc3.substring(1,lenc - 1);
        resultc3 = resultc3.replaceAll(",", "");
        System.out.println(resultc3);
    }

    public static String change(String from, int index) {
        if(index >= from.length()) {
            index = index % from.length();
        }
        from = reChange(from);
        String first = reChange(from.substring(0, from.length() - index));
        String second = reChange(from.substring(from.length() - index));
        from = first + second;
        return from;
    }

    public static String reChange(String from) {
        char[] froms = from.toCharArray();
        for (int i = 0; i < from.length() / 2; i++) {
            char temp = froms[i];
            froms[i] = froms[from.length() - 1 - i];
            froms[froms.length - 1 - i] = temp;
        }
        return String.valueOf(froms);
    }
}
