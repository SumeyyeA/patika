import java.util.ArrayList;
import java.util.Date;
import java.util.TreeSet;

// Address interface
interface Address {
    void setAddress(String address);
    String getAddress();
}

// HomeAddress class implementing Address interface
class HomeAddress implements Address {
    private String address;

    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String getAddress() {
        return address;
    }
}

// BusinessAddress class implementing Address interface
class BusinessAddress implements Address {
    private String address;

    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String getAddress() {
        return address;
    }
}

// Insurance abstract class
abstract class Insurance {
    private String name;
    private double cost;
    private Date startDate;
    private Date endDate;

    public Insurance(String name, double cost, Date startDate, Date endDate) {
        this.name = name;
        this.cost = cost;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public abstract double calculate();

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }
}

// HealthInsurance class extending Insurance
class HealthInsurance extends Insurance {
    public HealthInsurance(String name, double cost, Date startDate, Date endDate) {
        super(name, cost, startDate, endDate);
    }

    @Override
    public double calculate() {
        // Perform specific calculation for health insurance
        // Implement your calculation logic here
        return getCost() * 0.9; // Apply a discount of 10%
    }
}

// ResidenceInsurance class extending Insurance
class ResidenceInsurance extends Insurance {
    public ResidenceInsurance(String name, double cost, Date startDate, Date endDate) {
        super(name, cost, startDate, endDate);
    }

    @Override
    public double calculate() {
        // Perform specific calculation for residence insurance
        // Implement your calculation logic here
        return getCost() * 1.2; // Apply a markup of 20%
    }
}

// TravelInsurance class extending Insurance
class TravelInsurance extends Insurance {
    public TravelInsurance(String name, double cost, Date startDate, Date endDate) {
        super(name, cost, startDate, endDate);
    }

    @Override
    public double calculate() {
        // Perform specific calculation for travel insurance
        // Implement your calculation logic here
        return getCost() * 1.1; // Apply a markup of 10%
    }
}

// CarInsurance class extending Insurance
class CarInsurance extends Insurance {
    public CarInsurance(String name, double cost, Date startDate, Date endDate) {
        super(name, cost, startDate, endDate);
    }

    @Override
    public double calculate() {
        // Perform specific calculation for car insurance
        // Implement your calculation logic here
        return getCost() * 1.3; // Apply a markup of 30%
    }
}

// User class
class User {
    private String name;
    private String surname;
    private String email;
    private String password;
    private String profession;
    private int age;
    private ArrayList<Address> addressList;
    private Date lastLoginDate;

    public User(String name, String surname, String email, String password, String profession, int age) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.profession = profession;
        this.age = age;
        this.addressList = new ArrayList<>();
        this.lastLoginDate = new Date();
    }

    public void addAddress(Address address) {
        addressList.add(address);
    }

    public void removeAddress(Address address) {
        addressList.remove(address);
    }

    public void showUserInfo() {
        System.out.println("Name: " + name);
        System.out.println("Surname: " + surname);
        System.out.println("Email: " + email);
        System.out.println("Profession: " + profession);
        System.out.println("Age: " + age);
        System.out.println("Last Login Date: " + lastLoginDate);
        System.out.println("Address List: ");
        for (Address address : addressList) {
            System.out.println(address.getAddress());
        }
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}

// Account abstract class
abstract class Account implements Comparable<Account> {
    private AuthenticationStatus authenticationStatus;
    private User user;
    private ArrayList<Insurance> insuranceList;

    public Account(User user) {
        this.authenticationStatus = AuthenticationStatus.FAIL;
        this.user = user;
        this.insuranceList = new ArrayList<>();
    }

    public enum AuthenticationStatus {
        SUCCESS, FAIL
    }

    public abstract void addInsurance(Insurance insurance);

    public AuthenticationStatus login(String email, String password) throws InvalidAuthenticationException {
        if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
            authenticationStatus = AuthenticationStatus.SUCCESS;
        } else {
            throw new InvalidAuthenticationException();
        }
        return authenticationStatus;
    }

    public void showAccountType() {
        System.out.println("Account Type: " + this.getClass().getSimpleName());
    }

    public User getUser() {
        return user;
    }

    public ArrayList<Insurance> getInsuranceList() {
        return insuranceList;
    }

    @Override
    public int compareTo(Account otherAccount) {
        return user.getEmail().compareTo(otherAccount.getUser().getEmail());
    }

    @Override
    public int hashCode() {
        return user.getEmail().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Account otherAccount = (Account) obj;
        return user.getEmail().equals(otherAccount.getUser().getEmail());
    }
}

// Individual class extending Account
class Individual extends Account {
    public Individual(User user) {
        super(user);
    }

    @Override
    public void addInsurance(Insurance insurance) {
        getInsuranceList().add(insurance);
    }
}

// Enterprise class extending Account
class Enterprise extends Account {
    public Enterprise(User user) {
        super(user);
    }

    @Override
    public void addInsurance(Insurance insurance) {
        getInsuranceList().add(insurance);
    }
}

// InvalidAuthenticationException class
class InvalidAuthenticationException extends Exception {
    public InvalidAuthenticationException() {
        super("Invalid email or password.");
    }
}

// AddressManager class
class AddressManager {
    public static void addAddress(User user, Address address) {
        user.addAddress(address);
    }

    public static void removeAddress(User user, Address address) {
        user.removeAddress(address);
    }
}

// AccountManager class
class AccountManager {
    private TreeSet<Account> accountList;

    public AccountManager() {
        this.accountList = new TreeSet<>();
    }

    public void addAccount(Account account) {
        accountList.add(account);
    }

    public Account login(String email, String password) {
        for (Account account : accountList) {
            try {
                if (account.login(email, password) == Account.AuthenticationStatus.SUCCESS) {
                    return account;
                }
            } catch (InvalidAuthenticationException e) {
                System.out.println(e.getMessage());
                return null;
            }
        }
        return null;
    }
}

public class InsuranceManagementSystem {
    public static void main(String[] args) {
        // Create User
        User user = new User("John", "Doe", "john.doe@example.com", "password", "Engineer", 30);

        // Create Address
        Address homeAddress = new HomeAddress();
        homeAddress.setAddress("123 Main St, City");
        Address businessAddress = new BusinessAddress();
        businessAddress.setAddress("456 Business Rd, City");

        // Add addresses to user
        AddressManager.addAddress(user, homeAddress);
        AddressManager.addAddress(user, businessAddress);

        // Create Insurance
        Insurance healthInsurance = new HealthInsurance("Health Insurance", 1000.0, new Date(), new Date());
        Insurance residenceInsurance = new ResidenceInsurance("Residence Insurance", 2000.0, new Date(), new Date());

        // Create Individual Account
        Account individualAccount = new Individual(user);
        individualAccount.addInsurance(healthInsurance);
        individualAccount.addInsurance(residenceInsurance);

        // Create Account Manager
        AccountManager accountManager = new AccountManager();
        accountManager.addAccount(individualAccount);

        // Perform login
        Account loggedInAccount = accountManager.login("john.doe@example.com", "password");
        if (loggedInAccount != null) {
            loggedInAccount.showAccountType();
            loggedInAccount.getUser().showUserInfo();
        }
    }
}
