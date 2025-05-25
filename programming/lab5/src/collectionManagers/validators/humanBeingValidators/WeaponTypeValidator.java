package collectionManagers.validators.humanBeingValidators;

import collection.HumanBeing.WeaponType;
import collectionManagers.validators.Validator;

public class WeaponTypeValidator implements Validator<WeaponType> {
    public boolean validate(WeaponType weaponType){
        return weaponType != null;
    }
}
