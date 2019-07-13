package aoto.com.commonwidgetandlayout.basic_widget.checkedTextView;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;

import java.util.ArrayList;
import java.util.List;

import aoto.com.commonwidgetandlayout.R;

/**
 * author:why
 * created on: 2019/5/14 16:58
 * description:
 */
public class MyAdaptorTest extends ArrayAdapter<String> {

    private static final String TAG = "MyAdaptorWhy";
    private Context context;
    private ArrayList<String> resultList;
    public MyAdaptorTest(@NonNull Context context, int resource, List<String> list) {
        super(context, resource,list);
        this.context = context;
        resultList=new ArrayList();
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view;
        final ViewHolder holder;
        if (convertView == null) {
            view = new CheckedTextView(context);
            holder=new ViewHolder();
            holder.checkedTextView= (CheckedTextView) view;
            view.setTag(holder);
        } else {
            //布局缓存处理
            view = convertView;
            holder = (ViewHolder) view.getTag();
        }
        String str = getItem(position);
        holder.checkedTextView.setText(str);
        holder.checkedTextView.setCheckMarkDrawable(R.drawable.checked_text_view_back);
        holder.checkedTextView.setTextSize(25);
        return view;
    }

    class ViewHolder {
        CheckedTextView checkedTextView;
    }

}
