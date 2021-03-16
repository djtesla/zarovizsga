package hu.nive.ujratervezes.zarovizsga.workhours;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WorkHours {

    public String minWork(String file) {
        try (BufferedReader reader = Files.newBufferedReader(Path.of(file))) {
            List<WorkPerDayReport> report = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                report.add(getWorkPerDayReportPerLine(line));
            }
            Collections.sort(report);
            WorkPerDayReport reportOfMinWork = report.get(0);
            return reportOfMinWork.getName() + ": " + reportOfMinWork.getDate();

        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file");
        }
    }


    private WorkPerDayReport getWorkPerDayReportPerLine(String line) {
        String[] lineData =  line.split(",");
        String name = lineData[0];
        int hoursOfWork = Integer.parseInt(lineData[1]);
        String date = lineData[2];
        return new WorkPerDayReport(name, hoursOfWork, date);
    }
}
