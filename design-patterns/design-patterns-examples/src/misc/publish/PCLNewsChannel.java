package misc.publish;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class PCLNewsChannel implements PropertyChangeListener {
    private String news;

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        this.news = (String) evt.getNewValue();
    }
}