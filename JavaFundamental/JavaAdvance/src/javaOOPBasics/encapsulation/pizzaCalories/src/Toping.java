package javaOOPBasics.encapsulation.pizzaCalories.src;

class Toping {
    private final Double MEAT_MOD = 1.2;
    private final Double VEGGIES_MOD = 0.8;
    private final Double CHEESE_MOD = 1.1;
    private final Double SAUCE_MOD = 0.9;
    private final Double BASE_CAL_PER_GRAM = 2.0;

    private String type;
    private Double weight;

    Toping(String type, Double weight) throws Exception {
        setType(type);
        setWeight(weight);
    }

    private void setType(String type) throws Exception {
        if (!type.toLowerCase().equals("meat")
                && !type.toLowerCase().equals("veggies")
                && !type.toLowerCase().equals("cheese")
                && !type.toLowerCase().equals("sauce")) {
            throw new Exception(String.format("Cannot place %s on top of your pizza.", type));
        }

        this.type = type;
    }

    private void setWeight(Double weight) throws Exception {
        if (weight < 0 || weight > 50) {
            throw new Exception(String.format("%s weight should be in the range [1..50].", this.type));
        }
        this.weight = weight;
    }

    private Double getMod() {
        Double mod = 0D;

        switch (this.type.toLowerCase()) {
            case "meat":
                mod = MEAT_MOD;
                break;
            case "veggies":
                mod = VEGGIES_MOD;
                break;
            case "cheese":
                mod = CHEESE_MOD;
                break;
            case "sauce":
                mod = SAUCE_MOD;
                break;
            default:
                mod = 1.0;
        }
        return mod;
    }

    public Double getCalories() {
        double mod = getMod();
        return this.weight * BASE_CAL_PER_GRAM * mod;
    }

}
