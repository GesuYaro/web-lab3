package shagiev.web3.data;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class HistoryManager implements Serializable {

    private List<Result> history;

    public HistoryManager() {
        this.history = new LinkedList<>();
    }

    public void addResult(Result newResult) {
        history.add(newResult);
    }

    public List<Result> getHistory() {
        return history;
    }

    public void setHistory(List<Result> history) {
        this.history = history;
    }

}
