import java.util.ArrayList;

public class Main
{
    static ArrayList<String> myList = new ArrayList<>();
    static int maxSize = 5;

    public static void makeWords(int length, String word)
    {
        String newWord = "";

        if (length > maxSize)
        {
            return;
        }
        else
        {
            for (char letter = 'A'; letter <= 'Z'; letter++)
            {
                newWord = word + letter;
                myList.add(newWord);
                makeWords(length + 1, newWord);
            }
        }
    }

    public static void main(String[] args)
    {
        String pw1 = "1c75d402fb481523acd44e9d8247bc80";
        String pw2 = "5b1d59b5451c06afb65ab1bc2713cfb4";
        PasswordHash passHash = new PasswordHash();
        makeWords(1, "");
        for (String s : myList)
        {
            if (passHash.hashPW(s).equals(pw1))
            {
                System.out.println("Found Password 1: " + s);
            }

            if (passHash.hashPW(s).equals(pw2))
            {
                System.out.println("Found Password 2: " + s);
            }
        }
    }
}