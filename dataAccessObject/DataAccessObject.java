package dataAccessObject;

import java.util.ArrayList;

public interface DataAccessObject<R> {
    public int create(R r);
    public ArrayList<R>  selectAll();
    public int delete(R r);
    public int update(R r);
    public ArrayList<R> selectThrowCondition(String condition);
}
