package dto;

public class ResourceInputDTO {
	String className;
	int resourceId;
	String resourceName;

	public ResourceInputDTO( int resourceId, String resourceName,String className) {
		this.className = className;
		this.resourceId = resourceId;
		this.resourceName = resourceName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
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
}
