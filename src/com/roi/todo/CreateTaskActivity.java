package com.roi.todo;

import com.roi.todo.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CreateTaskActivity extends Activity 
{
	public final static String TASK_DESCRIPTION = "com.roi.todo.TASK_DESCRIPTION";
	
	@Override
	public void onCreate(Bundle savedInstanceStase)
	{
		super.onCreate(savedInstanceStase);
        setContentView(R.layout.create_task_layout);
	}
	
	public void addNewTask(View view)
    {
		Intent intent = new Intent(this, MainActivity.class);
		
		EditText taskDescription = (EditText) findViewById(R.id.task_description);
		String taskDescriptionStr = taskDescription.getText().toString();
		
		if (taskDescriptionStr.isEmpty())
		{
			setResult(RESULT_CANCELED,intent);
		}
		else
		{
			intent.putExtra(TASK_DESCRIPTION, taskDescriptionStr);
			setResult(RESULT_OK,intent);
		}
		
		finish();
    }
}
