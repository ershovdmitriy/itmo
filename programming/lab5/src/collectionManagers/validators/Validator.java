package collectionManagers.validators;

public interface Validator<T> {
    boolean validate(T value);
}