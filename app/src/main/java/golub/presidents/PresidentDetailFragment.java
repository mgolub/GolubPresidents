package golub.presidents;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by student1 on 12/10/2015.
 */
public class PresidentDetailFragment extends Fragment {
    private ViewPager viewPager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_president_detail, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewPager = (ViewPager)view.findViewById(R.id.viewPager);

    }

    public void showPresidentDetail(List<President> presidents, int position){
        PresidentPagerAdapter adapter = new PresidentPagerAdapter(presidents);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(position);
    }
}
