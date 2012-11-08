package aze.android.fragmentsaze;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

public class Fragment1 extends Fragment {

	private View convertView;
	private Button mButton;
	private String lastDate = "";
	private DatePickerWidget mDatePickerWidget;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		convertView = inflater.inflate(R.layout.fragment1, container, false);
		mButton = (Button) convertView.findViewById(R.id.fragment1_button1);

		mButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				openDateDialog();
			}
		});

		return convertView;
	}

	/**
	 * to open Date Picker Dialog
	 */
	public void openDateDialog() {
		mDatePickerWidget = new DatePickerWidget(getActivity(),
				mDateSetListener, lastDate);
	}

	protected DatePickerDialog.OnDateSetListener mDateSetListener = new DatePickerDialog.OnDateSetListener() {

		public void onDateSet(DatePicker view, int year, int monthOfYear,
				int dayOfMonth) {

			lastDate = String.valueOf((new StringBuilder()
					.append(monthOfYear + 1).append("-").append(dayOfMonth)
					.append("-").append(year).append(" ")));
			Toast.makeText(getActivity(), lastDate, Toast.LENGTH_SHORT).show();
		}
	};

}
