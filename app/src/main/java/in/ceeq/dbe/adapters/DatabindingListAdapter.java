package in.ceeq.dbe.adapters;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;

import in.ceeq.dbe.R;
import in.ceeq.dbe.databinding.LayoutDatabindingItemBinding;
import in.ceeq.dbe.models.DatabindingItemViewModel;
import in.ceeq.dbe.models.DatabindingItem;

public class DatabindingListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int VIEW_TYPE_CARD = 2;
    private Context mContext;
    private ArrayList<DatabindingItem> mDatabindingItemList = new ArrayList<>();

    public DatabindingListAdapter(Context context) {
        mContext = context;
    }

    public void initData(ArrayList<DatabindingItem> itemArrayList) {
        mDatabindingItemList.clear();
        if (!itemArrayList.isEmpty()) {
            mDatabindingItemList.addAll(itemArrayList);
        }
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        DatabindingItemViewModel databindingItemViewModel =
                new DatabindingItemViewModel(mContext);
        LayoutInflater inflater = LayoutInflater.from(context);
        LayoutDatabindingItemBinding layoutCardHealthBinding =
                    DataBindingUtil.inflate(inflater,
                            R.layout.layout_databinding_item, parent, false);
            layoutCardHealthBinding.setDatabindingItemViewModel(databindingItemViewModel);
            return new HealthCardViewHolder(layoutCardHealthBinding);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        LayoutDatabindingItemBinding layoutCardHealthBinding =
                ((HealthCardViewHolder) holder).getBinding();
        DatabindingItemViewModel healthViewModel =
                layoutCardHealthBinding.getDatabindingItemViewModel();
        DatabindingItem databindingItem = mDatabindingItemList.get(position);
        healthViewModel.setFromItem(databindingItem);
    }


    @Override
    public int getItemViewType(final int position) {
        return VIEW_TYPE_CARD;
    }

    @Override
    public int getItemCount() {
        return mDatabindingItemList.size();
    }

    private class HealthCardViewHolder extends RecyclerView.ViewHolder {

        private final LayoutDatabindingItemBinding mLayoutBinding;

        public HealthCardViewHolder(LayoutDatabindingItemBinding layoutCardHealthBinding) {
            super(layoutCardHealthBinding.getRoot());
            mLayoutBinding = layoutCardHealthBinding;
        }

        public LayoutDatabindingItemBinding getBinding() {
            return mLayoutBinding;
        }
    }
}
