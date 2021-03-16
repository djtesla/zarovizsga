package hu.nive.ujratervezes.zarovizsga.workhours;

public class WorkPerDayReport implements Comparable<WorkPerDayReport>{

    private String name;
    private int hoursOfWork;
    private String date;

    public WorkPerDayReport(String name, int hoursOfWork, String date) {
        this.name = name;
        this.hoursOfWork = hoursOfWork;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public int getHoursOfWork() {
        return hoursOfWork;
    }

    public String getDate() {
        return date;
    }

    @Override
    public int compareTo(WorkPerDayReport anotherWorkPerDayReport) {
        return this.hoursOfWork - anotherWorkPerDayReport.hoursOfWork;
    }
}
