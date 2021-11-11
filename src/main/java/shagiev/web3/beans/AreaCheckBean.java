package shagiev.web3.beans;

import shagiev.web3.data.*;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@ManagedBean
@ApplicationScoped
public class AreaCheckBean implements Serializable {

    private final History history = new History();
    private final AreaChecker areaChecker = new OptionAreaChecker();
    private final Validator validator = new OptionValidator();

    private String x;
    private String y;
    private String r = "3";

    private boolean isXCorrect = true;
    private boolean isYCorrect = true;
    private boolean isRCorrect = true;

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    public String getR() {
        return r;
    }

    public void setR(String r) {
        this.r = r;
    }

    public void submit() {
        long start = System.nanoTime();

        Double numX = validator.validateX(x);
        Double numY = validator.validateY(y);
        Double numR = validator.validateR(r);

        if (numX == null) {

            isXCorrect = false;
        } else {
            isXCorrect = true;
        }

        if (numY == null) {
            isYCorrect = false;
        } else {
            isYCorrect = true;
        }

        if (numR == null) {
            isRCorrect = false;
        } else {
            isRCorrect = true;
        }

        if (isXCorrect && isYCorrect && isRCorrect) {
            Result result = new Result(numX, numY, numR,
                    new SimpleDateFormat("HH:mm:ss dd.MM.yyyy").format(Calendar.getInstance().getTime()),
                    System.nanoTime() - start,
                    areaChecker.check(numX, numY, numR));

            history.addResult(result);
        }
    }

    public List<Result> getHistory() {
        return history.getHistory();
    }

    public List<Result> getReversedHistory() {
        List<Result> copy = new LinkedList<>(history.getHistory());
        Collections.reverse(copy);
        return copy;
    }

    public boolean isXCorrect() {
        return isXCorrect;
    }

    public boolean isYCorrect() {
        return isYCorrect;
    }

    public boolean isRCorrect() {
        return isRCorrect;
    }
}
