package com.example.firstjob.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.firstjob.AnswerItem;
import com.example.firstjob.R;

import java.util.List;

public class AnswerItemAdapter extends BaseAdapter{

    //fields
    private Context context;
    private List<AnswerItem> answerItemList;
    private LayoutInflater inflater;

    //constructor
    public AnswerItemAdapter(Context context, List<AnswerItem> answerItemList){
        this.context = context;
        this.answerItemList = answerItemList;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return answerItemList.size();
    }

    @Override
    public AnswerItem getItem(int position) {
        return answerItemList.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        view = inflater.inflate(R.layout.adapter_item, null);

        //get informations about item
        AnswerItem currentItem = getItem(i);
        String itemTitle = currentItem.getTitle();
        String itemContent = currentItem.getContent();

        //get item title view
        TextView itemTitleView = view.findViewById(R.id.item_title);
        itemTitleView.setText(itemTitle);

        //get item content view
        TextView itemContentView = view.findViewById(R.id.item_content);
        itemContentView.setText(itemContent);

        return view;
    }
}
