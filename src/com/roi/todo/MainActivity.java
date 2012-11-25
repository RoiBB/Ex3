package com.roi.todo;

import java.util.ArrayList;

import com.roi.todo.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity 
{
	private ListView listView;
	private ItemListBaseAdapter itemListBaseAdapter;
	public static ArrayList<ItemDetails> itemDetailsArrayList = new ArrayList<ItemDetails>();
	
	protected static final int ADD_TASK_SIMPLE = 100;
	
	
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        
        listView = (ListView) findViewById(R.id.main_item_list);
        itemListBaseAdapter = new ItemListBaseAdapter(this, itemDetailsArrayList);
        listView.setAdapter(itemListBaseAdapter);
    }
    
    public void goToCreateTaskActivity(View view)
    {
    	Intent intent = new Intent(this, CreateTaskActivity.class);
    	startActivityForResult(intent, ADD_TASK_SIMPLE);
    }
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) 
    {
    	if (requestCode == ADD_TASK_SIMPLE)
    	{
	    	if (resultCode == RESULT_OK)
	    	{
	    		itemDetailsArrayList.add(0, new ItemDetails(data.getStringExtra(CreateTaskActivity.TASK_DESCRIPTION)));
	    		itemListBaseAdapter.notifyDataSetChanged();
	    	}
	    	
	    	if (resultCode == RESULT_CANCELED)
	    	{
	    		Toast.makeText(this, "Please enter description.", Toast.LENGTH_SHORT).show();
	    	}
    	}
	}

}