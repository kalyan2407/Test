package com.example.test;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SearchFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SearchFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    String[] categories = new String[] {"Categories"};
    String[] geners = new String[] {"Geners"};
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Context mContext;
    public SearchFragment(Context context) {
        // Required empty public constructor
        this.mContext = context;
    }

    public SearchFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SearchFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SearchFragment newInstance(String param1, String param2) {
        SearchFragment fragment = new SearchFragment();
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
            // Inflate the layout for this fragment

            layout = inflater.inflate(R.layout.fragment_search, container, false);
            LinearLayout ll_left = (LinearLayout) layout.findViewById(R.id.ll_left);
            LinearLayout ll_right = (LinearLayout) layout.findViewById(R.id.ll_right);
            Spinner spinnerTest = (Spinner) layout.findViewById(R.id.spinnerTest);
            Spinner spinnerTest1 = (Spinner) layout.findViewById(R.id.spinnerTest1);

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(mContext,
                    android.R.layout.simple_spinner_item, categories);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerTest.setAdapter(adapter);

            adapter = new ArrayAdapter<String>(mContext,
                    android.R.layout.simple_spinner_item, geners);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerTest1.setAdapter(adapter);


            addView(ll_left, 6);
            addView(ll_right, 0);
        }catch (Exception e){
            Log.d("Exception",e.toString());
        }
        return layout;
    }

    private void addView(LinearLayout ll_left,int number) {
        try {
            for (int i = 0; i < 7; i++) {
                LinearLayout ll_child = new LinearLayout(mContext);
                int heigt_value = 0;
                if (i == number)
                    heigt_value = 4;
                else
                    heigt_value = 2;
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(MainActivity.deviceWidth / 2, MainActivity.deviceHeight / heigt_value);
                layoutParams.gravity = Gravity.CENTER;
                layoutParams.weight = 10;
                layoutParams.leftMargin = 10;
                layoutParams.rightMargin = 10;
                layoutParams.topMargin = 10;
                layoutParams.bottomMargin = 10;
                ll_child.setOrientation(LinearLayout.VERTICAL);
                ll_child.setLayoutParams(layoutParams);
                if (i == number) {
                    LinearLayout ll_two = new LinearLayout(mContext);
                    LinearLayout.LayoutParams layoutParams_two = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                    layoutParams_two.gravity = Gravity.CENTER;
                    layoutParams_two.weight = 8;
                    layoutParams_two.leftMargin = 10;
                    ll_two.setOrientation(LinearLayout.HORIZONTAL);
                    ll_two.setLayoutParams(layoutParams_two);

                    TextView mType = new TextView(mContext);
                    mType.setText("Kalyan");
                    mType.setTextColor(Color.BLACK);
                    mType.setTypeface(null, Typeface.BOLD);
                    mType.setTextSize(12);
                    mType.setGravity(Gravity.CENTER);
                    ll_two.addView(mType);
                    LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) mType.getLayoutParams();
                    params.gravity = (Gravity.CENTER);
                    ll_child.addView(ll_two);
                    ll_left.addView(ll_child);
                    params = (LinearLayout.LayoutParams) ll_child.getLayoutParams();
                    params.gravity = (Gravity.CENTER);
                } else {
                    LinearLayout ll_one = new LinearLayout(mContext);
                    LinearLayout.LayoutParams layoutParams_one = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                    layoutParams_one.gravity = Gravity.LEFT;
                    layoutParams_one.weight = 1;
                    layoutParams_one.leftMargin = 10;
                    ll_one.setOrientation(LinearLayout.HORIZONTAL);
                    ll_one.setLayoutParams(layoutParams_one);

                    ImageView img = new ImageView(mContext);
                    LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                    layoutParams3.gravity = Gravity.CENTER;
                    img.setLayoutParams(layoutParams3);
                    img.getLayoutParams().width = MainActivity.deviceWidth / 50;
                    img.getLayoutParams().height = MainActivity.deviceWidth / 50;
                    img.setImageResource(this.getResources().getIdentifier("drawable/border_one", null, mContext.getPackageName()));
                    ll_one.addView(img);


                    TextView mType = new TextView(mContext);
                    mType.setText(R.string.no_one);
                    mType.setTextColor(Color.BLACK);
                    mType.setTypeface(null, Typeface.BOLD);
                    mType.setTextSize(13);
                    mType.setGravity(Gravity.CENTER);
                    ll_one.addView(mType);
                    ll_child.addView(ll_one);

                    LinearLayout ll_two = new LinearLayout(mContext);
                    LinearLayout.LayoutParams layoutParams_two = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                    layoutParams_two.gravity = Gravity.CENTER;
                    layoutParams_two.weight = 8;
                    layoutParams_two.leftMargin = 10;
                    ll_two.setOrientation(LinearLayout.HORIZONTAL);
                    ll_two.setLayoutParams(layoutParams_two);

                    mType = new TextView(mContext);
                    mType.setText("Kaur");
                    mType.setTextColor(Color.BLACK);
                    mType.setTypeface(null, Typeface.BOLD);
                    mType.setTextSize(13);
                    mType.setGravity(Gravity.CENTER);
                    ll_two.addView(mType);
                    LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) mType.getLayoutParams();
                    params.gravity = (Gravity.CENTER);
                    ll_child.addView(ll_two);

                    LinearLayout ll_three = new LinearLayout(mContext);
                    LinearLayout.LayoutParams layoutParams_three = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                    layoutParams_three.gravity = Gravity.CENTER;
                    layoutParams_three.weight = 2;
                    layoutParams_three.leftMargin = 10;
                    ll_three.setOrientation(LinearLayout.HORIZONTAL);
                    ll_three.setLayoutParams(layoutParams_three);

                    LinearLayout ll_three_child_one = new LinearLayout(mContext);
                    LinearLayout.LayoutParams layoutParams_three_child_one = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                    layoutParams_three_child_one.gravity = Gravity.LEFT;
                    layoutParams_three_child_one.weight = 1;
                    ll_three_child_one.setOrientation(LinearLayout.HORIZONTAL);
                    ll_three_child_one.setLayoutParams(layoutParams_three_child_one);

                    img = new ImageView(mContext);
                    layoutParams3 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                    layoutParams3.gravity = Gravity.CENTER;
                    img.setLayoutParams(layoutParams3);
                    img.getLayoutParams().width = MainActivity.deviceWidth / 50;
                    img.getLayoutParams().height = MainActivity.deviceWidth / 50;
                    img.setImageResource(this.getResources().getIdentifier("drawable/border", null, mContext.getPackageName()));
                    ll_three_child_one.addView(img);


                    mType = new TextView(mContext);
                    mType.setText("5 likes");
                    mType.setTextColor(Color.parseColor("#FF7B00"));
                    mType.setTypeface(null, Typeface.BOLD);
                    mType.setTextSize(20);
                    mType.setGravity(Gravity.CENTER);
                    ll_three_child_one.addView(mType);
                    ll_three.addView(ll_three_child_one);

                    LinearLayout ll_three_child_two = new LinearLayout(mContext);
                    LinearLayout.LayoutParams layoutParams_three_child_two = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
                    layoutParams_three_child_two.gravity = Gravity.RIGHT;
                    layoutParams_three_child_two.weight = 1;
                    ll_three_child_two.setOrientation(LinearLayout.HORIZONTAL);
                    ll_three_child_two.setLayoutParams(layoutParams_three_child_two);

                    img = new ImageView(mContext);
                    layoutParams3 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                    layoutParams3.gravity = Gravity.RIGHT;
                    img.setLayoutParams(layoutParams3);
                    img.getLayoutParams().width = MainActivity.deviceWidth / 50;
                    img.getLayoutParams().height = MainActivity.deviceWidth / 50;
                    img.setImageResource(this.getResources().getIdentifier("drawable/border", null, mContext.getPackageName()));
                    ll_three_child_two.addView(img);


                    mType = new TextView(mContext);
                    mType.setText("5 comments");
                    mType.setTextColor(Color.parseColor("#FF7B00"));
                    mType.setTypeface(null, Typeface.BOLD);
                    mType.setTextSize(20);
                    mType.setGravity(Gravity.RIGHT);
                    ll_three_child_two.addView(mType);
                    ll_three.addView(ll_three_child_two);
                    ll_child.addView(ll_three);
                    ll_child.setBackgroundResource(R.drawable.border_one);
                    ll_left.addView(ll_child);
                }
            }
        }catch (Exception e){
            Log.d("Exception",e.toString());
        }
    }
}