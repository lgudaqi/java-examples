/**
 * A functional interface that represents
 * the principle of access
 * based on a method that represents
 * whether a code is accepted or denied.
 * @author Linda Gudaqi
 */
@FunctionalInterface
public interface access {

    /**
     * Decides whether access is granted
     * depending on particular implementation.
     * @param code Code to attempt to get access.
     * @return Whether code grants access.
     */
    boolean accessGranted(String code);

}
