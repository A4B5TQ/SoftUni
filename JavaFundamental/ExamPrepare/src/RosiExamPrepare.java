import java.util.HashMap;

public class RosiExamPrepare {
    public static void main(String[] args) {
        HashMap<String,Integer> examSolutions = new HashMap<>();

        examSolutions.put("Rosi",4);
        examSolutions.put("Petio",0);
        examSolutions.put("Plamen",1);
        examSolutions.put("Ivan",25);
        examSolutions.put("Rosito",25);
        examSolutions.put("Ivancho",25);
        examSolutions.put("Plamencho",25);

        System.out.println(examSolutions);

        //examSolutions.put("Rosi",0);
        examSolutions.put("Rosi",examSolutions.get("Rosi") + 6);
        System.out.println(examSolutions);

        examSolutions.entrySet().stream().sorted((e1,e2) -> {
            if (Integer.compare(e2.getValue(),e1.getValue()) == 0){
                return e1.getKey().compareTo(e2.getKey());
            }

            return Integer.compare(e2.getValue(),e1.getValue());
        }).forEach(System.out::println);
    }
}
