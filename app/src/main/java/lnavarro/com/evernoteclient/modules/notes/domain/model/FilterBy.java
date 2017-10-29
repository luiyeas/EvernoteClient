package lnavarro.com.evernoteclient.modules.notes.domain.model;

import android.content.pm.FeatureInfo;

/**
 * Created by luis on 29/10/17.
 */

public class FilterBy {

    private Filter filter;

    public FilterBy() {
        this.filter = Filter.TITLE;
    }

    public enum Filter {
        TITLE, DATE
    }

    public Filter getFilter() {
        return filter;
    }

    public void setFilter(Filter filter) {
        this.filter = filter;
    }
}
