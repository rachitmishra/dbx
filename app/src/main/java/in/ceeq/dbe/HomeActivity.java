package in.ceeq.dbe;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import in.ceeq.dbe.adapters.DatabindingListAdapter;
import in.ceeq.dbe.databinding.ActivityHomeBinding;
import in.ceeq.dbe.models.DatabindingItem;
import in.ceeq.dbe.models.HomeViewModel;

public class HomeActivity extends AppCompatActivity {

    private static final String HOME_VIEW_MODEL = "home_view_model";
    private HomeViewModel mHomeViewModel;
    private DatabindingListAdapter mItemAdapter;
    private ArrayList<DatabindingItem> mItemArrayList = new ArrayList<>();

    public static void start(Context context) {
        Intent starter = new Intent(context, HomeActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (null != savedInstanceState) {
            mHomeViewModel = savedInstanceState.getParcelable(HOME_VIEW_MODEL);
        }

        if (null == mHomeViewModel) {
            mHomeViewModel = new HomeViewModel();

            // Setting title to toolbar
            mHomeViewModel.setToolbarTitle("Sample List");
        }

        ActivityHomeBinding activitySignInBinding
                = DataBindingUtil.setContentView(this, R.layout.activity_home);
        activitySignInBinding.setHomeViewModel(mHomeViewModel);

        initItemList();
        initWithDemoData();
    }

    private void initItemList() {
        RecyclerView databindingRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        databindingRecyclerView.setLayoutManager(linearLayoutManager);
        databindingRecyclerView.setHasFixedSize(true);
        mItemAdapter = new DatabindingListAdapter(this);
        mItemAdapter.initData(new ArrayList<DatabindingItem>());
        databindingRecyclerView.setAdapter(mItemAdapter);
    }

    private void initWithDemoData() {
        DatabindingItem databindingItem = new DatabindingItem();
        databindingItem.title = "Netflix";
        databindingItem.suggestion = "For the glory of merlin!";
        databindingItem.value = "Jim";
        databindingItem.rating = "Lake Jr.";
        databindingItem.color = R.color.colorPositive;
        databindingItem.button = "Excited";
        mItemArrayList.add(databindingItem);

        databindingItem = new DatabindingItem();
        databindingItem.title = "Netflix";
        databindingItem.suggestion = "Nom! Nom! Nom!";
        databindingItem.value = "Gnome";
        databindingItem.rating = "Chomsky";
        databindingItem.color = R.color.colorPositive;
        databindingItem.button = "Angry";
        mItemArrayList.add(databindingItem);

        databindingItem = new DatabindingItem();
        databindingItem.title = "Netflix";
        databindingItem.suggestion = "";
        databindingItem.value = "Blinkous";
        databindingItem.rating = "Gladrigous";
        databindingItem.color = R.color.colorPositive;
        databindingItem.button = "Calm";
        mItemArrayList.add(databindingItem);

        mItemAdapter.initData(mItemArrayList);
    }

    public void handleButtonClick() {
        FormActivity.start(this);
    }
}
