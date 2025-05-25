package collectionManagers.validators.humanBeingValidators;

import collectionManagers.validators.Validator;

public class IdValidator implements Validator<Integer>{
    public boolean validate(Integer id){
        return id > 0;
    }
}
