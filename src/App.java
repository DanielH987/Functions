import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Read and parse domain, codomain, and relation
            String[] domainArray = scanner.nextLine().split(" ");
            String[] codomainArray = scanner.nextLine().split(" ");
            String[] relationArray = scanner.nextLine().split(" ");

            Set<String> domain = new HashSet<>(Arrays.asList(domainArray));
            Set<String> codomain = new HashSet<>(Arrays.asList(codomainArray));

            List<String> relationList = new ArrayList<>(Arrays.asList(relationArray));
            List<String> relationPairs = new ArrayList<>();

            // Parse the relation pairs
            for (int i = 0; i < relationList.size(); i += 2) {
                if (i + 1 < relationList.size()) {
                    String pair = "(" + relationList.get(i) + "," + relationList.get(i + 1) + ")";
                    relationPairs.add(pair);
                }
            }

            // Print domain, codomain, and relation sets
            System.out.println("DOMAIN: { " + String.join(", ", domain) + " }");
            System.out.println("CODOMAIN: { " + String.join(", ", codomain) + " }");
            System.out.println("RELATION: { " + String.join(", ", relationPairs) + " }");

            // Check if it's a function
            boolean isFunction = checkIfFunction(domain, relationPairs);
            if (isFunction) {
                System.out.println("This is a function.");

                // Check if it's onto
                boolean isOnto = checkIfOnto(codomain, relationPairs);
                if (isOnto) {
                    System.out.println("It is onto.");
                } else {
                    System.out.println("It is *not* onto.");
                }

                // Check if it's one-to-one
                boolean isOneToOne = checkIfOneToOne(relationPairs);
                if (isOneToOne) {
                    System.out.println("It is one-to-one.");
                } else {
                    System.out.println("It is *not* one-to-one.");
                }

                // Check if it's a bijection
                if (isOnto && isOneToOne) {
                    System.out.println("It is a bijection.");
                } else {
                    System.out.println("It is *not* a bijection.");
                }
            } else {
                System.out.println("This is *not* a function.");
            }
        }
    }

    // Function checking
    private static boolean checkIfFunction(Set<String> domain, List<String> relationPairs) {
        return domain.size() == relationPairs.size();
    }

    // Onto checking
    private static boolean checkIfOnto(Set<String> codomain, List<String> relationPairs) {
        Set<String> mappedValues = relationPairs.stream()
                .map(pair -> pair.substring(pair.indexOf(',') + 1, pair.length() - 1))
                .collect(Collectors.toSet());
        return codomain.equals(mappedValues);
    }

    // One-to-one checking
    private static boolean checkIfOneToOne(List<String> relationPairs) {
        Set<String> distinctValues = new HashSet<>();
        for (String pair : relationPairs) {
            String value = pair.substring(pair.indexOf(',') + 1, pair.length() - 1);
            if (!distinctValues.add(value)) {
                return false; // Duplicate value found
            }
        }
        return true;
    }
}
