package pareto_prinzip.scanner;

public class Host implements Comparable{
    private final String address;
    private final String hostname;
    private final String username;

    public Host(final String address, final String hostname, final String username) {
        this.address = address;
        this.hostname = hostname;
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public String getHostname() {
        return hostname;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return "Host{" +
                "address='" + address + '\'' +
                ", hostname='" + hostname + '\'' +
                ", username='" + username + '\'' +
                '}';
    }

    @Override
    public int compareTo(final Object o) {
        Host comparedHost = (Host)o;
        return this.hostname.compareTo(comparedHost.hostname);
    }
}
