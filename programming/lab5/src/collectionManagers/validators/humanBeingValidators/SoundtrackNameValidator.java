package collectionManagers.validators.humanBeingValidators;

import collectionManagers.validators.Validator;

public class SoundtrackNameValidator implements Validator<String> {
    public boolean validate(String soundtrackName){
        return soundtrackName != null;
    }
}
