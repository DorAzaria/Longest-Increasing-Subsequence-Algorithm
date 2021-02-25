import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TestSystem {

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_RED = "\u001B[31m";
    private int _errors, _tests ,_number_of_exception;
    private static String _log = "";
    private ArrayList<Long> total_time;

    public TestSystem() {
        this.total_time = new ArrayList<>();
        System.out.print("~~~~~~~ LIS TEST ~~~~~~~");
    }

    public void test(LIS lis, int exp2, int exp3, int[][] exp4) {
        long start = System.currentTimeMillis();
        int act2 = lis.lengthLIS();
        int act3 = lis.numOfLIS();
        int[][] act4 = lis.allLIS();
        long end = System.currentTimeMillis();
        long time = end - start;
//        printAllLIS(act4);
        boolean actual = true;
        String check4 = "Not equals!";
        String check = "";
        if(act2 == exp2) {
            actual &= true;
        }else{
            check += " lengthLIS() ";
            actual &= false;
        }
        if(act3 == exp3) {
            actual &= true;
        } else {
            check += " numOfLIS() ";
            actual &= false;
        }
        if(this.checkEquals(act4,exp4,lis.getTeta(),act3)) {
            actual &= true;
            check4 = "OK";
        } else {
            check += " allLIS()";
            actual &= false;
        }
        if(actual == false) {
            check = ANSI_RED+" || Error at:" + check ;
        }
        String ans = " [lengthLIS: actual="+act2+", expected="+exp2+"][numOfLIS: actual="+act3+", expected="+exp3+"][allLIS: check:"+check4+"]"+check;
        this.setTest(ans,  actual,  true, time);
    }

    public void setTest(String test, boolean actual, boolean expected,long time) {
        boolean success = true;
        String improvement = checkImprovement(time,_tests);
        _tests++;
        success = actual == expected;
        String tt = "";
        this.total_time.add(time);
        if(success) {
            tt = "Test "+_tests + ")" + test + improvement +" ||"+ANSI_GREEN+" ✔\n" +ANSI_RESET+
                    "================================================";
        }
        else {
            tt = _tests + ") " + test + improvement + " || "+ANSI_RED+"MANIAC! ✘\n" +ANSI_RESET+
                    "================================================";
        }
        _log += "\n"+tt;
        if(!success) {
            _errors++;
        }
    }

    public void finalGrade() {
        System.out.println(_log);
        double g = 100.0*(_tests-_errors)/_tests;
        g = g - _number_of_exception*10;
        g = Math.max(g,20);
        long final_time = 0;
        for(Long time : this.total_time) {
            final_time += time;
        }
        System.out.println("Number of Errors: "+_errors+" of "+_tests+" tests, "+_errors +" errors , total time " + final_time + " ms.");
        System.out.println(ANSI_GREEN+"Grade: "+(int)g);
    }

    private String checkImprovement(long dt, int i) {
        return ANSI_GREEN+" || time: "+dt+" ms " + ANSI_RESET;
    }

    private boolean checkEquals(int[][] act, int[][] exp, int theta, int numOfLIS) {
        int numchecks = 0;
        for(int i = 0 ; i < act.length; i++) {
            for(int j = 0; j < exp.length; j++) {
                if(Arrays.equals(act[i], exp[j])){
                    numchecks++;
                    if(theta < numOfLIS) {
                        return true;
                    }
                    break;
                }
            }
        }
        return numchecks == exp.length;
    }

    public void printAllLIS(int[][] arr){
        System.out.println("\nPrint All LCS for test number: " + (_tests+1));
        for(int i = 0; i < arr.length; i++){
            System.out.println(Arrays.toString(arr[i]));
        }
    }
}
