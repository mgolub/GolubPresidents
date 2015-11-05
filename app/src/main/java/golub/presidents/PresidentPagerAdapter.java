package golub.presidents;

import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class PresidentPagerAdapter extends PagerAdapter {

    private President[] presidents;

    public PresidentPagerAdapter(President[] presidents) {
        this.presidents = presidents;
    }

    @Override
    public int getCount() {
        return presidents.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        LayoutInflater inflater = LayoutInflater.from(container.getContext());
        View view = inflater.inflate(R.layout.president_pager_item, null);
        TextView name = (TextView) view.findViewById(R.id.name);
        TextView number = (TextView) view.findViewById(R.id.number);
        TextView birthYear = (TextView) view.findViewById(R.id.birthDate);
        TextView deathYear = (TextView) view.findViewById(R.id.death);
        TextView tookOffice = (TextView) view.findViewById(R.id.tookOffice);
        TextView leftOffice = (TextView) view.findViewById(R.id.leftOffice);
        TextView party = (TextView) view.findViewById(R.id.party);

        President president = presidents[position];
        name.setText(president.getPresident());
        number.setText(String.valueOf(president.getNumber()));
        birthYear.append("Birth Year: ");
        birthYear.append(String.valueOf(president.getBirthYear()));
        deathYear.append("Death Year: ");
        deathYear.append(String.valueOf(president.getDeathYear()));
        tookOffice.append("Took Office: ");
        tookOffice.append(president.getTookOffice());
        leftOffice.append("Left Office: ");
        leftOffice.append(president.getLeftOffice());
        party.append("Party: ");
        party.append(president.getParty());


        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

}
