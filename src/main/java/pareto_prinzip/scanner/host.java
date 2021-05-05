package pareto_prinzip.scanner;

public class host {
    private final String address;
    private final String hostname;

    public String getAddress() {
        return address;
    }

    public String getHostname() {
        return hostname;
    }

    public host(String address, String hostname) {
        this.address = address;
        this.hostname = hostname;
    }

    @Override
    public String toString() {
        return "host{" +
                "address='" + address + '\'' +
                ", hostname='" + hostname + '\'' +
                '}';
    }
}
