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

    /**
     * 测试
     */
    public void testCasesFindPairs(){
        testCase1();
        testCase2();
        testCase3();
        testCase4();
    }

    /**
     * 针对case1的测试
     */
    public void testCase1(){
        /**
         * 输入目标合值
         */
        int target = 10;
        /**
         * 源整数数组
         */
        Integer[] listOfIntegers = new Integer[]{3,1,7,5,6};
        /**
         * 预期：输出结果对应的数字，按照顺序排列
         */
        String output = "37";
        /**
         * 预期：输出匹配结果的个数
         */
        int matchSize = 1;
        /**
         * 测试
         */
        testCase0(target,listOfIntegers,matchSize,output);
    }

    /**
     * 针对case2的测试
     */
    public void testCase2(){
        int target = 10;
        Integer[] listOfIntegers = new Integer[]{3, 7, 5, 5, 5, 1, 6};
        String output = "3755";
        int matchSize = 2;
        testCase0(target,listOfIntegers,matchSize,output);
    }

    /**
     * 针对case3的测试
     */
    public void testCase3(){
        int target = 10;
        Integer[] listOfIntegers = new Integer[]{3, 3, 7, 7, 5, 1, 6, 5};
        String output = "373755";
        int matchSize = 3;
        testCase0(target,listOfIntegers,matchSize,output);
    }

    /**
     * 针对case4的测试
     */
    public void testCase4(){
        int target = 10;
        Integer[] listOfIntegers = new Integer[]{3, 3, 4, 1, 8};
        String output = "";
        int matchSize = 0;
        testCase0(target,listOfIntegers,matchSize,output);
    }

    /**
     * 测试，如果测试不通过则抛出运行时异常（自定义）
     * @param target  目标合值
     * @param listOfIntegers 源整数数组
     * @param matchedSize 预期匹配个数
     * @param output 预期输出字符串
     */
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
     * pick pairs of integers which are summed up to the target integer
     * @param targetIntger  target integer
     * @param listOfIntegers  source integers
     * @return java.util.List  Integer[]
     */
    public List<Integer[]> findPairs(int targetIntger, Integer[] listOfIntegers)
    {
        List<Integer[]> ret = new ArrayList<Integer[]>();
        /**
         * 用于标记哪一些位置上的整数已经被使用过
         */
        List<Integer> usedIndex = new ArrayList<>();

        for(int i=0;i<listOfIntegers.length-1;i++)
        {
            for(int j=1;j<listOfIntegers.length;j++)
            {
                /**
                 * 满足两者相加等于目标整数 & 不可以自己加自己 & 使用过的位置不再重复使用
                 */
               if(listOfIntegers[i] + listOfIntegers[j] == targetIntger && i!=j && (!usedIndex.contains(i) && !usedIndex.contains(j)))
               {
                   /**
                    * 满足加入返回结果集合中
                    */
                   ret.add(new Integer[]{listOfIntegers[i],listOfIntegers[j]});
                   System.out.println(listOfIntegers[i]+" - " + listOfIntegers[j]);
                   /**
                    * 标记指定的i 、j位置为使用过的位置，等价于从原集合中移除这两项
                    */
                   usedIndex.add(i);
                   usedIndex.add(j);
               }
            }
        }
        return ret;
    }
}
