package domain;

public class Resource {
	int resourceId ;
	String resourceName;
	Resource(){
		
	}
	Resource(int resourceId, String resourceName) {
		this.resourceId = resourceId;
		this.resourceName = resourceName;
	}
	public int getResourceId() {
		return resourceId;
	}
	public void setResourceId(int resourceId) {
		this.resourceId = resourceId;
	}
	public String getresourceName() {
		return resourceName;
	}
	public void setresourceName(String resourceName) {
		this.resourceName = resourceName;
	}
}
