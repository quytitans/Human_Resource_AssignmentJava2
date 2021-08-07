package Human_Resource.Unity;

import Human_Resource.Util.MilisecToDateTime;

import java.util.Calendar;

public class Employee {
    String name;
    String address;
    String email;
    String account;
    String password;
    long createdAt;
    long updatedAt;
    int status;

    public Employee() {
    }

    public Employee(String name, String address, String email, String account, String password, long createdAt, long updatedAt, int status) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.account = account;
        this.password = password;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.status = status;
    }

    public Employee(String name, String address, String email, String account, String password) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.account = account;
        this.password = password;
        this.createdAt = Calendar.getInstance().getTimeInMillis();
        this.updatedAt = Calendar.getInstance().getTimeInMillis();
        this.status = 1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public String getCreatedAtString() {
        return MilisecToDateTime.convertToDateTime(createdAt);
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public long getUpdatedAt() {
        return updatedAt;
    }

    public String getUpdatedAtString() {
        return MilisecToDateTime.convertToDateTime(updatedAt);
    }

    public void setUpdatedAt(long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getStatus() {
        return status;
    }

    public String getStatusString() {
        String getStatusString = null;
        if (this.status == 1) {
            getStatusString = "active";
        } else if (this.status == 0) {
            getStatusString = "deactive";
        }
        return getStatusString;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format("|%5s%15s%5s|%5s%20s%5s|%5s%25s%5s|%5s%20s%5s|%5s%15s%10s|%5s%20s%5s|",
                "", this.account, "",
                "", this.name, "",
                "", this.address, "",
                "", this.getCreatedAtString(), "",
                "", this.getUpdatedAtString(), "",
                "", this.getStatusString(), ""
        );
    }
}
