import java.util.Arrays;
import java.util.Scanner;

//Considering both input String contains small and upperCase characters
//There are two approach two solve this problem.

//Naive Approach
// Store the frequency in the hashmap and use the

// Optimal Approach
// I have written the optimal approach that is using:
// O(n) Time Complexity, and the O(43) i.e O(1) constant spaceComplexity

public class Anagram {

    private boolean isUpperCharacter(char ch) {

        return ch >= 'A' && ch <= 'Z';
    }

    private boolean checkStringAnagram(String first, String second) {

        int freq[] = new int[53];

        // Iterating on the characters of the first String

        for (int i = 0; i < first.length(); ++i) {

            char ch = first.charAt(i);

            if (isUpperCharacter(ch)) {

                // Storing the frequency of upperCase characters

                freq[ch - 'A' + 26]++;
            } else {

                // Storing the frequence of lowerCase Characters
                freq[ch - 'a']++;
            }
        }


        //Checking whether the frequency of characters in the First String
        // is equal to the Second String

          for (int i = 0; i < second.length(); ++i) {

            char ch = second.charAt(i);

            if (isUpperCharacter(ch)) {

                // Storing the frequency of upperCase characters

                freq[ch - 'A' + 26]--;
            } else {

                // Storing the frequence of lowerCase Characters
                freq[ch - 'a']--;
            }
        }


        for(int i=0;i<53;++i){

            if(freq[i]!=0)return false;
        }

        return true;

    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        // Enter the First String

        String first = scan.next();

        // Enter the Second String

        String second = scan.next();

        Anagram ob=new Anagram();

        System.out.println(ob.checkStringAnagram(first,second));

    }
}
