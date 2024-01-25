package com.bakeryteam.bakeryapp.sql.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class SQLUtils {

/*    public static Map<Integer, String[]> ResultSetToStringArrayMap(ResultSet resultSet) throws SQLException {
        Map<Integer, String[]> strings = new HashMap<>();

        while (resultSet.next()) {
            for(int i = 2; true ; i++) {
                try {
                    str += resultSet.getString(i) + ';';
                } catch (Exception e) {
                    break;
                }
            }

            strings.put(resultSet.getInt("id"), str.split(";"));
        }

        return strings;
    }*/

    public static Map<Integer, String> ResultSetToStringMap(ResultSet resultSet) throws SQLException {
        Map<Integer, String> ret = new HashMap<>();

        while (resultSet.next()) {
            String str = "";

            for(int i = 1; true ; i++) {
                try {
                    str += resultSet.getString(i) + ';';
                } catch (Exception e) {
                    break;
                }
            }

            ret.put(resultSet.getInt("id"), str);
        }

        return ret;
    }

    public static List<String> ResultSetToStringList(ResultSet resultSet) throws SQLException {
        List<String> ret = new ArrayList<>();

        while (resultSet.next()) {
            String str = "";

            for(int i = 1; true ; i++) {
                try {
                    str += resultSet.getString(i) + ';';
                } catch (Exception e) {
                    break;
                }
            }

            ret.add(str);
        }

        return ret;
    }

    public static Set<String> ResultSetToStringHashSet(ResultSet resultSet) throws SQLException {
        Set<String> ret = new HashSet<>();

        while (resultSet.next()) {
            String str = "";

            for(int i = 1; true ; i++) {
                try {
                    str += resultSet.getString(i) + ';';
                } catch (Exception e) {
                    break;
                }
            }

            ret.add(str);
        }

        return ret;
    }
}