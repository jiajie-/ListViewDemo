package com.sise.chat_qq;

import java.util.List;

import com.sise.bean.Msg;
import com.sise.listviewdemo.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MsgAdapter extends ArrayAdapter<Msg> {

	private int resourceId;

	public MsgAdapter(Context context, int textViewResourceId, List<Msg> objects) {
		super(context, textViewResourceId, objects);
		resourceId = textViewResourceId;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Msg msg = getItem(position);
		View view;
		ViewHolder viewHolder;
		if (convertView == null) {
			view = LayoutInflater.from(getContext()).inflate(resourceId, null);

			viewHolder = new ViewHolder();
			viewHolder.leftLayout = (LinearLayout) view
					.findViewById(R.id.layout_left);
			viewHolder.rightLayout = (LinearLayout) view
					.findViewById(R.id.layout_right);
			viewHolder.leftMsg = (TextView) view.findViewById(R.id.tv_left_msg);
			viewHolder.rightMsg = (TextView) view
					.findViewById(R.id.tv_right_msg);

			view.setTag(viewHolder);

		} else {
			view = convertView;
			viewHolder = (ViewHolder) view.getTag();
		}

		if (msg.getType() == Msg.TYPE_RECEIVED) {
			// 如果是收到的消息，则显示左边的消息布局，将右边的消息布局隐藏
			viewHolder.leftLayout.setVisibility(View.VISIBLE);
			viewHolder.rightLayout.setVisibility(View.GONE);
			viewHolder.leftMsg.setText(msg.getContent());
		} else if (msg.getType() == Msg.TYPE_SEND) {
			// 如果是发出的消息，则显示右边的消息布局，将左边的消息布局隐藏
			viewHolder.leftLayout.setVisibility(View.GONE);
			viewHolder.rightLayout.setVisibility(View.VISIBLE);
			viewHolder.rightMsg.setText(msg.getContent());
		}
		return view;
	}

	class ViewHolder {
		LinearLayout leftLayout;
		LinearLayout rightLayout;
		TextView leftMsg;
		TextView rightMsg;
	}

}
