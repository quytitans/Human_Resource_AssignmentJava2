package Human_Resource.Model;

import Human_Resource.Unity.Employee;
import Human_Resource.Util.ConnectionHelper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeModel {

    public static List<Employee> selectEmployeeList() {
        List<Employee> employeeList = new ArrayList<>();
        try {
            Connection cnn = ConnectionHelper.getConnection();
            Statement statement = cnn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM employees");
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");
                String email = resultSet.getString("account");
                String password = resultSet.getString("password");
                long createdAt = resultSet.getLong("createdAt");
                long updatedAt = resultSet.getLong("updatedAt");
                int status = resultSet.getInt("status");
                String account = resultSet.getString("account");
                Employee employee = new Employee(name, address, email, account, password, createdAt, updatedAt, status);
                employeeList.add(employee);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employeeList;
    }

    public static boolean checkExistAccount(String accountChecking) {
        List<Employee> employeeList = selectEmployeeList();
        if (employeeList == null) {
            return false;
        }
        int check = 0;
        for (Employee employee : employeeList
        ) {
            if (employee.getAccount().equals(accountChecking)) {
                check = 1;
                break;
            }
        }
        if (check != 0) {
            return true;
        }
        return false;
    }


    public static boolean register(Employee employeeInput) {
        try {
            //kiem tra xem ten dang ki da ton tai chua
            if (checkExistAccount(employeeInput.getAccount())){
                return false;
            }
            Connection cnn = ConnectionHelper.getConnection();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("INSERT INTO employees");
            stringBuilder.append(" (name, address, email, account, password, createdAt, updatedAt, status) ");
            stringBuilder.append("VALUES (?,?,?,?,?,?,?,?)");
            PreparedStatement preparedStatement = cnn.prepareStatement(stringBuilder.toString());
            preparedStatement.setString(1, employeeInput.getName());
            preparedStatement.setString(2, employeeInput.getAddress());
            preparedStatement.setString(3, employeeInput.getEmail());
            preparedStatement.setString(4, employeeInput.getAccount());
            preparedStatement.setString(5, employeeInput.getPassword());
            preparedStatement.setLong(6, employeeInput.getCreatedAt());
            preparedStatement.setLong(7, employeeInput.getUpdatedAt());
            preparedStatement.setInt(8, employeeInput.getStatus());
            preparedStatement.execute();
            return true;
        } catch (SQLException throwables) {
            return false;
        }
    }
}
