package uta.cse3310;

public class Card {
    public Card(Suite suite, Num n, int value) {
        this.suite = suite;
        this.number = n;
        this.value = value;
    }

    public Suite getSuite() {
        return suite;
    }

    public Num getNumber() {
        return number;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int i) {
        value = i;
    }

    // public Card(String string, String string2, int value2) {
    // }

    private Suite suite;
    private Num number;
    private int value;
}
// I used two enumerations for the card identiification and I used a serperate
// integer value for the value of the card since face card and aces dont map
// exactly to their order


