package ru.alexeySekatskiy.mycurrencyconverter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * @author Aleksey Sekatskiy
 */
public class CurrencyAdapter extends RecyclerView.Adapter<CurrencyAdapter.CurrencyViewHolder> {

    private final int itemsCount = CurrencyList.size;

    @Override
    public CurrencyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.currency_list_item;

        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(layoutIdForListItem, parent, false);

        CurrencyViewHolder viewHolder = new CurrencyViewHolder(view);

        /*Здесь можно задать повторяющиеся значения, которые будут присвоены ViewHolder константно*/

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CurrencyViewHolder holder, int position) {
        holder.bind(CurrencyList.get(position));
    }

    @Override
    public int getItemCount() {
        return itemsCount;
    }

    class CurrencyViewHolder extends RecyclerView.ViewHolder {

        TextView listItemNameView;
        TextView listItemCharCodeView;

        public CurrencyViewHolder(View itemView) {
            super(itemView);

            listItemNameView = itemView.findViewById(R.id.tv_item_currency_name);
            listItemCharCodeView = itemView.findViewById(R.id.tv_item_currency_charcode);
        }

        void bind(CurrencyBucket bucket) {
            listItemNameView.setText(bucket.getName());
            listItemCharCodeView.setText(bucket.getCharCode());
        }
    }
}
