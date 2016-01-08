package golub.presidents;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import java.util.List;


public class MainActivity extends AppCompatActivity implements OnPresidentSelectedListener {

    private PresidentListFragment listFragment;
    private PresidentDetailFragment detailFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager manager = getSupportFragmentManager();
        listFragment = (PresidentListFragment) manager.findFragmentById(R.id.presidentListFragment);
        detailFragment = (PresidentDetailFragment)manager.findFragmentById(R.id.detailFragment);
    }
    @Override
    public void onSelect(List<President> presidents, int position) {
        if (detailFragment != null) {
            detailFragment.showPresidentDetail(presidents, position);
        } else {
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra("PRESIDENTS", presidents.toArray(new President[0]));
            intent.putExtra("POSITION", position);
            this.startActivity(intent);
        }
    }
}
