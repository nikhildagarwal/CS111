/*************************************************************************
 *  Compilation:  javac HeartTransplant.java
 *  Execution:    java HeartTransplant < data.txt
 *
 *  @author:
 *
 *************************************************************************/

public class HeartTransplant {

    /* ------ Instance variables  -------- */

    // Person array, each Person is read from the data file
    private Person[] listOfPatients;

    // SurvivabilityByAge array, each rate is read from data file
    private SurvivabilityByAge[] survivabilityByAge;

    // SurvivabilityByCause array, each rate is read from data file
    private SurvivabilityByCause[] survivabilityByCause;

    /* ------ Constructor  -------- */
    
    /*
     * Initializes all instance variables to null.
     */
    public HeartTransplant() {
        Person[] listOfPatients = null;
        SurvivabilityByAge[] survivabilityByAge = null;
        SurvivabilityByCause[] survivabilityByCause = null;
    }

    /* ------ Methods  -------- */

    /*
     * Inserts Person p into listOfPatients
     * 
     * Returns:  0 if successfully inserts p into array, 
     *          -1 if there is not enough space to insert p into array
     */
    public int addPerson(Person p, int arrayIndex) {
        if(arrayIndex <= listOfPatients.length-1){
            listOfPatients[arrayIndex] = p;
            return 0;
        } else {
            return -1;
        }
    }

    /*
     * 1) Creates the listOfPatients array with numberOfLines length.
     * 
     * 2) Reads from the command line data file.
     *    File Format: ID, Ethinicity, Gender, Age, Cause, Urgency, State of health
     *    Each line refers to one Person.
     * 
     * 3) Inserts each person from file into listOfPatients
     *    Hint: uses addPerson() method
     * 
     * Returns the number of patients read from file
     */
    public int readPersonsFromFile(int numberOfLines) {
        listOfPatients = new Person[numberOfLines];
        int count = 0;
        for (int i = 0; i < numberOfLines; i++) {
            int iD = StdIn.readInt();
            int ethnicity = StdIn.readInt();
            int gender = StdIn.readInt();
            int age = StdIn.readInt();
            int cause = StdIn.readInt();
            int urgency = StdIn.readInt();
            int stateOfHealth = StdIn.readInt();
            Person person = new Person (iD, ethnicity, gender, age, cause, urgency, stateOfHealth);
            addPerson(person,i);
            count++;
        }
        return count;
    }

    /*
     * 1) Creates the survivabilityByAge array with numberOfLines length.
     * 
     * 2) Reads from the command line file.
     *    File Format: Age YearsPostTransplant Rate
     *    Each line refers to one survivability rate by age.
     * 
     * 3) Inserts each rate from file into the survivabilityByAge array
     * 
     * Returns the number of survivabilities rates read from file
     */
    public int readSurvivabilityRateByAgeFromFile (int numberOfLines) {
        survivabilityByAge = new SurvivabilityByAge[numberOfLines];
        int countOne = 0;
        for(int j = 0; j< numberOfLines;j++){
            int age = StdIn.readInt();
            int yearsPostTransplant = StdIn.readInt();
            double rate = StdIn.readDouble();
            SurvivabilityByAge sAge = new SurvivabilityByAge(age, yearsPostTransplant, rate);
            survivabilityByAge[j] = sAge;
            countOne++;
        }
        return countOne;
    }

    /*
     * 1) Creates the survivabilityByCause array with numberOfLines length.
     * 
     * 2) Reads from the command line file.
     *    File Format: Cause YearsPostTransplant Rate
     *    Each line refers to one survivability rate by cause.
     * 
     * 3) Inserts each rate from file into the survivabilityByCause array
     * 
     * Returns the number of survivabilities rates read from file
     */
    public int readSurvivabilityRateByCauseFromFile (int numberOfLines) {
        survivabilityByCause = new SurvivabilityByCause[numberOfLines];
        int countTwo = 0;
        for(int k = 0; k< numberOfLines;k++){
            int cause = StdIn.readInt();
            int yearsPostTransplant = StdIn.readInt();
            double rate = StdIn.readDouble();
            SurvivabilityByCause sCause = new SurvivabilityByCause(cause, yearsPostTransplant, rate);
            survivabilityByCause[k] = sCause;
            countTwo++;
        }
        return countTwo;
    }
    
