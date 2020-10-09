package bonnysid.citypack;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class City {
    private String name;
    private Map<City, Integer> routes = new HashMap<City, Integer>();

    public City(String name) {
        this.name = name;
    }

    public City setName(String name) {
        this.name = name;
        return this;
    }

    public City addRoute(City city, int weight) {
        routes.put(city, weight);
        return this;
    }

    public City addRoute(City city, int weight, boolean isBilateral) {
        routes.put(city, weight);
        System.out.println(this.name + " " + city.getName() + ": " + !city.getRoutes().containsKey(this));
        if (isBilateral && !city.getRoutes().containsKey(this)) city.addRoute(this, weight);
        return this;
    }

    public String getName() {
        return name;
    }

    public Map<City, Integer> getRoutes() {
        return routes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Objects.equals(name, city.name) &&
                Objects.equals(routes, city.routes);
    }

    @Override
    public String toString() {
        String routesStr = "";
        for (Map.Entry<City, Integer> city : routes.entrySet()) {
            routesStr += "\n\t" + city.getKey().getName() + ": " + city.getValue();
        }
        return "City " + name + " has routes:" + routesStr;
    }
}
