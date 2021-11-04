package shagiev.web3.beans;

import shagiev.web3.data.*;
import shagiev.web3.database.DatabaseConnector;
import shagiev.web3.database.DatabaseManager;
import shagiev.web3.managers.AreaChecker;
import shagiev.web3.managers.OptionAreaChecker;
import shagiev.web3.managers.OptionValidator;
import shagiev.web3.managers.Validator;
import shagiev.web3.util.LoginGetter;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@ManagedBean
@ApplicationScoped
public class AreaCheckBean implements Serializable {

    private final HistoryManager historyManager;
    private final AreaChecker areaChecker;
    private final Validator validator;
    private DatabaseManager databaseManager;

    public AreaCheckBean() {
        historyManager = new HistoryManager();
        areaChecker = new OptionAreaChecker();
        validator = new OptionValidator();
        DatabaseConnector connector;
        String[] dbinfo = LoginGetter.getLoginInfo("dbinfo");
        if (dbinfo != null) {
            connector = new DatabaseConnector(dbinfo[0], Integer.parseInt(dbinfo[1]), dbinfo[3], dbinfo[4], dbinfo[5]);
            Connection connection = null;
            try {
                connection = connector.getConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (connection != null) {
                databaseManager = new DatabaseManager(connection);
            }
        }
    }

    private String x;
    private String y;
    private String r;

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

//            historyManager.addResult(result);
            try {
                databaseManager.addNewResult(result);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Result> getHistory() {
//        return historyManager.getHistory();
        List<Result> list = null;
        try {
            list = databaseManager.getHistory();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
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
