package zarovizsgapotpotvizsga2021.bistros;

import java.util.*;

public class City {

    private Set<Bistro> bistros = new LinkedHashSet<>();

    public void addBistro(Bistro bistro) {
        bistros.add(bistro);
    }

    public Bistro findBistroByAddress(Address address) {
        return bistros.stream()
                .filter(bistro -> bistro.getAddress().equals(address))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid address"));
    }

    public Bistro findLongestMenu() {
        return bistros.stream()
                .max(Comparator.comparingInt(bistro -> bistro.getMenu().size()))
                .orElseThrow(() -> new IllegalArgumentException("There are no bistros"));
    }

    public List<Bistro> findBistroWithMenuItem(String menuItemName) {
        return bistros.stream()
                .filter(bistro -> bistro.getMenu().stream()
                        .anyMatch(menuItem -> menuItem.getName().equals(menuItemName)))
                .toList();
    }

    public Set<Bistro> getBistros() {
        return Collections.unmodifiableSet(bistros);
    }
}
