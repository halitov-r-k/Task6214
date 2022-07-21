import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    static Logger LOGGER = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) throws IOException {
        LOGGER.log(Level.INFO,   "Start program");
        Reader reader = new FileReader("test.txt");
        System.out.println( getSalesMap(reader).toString());
    }
    public static Map<String, Long> getSalesMap(Reader reader)  {
        LOGGER.log(Level.INFO, "Start getSalesMap()");
        Map map = new HashMap<>();
        Scanner scanner = new Scanner(new BufferedReader(reader));
        while (scanner.hasNext()) {
            map.merge(scanner.next(), scanner.hasNextLong() ? scanner.nextLong() : 0, (oldValue, newValue) -> (Long)oldValue + (Long)newValue);
        }
        return map;
        }

    }