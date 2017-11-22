package fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.timotiusek.runcompanionvr.Activity.MainActivity;
import com.example.timotiusek.runcompanionvr.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AchievementFragment extends Fragment {


    public AchievementFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_achievement, container, false);
        MainActivity ma = (MainActivity) getActivity();
        ma.toolbar.setTitle("Achievements");
        ma.setChecked(R.id.menu_achievements);
        // Inflate the layout for this fragment
        return v;
    }

}