    /*
     * Returns listOfPatients
     */
    public Person[] getListOfPatients() {
        return listOfPatients;
    } 

    /*
     * Returns survivabilityByAge
     */
    public SurvivabilityByAge[] getSurvivabilityByAge() {
        return survivabilityByAge;
    }

    /*
     * Returns survivabilityByCause
     */
    public SurvivabilityByCause[] getSurvivabilityByCause() {
        return survivabilityByCause;
    }

    /*
     * Returns a Person array in which with every Person that has 
     * age above the parameter age from the listOfPatients array.
     * 
     * The return array has to be completely full with no empty
     * spots, that is the array size should be equal to the number
     * of persons with age above the parameter age.
     * 
     * Return null if there is no Person with age above the 
     * parameter age.
     */ 
    public Person[] getPatientsWithAgeAbove(int age) {
        int arrayLength = 0;
        for(int p = 0; p< listOfPatients.length; p++){
            if(listOfPatients[p].getAge() > age){
                arrayLength++;
            }
        }
        Person[] newList = new Person[arrayLength];
        int arrayIndex = 0;
        for(int l = 0; l< listOfPatients.length; l++){
            if(listOfPatients[l].getAge() > age){
                newList[arrayIndex] = listOfPatients[l];
                arrayIndex++;
            }
        }
        if(arrayLength == 0){
            return null;
        } else{
            return newList;
        }
    }
    
    /*
     * Returns a Person array with every Person that has the state of health 
     * equal to the parameter state from the listOfPatients array.
     * 
     * The return array has to be completely full with no empty
     * spots, that is the array size should be equal to the number
     * of persons with the state of health equal to the parameter state.
     * 
     * Return null if there is no Person with the state of health 
     * equal to the parameter state.
     */ 
    public Person[] getPatientsByStateOfHealth(int state) {
        int arrayLengthOne = 0;
        for(int a = 0; a< listOfPatients.length; a++){
            if(listOfPatients[a].getStateOfHealth() == state){
                arrayLengthOne++;
            }
        }
        Person[] newListOne = new Person[arrayLengthOne];
        int arrayIndexOne = 0;
        for(int b = 0; b< listOfPatients.length; b++){
            if(listOfPatients[b].getStateOfHealth() == state){
                newListOne[arrayIndexOne] = listOfPatients[b];
                arrayIndexOne++;
            }
        }
        if(arrayLengthOne == 0){
            return null;
        } else{
            return newListOne;
        }
    }

    /*
     * Returns a Person array with every person that has the heart 
     * condition cause equal to the parameter cause from the listOfPatients array.
     * 
     * The return array has to be completely full with no empty
     * spots, that is the array size should be equal to the number
     * of persons with the heart condition cause equal to the parameter cause.
     * 
     * Return null if there is no Person with the heart condition cause 
     * equal to the parameter cause.
     */ 
    public Person[] getPatientsByHeartConditionCause(int cause) {
        int arrayLengthTwo = 0;
        for(int c = 0; c< listOfPatients.length; c++){
            if(listOfPatients[c].getCause() == cause){
                arrayLengthTwo++;
            }
        }
        Person[] newListTwo = new Person[arrayLengthTwo];
        int arrayIndexTwo = 0;
        for(int b = 0; b< listOfPatients.length; b++){
            if(listOfPatients[b].getCause() == cause){
                newListTwo[arrayIndexTwo] = listOfPatients[b];
                arrayIndexTwo++;
            }
        }
        if(arrayLengthTwo == 0){
            return null;
        } else{
            return newListTwo;
        }
    }

