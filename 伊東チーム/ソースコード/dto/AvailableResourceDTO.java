package dto;

public class AvailableResourceDTO {
	private int resourceId;
	private String resourceName;
	public AvailableResourceDTO() {

	}
	public AvailableResourceDTO(int resourceId, String resourceName) {

		this.resourceId = resourceId;
		this.resourceName = resourceName;
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
