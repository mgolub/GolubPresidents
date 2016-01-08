package golub.presidents;

import java.util.List;

/**
 * Created by student1 on 12/17/2015.
 */
public interface OnPresidentSelectedListener {

    void onSelect(List<President> presidents, int position);
}
