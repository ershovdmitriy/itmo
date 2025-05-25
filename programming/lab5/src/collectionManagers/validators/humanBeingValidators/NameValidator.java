package collectionManagers.validators.humanBeingValidators;

import collectionManagers.validators.Validator;

public class NameValidator implements Validator<String>{
    public boolean validate(String name){
        return name != null && !name.isBlank();
    }
}
