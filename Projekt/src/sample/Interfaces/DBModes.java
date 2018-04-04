package sample.Interfaces;

import java.util.List;

public interface DBModes {
    public List<String> Select(String SQLQuery);

    public void Insert(String SQLQuery);

    public void Delete(String SQLQuery);

    public void Update(String SQLQuery);

}
