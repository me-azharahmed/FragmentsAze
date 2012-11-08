package aze.android.fragmentsaze;

import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;

public class DatePickerWidget {

	DatePickerDialog.OnDateSetListener DateSetListener;
	static final int DATE_DIALOG_ID = 0;
	static final int Date_Id = 1;
	private int _Year;
	private int _Month;
	private int _Day;
	Activity mActivity;

	public DatePickerWidget(Activity mActivity,
			DatePickerDialog.OnDateSetListener mDateSetListener, String lastDate) {
		this.mActivity = mActivity;
		System.out.println("...lastDate...." + lastDate);

		Calendar c = Calendar.getInstance();
		_Year = c.get(Calendar.YEAR);
		_Month = c.get(Calendar.MONTH);
		_Day = c.get(Calendar.DAY_OF_MONTH);
		onCreateDialog(DATE_DIALOG_ID, mDateSetListener).show();
	}

	protected Dialog onCreateDialog(int id,
			DatePickerDialog.OnDateSetListener mDateSetListener) {

		switch (id) {

		case DATE_DIALOG_ID:
			return new DatePickerDialog(mActivity, mDateSetListener, _Year,
					_Month, _Day);

		case Date_Id:
			return new DatePickerDialog(mActivity, DateSetListener, _Year,
					_Month, _Day);

		}
		return null;
	}

	protected void onPrepareDialog(int id, Dialog dialog) {

		switch (id) {

		case DATE_DIALOG_ID:
			((DatePickerDialog) dialog).updateDate(_Year, _Month, _Day);

			break;
		case Date_Id:
			((DatePickerDialog) dialog).updateDate(_Year, _Month, _Day);
			break;
		}
	}

}
