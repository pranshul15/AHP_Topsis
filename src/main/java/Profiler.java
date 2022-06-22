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
        if (node.equals("End Device-1")) {
            siteCriteria.add(Fuzzy.VERY_LOW);
            siteCriteria.add(Fuzzy.VERY_LOW);
            siteCriteria.add(Fuzzy.VERY_HIGH);
            siteCriteria.add(Fuzzy.VERY_HIGH);
            siteCriteria.add(Fuzzy.VERY_LOW);
        }

        //End Device-2
        else if (node.equals("End Device-2")) {
            siteCriteria.add(Fuzzy.VERY_LOW);
            siteCriteria.add(Fuzzy.VERY_LOW);
            siteCriteria.add(Fuzzy.VERY_HIGH);
            siteCriteria.add(Fuzzy.VERY_HIGH);
            siteCriteria.add(Fuzzy.VERY_LOW);
        }

        //End Device-3
        else if (node.equals("End Device-3")) {
            siteCriteria.add(Fuzzy.LOW);
            siteCriteria.add(Fuzzy.VERY_LOW);
            siteCriteria.add(Fuzzy.VERY_HIGH);
            siteCriteria.add(Fuzzy.HIGH);
            siteCriteria.add(Fuzzy.LOW);
        }

        //End Device-4
        else if (node.equals("End Device-4")) {
            siteCriteria.add(Fuzzy.LOW);
            siteCriteria.add(Fuzzy.LOW);
            siteCriteria.add(Fuzzy.HIGH);
            siteCriteria.add(Fuzzy.HIGH);
            siteCriteria.add(Fuzzy.LOW);
        }
        //End Device-5
        else if (node.equals("End Device-5")) {
            siteCriteria.add(Fuzzy.LOW);
            siteCriteria.add(Fuzzy.LOW);
            siteCriteria.add(Fuzzy.HIGH);
            siteCriteria.add(Fuzzy.HIGH);
            siteCriteria.add(Fuzzy.LOW);
        }
        
        //Fog-1
        else if (node.equals("Fog Node-1")) {
            siteCriteria.add(Fuzzy.LOW);
            siteCriteria.add(Fuzzy.LOW);
            siteCriteria.add(Fuzzy.HIGH);
            siteCriteria.add(Fuzzy.HIGH);
            siteCriteria.add(Fuzzy.LOW);
        }

        //Fog-2
        else if (node.equals("Fog Node-2")) {
            siteCriteria.add(Fuzzy.AVERAGE);
            siteCriteria.add(Fuzzy.LOW);
            siteCriteria.add(Fuzzy.HIGH);
            siteCriteria.add(Fuzzy.HIGH);
            siteCriteria.add(Fuzzy.LOW);
        }

        //Fog-3
        else if (node.equals("Fog Node-3")) {
            siteCriteria.add(Fuzzy.AVERAGE);
            siteCriteria.add(Fuzzy.AVERAGE);
            siteCriteria.add(Fuzzy.AVERAGE);
            siteCriteria.add(Fuzzy.AVERAGE);
            siteCriteria.add(Fuzzy.AVERAGE);
        }
        
        //Fog-4
        else if (node.equals("Fog Node-4")) {
            siteCriteria.add(Fuzzy.AVERAGE);
            siteCriteria.add(Fuzzy.HIGH);
            siteCriteria.add(Fuzzy.AVERAGE);
            siteCriteria.add(Fuzzy.LOW);
            siteCriteria.add(Fuzzy.HIGH);
        }
        
        //Fog-5
        else if (node.equals("Fog Node-5")) {
            siteCriteria.add(Fuzzy.HIGH);
            siteCriteria.add(Fuzzy.HIGH);
            siteCriteria.add(Fuzzy.LOW);
            siteCriteria.add(Fuzzy.LOW);
            siteCriteria.add(Fuzzy.HIGH);
        }

        //Cloud-1
        else if (node.equals("Cloud-1")) {
            siteCriteria.add(Fuzzy.HIGH);
            siteCriteria.add(Fuzzy.HIGH);
            siteCriteria.add(Fuzzy.LOW);
            siteCriteria.add(Fuzzy.LOW);
            siteCriteria.add(Fuzzy.HIGH);
        }

        //Cloud-2
        else if (node.equals("Cloud-2")) {
            siteCriteria.add(Fuzzy.HIGH);
            siteCriteria.add(Fuzzy.HIGH);
            siteCriteria.add(Fuzzy.LOW);
            siteCriteria.add(Fuzzy.LOW);
            siteCriteria.add(Fuzzy.HIGH);
        }

        //Cloud-3
        else if (node.equals("Cloud-3")) {
            siteCriteria.add(Fuzzy.HIGH);
            siteCriteria.add(Fuzzy.VERY_HIGH);
            siteCriteria.add(Fuzzy.LOW);
            siteCriteria.add(Fuzzy.LOW);
            siteCriteria.add(Fuzzy.HIGH);
        }
        
        //Cloud-4
        else if (node.equals("Cloud-4")) {
            siteCriteria.add(Fuzzy.VERY_HIGH);
            siteCriteria.add(Fuzzy.VERY_HIGH);
            siteCriteria.add(Fuzzy.AVERAGE);
            siteCriteria.add(Fuzzy.VERY_LOW);
            siteCriteria.add(Fuzzy.VERY_HIGH);
        }
        
        //Cloud-5
        else if (node.equals("Cloud-5")) {
            siteCriteria.add(Fuzzy.VERY_HIGH);
            siteCriteria.add(Fuzzy.VERY_HIGH);
            siteCriteria.add(Fuzzy.AVERAGE);
            siteCriteria.add(Fuzzy.VERY_LOW);
            siteCriteria.add(Fuzzy.VERY_HIGH);
        }

        return siteCriteria;
    }
}
