import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

class Config {

//    static String[] alternatives = new String[]{"End Device", "Fog Node", "Cloud"};
    static List<String> alternatives = new ArrayList<String>();

    // Set your criteria here
    static String[] criteria = new String[]{"Network Bandwidth", "CPU Speed", "VM Utilisation", "Energy Efficiency", "Cost"};

    // Set true for benefit criterion, false for cost criterion
    static boolean[] costCriteria = new boolean[]{false, false, false, false, true}; // price is cost

    static Double[] ahpWeights = new Double[Config.criteria.length];

    // AHP criteria weights in respect to each other

    static final Double NETWORKBANDWIDTH_CPUSPEED = 1.0;
    static final Double NETWORKBANDWIDTH_VMUTILISATION = 5.0;
    static final Double NETWORKBANDWIDTH_ENERGYEFFICIENCY = 7.0;
    static final Double NETWORKBANDWIDTH_COST = 9.0;
    static final Double CPUSPEED_VMUTILISATION = 5.0;
    static final Double CPUSPEED_ENERGYEFFICIENCY = 6.0;
    static final Double CPUSPEED_COST = 8.0;
    static final Double VMUTILISATION_ENERGYEFFICIENCY = 3.0;
    static final Double VMUTILISATION_PRICE = 3.0;
    static final Double ENERGYEFFICIENCY_COST = 2.0;

    // These values can also be computed from max and min of weighted decision matrix
    static double[] idealSolution = {0.75, 1.0, 1.0};
    static double[] antiIdealSolution = {0.0, 0.0, 0.25};

    // Number of decimal points for float number formatting
    static DecimalFormat df = new DecimalFormat("0.0000");

    
    static void setAlternatives(int noOfCloudNodes,int noOfFogNodes, int noOfEndDevices) {
    	List<String> tempAlternatives = new ArrayList<String>();
    	for(int i=1;i<=noOfEndDevices;i++) tempAlternatives.add("End Device-" + String.valueOf(i));
    	for(int i=1;i<=noOfFogNodes  ;i++) tempAlternatives.add("Fog Node-" + String.valueOf(i));
    	for(int i=1;i<=noOfCloudNodes;i++) tempAlternatives.add("Cloud-" + String.valueOf(i));
    	alternatives = tempAlternatives;
    }
}
