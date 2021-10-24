package shagiev.web3.beans;

import shagiev.web3.data.Result;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

@ManagedBean
@ApplicationScoped
public class HistoryBean implements Serializable {

    private List<Result> history;
    private Result newResult;

    public HistoryBean() {
        this.history = new LinkedList<>();
        this.newResult = new Result();
    }

    public void addResult() {
        history.add(newResult);
        newResult = new Result();
    }

    public List<Result> getHistory() {
        return history;
    }

    public void setHistory(List<Result> history) {
        this.history = history;
    }

    public Result getNewResult() {
        return newResult;
    }

    public void setNewResult(Result newResult) {
        this.newResult = newResult;
    }
}
