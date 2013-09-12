package sample;

import org.joda.time.DateTime;

/**
 *
 * @author Rajith
 */
public class Interpreter {

    private DateTime birthday;
    private boolean voter;
    private String gender;

    public void interpret(NICProp nicProp) {
        //the interpretting logic is inserted here
        int year = Integer.parseInt(nicProp.getId().substring(0, 2));
        year += 1900;
        int day = Integer.parseInt(nicProp.getId().substring(2, 5));
        if (day > 500) {
            gender = "Female";
            day-=500;
        } else {
            gender = "Male";
        }

        DateTime tempDate = new DateTime(year, 1, 1, 0, 0);
        day--;      //this minus one is added as the counting starts from the first day of the respective year

        if (!tempDate.year().isLeap() && day > 59) {
            day--;
        }

        birthday = tempDate.plusDays(day);

        DateTime votingEligibility = new DateTime().minusYears(18);

        if (birthday.isBefore(votingEligibility)) {
            voter = true;
        } else {
            voter = false;
        }
    }

    public NICProp createNICProp(String id) throws InvalidNICPropException {

        NICProp tempNicProp = new NICProp(id);
        if (validate(tempNicProp)) {
            return tempNicProp;
        } else {
            throw new InvalidNICPropException();
        }

    }

    public boolean validate(NICProp nicProp) {

        if (nicProp.getId().length() != 10) {
            return false;
        }
        try {
            Long.parseLong(nicProp.getId().substring(0, 9));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public DateTime getBirthday() {
        return birthday;
    }

    public boolean isVoter() {
        return voter;
    }

    public String getGender() {
        return gender;
    }
}
