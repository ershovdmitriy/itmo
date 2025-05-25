package collectionManagers.validators.humanBeingValidators;

import collectionManagers.validators.Validator;
import collection.HumanBeing.Car;

public class CarValidator implements Validator<Car> {
    public boolean validate(Car car){
        return car != null;
    }
}
