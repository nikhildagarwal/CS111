/*************************************************************************
 *  Compilation:  javac ScenarioAnalysis.java
 *  Execution:    java ScenarioAnalysis
 *
 *  @author:
 *
 *************************************************************************/
public class ScenarioAnalysis {

    // Instance variables
    private Vehicle[] vehicles;       // all vehicless being analyzed 
    private double  gasPrice;         // price of one gallon of gas in dollars
    private double  electricityPrice; // price of 1 kWh in cents of a dollar, c$/kWh

    /*
     * Constructor
     */ 
    public ScenarioAnalysis ( double gasPrice, double electricityPrice ) {
        this.gasPrice = gasPrice;
        this.electricityPrice = electricityPrice;
    }

    /*
     * Updates the price of gas
     * Call computeCO2EmissionsAndCost() whenever there is an update on gas prices
     */
    public void setGasPrice ( double gasPrice ) {
        this.gasPrice = gasPrice;
        computeCO2EmissionsAndCost();
    }

    /*
     * Returns the gas price
     */ 
    public double getGasPrice () {
        return gasPrice;
    }

    /*
     * Updates the price of electricity
     * Call computeCO2EmissionsAndCost() whenever there is an update on electricity prices
     */
    public void setElectricityPrice ( double electricityPrice ) {
        this.electricityPrice = electricityPrice;
    }
    
    /*
     * Returns electricity price
     */
    public double getElectricityPrice () {
        return electricityPrice;
    }

    /*
     * Computes and updates the CO2 emissions, fuel cost and total cost for each 
     * vehicle in the vehicles array.
     */
    public void computeCO2EmissionsAndCost () {
        double a =0;
        double b =0;
        double c =0;
        double d =0;
        double e =0;
        double f =0;
        double g =0;
        double h =0;
        double j =0;
        double k =0;
        double l =0;
        double m =0;
        int carNum = vehicles.length;
        for(int i = 0; i<carNum;i++){
            if(vehicles[i].getFuel().getType() == Fuel.GAS){
                a = vehicles[i].getLease().getNumberOfMonths();
                b = vehicles[i].getLease().getMileageAllowance();
                c = vehicles[i].getFuel().getUsage();
                d = Fuel.CO2EMITTED_GASCOMBUSTION;
                e = ((b*(a/12))/c)*d;
                vehicles[i].setCO2Emission(e);
            }
            if(vehicles[i].getFuel().getType() == Fuel.ELECTRIC){
                f = vehicles[i].getLease().getNumberOfMonths();
                g = vehicles[i].getLease().getMileageAllowance();
                h = vehicles[i].getFuel().getUsage();
                j = Fuel.CO2EMITTED_GENERATEmWh;
                k = vehicles[i].getFuel().getKWhPerCharge();
                l = 0.45/1000;
                m = ((g*(f/12))/h)*k*j*l;
                vehicles[i].setCO2Emission(m);
            }
        }
        double totalG =0;
        double totalE = 0;
        double otherG = 0;
        double otherE = 0;
        double monthlyCostG = 0;
        double monthlyCostE = 0;

        for(int z=0;z<carNum;z++){
            if(vehicles[z].getFuel().getType() == Fuel.GAS){
                a = vehicles[z].getLease().getNumberOfMonths();
                b = vehicles[z].getLease().getMileageAllowance();
                c = vehicles[z].getFuel().getUsage();
                e = ((b*(a/12))/c)*gasPrice;
                vehicles[z].setFuelCost(e);

                monthlyCostG = a*(vehicles[z].getLease().getMonthlyCost())+(vehicles[z].getLease().getDueAtSigning());
                otherG = vehicles[z].getOtherCost();
                totalG = monthlyCostG + otherG +e;
                vehicles[z].setTotalCost(totalG);
            }
            if(vehicles[z].getFuel().getType() == Fuel.ELECTRIC){
                f = vehicles[z].getLease().getNumberOfMonths();
                g = vehicles[z].getLease().getMileageAllowance();
                h = vehicles[z].getFuel().getUsage();
                j = vehicles[z].getFuel().getKWhPerCharge();
                k = electricityPrice/100;
                l = ((g*(f/12))/h)*j*k;
                vehicles[z].setFuelCost(l);

                monthlyCostE = f*(vehicles[z].getLease().getMonthlyCost())+(vehicles[z].getLease().getDueAtSigning());
                otherE = vehicles[z].getOtherCost();
                totalE = monthlyCostE + otherE +l;
                vehicles[z].setTotalCost(totalE);
            }
        }


    }

    /*
     * Returns vehicles array
     */
    public Vehicle[] getVehicles () {
        return vehicles;
    }

    /*
     * Prints all vehicles
     */
    public void printVehicles () {
        for ( Vehicle v : vehicles ) {
            StdOut.println(v);
        }
    }

    /*
     * Populates the array vehicles from file vehicles.txt
     * 
     * File Format: The file can have either gas or electric lines
     * 
     * gas,      name, cash due at signing lease,lease length in months, monthly lease cost, mileage allowance per 12 months, miles per gallon, cost of oil change
     * electric, name, cash due at signing lease,lease length in months, monthly lease cost, mileage allowance per 12 months, miles per kWh/charge, kWh per charge, cost of home charger
     */ 
    public void populateVehicleArray () {
        StdIn.setFile("vehicles.txt");

        // read the number of car models and allocate array
        int numberOfCars = StdIn.readInt();
        vehicles = new Vehicle[numberOfCars];

        for (int i = 0; i < numberOfCars; i++) {
            String fuelType = StdIn.readString();
            String name     = StdIn.readString();

            // Lease information
            double dueAtSigning  = StdIn.readDouble();
            int numberOfMonths = StdIn.readInt();
            double montlyCost  = StdIn.readDouble();
            int mileageAllowance = StdIn.readInt();
            Lease lease = new Lease(dueAtSigning,numberOfMonths,montlyCost,mileageAllowance);

            // Fuel
            double usage = StdIn.readDouble();
            Fuel fuel = null; 
            if ( fuelType.toLowerCase().equals("electric")) {
                double kWhPerCharge = StdIn.readDouble();
                fuel = new Fuel (usage, kWhPerCharge);
            } else {
                fuel = new Fuel (usage);
            }

            // other cost include oil change for gas-powered or home charger for eletric-powered
            double otherCost = StdIn.readDouble();

            // Instatiate the new vehicle
            vehicles[i] = new Vehicle (name, fuel, lease, otherCost);
        }
    }

    /*
     * Test client
     */
    public static void main (String[] args) {
        ScenarioAnalysis sa = new ScenarioAnalysis(3.45, 0.3);
        sa.populateVehicleArray();
        sa.setGasPrice(3);           // $2.23 per gallon of gas
        sa.setElectricityPrice(16.14);  // c$16.14 per kWh
        sa.computeCO2EmissionsAndCost();
        sa.printVehicles();
    }
}
