package com.roi.todo;

import java.util.ArrayList;

import com.roi.todo.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

public class ItemListBaseAdapter extends BaseAdapter
{
	private static ArrayList<ItemDetails> itemDetailsArrayList;
	private LayoutInflater l_Inflater;
	
	public ItemListBaseAdapter(Context context, ArrayList<ItemDetails> results) 
	{
		itemDetailsArrayList = results;
		l_Inflater = LayoutInflater.from(context);
	 }
	
	public int getCount() 
	{
		return itemDetailsArrayList.size();
	}

	public Object getItem(int position)
	{
		return itemDetailsArrayList.get(position);
	}

	public long getItemId(int position)
	{
		return itemDetailsArrayList.get(position).getId();
	}

	public View getView(int position, View convertView, ViewGroup parent)
	{
		ViewHolder holder;
		final int pos = position;
		
		if (convertView == null)
		{
			convertView = l_Inflater.inflate(R.layout.item_layout, null);
			
			holder = new ViewHolder();
			
			holder.itemDescription = (TextView) convertView.findViewById(R.id.item_task_description);
			
			holder.itemButton = (Button) convertView.findViewById(R.id.item_done_button);
			holder.itemButton.setOnClickListener(new OnClickListener() {
				
				public void onClick(View v) {
					itemDetailsArrayList.remove(getItem(pos));
				    notifyDataSetChanged();
				}
			    });
			
			convertView.setTag(holder);
		}
		else 
		{
			holder = (ViewHolder) convertView.getTag();
	    }
		
		holder.itemDescription.setText(itemDetailsArrayList.get(position).getItemDescription());
		  
		return convertView;
	}
	
	static class ViewHolder 
	{
		TextView itemDescription;
		Button itemButton;
	}
}
