package diabloapi;

public class Item {	
	
	private long id;
	private String content;

	public Item(long id, String content) {
		this.id = id;
		this.content = content;
	}

	public long getId() {
		return id;
	}	

	public String getContent() {
		return content;
	}
	
    public void setId( long a) {
    	this.id = a;
    }
}