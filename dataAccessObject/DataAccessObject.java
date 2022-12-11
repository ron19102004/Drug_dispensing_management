package dataAccessObject;

import java.util.ArrayList;

public interface DataAccessObject<R> {
    public void create(R r);
    public ArrayList<R>  selectAll();
    public void delete(R r);
    public void update(R r);
    public ArrayList<R> selectThrowCondition(String condition);
}
