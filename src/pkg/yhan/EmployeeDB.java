package pkg.yhan;

import java.util.ArrayList;

public class EmployeeDB
{
    private ArrayList employees;

    public void update(ArrayList list) {
        this.employees = list;
    }
    public ArrayList find(String query) {
        return employees;
    }
}
