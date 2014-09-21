package com.sise.chat_qq;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.sise.bean.Msg;
import com.sise.listviewdemo.BaseActivity;
import com.sise.listviewdemo.R;

public class ChatActivity extends BaseActivity {

	private ListView lv_msg;

	private EditText et_input;

	private Button btn_send;

	private MsgAdapter adapter;

	private List<Msg> msgList = new ArrayList<Msg>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_chat);

		initMsgs();

		adapter = new MsgAdapter(ChatActivity.this, R.layout.msg_item, msgList);

		et_input = (EditText) findViewById(R.id.et_input);
		btn_send = (Button) findViewById(R.id.btn_send);
		lv_msg = (ListView) findViewById(R.id.lv_msg);

		lv_msg.setAdapter(adapter);

		btn_send.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String content = et_input.getText().toString();
				if (!"".equals(content)) {
					Msg msg = new Msg(content, Msg.TYPE_SEND);
					msgList.add(msg);
					// 当有新消息时，刷新ListView
					adapter.notifyDataSetChanged();
					// 将ListView定位到最后一行
					lv_msg.setSelection(msgList.size());
					// 清空输入框的内容
					et_input.setText("");
				}
			}
		});
	}

	private void initMsgs() {
		Msg msg1 = new Msg("Hello World!", Msg.TYPE_RECEIVED);
		msgList.add(msg1);
		Msg msg2 = new Msg("What?", Msg.TYPE_SEND);
		msgList.add(msg2);
		Msg msg3 = new Msg("It's me!", Msg.TYPE_RECEIVED);
		msgList.add(msg3);
	}

}
