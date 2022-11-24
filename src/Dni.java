public class Dni {
    private int number;
    private char letter;
    private static char[] LETTERS = {'T','R','W','A','G','M','Y','F','P','D',
            'X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
    public Dni() {
        number = 0;
        letter = LETTERS[0];
    }
    public Dni(int newNumber) throws NIFException {
        if (newNumber <= 0) {
            throw new NIFException();
        }
        number = newNumber;
        letter = LETTERS[number % 23];
    }

    public Dni(int newNumber, char newLetter) throws NIFException, NIFLetterException {
        if (newNumber <= 0) {
            throw new NIFException();
        }
        letter = LETTERS[number % 23];
        if (Character.toUpperCase(newLetter) != letter) {
            throw new NIFLetterException();
        }
    }
    public Dni(String s) throws NIFLetterException, NIFException {
        char c = s.charAt(s.length()-1);
        String newS = s.replaceAll("[^0-9]", "");
        try {
            number = Integer.parseInt(newS);
        } catch(NumberFormatException ex) {
            throw new NIFException();
        }
        letter = LETTERS[number % 23];
        if (Character.toUpperCase(c) != letter) {
            throw new NIFLetterException();
        }
    }
    public boolean isDniCorrect() {
// This makes no sense now
        return true;
    }
    public int getNumber() {
        return number;
    }
    public char getLetter() {
        return letter;
    }
    public void setNumber(int newNumber) throws NIFException {
        if (newNumber <= 0) {
            throw new NIFException();
        }
        number = newNumber;
        letter = LETTERS[number % 23];
    }
    public String toString() {
        return number + Character.toString(letter);
    }

    public String toFormattedString() {
        StringBuilder s = new StringBuilder(String.valueOf(number));
        if (number > 999) {
            s.insert(s.length() - 3,'.');
        }
        if (number > 999999) {
            s.insert(s.length() - 7,'.');
        }
        if (number > 999999999) {
            s.insert(s.length() - 11,'.');
        }
        return s.toString() + "-" + letter;
    }
}