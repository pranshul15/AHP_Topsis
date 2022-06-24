import java.util.Scanner;

public class Test {

    private void calculateAHP(){

        AHP ahp = AHP.getInstance(Config.criteria);

        double[] compArray = ahp.getPairwiseComparisonArray();

//        double[] dm = {1.0 5.0 7.0 9.0 5.0 6.0 8.0 3.0 3.0 2.0}; // DM1
        double[] dm = {5.0, 7.0, 9.0, 9.0, 3.0, 7.0, 7.0, 5.0, 5.0, 1.0}; // DM2
//        double[] dm = {1.0/7.0, 1.0/5.0, 5.0, 5.0, 3.0, 9.0, 9.0, 9.0, 9.0, 1.0}; // DM3
//        double[] dm = {1.0, 1.0, 1.0/9.0, 3.0, 3.0, 1.0/9.0, 3.0, 1.0/9.0, 3.0, 9.0}; // DM4
//        double[] dm = {1.0, 3.0, 3.0, 1.0/9.0, 3.0, 3.0, 1.0/9.0, 3.0, 1.0/9.0, 1.0/9.0}; // DM5

        System.arraycopy(dm, 0, compArray, 0, 10);

        ahp.setPairwiseComparisonArray(compArray);
        ahp.setEvd();

        for (int i = 0; i < ahp.getNrOfPairwiseComparisons(); i++) {
            System.out.print("Importance of " + Config.criteria[ahp.getIndicesForPairwiseComparison(i)[0]] + " compared to ");
            System.out.print(Config.criteria[ahp.getIndicesForPairwiseComparison(i)[1]] + "= ");
            System.out.println(ahp.getPairwiseComparisonArray()[i]);
        }

        System.out.println("A: " + ahp.toString());

        System.out.println("Geometric Consistency Index: " + Config.df.format(ahp.getGeometricConsistencyIndex()));
        System.out.println("Geometric Cardinal Consistency Index: " + Config.df.format(ahp.getGeometricCardinalConsistencyIndex()));
        System.out.println("Consistency Index: " + Config.df.format(ahp.getConsistencyIndex()));
        System.out.println("Consistency Ratio: " + Config.df.format(ahp.getConsistencyRatio()) + "%");
        System.out.println("Weights: ");
        for (int k=0; k<ahp.getWeights().length; k++) {
            Config.ahpWeights[k] = ahp.getWeights()[k];
            System.out.println(Config.criteria[k] + ": " + Config.df.format(ahp.getWeights()[k]));
        }
    }

    private void topsisMethod(){
        Topsis topsis = new Topsis();
        topsis.start();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    	
    	double[] dm = new double[10];
    	for(int i=0;i<10;i++) dm[i] = sc.nextDouble();
    	
    	Test test = new Test();

        System.out.println("Calculating AHP Criteria weighting: ");
        test.calculateAHP();

        System.out.println("End of AHP");
        System.out.println("********************************");
        System.out.println("Calculating Fuzzy TOPSIS: ");

        test.topsisMethod();
        sc.close();
    }
}
