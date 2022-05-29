package ss4_lop_va_doi_tuong_trong_java.bai_tap;

import java.util.Arrays;
import java.util.Date;

public class StopWatch {
    public Date startTime;
    private Date endTime;


    public StopWatch() {
        startTime = new Date();
    }

    public void start() {
        startTime = new Date();
    }

    public void stop() {
        endTime = new Date();
    }

    public long getElapsedTime() {
        return endTime.getTime() - startTime.getTime();
    }
}