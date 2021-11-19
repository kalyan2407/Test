package com.example.test;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NotificationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NotificationFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ArrayList<String> names_list = new ArrayList<>();
    private ArrayList<String> desc_list = new ArrayList<>();
    private Context mContext;
    private Activity mActivity;
    public NotificationFragment(Context context,Activity activity) {
        // Required empty public constructor
        this.mContext = context;
        this.mActivity = activity;
    }

    public NotificationFragment() {

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NotificationFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NotificationFragment newInstance(String param1, String param2) {
        NotificationFragment fragment = new NotificationFragment();
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
        View layout = null;
        try {
            layout = inflater.inflate(R.layout.fragment_notification, container, false);
            // Inflate the layout for this fragment
            for (int i = 0; i < 20; i++) {
                names_list.add("Kalyan M");
                desc_list.add(" and " + i + " others liked your content");
            }

            MyListView adapter=new MyListView(getActivity(),names_list.toArray(new String[names_list.size()]),desc_list.toArray(new String[desc_list.size()]));
            ListView  list_calllog=(ListView)layout.findViewById(R.id.list_noti);
            list_calllog.setAdapter(adapter);
        }catch (Exception e){
            Log.d("Exception",e.toString());
        }
        return layout;
    }
}