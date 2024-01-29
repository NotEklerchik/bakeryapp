package com.bakeryteam.bakeryapp.sql;

import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.util.*;

public class SuppliesTableController extends AbstractTableController {

    public static void insertNewSupplies(int supplierID, HashMap<Integer, Integer> IDAndCountMap, HashMap<Integer, Float> IDAndCostMap) throws SQLException {
        String querySupplies = "INSERT INTO 'Supplies' ('Date', 'IDSupplier') VALUES ('%s', '%s')";
        String queryIngSup = "";

        executeUpdateStatement(String.format(querySupplies, LocalDate.now(), supplierID));

        String lastSuppliesID = executeQueryStatement("SELECT ID FROM 'Supplies' LIMIT 1").getString("ID");

        for (int id = 1; IDAndCountMap.containsKey(id) && IDAndCostMap.containsKey(id); id++) {
            queryIngSup += String.format(
                    "INSERT INTO 'IngSup' ('IDing', 'IDSup', 'count', 'cost') VALUES ('%s', '%s', '%s', '%s');",
                    id,
                    lastSuppliesID,
                    IDAndCountMap.get(id).toString(),
                    IDAndCostMap.get(id).toString()
            );
        }

        executeUpdateStatement(querySupplies);
    }

}
