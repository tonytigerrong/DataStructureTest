package com.hackerrank;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Solution {

    /*
     * Complete the 'diagonalDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int diagonalDifference(List<List<Integer>> arr) {
        List<Integer> ar = new ArrayList<Integer>();
        int n = arr.get(0).size();
        int j = 0;
        for(int a=0 ; a<n ; a++){
            for(int b=0 ; b<n ; b++){
                ar.add(j++, arr.get(a).get(b));
            }
        }

        int result = 0;
        List<Integer> indexOfL2R = new ArrayList<Integer>();
        List<Integer> indexOfR2L = new ArrayList<Integer>();
        for(int l=0 ; l< n ; l++){
            indexOfL2R.add(l,(n+1)*(l));
            indexOfR2L.add(l,(n-1)*(l+1));
        }

        int sumOfL2R = 0 , sumOfR2L = 0;
        for( int i = 0 ; i<indexOfL2R.size(); i++ ){
            sumOfL2R += ar.get(indexOfL2R.get(i));
        }
        for(  int i = 0 ; i<indexOfR2L.size(); i++ ){
            sumOfR2L += ar.get(indexOfR2L.get(i));
        }
        result = Math.abs(sumOfL2R-sumOfR2L);

        return result;
    }

}

public class DiagonalDiff {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("./output.txt"));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Solution.diagonalDifference(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
/**
 *
 *
 * Given a square matrix, calculate the absolute difference between the sums of its diagonals.
 *
 * For example, the square matrix  is shown below:
 *
 * 1 2 3
 * 4 5 6
 * 9 8 9
 * The left-to-right diagonal = . The right to left diagonal = . Their absolute difference is .
 *
 * Function description
 *
 * Complete the  function in the editor below.
 *
 * diagonalDifference takes the following parameter:
 *
 * int arr[n][m]: an array of integers
 * Return
 *
 * int: the absolute diagonal difference
 * Input Format
 *
 * The first line contains a single integer, , the number of rows and columns in the square matrix .
 * Each of the next  lines describes a row, , and consists of  space-separated integers .
 *
 * Constraints
 *
 * Output Format
 *
 * Return the absolute difference between the sums of the matrix's two diagonals as a single integer.
 *
 * Sample Input
 *
 * 3
 * 11 2 4
 * 4 5 6
 * 10 8 -12
 * Sample Output
 *
 * 15
 * Explanation
 *
 * The primary diagonal is:
 *
 * 11
 *    5
 *      -12
 * Sum across the primary diagonal: 11 + 5 - 12 = 4
 *
 * The secondary diagonal is:
 *
 *      4
 *    5
 * 10
 * Sum across the secondary diagonal: 4 + 5 + 10 = 19
 * Difference: |4 - 19| = 15
 *
 * Note: |x| is the absolute value of x
 */