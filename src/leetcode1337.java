import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class leetcode1337 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

    }

    public static class Solution {
        public int[] kWeakestRows(int[][] mat, int k) {

            Item[] itemsArr = new Item[mat.length];
            int[] arr = new int[2];

            for(int i = 0; i< mat.length; i++){
                int sum = 0;

                for(int j = 0; j<mat[0].length; j++){
                    if(mat[i][j] == 1){
                        sum++;
                    }
                }
                itemsArr[i] = new Item(i, sum);
            }

            for(int i = 1; i<itemsArr.length; i++){

                if(itemsArr[i].noOfOnes == itemsArr[i-1].noOfOnes){
                    swap(itemsArr, i, i-1);
                }

            }

            Arrays.sort(itemsArr, new Comparator<>() {
                @Override
                public int compare(Item item1, Item item2) {
                    return item1.noOfOnes.compareTo(item2.noOfOnes);
                }
            });

            return arr;
        }

        private void swap(Item[] itemsArr, int i, int i1) {
            Item temp = itemsArr[i];
            itemsArr[i] = itemsArr[i1];
            itemsArr[i1] = temp;
        }

        public static class Item{

            int index;
            Integer noOfOnes;

            public Item(int index, int noOfOnes){
                this.index = index;
                this.noOfOnes = noOfOnes;
            }

        }

    }

}
