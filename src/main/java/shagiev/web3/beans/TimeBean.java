package shagiev.web3.beans;


import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.time.ZonedDateTime;

@ManagedBean
@ApplicationScoped
public class TimeBean implements Serializable {

    private String day;
    private String month;
    private String year;
    private String hour;
    private String min;
    private String sec;

    public String getDay() {
        return format(ZonedDateTime.now().getDayOfMonth());
    }

    public String getMonth() {
        return format(ZonedDateTime.now().getMonthValue());
    }

    public String getYear() {
        return format(ZonedDateTime.now().getYear());
    }

    public String getHour() {
        return format(ZonedDateTime.now().getHour());
    }

    public String getMin() {
        return format(ZonedDateTime.now().getMinute());
    }

    public String getSec() {
        return format(ZonedDateTime.now().getSecond());
    }

    public void setDay(String day) {
    }

    public void setMonth(String month) {
    }

    public void setYear(String year) {
    }

    public void setHour(String hour) {
    }

    public void setMin(String min) {
    }

    public void setSec(String sec) {
    }

    private String format(int val) {
        String day = String.valueOf(val);
        if (day.length() < 2) {
            day = "0" + day;
        }
        return day;
    }
}
