package id.dimas.android.kalkulatorfisika;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 12/25/2016.
 */
public class BabRVAdapter extends RecyclerView.Adapter<BabRVAdapter.ViewHolder> {

    private List<String> bab = new ArrayList<>();

    private OnBabClickListener listener;

    public BabRVAdapter(List<String> bab, OnBabClickListener listener){
        this.bab = bab;
        this.listener = listener;

    }
    @Override
    public BabRVAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        view = layoutInflater.inflate(R.layout.menu_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BabRVAdapter.ViewHolder holder, int position) {
        holder.ivMoviePoster.setText(bab.get(position));
    }

    @Override
    public int getItemCount() {
        if (null != bab) {
            return bab.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView ivMoviePoster;

        public ViewHolder(View itemView) {
            super(itemView);
            ivMoviePoster = (TextView) itemView.findViewById(R.id.textview_listitem);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            listener.onBabClick();
        }
    }
}
