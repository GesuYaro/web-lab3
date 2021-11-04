package shagiev.web3.database;

import shagiev.web3.data.Result;

import java.sql.*;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class DatabaseManager {

    private final Connection connection;

    private static final String ADD = "INSERT INTO web_results VALUES (?, ?, ?, ?, ?, ?)";
    private static final String GET_ALL = "SELECT result, x, y, r, time, execution_time FROM web_results";

    public DatabaseManager(Connection connection) {
        this.connection = connection;
    }

    public int addNewResult(Result result) throws SQLException {
        int rows = 0;
        PreparedStatement addStatement = connection.prepareStatement(ADD);
        addStatement.setBoolean(1, result.isResult());
        addStatement.setFloat(2, (float) result.getX());
        addStatement.setFloat(3, (float) result.getY());
        addStatement.setFloat(4, (float) result.getR());
        addStatement.setDate(5, Date.valueOf(result.getCurrentTime()));
        addStatement.setInt(6, (int) result.getExecutionTime());
        rows = addStatement.executeUpdate();
        return rows;
    }

    public List<Result> getHistory() throws SQLException {
        List<Result> list = new LinkedList<>();
        PreparedStatement getAllStatement = connection.prepareStatement(GET_ALL);
        ResultSet resultSet = getAllStatement.executeQuery();
        while (resultSet.next()) {
            boolean res = resultSet.getBoolean("result");
            double x = resultSet.getFloat("x");
            double y = resultSet.getFloat("y");
            double r = resultSet.getFloat("r");
            Date time = resultSet.getDate("time");
            long execution_time = resultSet.getInt("execution_time");
            list.add(new Result(x, y, r, time.toString(), execution_time, res));
        }
        return list;
    }
}
