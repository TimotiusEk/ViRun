package fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.timotiusek.runcompanionvr.Activity.MainActivity;
import com.example.timotiusek.runcompanionvr.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PointFragment extends Fragment {
    private TextView minusPoint;
    private TextView showPoint;
    private TextView plusPoint;
    private int point;
    private Button spendBtn;
    private TextView currentPointTV;

    public PointFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_point, container, false);
        minusPoint = (TextView) v.findViewById(R.id.minus_point);
        plusPoint = (TextView) v.findViewById(R.id.plus_point);
        showPoint = (TextView) v.findViewById(R.id.show_point);
        currentPointTV = (TextView) v.findViewById(R.id.current_point);
        currentPointTV.setText(String.valueOf(MainActivity.currentPoint));

        plusPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                point = Integer.parseInt(showPoint.getText().toString()) + 10;

                if(point <= MainActivity.currentPoint)
                    showPoint.setText(String.valueOf(point));
            }
        });

        minusPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(point > 0) {
                    point = Integer.parseInt(showPoint.getText().toString()) - 10;
                    showPoint.setText(String.valueOf(point));
                }
            }
        });

        spendBtn = (Button) v.findViewById(R.id.spend_btn);

        spendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int remainingPoint = MainActivity.currentPoint - point;
                if(point <= MainActivity.currentPoint && point != 0){
                    MainActivity.currentPoint -= point;
                    point = 0;
                    showPoint.setText("0");
                    currentPointTV.setText(String.valueOf(remainingPoint));
                    Toast.makeText(getActivity(), "You have spent " + showPoint.getText().toString() + " points", Toast.LENGTH_SHORT).show();
                }
            }
        });

        MainActivity ma = (MainActivity) getActivity();
        ma.toolbar.setTitle("Points");
        ma.setChecked(R.id.menu_points);
        // Inflate the layout for this fragment
        return v;
    }

}