    /*
     * Assume there are numberOfHearts available for transplantation surgery.
     * Also assume that the hearts are of the same blood type as the
     * persons on the listOfPatients.
     * This method finds a set of persons to be the recepients of these
     * hearts.
     * 
     * The method returns a Person array from the listOfPatients
     * array that have the highest potential for survivability after
     * the transplant. The array size is numberOfHearts.
     * 
     * If numberOfHeartsAvailable is greater than listOfPatients
     * array size all Persons will receive a transplant.
     * 
     * If numberOfHeartsAvailable is smaller than listOfPatients
     * array size find the set of people with the highest
     * potential for survivability.
     */ 
    public Person[] match(int numberOfHearts) {
        Person[] listTransplant = new Person[numberOfHearts];
        double[] rate = new double[listOfPatients.length];
        Person[] listNew = new Person[listOfPatients.length];
        for(int i = 0; i< listOfPatients.length;i++){
            for(int j = 0; j<=4;j++){
                if(listOfPatients[i].getCause() == j){
                    for(int k = 0; k<survivabilityByCause.length;k++){
                        if(survivabilityByCause[k].getCause() == j && survivabilityByCause[k].getYears() == 1){
                            rate[i] = survivabilityByCause[k].getRate();
                            listNew[i] = listOfPatients[i];
                        }
                        if(survivabilityByCause[k].getCause() == j && survivabilityByCause[k].getYears() == 3){
                            rate[i] = survivabilityByCause[k].getRate();
                            listNew[i] = listOfPatients[i];
                        }
                        if(survivabilityByCause[k].getCause() == j && survivabilityByCause[k].getYears() == 5){
                            rate[i] = survivabilityByCause[k].getRate();
                            listNew[i] = listOfPatients[i];
                        }

                    }
                }
            }
        }
        double[] newRate = new double[listOfPatients.length];
        Person[] orderList = new Person[listOfPatients.length];
        for(int a = 0; a<newRate.length; a++){
            double placeHolder = 0;
            int order = 0;
            for(int b = 0; b< newRate.length; b++){
                if(rate[b]>placeHolder){
                    placeHolder = rate[b];
                    order = b;
                }
            }
            newRate[a] = placeHolder;
            orderList[a] = listNew[order];
        }
        for(int t = 0; t<numberOfHearts; t++){
            listTransplant[t] = orderList[t];
        }
        if(numberOfHearts == listOfPatients.length){
            return listOfPatients;
        } else{
            return listTransplant;
        }
    }

    /*
     * Client to test the methods you write
     */
    public static void main (String[] args) {

        HeartTransplant ht = new HeartTransplant();

        // read persons from file
        int numberOfLines = StdIn.readInt();
        int numberOfReadings = ht.readPersonsFromFile(numberOfLines);
        StdOut.println(numberOfReadings + " patients read from file.");
 
        // read survivability by age from file
        numberOfLines = StdIn.readInt();
        numberOfReadings = ht.readSurvivabilityRateByAgeFromFile(numberOfLines);
        StdOut.println(numberOfReadings + " survivability rates by age lines read from file.");

        // read survivability by heart condition cause from file        
        numberOfLines = StdIn.readInt();
        numberOfReadings = ht.readSurvivabilityRateByCauseFromFile(numberOfLines);
        StdOut.println(numberOfReadings + " survivability rates by cause lines read from file.");

        // list all patients
        for (Person p : ht.getListOfPatients()) {
            StdOut.println(p);
        }

        // list survivability by age rates
        for (SurvivabilityByAge rate : ht.getSurvivabilityByAge()) {
            StdOut.println(rate);
        }

        // list survivability by cause rates
        for (SurvivabilityByCause rate : ht.getSurvivabilityByCause()) {
            StdOut.println(rate);
        }

    }
}
