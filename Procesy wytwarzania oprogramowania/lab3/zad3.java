
public class User {

    public String userName;
    protected String login;
    private String pwdHash;
    UserService service;

    User(String userName, String login, String pwd) {
        this.useNname = username;
        this.login = login;
        this.pwdHash = SHA256.hash(pwd);
    }

    public void logIn() {
        if (pwdHash = SHA256.hash(pwd)) {
            service.logIn(username, pwdHash);
        }
    }

    public void logOut() {
        service.logOut(username);
    }
}

public class SuperUser extends User {

    private double age;
    private String userName;
    private String login;
    public double[] permissions;

    SuperUser(String userName, String login, String pwd) {
        this.useNname = username;
        this.login = login;
        this.pwdHash = SHA512.hash(pwd);
    }

    public void setPermissions(double[] perms) {
        permissions = perms;
    }

    public double[] getPermissions() {
        return permissions;
    }

    public void logIn() {
        if (pwdHash = SHA256.hash(pwd)) {
            service.logIn(username, String.toUpperCase(pwdHash));
        }
    }

    public void logOut() {
        service.logOutWithPwd(username,
                String.toUpperCase(pwdHash));
    }
}

public class Admin extends User {

    private double age;
    private String userName;
    private String login;
    private boolean loggedIn = false;
    public double[] permissions;

    Admin(String userName, String login, String pwd) {
        this.useNname = username;
        this.login = “Admin” + login;
        this.pwdHash = SHA1.hash(pwd);
    }

    public void setPermissions(double[] perms) {
        System.out.println(
        “Set permissions
        ”);
permissions = perms;
    }

    public double getPermission(int index) {
        return permissions.get(index);
    }

    public void logIn() {
        if (pwdHash = SHA256.hash(pwd)) {
            service.logIn(username, String.toUpperCase(pwdHash));
            loggedIn = true;
        }
    }

    public void logOut() {
        service.logOutWithPwd(username, String.toUpperCase(pwdHash));
        loggedIn = false;
    }
}

public class User {

    protected String userName;
    protected String login;
    protected String pwdHash;
    protected UserService service;

    public User(String userName, String login, String pwd, UserService service) {
        this.userName = userName;
        this.login = login;
        this.pwdHash = SHA256.hash(pwd);
        this.service = service;
    }

    public void logIn(String pwd) {
        if (pwdHash.equals(SHA256.hash(pwd))) {
            service.logIn(userName, pwdHash);
        }
    }

    public void logOut() {
        service.logOut(userName);
    }
}

// SuperUser używa tej samej logiki logowania co User
public class SuperUser extends User {

    private double age;
    private double[] permissions;

    public SuperUser(String userName, String login, String pwd, UserService service) {
        super(userName, login, pwd, service);
    }

    public void setPermissions(double[] perms) {
        this.permissions = perms;
    }

    public double[] getPermissions() {
        return permissions;
    }
}

// Admin używa tej samej logiki logowania co User
public class Admin extends User {

    private double age;
    private boolean loggedIn = false;
    private double[] permissions;

    public Admin(String userName, String login, String pwd, UserService service) {
        super(userName, "Admin" + login, pwd, service);
    }

    public void setPermissions(double[] perms) {
        System.out.println("Set permissions");
        this.permissions = perms;
    }

    public double getPermission(int index) {
        return permissions[index];
    }

    @Override
    public void logIn(String pwd) {
        super.logIn(pwd);
        if (pwdHash.equals(SHA256.hash(pwd))) {
            loggedIn = true;
        }
    }

    @Override
    public void logOut() {
        super.logOut();
        loggedIn = false;
    }
}
