package LoggerUtility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;

public class LoggerUtility {
    private static String suiteLogsPath = "target/logs/suite/";

    private static String regressionLogsPath = "target/logs/";

    private static Logger logger = LogManager.getLogger();

    public static synchronized void startTestCase(String testName) {

        ThreadContext.put("threadName", testName);
        logger.info("====================================== Execution started : " + testName + "================================================");
    }

    public static synchronized void endTestCase(String testName) {
        logger.info("====================================== Execution finished : " + testName + "================================================");
    }

    public static synchronized void info(String message) {
        logger.info(Thread.currentThread().getName() + " : " + getCallInfo() + " " + message);
    }

    private static synchronized String getCallInfo() {
        String className = Thread.currentThread().getStackTrace()[3].getClassName();
        String methodName = Thread.currentThread().getStackTrace()[3].getMethodName();
        return className + " : " + methodName + "==>";
    }

    public static synchronized void error(String message) {
        logger.error(Thread.currentThread().getName() + " : " + getCallInfo() + " " + message);
        logger.info("====================================== Test failed ================================================");
    }

    public static void mergeLogsIntoOne(){
        File dir = new File(suiteLogsPath);

        // Get list of all the files in form of String Array
        String[] fileNames = dir.list();

        try {
            PrintWriter pw = new PrintWriter(regressionLogsPath + "output.log");

            for (String fileName : fileNames) {
                if(fileName.contains(".log")) {

                    File f = new File(dir, fileName);

                    BufferedReader br = new BufferedReader(new FileReader(f));
                    pw.println("Contents of file " + fileName);

                    String line = br.readLine();
                    while (line != null) {

                        pw.println(line);
                        line = br.readLine();
                    }
                    pw.flush();
                }
            }
        }
        catch (Exception exception){
            System.out.println(exception.getMessage());
        }

    }


}
