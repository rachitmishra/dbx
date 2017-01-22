package in.ceeq.dbe;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.DatePicker;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import in.ceeq.dbe.adapters.ItemAdapter;
import in.ceeq.dbe.databinding.ActivityFormBinding;
import in.ceeq.dbe.models.FormViewModel;

public class FormActivity extends AppCompatActivity implements
        DatePickerDialog.OnDateSetListener {

    private static final String FORM_VIEW_MODEL = "form_view_model";
    private FormViewModel mLoginViewModel;
    private BottomSheetDialog mBottomSheetDialog;

    public static void start(Context context) {
        Intent starter = new Intent(context, FormActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (null != savedInstanceState) {
            mLoginViewModel = savedInstanceState.getParcelable(FORM_VIEW_MODEL);
        }

        if (null == mLoginViewModel) {
            mLoginViewModel = new FormViewModel(this);
            mLoginViewModel.setToolbarTitle("Sample Form");
            mLoginViewModel.name.set("Jim Lake Jr.");
            mLoginViewModel.dateOfBirth.set("01/01/2001");
            mLoginViewModel.gender.set("Male");
            mLoginViewModel.action.set("Netflix");
        }

        ActivityFormBinding activityFormBinding
                = DataBindingUtil.setContentView(this, R.layout.activity_form);
        activityFormBinding.setFormViewModel(mLoginViewModel);
    }

    public void handleDateOfBirthClick(String dateOfBirth) {
        try {
            SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
            Date date = df.parse(dateOfBirth);
            final Calendar c = Calendar.getInstance();
            c.setTime(date);
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);
            // Create a new instance of DatePickerDialog and return it
            new DatePickerDialog(this, this, year, month, day).show();
        } catch (ParseException e) {
            // Bleh!
        }
    }

    public void handleGenderClick() {
        showGenderBottomSheet();
    }

    public void onDateSet(DatePicker view, int year, int month, int day) {
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        final Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, day);
        String requiredDate = df.format(c.getTime()).toString();
        mLoginViewModel.dateOfBirth.set(requiredDate);
    }

    private ArrayList<String> getSelectableItems() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Male");
        arrayList.add("Female");
        return arrayList;
    }

    private void showGenderBottomSheet() {
        mBottomSheetDialog = new BottomSheetDialog(this);
        View view = getLayoutInflater().inflate(R.layout.layout_bottomsheet, null);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ItemAdapter(getSelectableItems(),
                new ItemAdapter.ItemListener() {
                    @Override
                    public void onItemClick(int position) {
                        if (mBottomSheetDialog != null) {
                            switch (position) {
                                case 1:
                                    mLoginViewModel.gender.set("Male");
                                    break;
                                case 2:
                                    mLoginViewModel.gender.set("Female");
                            }
                            mBottomSheetDialog.dismiss();
                        }
                    }
                }));
        mBottomSheetDialog.setContentView(view);
        mBottomSheetDialog.show();
    }

    public void handleSubmitClick() {
        HomeActivity.start(this);
    }
}
