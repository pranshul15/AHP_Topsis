import java.util.ArrayList;
import java.util.TreeMap;

// Profiler is used to set 5 fuzzy values corresponding to each config.alternative
//Cloud-1=[HIGH, LOW, VERY_HIGH, LOW, GOOD]
//Cloud-2=[GOOD, HIGH, VERY_HIGH, LOW, HIGH]
//Cloud-3=[LOW, VERY_HIGH, VERY_HIGH, LOW, VERY_HIGH]
//End Device-1=[VERY_HIGH, LOW, GOOD, HIGH, VERY_LOW]
//End Device-2=[VERY_HIGH, LOW, LOW, HIGH, VERY_LOW]
//End Device-3=[VERY_HIGH, HIGH, LOW, HIGH, VERY_LOW]
//Fog Node-1=[HIGH, GOOD, HIGH, HIGH, LOW]
//Fog Node-2=[HIGH, HIGH, HIGH, HIGH, GOOD]
//Fog Node-3=[HIGH, VERY_HIGH, HIGH, HIGH, HIGH]

class Profiler {

    private TreeMap<String, ArrayList<Fuzzy>> availableSites = new TreeMap<>();

    TreeMap<String, ArrayList<Fuzzy>> start(){
        for (String alternative : Config.alternatives) {
            ArrayList<Fuzzy> criteriaImportance = profileNode(alternative);
            availableSites.put(alternative, criteriaImportance);
        }

        return availableSites;
    }

    private ArrayList<Fuzzy> profileNode(String node) {

        ArrayList<Fuzzy> siteCriteria = new ArrayList<>();

        //End Device-1
        if (node.equalsIgnoreCase(Config.alternatives[0])) {
            siteCriteria.add(Fuzzy.VERY_HIGH);
            siteCriteria.add(Fuzzy.LOW);
            siteCriteria.add(Fuzzy.GOOD);
            siteCriteria.add(Fuzzy.HIGH);
            siteCriteria.add(Fuzzy.VERY_LOW);
        }

        //End Device-2
        else if (node.equalsIgnoreCase(Config.alternatives[1])) {
            siteCriteria.add(Fuzzy.VERY_HIGH);
            siteCriteria.add(Fuzzy.LOW);
            siteCriteria.add(Fuzzy.LOW);
            siteCriteria.add(Fuzzy.HIGH);
            siteCriteria.add(Fuzzy.VERY_LOW);
        }

        //End Device-3
        else if (node.equalsIgnoreCase(Config.alternatives[2])) {
            siteCriteria.add(Fuzzy.VERY_HIGH);
            siteCriteria.add(Fuzzy.HIGH);
            siteCriteria.add(Fuzzy.LOW);
            siteCriteria.add(Fuzzy.HIGH);
            siteCriteria.add(Fuzzy.VERY_LOW);
        }

        //End Device-4
        
        //Fog-1
        else if (node.equalsIgnoreCase(Config.alternatives[3])) {
            siteCriteria.add(Fuzzy.HIGH);
            siteCriteria.add(Fuzzy.GOOD);
            siteCriteria.add(Fuzzy.HIGH);
            siteCriteria.add(Fuzzy.HIGH);
            siteCriteria.add(Fuzzy.LOW);
        }

        //Fog-2
        else if (node.equalsIgnoreCase(Config.alternatives[4])) {
            siteCriteria.add(Fuzzy.HIGH);
            siteCriteria.add(Fuzzy.HIGH);
            siteCriteria.add(Fuzzy.HIGH);
            siteCriteria.add(Fuzzy.HIGH);
            siteCriteria.add(Fuzzy.GOOD);
        }

        //Fog-3
        else if (node.equalsIgnoreCase(Config.alternatives[5])) {
            siteCriteria.add(Fuzzy.HIGH);
            siteCriteria.add(Fuzzy.VERY_HIGH);
            siteCriteria.add(Fuzzy.HIGH);
            siteCriteria.add(Fuzzy.HIGH);
            siteCriteria.add(Fuzzy.HIGH);
        }
        
        //Fog-4

        //Cloud-1
        else if (node.equalsIgnoreCase(Config.alternatives[6])) {
            siteCriteria.add(Fuzzy.HIGH);
            siteCriteria.add(Fuzzy.LOW);
            siteCriteria.add(Fuzzy.VERY_HIGH);
            siteCriteria.add(Fuzzy.LOW);
            siteCriteria.add(Fuzzy.GOOD);
        }

        //Cloud-2
        else if (node.equalsIgnoreCase(Config.alternatives[7])) {
            siteCriteria.add(Fuzzy.GOOD);
            siteCriteria.add(Fuzzy.HIGH);
            siteCriteria.add(Fuzzy.VERY_HIGH);
            siteCriteria.add(Fuzzy.LOW);
            siteCriteria.add(Fuzzy.HIGH);
        }

        //Cloud-3
        else if (node.equalsIgnoreCase(Config.alternatives[8])) {
            siteCriteria.add(Fuzzy.LOW);
            siteCriteria.add(Fuzzy.VERY_HIGH);
            siteCriteria.add(Fuzzy.VERY_HIGH);
            siteCriteria.add(Fuzzy.LOW);
            siteCriteria.add(Fuzzy.VERY_HIGH);
        }
        
        //Cloud-4

        return siteCriteria;
    }
}
