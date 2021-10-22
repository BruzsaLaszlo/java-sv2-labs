package algorithmscount;

/**
 * A Digits osztályba írj egy getCountOfNumbers() metódust, amely a következő matematikai feladat
 * megoldását adja vissza: Hány olyan kétjegyű pozitív egész szám van, amelyben az egyik számjegy
 * 5-tel nagyobb a másiknál?
 */
public class Digits {

    public int getCountOfNumbers() {

        int count = 0;

        for (int i = 10; i < 100; i++) {
            int elso = i / 10;
            int masodik = i % 10;
            if (elso + 5 == masodik || masodik + 5 == elso)
                count++;
        }

        return count;

    }

}
