
public class TestLIS {

    public static void main(String[] args) {
        TestSystem testSystem = new TestSystem();
        LIS lis;
        int lengthLIS, numOfLIS;
        int[][] allLIS;

        /////// TEST 1 - The empty test ////////////////////////////////////
        lis = new LIS(new int[] {},10);
        lengthLIS = 0;
        numOfLIS = 0;
        allLIS = new int[][]{{}};
        testSystem.test(lis,lengthLIS,numOfLIS,allLIS);

        /////// TEST 2 - The empty test ////////////////////////////////////
        lis = new LIS(new int[] {1},10);
        lengthLIS = 1;
        numOfLIS = 1;
        allLIS = new int[][]{{1}};
        testSystem.test(lis,lengthLIS,numOfLIS,allLIS);

        /////// TEST 3 - The empty test ////////////////////////////////////
        lis = new LIS(new int[] {1,1},10);
        lengthLIS = 1;
        numOfLIS = 2;
        allLIS = new int[][]{{1},{1}};
        testSystem.test(lis,lengthLIS,numOfLIS,allLIS);

        /////// TEST 4 - The empty test ////////////////////////////////////
        lis = new LIS(new int[] {1,2},10);
        lengthLIS = 2;
        numOfLIS = 1;
        allLIS = new int[][]{{1,2}};
        testSystem.test(lis,lengthLIS,numOfLIS,allLIS);

        /////// TEST 5 /////////////////////////////////////////////////////
        lis = new LIS(new int[] {2,4,90,-3,-2,-1,-10,-9,-8},10);
        lengthLIS = 3;
        numOfLIS = 3;
        allLIS = new int[][]{{2,4,90},{-3,-2,-1},{-10,-9,-8}};
        testSystem.test(lis,lengthLIS,numOfLIS,allLIS);

        /////// TEST 6 /////////////////////////////////////////////////////
        lis = new LIS(new int[] {2,-3,4,90,-2,-1,-10,-9,-8},10);
        lengthLIS = 3;
        numOfLIS = 4;
        allLIS = new int[][]{{2,4,90},{-3,4,90},{-3,-2,-1},{-10,-9,-8}};
        testSystem.test(lis,lengthLIS,numOfLIS,allLIS);

        /////// TEST 7 /////////////////////////////////////////////////////
        lis = new LIS(new int[] {3, 4, -1, 5, 8, 2, 3, 12, 7, 9, 10},10);
        lengthLIS = 6;
        numOfLIS = 3;
        allLIS = new int[][]{{-1,2,3,7,9,10}, {3, 4, 5, 7, 9, 10} , {3, 4, 5, 8, 9, 10}};
        testSystem.test(lis,lengthLIS,numOfLIS,allLIS);

        /////// TEST 8 /////////////////////////////////////////////////////
        lis = new LIS(new int[] {1,11,2,10,4,5,2,1},1);
        lengthLIS = 4;
        numOfLIS = 1;
        allLIS = new int[][]{{1,2,4,5}};
        testSystem.test(lis,lengthLIS,numOfLIS,allLIS);

        /////// TEST 9 /////////////////////////////////////////////////////
        lis = new LIS(new int[] {8,1,100,101,2,3,4,102,100,101,50},10);
        lengthLIS = 6;
        numOfLIS = 1;
        allLIS = new int[][]{{1,2,3,4,100,101}};
        testSystem.test(lis,lengthLIS,numOfLIS,allLIS);

        /////// TEST 10 /////////////////////////////////////////////////////
        lis = new LIS(new int[] {0, 1, 101, 9, 10, 11, 2, 3, 100, 4, -1, 5, 6},10);
        lengthLIS = 7;
        numOfLIS = 1;
        allLIS = new int[][]{{0,1,2,3,4,5,6}};
        testSystem.test(lis,lengthLIS,numOfLIS,allLIS);

        /////// TEST 11 /////////////////////////////////////////////////////
        lis = new LIS(new int[] {1, 2, 9, 13, 15, 17, 24, 26, 35, 37},10);
        lengthLIS = 10;
        numOfLIS = 1;
        allLIS = new int[][]{{1, 2, 9, 13, 15, 17, 24, 26, 35, 37}};
        testSystem.test(lis,lengthLIS,numOfLIS,allLIS);

        /////// TEST 12 ////////////////////////////////////////////////////
        lis = new LIS(new int[] {9, 6, 1, 10, 2, 5, 12, 30, 31, 20, 22, 18},10);
        lengthLIS = 6;
        numOfLIS = 2;
        allLIS = new int[][]{{1, 2, 5, 12, 30, 31},{1, 2, 5, 12, 20, 22}};
        testSystem.test(lis,lengthLIS,numOfLIS,allLIS);

        /////// TEST 13 /////////////////////////////////////////////////////
        lis = new LIS(new int[] {1, 1, 2, 1, 1},10);
        lengthLIS = 2;
        numOfLIS = 2;
        allLIS = new int[][]{{1,2},{1,2}};
        testSystem.test(lis,lengthLIS,numOfLIS,allLIS);

        /////// TEST 14 /////////////////////////////////////////////////////
        lis = new LIS(new int[] {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15},10);
        lengthLIS = 6;
        numOfLIS = 4;
        allLIS = new int[][]{{0, 4, 6, 9, 13, 15}, {0, 2, 6 ,9 ,13 ,15}, {0, 4, 6, 9 ,11, 15}, {0 ,2, 6, 9, 11 ,15}};
        testSystem.test(lis,lengthLIS,numOfLIS,allLIS);

        /////// TEST 15 /////////////////////////////////////////////////////
        lis = new LIS(new int[] {10,9,2,5,3,7,101,18},10);
        lengthLIS = 4;
        numOfLIS = 4;
        allLIS = new int[][]{{2, 3, 7, 101}, {2, 5, 7, 101}, {2, 3, 7, 18}, {2, 5, 7, 18}};
        testSystem.test(lis,lengthLIS,numOfLIS,allLIS);

        /////// TEST 16 /////////////////////////////////////////////////////
        lis = new LIS(new int[] {0,1,0,3,2,3},10);
        lengthLIS = 4;
        numOfLIS = 1;
        allLIS = new int[][]{{0, 1, 2, 3}};
        testSystem.test(lis,lengthLIS,numOfLIS,allLIS);

        /////// TEST 17 /////////////////////////////////////////////////////
        lis = new LIS(new int[] {7,7,7,7,7,7,7},10);
        lengthLIS  = 1;
        numOfLIS = 7;
        allLIS = new int[][]{{7},{7},{7},{7},{7},{7},{7}};
        testSystem.test(lis,lengthLIS,numOfLIS,allLIS);

        /////// TEST 18 /////////////////////////////////////////////////////
        lis = new LIS(new int[] {1,3,5,4,7},10);
        lengthLIS  = 4;
        numOfLIS = 2;
        allLIS = new int[][]{{1, 3, 4, 7}, {1, 3, 5, 7}};
        testSystem.test(lis,lengthLIS,numOfLIS,allLIS);

        /////// TEST 19 ///////////////////////////////////////////////////// NEED TO CHECK!
        lis = new LIS(new int[] {3, 0, 0, 2, 0, 1, 3, 0, 1, 3},10); ////////// <-- y not also [0,1,3] , [0,2,3]
        lengthLIS  = 3;
        numOfLIS = 14;
        allLIS = new int[][]{{0,2,3}};
        testSystem.test(lis,lengthLIS,numOfLIS,allLIS);

        /////// TEST 20 ///////////////////////////////////////////////////// ---> NEED TO CHECK.
        lis = new LIS(new int[] {0, 2, 3, 2, 2, 0, 1, 2, 2, 4, 2, 2},10);
        lengthLIS  = 4;
        numOfLIS = 5;
        allLIS = new int[][]{{0, 1, 2, 4}, {0, 1, 2, 4}, {0, 1, 2, 4}, {0, 1, 2, 4}, {0,2,3,4}};
        testSystem.test(lis,lengthLIS,numOfLIS,allLIS);

        /////// TEST 21 /////////////////////////////////////////////////////
        lis = new LIS(new int[] {1, 4, 4, 0, 4, 2, 3, 0},10);
        lengthLIS  = 3;
        numOfLIS = 2;
        allLIS = new int[][]{{0, 2, 3}, {1, 2, 3}};
        testSystem.test(lis,lengthLIS,numOfLIS,allLIS);

        /////// TEST 22 /////////////////////////////////////////////////////
        lis = new LIS(new int[] {2, 2, 0, 4},10);
        lengthLIS  = 2;
        numOfLIS = 3;
        allLIS = new int[][]{{0 ,4 }, {2, 4}, {2, 4}};
        testSystem.test(lis,lengthLIS,numOfLIS,allLIS);

        /////// TEST 23 /////////////////////////////////////////////////////
        lis = new LIS(new int[] {4, 4, 1, 4, 2, 0, 1, 4, 3, 3, 3},10); /// <=== NEED TO CHECK
        lengthLIS  = 3;
        numOfLIS = 8;
        allLIS = new int[][]{{0, 1, 4}, {1, 2, 4}, {0,1,3},{1,2,3}, {0,1,3}, {1,2,3}, {0,1,3}, {1,2,3}};
        testSystem.test(lis,lengthLIS,numOfLIS,allLIS);

        /////// TEST 24 /////////////////////////////////////////////////////
        lis = new LIS(new int[] {2,1,0,-1,-2},10);
        lengthLIS  = 1;
        numOfLIS = 5;
        allLIS = new int[][]{{2},{1},{0},{-1},{-2}};
        testSystem.test(lis,lengthLIS,numOfLIS,allLIS);

        /////// TEST 25 /////////////////////////////////////////////////////
        lis = new LIS(new int[] {1, 2, 1, 1, 2, 1, 3, 4, 3, 4},10); // <=== NEED TO CHECK!!!!
        lengthLIS  = 4;
        numOfLIS = 12;
        allLIS = new int[][]{{1,2,3,4}};
        testSystem.test(lis,lengthLIS,numOfLIS,allLIS);

        /////// TEST 26 /////////////////////////////////////////////////////
        lis = new LIS(new int[] {1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1},10); /// <==== NEED TO CHECK!
        lengthLIS  = 2;
        numOfLIS = 5;
        allLIS = new int[][]{{0,1}, {0,1} , {0,1} , {0,1} , {0,1}};
        testSystem.test(lis,lengthLIS,numOfLIS,allLIS);

        /////// TEST 27 /////////////////////////////////////////////////////
        lis = new LIS(new int[] {1,1,1,1,1,1,1,0,0,1,1,0,1,1,1,1},10); /// <==== NEED TO CHECK!!!
        lengthLIS  = 2;
        numOfLIS = 16;
        allLIS = new int[][]{{0,1}};
        testSystem.test(lis,lengthLIS,numOfLIS,allLIS);

        /////// TEST 28 /////////////////////////////////////////////////////
        lis = new LIS(new int[] {0,-5,-8,-6,-2},10);
        lengthLIS  = 3;
        numOfLIS = 1;
        allLIS = new int[][]{{-8,-6,-2}};
        testSystem.test(lis,lengthLIS,numOfLIS,allLIS);

        /////// TEST 29 /////////////////////////////////////////////////////
        lis = new LIS(new int[] {4,5,1,2,3,6},10);
        lengthLIS  = 4;
        numOfLIS = 1;
        allLIS = new int[][]{{1,2,3,6}};
        testSystem.test(lis,lengthLIS,numOfLIS,allLIS);

        /////// TEST 30 /////////////////////////////////////////////////////
        lis = new LIS(new int[] {99,2,3,4,5,7,18,9},10);
        lengthLIS  = 6;
        numOfLIS = 2;
        allLIS = new int[][]{{2,3,4,5,7,18}, {2,3,4,5,7,9}};
        testSystem.test(lis,lengthLIS,numOfLIS,allLIS);

        /////// TEST 31 /////////////////////////////////////////////////////
        lis = new LIS(new int[] {1},1);
        lengthLIS = 1;
        numOfLIS = 1;
        allLIS = new int[][]{{1}};
        testSystem.test(lis,lengthLIS,numOfLIS,allLIS);

        /////// TEST 32 /////////////////////////////////////////////////////
        lis = new LIS(new int[] {2,4,90,-3,-2,-1,-10,-9,-8},2);
        lengthLIS = 3;
        numOfLIS = 3;
        allLIS = new int[][]{{2,4,90},{-3,-2,-1},{-10,-9,-8}};
        testSystem.test(lis,lengthLIS,numOfLIS,allLIS);

        /////// TEST 33 /////////////////////////////////////////////////////
        lis = new LIS(new int[] {0, 1, 101, 9, 10, 11, 2, 3, 100, 4, -1, 5, 6},1);
        lengthLIS = 7;
        numOfLIS = 1;
        allLIS = new int[][]{{0,1,2,3,4,5,6}};
        testSystem.test(lis,lengthLIS,numOfLIS,allLIS);

        /////// TEST 34 /////////////////////////////////////////////////////
        lis = new LIS(new int[] {10,9,2,5,3,7,101,18},3);
        lengthLIS = 4;
        numOfLIS = 4;
        allLIS = new int[][]{{2, 3, 7, 101}, {2, 5, 7, 101}, {2, 3, 7, 18}, {2, 5, 7, 18}};
        testSystem.test(lis,lengthLIS,numOfLIS,allLIS);

        /////// TEST 35 /////////////////////////////////////////////////////
        lis = new LIS(new int[] {0, 2, 3, 2, 2, 0, 1, 2, 2, 4, 2, 2},1); /// <==== NEED TO CHECK!!!
        lengthLIS  = 4;
        numOfLIS = 5;
        allLIS = new int[][]{{0, 1, 2, 4},{0, 1, 2, 4},{0, 1, 2, 4},{0, 1, 2, 4},{0, 2, 3, 4}};
        testSystem.test(lis,lengthLIS,numOfLIS,allLIS);

        testSystem.finalGrade();
    }



}
