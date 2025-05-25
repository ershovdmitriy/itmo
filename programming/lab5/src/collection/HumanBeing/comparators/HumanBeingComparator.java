package collection.HumanBeing.comparators;
import collection.HumanBeing.HumanBeing;
import java.util.Comparator;

/**
 * This class provides a comparator for the HumanBeing class that compares two people
 * based on their natural order using the compareTo method of the HumanBeing class.
 */

public class HumanBeingComparator implements Comparator<HumanBeing>{

    /**
     * Compares two HumanBeing objects based on their natural order using the compareTo method.
     * @param o1 the first HumanBeing object to be compared
     * @param o2 the second HumanBeing object to be compared
     * @return result of comparison in int
     */

    @Override
    public int compare(HumanBeing o1, HumanBeing o2) {
        if (o1 == null) {
            if (o2 == null) {
                return 0;
            } else {
                return -1;
            }
        }
        return o1.compareTo(o2);
    }
}
