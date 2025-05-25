package collectionManagers.validators.humanBeingValidators;

import collectionManagers.validators.Validator;

public class RealHeroValidator implements Validator<Boolean> {
    public boolean validate(Boolean realHero){
        return realHero != null;
    }
}
