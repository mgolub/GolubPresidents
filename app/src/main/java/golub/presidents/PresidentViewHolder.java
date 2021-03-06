package golub.presidents;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by student1 on 10/22/2015.
 */
public class PresidentViewHolder extends RecyclerView.ViewHolder {

    @Bind(R.id.name)
    TextView name;

    public PresidentViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);

    }

    public void bind(President president) {
        name.setText(president.getPresident());
    }

}
