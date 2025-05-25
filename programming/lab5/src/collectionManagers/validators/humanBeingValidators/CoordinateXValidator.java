package collectionManagers.validators.humanBeingValidators;

import collectionManagers.validators.Validator;

public class CoordinateXValidator implements Validator<Double> {
    public boolean validate(Double x){
        return x != null;
    }
}
