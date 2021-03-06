package com.example.mahatourguide;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ZooFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ZooFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ZooFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ZooFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ZooFragment newInstance(String param1, String param2) {
        ZooFragment fragment = new ZooFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.places_list, container, false);

        int[] zooNames = {R.drawable.amte,R.drawable.gorewada,R.drawable.rajeev_gandhi,R.drawable.peshwa_udyan};

        final ArrayList<Place> places = new ArrayList<Place>();

        places.add(new Place(getString(R.string.amte), getString(R.string.amte_short), getString(R.string.amte_description), zooNames[1]));
        places.add(new Place(getString(R.string.gorewada), getString(R.string.gorewada_short), getString(R.string.gorewada_description), zooNames[0]));
        places.add(new Place(getString(R.string.rajivgandhi), getString(R.string.rajeev_short), getString(R.string.rajeev_description), zooNames[2]));
        places.add(new Place(getString(R.string.peshwa), getString(R.string.peshwa_short), getString(R.string.peshwa_description), zooNames[3]));

        PlaceAdapter adapter = new PlaceAdapter(getContext(),places);

        ListView listView = rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Place place = places.get(position);
                Intent intent = new Intent(getContext(),PlaceInfo.class);
                intent.putExtra("image", place.getImageResourceId());
                intent.putExtra(getString(R.string.placename) , place.getName());
                intent.putExtra(getString(R.string.placedes), place.getDescription());
                startActivity(intent);
            }
        });
        return rootView;
    }
}
