package aze.android.fragmentsaze;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class Fragment2 extends Fragment implements OnClickListener {

	private View convertView;
	private Button mButton;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		convertView = inflater.inflate(R.layout.fragment2, container, false);
		mButton = (Button) convertView.findViewById(R.id.fragment2_button1);

		mButton.setOnClickListener(this);

		return convertView;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.fragment2_button1:
			Toast.makeText(getActivity(), mButton.getText(), Toast.LENGTH_SHORT)
					.show();
			break;

		default:
			break;
		}
	}

}
