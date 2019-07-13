package aoto.com.commonwidgetandlayout.basic_widget.spinner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

import aoto.com.commonwidgetandlayout.R;

/**
 * author:why
 * created on: 2019/5/18 12:06
 * description:
 */
public class MySpinnerAdaptor extends BaseAdapter{

    Context mContext;
    private List<String> mList;

    public MySpinnerAdaptor(Context context, List<String> list) {
        this.mContext = context;
        this.mList = list;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    /**
     * 绑定数据与View
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView=LayoutInflater.from(mContext).inflate(R.layout.spinner_item, null);
        if(convertView!=null)
        {
            ImageView icon=convertView.findViewById(R.id.item_icon_1);
            TextView info=convertView.findViewById(R.id.item_info_1);
            TextView resultInfo=convertView.findViewById(R.id.result_info);
            icon.setImageDrawable(mContext.getDrawable(R.drawable.year_icon));
            info.setText(mList.get(position));
            resultInfo.setText(mList.get(position));
        }
        return convertView;
    }
}
