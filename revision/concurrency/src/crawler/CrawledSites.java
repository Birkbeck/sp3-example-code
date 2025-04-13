package crawler;

import java.util.ArrayList;
import java.util.List;

/**
 * Data structure for a web crawler. Keeps track of the visited sites and keeps
 * a list of sites which needs still to be crawled.
 *
 * @author Lars Vogel
 */
public class CrawledSites {
    private List<String> crawledSites = new ArrayList<>();
    private final List<String> linkedSites = new ArrayList<>();

    public void add(String site) {
        synchronized (this) {
            if (!crawledSites.contains(site)) {
                linkedSites.add(site);
            }
        }
    }

    /**
     * Get the next site to crawl. Can return null (if nothing to crawl)
     */
    public String next() {
        if (linkedSites.isEmpty()) {
            return null;
        }
        synchronized (this) {
            // Need to check again if size has changed
            if (!linkedSites.isEmpty()) {
                String s = linkedSites.getFirst();
                linkedSites.removeFirst();
                crawledSites.add(s);
                return s;
            }
            return null;
        }
    }

}