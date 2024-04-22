/**
 * Simulates an application
 * focusing on a login-function.
 * @author Linda Gudaqi
 */
public class application {

    /**
     * Contains the constraint(s) for the login-code
     * in the form of an access-implementation.
     */
    private final access appAccess;

    /**
     * Contains whether the user is currently logged in.
     */
    private boolean loginStatus;

    /**
     * Creates an application-object
     * with the given access-implementation
     * as the login-code restraint.
     * @param appAccess Defines which requirements
     *                  the code has to meet to allow login.
     */
    public application(access appAccess) {
        this.appAccess = appAccess;
        this.loginStatus = false;
    }

    /**
     * Attempts to log in to the application
     * with the given code and prints a message
     * regarding the status of the attempt.
     * @param code Code to attempt login.
     * @return Whether code allows login.
     */
    public boolean login(String code) {
        boolean isGranted = appAccess.accessGranted(code);
        if(isGranted && !loginStatus) {
            loginStatus = true;
            System.out.println("Login successful!");
        } else if(isGranted && loginStatus) {
            System.out.println("Already logged in.");
        } else if(!isGranted){
            System.out.println("Login failed.");
        }
        return isGranted;
    }

    /**
     * Application-objects are defined
     * by their access-implementation.
     * @return hashCode of the application-object.
     */
    @Override
    public int hashCode() {
        return appAccess.hashCode();
    }

    /**
     * Logs the user out and prints a message
     * regarding the status of the logout.
     * @return Whether user is logged out.
     */
    public boolean logout() {
        if(loginStatus) {
            loginStatus = false;
            System.out.println("Logout successful.");
        } else {
            System.out.println("Already logged out.");
        }
        return !loginStatus;
    }

    /**
     * Illustrates the functions of the
     * class application.
     * @param args Not used.
     */
    public static void main(String[] args) {
        application sampleApp
                = new application(code -> code.length() == 3);

        sampleApp.login("1A3");
        sampleApp.logout();
        sampleApp.logout();
        sampleApp.login("ABCD");
        sampleApp.login("A12");
        sampleApp.login("234");
    }
}

