package com.leoruan.test;



import java.util.ArrayList;
import java.util.List;

/**
 * Coding test - Find pairs
 *
 * - Write a function that can pick pairs of integers which are summed up to the target integer.
 *
 * - Apply TDD way in coding
 *
 * for example, the function signature is
 *
 * findPairs(targetInteger, listOfIntegers) -> listOfMatchedPairs
 *
 * case 1: findPairs(10, [3, 1, 7, 5, 6]) outputs [{3, 7}]
 *
 * case 2: findPairs(10, [3, 7, 5, 5, 5, 1, 6]) outputs [{3, 7}, {5, 5}]
 *
 * case 3: findPairs(10, [3, 3, 7, 7, 5, 1, 6, 5]) outputs [{3, 7}, {3, 7}, {5, 5}]
 *
 * case 4: findPairs(10, [3, 3, 4, 1, 8]) outputs []
 */
public class Test
{

    public static void main(String[] args) {
        new Test().testCasesFindPairs();
    }

    public void testCasesFindPairs(){
        testCase1();
        testCase2();
        testCase3();
        testCase4();
    }

    public void testCase1(){
        int target = 10;
        Integer[] listOfIntegers = new Integer[]{3,1,7,5,6};
        String output = "37";
        int matchSize = 1;
        testCase0(target,listOfIntegers,matchSize,output);
    }

    public void testCase2(){
        int target = 10;
        Integer[] listOfIntegers = new Integer[]{3, 7, 5, 5, 5, 1, 6};
        String output = "3755";
        int matchSize = 2;
        testCase0(target,listOfIntegers,matchSize,output);
    }

    public void testCase3(){
        int target = 10;
        Integer[] listOfIntegers = new Integer[]{3, 3, 7, 7, 5, 1, 6, 5};
        String output = "373755";
        int matchSize = 3;
        testCase0(target,listOfIntegers,matchSize,output);
    }

    public void testCase4(){
        int target = 10;
        Integer[] listOfIntegers = new Integer[]{3, 3, 4, 1, 8};
        String output = "";
        int matchSize = 0;
        testCase0(target,listOfIntegers,matchSize,output);
    }

    public void testCase0(int target,Integer[] listOfIntegers,int matchedSize,String output){
        List<Integer[]> ret = findPairs(target,listOfIntegers);
        if(ret.size()!=matchedSize)
            throw new RuntimeException("size not match");

        StringBuffer sb = new StringBuffer();

        for(Integer[] r:ret)
        {
            int sum_ = 0;
            for(Integer i:r) {
                sum_ += i;
                sb.append(i);
            }


            if(target != sum_)
                throw new RuntimeException("ele not match");
        }

        if(!sb.toString().equals(output))
            throw new RuntimeException("output not match");



    }

    /**
     * 如果没有值则返回空
     * @param targetIntger
     * @param listOfIntegers
     * @return
     */
    public List<Integer[]> findPairs(int targetIntger, Integer[] listOfIntegers)
    {
        List<Integer[]> ret = new ArrayList<Integer[]>();
        List<Integer> usedIndex = new ArrayList<>();


        for(int i=0;i<listOfIntegers.length-1;i++)
        {
            for(int j=1;j<listOfIntegers.length;j++)
            {
               if(listOfIntegers[i] + listOfIntegers[j] == targetIntger && i!=j && (!usedIndex.contains(i) && !usedIndex.contains(j)))
               {
                   ret.add(new Integer[]{listOfIntegers[i],listOfIntegers[j]});
                   System.out.println(listOfIntegers[i]+" - " + listOfIntegers[j]);

                   usedIndex.add(i);
                   usedIndex.add(j);
               }
            }
        }
        return ret;
    }
}
