package domain;

public class Resource {
	int ResourceId;
	String ResourceName;
	public Resource() {
		super();
	}
	public Resource(int resourceId, String resourceName) {
		super();
		ResourceId = resourceId;
		ResourceName = resourceName;
	}
	public int getResourceId() {
		return ResourceId;
	}
	public void setResourceId(int resourceId) {
		ResourceId = resourceId;
	}
	public String getResourceName() {
		return ResourceName;
	}
	public void setResourceName(String resourceName) {
		ResourceName = resourceName;
	}
	
}
