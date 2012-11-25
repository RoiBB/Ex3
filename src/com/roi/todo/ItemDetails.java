package com.roi.todo;


public class ItemDetails 
{
	private long id;
	private String itemDescription;
	
	private static long nextID = 0;
	
	public ItemDetails(String itemDescription) {
		super();
		this.id = ++nextID;
		this.itemDescription = itemDescription;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getItemDescription() {
		return itemDescription;
	}
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	@Override
	public boolean equals(Object other)
	{
		if (other == this) 
		{
            return true;
        }
		
        if (other == null || other.getClass() != this.getClass())
        {
            return false;
        }

		ItemDetails otherItemDetails = (ItemDetails) other;
		
		return otherItemDetails.id == id;
	}
	
	
}
