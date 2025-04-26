package db;

import model.Student;

import java.util.ArrayList;
import java.util.List;

public class DBConnection {
    private static DBConnection instance;
    List<Student> studentList;
    private DBConnection(){
        studentList=new ArrayList<>();
    }
    public List<Student> getConnection(){
        return studentList;
    }
    public static DBConnection getInstance(){
        return  instance==null?instance=new DBConnection():instance;
    }
}
