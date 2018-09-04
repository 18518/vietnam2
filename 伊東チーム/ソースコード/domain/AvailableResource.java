package domain;

public class AvailableResource {
	private int  resourceId;
	private String resourceName;
	public int getResourceId() {
		return resourceId;
	}
	public void setResourceId(int resourceId) {
		this.resourceId = resourceId;
	}
	public String getResourceName() {
		return resourceName;
	}
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	public AvailableResource(int resourceId, String resourceName) {
		super();
		this.resourceId = resourceId;
		this.resourceName = resourceName;
	}


}

