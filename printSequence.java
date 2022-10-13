import java.util.*;

import java.io.*;

//Class to print the valid sequence that sum up to 100
// Naive approach
//Generate all the possible and valid sequence that is containing +, and -
// At last validate the sequence whether it the total sum is equal to 100
// If yes, print the sequence

//The TimeComplexity of this approach will O(2^(N-1))*O(2^(N-1))(for validating every sequence).
//The N is the total number of digits in the String,

//Efficient approach (I am writing this approach)

// While generating the sequence, we can validate the required sum.

// The TimeComplexity of this approach will be O(2*(N-1))*N in worst case

public class printSequence {

    //Method to generate valid Seqeuence Using StringBuilder to avoid immutability
   public void generateValidSequence(StringBuilder sequence, String digits, int position, int target, long previous) {

	if(position == digits.length()) {
		if(target == previous) {

            System.out.println(sequence);
        }
		return;
	}
	for(int i = position; i < digits.length(); i++) {
		if(digits.charAt(position) == '0' && i != position) break;
		long curr = Long.parseLong(digits.substring(position, i + 1));
		int length = sequence.length();
		if(position == 0) {
			generateValidSequence(sequence.append(curr), digits, i + 1, target, curr);
			sequence.setLength(length);
		} else {
            //Generating sequence by + symbol
			generateValidSequence( sequence.append("+").append(curr), digits, i + 1, target, previous + curr);
			sequence.setLength(length);
            //Generating sequence by - symbol
			generateValidSequence(sequence.append("-").append(curr), digits, i + 1, target, previous - curr);
            sequence.setLength(length);
		}
	}

}
    public static void main(String[] args) {

        Scanner scan=new Scanner(System.in);

        String m=scan.next();

        printSequence ob=new printSequence();

        StringBuilder sb=new StringBuilder();

        ob.generateValidSequence(sb,m,0,100,0);



    }
}
