package javaOOPBasics.encapsulation.pizzaCalories.src;

class Dough {
    private final Double WHITE_MOD = 1.5D;
    private final Double WHOLEGRAIN_MOD = 1D;
    private final double CRISPY_MOD = 0.9;
    private final double CHEWY_MOD = 1.1;
    private final double HOMEMADE_MOD = 1;
    private final double BASE_CAL_PER_GRAM = 2;

    private String flourType;
    private String bakingTechnique;
    private Double weight;

    Dough(String flourType, String bakingTechnique, Double weight) throws Exception {
        setFlourType(flourType);
        setBakingTechnique(bakingTechnique);
        setWeight(weight);
    }

    private void setFlourType(String flourType) throws Exception {
        if (!flourType.toLowerCase().equals("white") &&
                !flourType.toLowerCase().equals("wholegrain")) {
            throw new Exception("Invalid type of dough.");
        }
        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) throws Exception {
        if (!bakingTechnique.toLowerCase().equals("crispy")
                && !bakingTechnique.toLowerCase().equals("chewy")
                && !bakingTechnique.toLowerCase().equals("homemade")) {
            throw new Exception("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }

    private void setWeight(Double weight) throws Exception {
        if (weight < 1 || weight > 200) {
            throw new Exception("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    double getCalories() {
        double result;

        double flourMod = getFlourMod();
        double bakingTechMod = getBakingTechMod();

        result = this.weight * BASE_CAL_PER_GRAM * flourMod * bakingTechMod;
        return result;
    }

    private double getFlourMod() {
        Double mod;
        switch (this.flourType.toLowerCase()) {
            case "white":
                mod = WHITE_MOD;
                break;
            case "wholegrain":
                mod = WHOLEGRAIN_MOD;
                break;
            default:
                mod = 1D;
                break;
        }
        return mod;
    }

    private double getBakingTechMod() {
        Double mod = 0D;

        switch (this.bakingTechnique.toLowerCase()) {
            case "crispy":
                mod = CRISPY_MOD;
                break;
            case "chewy":
                mod = CHEWY_MOD;
                break;
            case "homemade":
                mod = HOMEMADE_MOD;
                break;
            default:
                mod = 1D;
                break;
        }
        return mod;
    }
}
