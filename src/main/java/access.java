/**
 * A functional interface that represents
 * the principle of access
 * based on a method that represents
 * whether a code is accepted or denied.
 * @author Linda Gudaqi
 */
@FunctionalInterface
public interface access {

    boolean accessGranted(String code);

}
