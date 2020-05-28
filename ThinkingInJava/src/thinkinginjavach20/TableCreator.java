// 13
// {Args: thinkinginjavach20.Member}
package thinkinginjavach20;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class TableCreator {
    public static void main(String[] args2) throws ClassNotFoundException {
        String[] args = {"thinkinginjavach20.Member"};
        if (args.length < 1) {
            System.out.println("argements: annotated classes");
            System.exit(0);
        }
        for (String className : args) {
            Class<?> cl = Class.forName(className);
            DBTable dbTable = cl.getAnnotation(DBTable.class);
            if (dbTable == null) {
                System.out.println("No DBTable annotation in class " + className);
                continue;
            }
            String tableName = dbTable.name();
            // Если не указано имя, использовать имя Class
            if (tableName.length() < 1) {
                tableName = cl.getName().toUpperCase();
            }
            List<String> columnDefs = new ArrayList<>();
            for (Field field : cl.getDeclaredFields()) {
                String columnName = null;
                Annotation[] anns = field.getDeclaredAnnotations();
                if (anns.length < 1) {
                    continue; // Не является столбцом таблицы базы данных
                }
                if (anns[0] instanceof SQLInteger) {
                    SQLInteger sInt = (SQLInteger)anns[0];
                    // Использовать имя поля, если не указано имя
                    if (sInt.name().length() < 1) {
                        columnName = field.getName().toUpperCase();
                    } else {
                        columnName = sInt.name();
                    }
                    columnDefs.add(columnName + " INT" + getConstraints(sInt.constraints()));
                }
                 if (anns[0] instanceof SQLString) {
                    SQLString sString = (SQLString)anns[0];
                    // Использовать имя поля, если не указано имя
                    if (sString.name().length() < 1) {
                        columnName = field.getName().toUpperCase();
                    } else {
                        columnName = sString.name();
                    }
                    columnDefs.add(columnName + " VARCHAR(" + sString.value() +
                                   ")"+ getConstraints(sString.constraints()));
                }
                 StringBuilder createCommand = new StringBuilder(
                         "CREATE TABLE " + tableName + "(");
                 for (String columnDef : columnDefs) {
                     createCommand.append("\n    " + columnDef + ",");
                 }
                 // Удалить завершающую запятую
                 String tableCreate = createCommand.substring(0, createCommand.length() - 1) + ");";
                 System.out.println("Table Creation SQL for " + className + " is :\n" + tableCreate);
            }
        }
    }

    private static String getConstraints(Constraints con) {
        String constraints = "";
        if (!con.allowNUll())
            constraints += " NOT NULL";
        if (!con.primaryKey())
            constraints += " PRIMARY KEY";
        if (!con.unique())
            constraints += " UNIQUE";
        return constraints;
    }
}
/*
Table Creation SQL for thinkinginjavach20.Member is :
CREATE TABLE MEMBER(
    FIRSTNAME VARCHAR(30) PRIMARY KEY UNIQUE);
Table Creation SQL for thinkinginjavach20.Member is :
CREATE TABLE MEMBER(
    FIRSTNAME VARCHAR(30) PRIMARY KEY UNIQUE,
    LASTNAME VARCHAR(50) PRIMARY KEY UNIQUE);
Table Creation SQL for thinkinginjavach20.Member is :
CREATE TABLE MEMBER(
    FIRSTNAME VARCHAR(30) PRIMARY KEY UNIQUE,
    LASTNAME VARCHAR(50) PRIMARY KEY UNIQUE,
    AGE INT PRIMARY KEY UNIQUE);
Table Creation SQL for thinkinginjavach20.Member is :
CREATE TABLE MEMBER(
    FIRSTNAME VARCHAR(30) PRIMARY KEY UNIQUE,
    LASTNAME VARCHAR(50) PRIMARY KEY UNIQUE,
    AGE INT PRIMARY KEY UNIQUE,
    HANDLE VARCHAR(30) UNIQUE);
*/