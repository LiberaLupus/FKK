package sample.AbstractClasses;

import sample.Functions.DBManager;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class IDHelper {

    private static Integer KarteienID = 0;

    public void setKarteienID(String Karteiname) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        DBManager DBHelper = new DBManager();
        List<Integer> Liste01 = new ArrayList<Integer>();
        Liste01 = (List<Integer>) DBHelper.Select01("select * from Karteien where Name ='" + Karteiname +"';","ID");
        KarteienID = Liste01.get(0);
    }

    public Integer getKarteienID(){
         return KarteienID;
    }
}
