public class Entry {
	private String id;
	private String title;
	private String url;
	private String background;
	private String lang="en";
    
	public Entry(){
		
	}
	
	public Entry(String id, String title, String url, String background) {
		super();
		this.id = id;
		this.title = title;
		this.url = url;
		this.background = background;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getBackground() {
		return background;
	}

	public void setBackground(String background) {
		this.background = background;
	}
 
	@Override
	public String toString() {
		
		return ""+", \""+title+"\",\""+url+"\",\""+background+"\",\""+lang+"\"";
	}
}
