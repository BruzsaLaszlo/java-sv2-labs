package primitivetypes;

public class PrimitiveTypesMain {

    public static void main(String[] args) {

        int a = 2;
        Integer b = 2;
        Integer c = a;
        Integer d = b;
        Integer e = Integer.valueOf(2);
        int f = Integer.valueOf(2);
        int g = Integer.valueOf(a);
        int h = Integer.valueOf(c);
        int i = Integer.parseInt("2");
        Integer j = Integer.parseInt("2");

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
        System.out.println(f);
        System.out.println(g);
        System.out.println(h);
        System.out.println(i);
        System.out.println(j);

        boolean k = true;
        Boolean l = true;
        boolean m = Boolean.valueOf(true);
        Boolean n = Boolean.valueOf(true);
        boolean o = Boolean.valueOf("TrUe");
        Boolean p = Boolean.valueOf("TrUe");
        boolean q = Boolean.valueOf("TreU");
        Boolean r = Boolean.valueOf("TreU");

        System.out.println(k);
        System.out.println(l);
        System.out.println(m);
        System.out.println(n);
        System.out.println(o);
        System.out.println(p);
        System.out.println(q);
        System.out.println(r);

    }

}
