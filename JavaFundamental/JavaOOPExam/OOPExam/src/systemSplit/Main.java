package systemSplit;

import systemSplit.systemsComponents.Core;
import systemSplit.systemsComponents.Dump;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        Dump dump = new Dump();
        Core core = new Core(dump);

        String line = "";
        while (!line.equals("System Split")) {
            line = sc.readLine();

            if (line.equals("System Split")) {
                core.split();
                return;
            } else {
                executeCommands(core, line);
            }
        }
    }

    private static void executeCommands(Core core, String line) {
        int indexOfFirstBrace = line.indexOf("(");
        int indexOfLastBrace = line.indexOf(")");
        String command = line.substring(0, indexOfFirstBrace);
        String[] commandParameters = line.substring(indexOfFirstBrace + 1, indexOfLastBrace).split(", ");

        switch (command) {
            case "RegisterPowerHardware":
                core.registerPowerHardware(commandParameters[0],
                        Double.valueOf(commandParameters[1]),
                        Integer.valueOf(commandParameters[2]),
                        Integer.valueOf(commandParameters[3]),
                        Integer.valueOf(commandParameters[4]));
                break;
            case "RegisterHeavyHardware":
                core.registerHeavyHardware(commandParameters[0],
                        Double.valueOf(commandParameters[1]),
                        Integer.valueOf(commandParameters[2]),
                        Integer.valueOf(commandParameters[3]),
                        Integer.valueOf(commandParameters[4]));
                break;
            case "RegisterExpressSoftware":
                core.registerExpressSoftware(commandParameters[0],
                        commandParameters[1],
                        Double.valueOf(commandParameters[2]),
                        Integer.valueOf(commandParameters[3]),
                        Integer.valueOf(commandParameters[4]));
                break;
            case "RegisterLightSoftware":
                core.registerLightSoftware(commandParameters[0],
                        commandParameters[1],
                        Double.valueOf(commandParameters[2]),
                        Integer.valueOf(commandParameters[3]),
                        Integer.valueOf(commandParameters[4]));
                break;
            case "Analyze":
                core.analyze();
                break;
            case "Dump":
                core.dump(commandParameters[0], commandParameters[1]);
                break;
            case "Restore":
                core.restore(commandParameters[0],
                        commandParameters[1]);
                break;
            case "Destroy":
                core.destroy(commandParameters[0],
                        commandParameters[1]);
                break;
        }
    }
}
