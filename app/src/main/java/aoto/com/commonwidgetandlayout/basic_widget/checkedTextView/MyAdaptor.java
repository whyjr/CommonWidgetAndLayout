package aoto.com.commonwidgetandlayout.basic_widget.checkedTextView;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import java.util.ArrayList;

import java.util.List;

import aoto.com.commonwidgetandlayout.R;

/**
 * author:why
 * created on: 2019/5/14 10:49
 * description:
 */
public class MyAdaptor extends ArrayAdapter<String> {
    private static final String TAG = "MyAdaptorWhy";
    private int resourceID;
    private Context context;
    private ArrayList<String> resultList;
    public MyAdaptor(@NonNull Context context, int resource, List<String> list) {
        super(context, resource,list);
        this.context = context;
        this.resourceID = resource;
        resultList=new ArrayList();
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view;
        final ViewHolder holder;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceID, parent, false);
            holder=new ViewHolder();
            holder.checkedTextView=view.findViewById(R.id.checked_textView);
            view.setTag(holder);
        } else {
            //布局缓存处理
            view = convertView;
            holder = (ViewHolder) view.getTag();
        }

        String str = getItem(position);
        holder.checkedTextView.setText(str);
        holder.checkedTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.checkedTextView.toggle();//切换选中与非选中状态
                if(holder.checkedTextView.isChecked()){
                    resultList.add(holder.checkedTextView.getText().toString());
                }
                else {
                    if(resultList.contains(holder.checkedTextView.getText().toString())){
                        resultList.remove(holder.checkedTextView.getText().toString());
                    }
                }
            }
        });
        return view;
    }

    class ViewHolder {
       CheckedTextView checkedTextView;
    }

    public ArrayList<String> getList(){
        return resultList;
    }
}
