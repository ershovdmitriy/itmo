package collectionManagers.validators.humanBeingValidators;

import collection.HumanBeing.Coordinates;
import collectionManagers.validators.Validator;

public class CoordinatesValidator implements Validator<Coordinates> {
    public boolean validate(Coordinates coordinates){
        return coordinates != null && new CoordinateXValidator().validate(coordinates.getX());
    }
}
