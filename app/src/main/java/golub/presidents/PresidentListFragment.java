package golub.presidents;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.GsonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;

public class PresidentListFragment extends Fragment {
    private RecyclerView recyclerView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_president_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        recyclerView = (RecyclerView)view.findViewById(R.id.list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

       PresidentsService service = retrofit.create(PresidentsService.class);
        Call<List<President>> call = service.listPresidents();
        call.enqueue(new Callback<List<President>>() {
            @Override
            public void onResponse(Response<List<President>> response) {
                List<President> list = response.body();

                OnPresidentSelectedListener listener = (OnPresidentSelectedListener) getActivity();

                PresidentRecyclerViewAdapter adapter = new PresidentRecyclerViewAdapter(list, listener);
                recyclerView.setAdapter(adapter);

            }


            @Override
            public void onFailure(Throwable t) {
                t.printStackTrace();
            }
        });


       // InputStream in = getResources().openRawResource(R.raw.presidents);
        //President presidents[] = gson.fromJson(new InputStreamReader(in), President[].class);



    }
}
