package array;

public class ArrayMain {

    public static void main(String[] args) {

        String[] weekdays = {"Hetfő", "Kedd", "Szerda", "Csötürtök", "Péntek", "Szombat", "Vasárnap"};
        System.out.println(weekdays[1]);
        System.out.println(weekdays.length);

        int[] hatvany = new int[5];
        hatvany[0] = 1;
        for (int i = 1; i < hatvany.length; i++)
            hatvany[i] = hatvany[i - 1] * 2;
        for (int i : hatvany)
            System.out.print(i + " ");
        System.out.println();

        boolean[] ft = new boolean[6];
        for (int i = 1; i < ft.length; i++)
            ft[i] = !ft[i - 1];
        for (boolean b : ft)
            System.out.print(b + " ");
        System.out.println();

    }

}
