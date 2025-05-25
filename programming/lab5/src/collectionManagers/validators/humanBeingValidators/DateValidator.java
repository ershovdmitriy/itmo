package collectionManagers.validators.humanBeingValidators;

import collectionManagers.validators.Validator;

import java.util.Date;

public class DateValidator implements Validator<Date> {
    public boolean validate(Date date){
        return date != null;
    }
}
