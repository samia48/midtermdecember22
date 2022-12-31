package string.problems;

public class DuplicateWord {

    public static void main(String[] args) {
        /*
         * Write a java program to find the duplicate words and their number of occurrences in the string.
         * Also, Find the average length of the words.
         */

        String st = "Java is a programming Language. Java is also an Island of Indonesia. Java is widely used language";

        String[] strArray = st.split(" ");
        int wrc = 1;

        for (int i = 0; i < strArray.length; i++) {

            for (int j = i + 1; j < strArray.length; j++)

            {
                if (strArray[i].equals(strArray[j]))
                {
                    wrc = wrc + 1;
                    strArray[j] = "0";
                }

            }
            if(wrc > 1 && strArray[i] != "0")

                System.out.println(strArray[i]+","+wrc);
            wrc=1;
        }
    }
}
