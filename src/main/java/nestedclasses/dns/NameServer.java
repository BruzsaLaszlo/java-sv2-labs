package nestedclasses.dns;

import java.util.ArrayList;
import java.util.List;

public class NameServer {

    private static record DnsEntry(String name, String hostIp) {
    }

    private List<DnsEntry> dnsEntries = new ArrayList<>();

    public void addEntry(String name, String hostIp) {
        for (DnsEntry dnsEntry : dnsEntries) {
            if (dnsEntry.hostIp.equals(hostIp) || dnsEntry.name.equals(name)) {
                throw new IllegalArgumentException("Already exists");
            }
        }
        dnsEntries.add(new DnsEntry(name, hostIp));
    }

    public void removeEntryByName(String name) {
        DnsEntry found = null;
        for (DnsEntry dnsEntry : dnsEntries) {
            if (dnsEntry.name.equals(name)) {
                found = dnsEntry;
                break;
            }
        }
        dnsEntries.remove(found);
    }

    public void removeEntryByIp(String hostIp) {
        DnsEntry found = null;
        for (DnsEntry dnsEntry : dnsEntries) {
            if (dnsEntry.hostIp.equals(hostIp)) {
                found = dnsEntry;
                break;
            }
        }
        dnsEntries.remove(found);
    }

    public String getIpByName(String name) {
        for (DnsEntry dnsEntry : dnsEntries) {
            if (dnsEntry.name.equals(name)) {
                return dnsEntry.hostIp;
            }
        }
        throw new IllegalArgumentException("Element not found");
    }

    public String getNameByIp(String ip) {
        for (DnsEntry dnsEntry : dnsEntries) {
            if (dnsEntry.hostIp.equals(ip)) {
                return dnsEntry.name;
            }
        }
        throw new IllegalArgumentException("Element not found");
    }

}
