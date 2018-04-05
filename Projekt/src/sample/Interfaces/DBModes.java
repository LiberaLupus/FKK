package sample.Interfaces;

import java.util.List;

public interface DBModes <T> {
    public List<Integer> Select01(String SQLQuery, String Attribut);

    public List<String> Select02(String SQLQuery, String Attribut);

    public void Insert1(String SQLQuery,String Value);

    public void Insert2(String SQLQuery,String Value1, String Value2, Integer Value3);

    public void Delete(String SQLQuery);

    public void Update(String SQLQuery);

}
