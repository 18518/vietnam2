package dto;

public class AvaibableResourceDTO {
	
	private int resourceId;
	private String sesourceName;
	
	
	public AvaibableResourceDTO() {
	}

	public AvaibableResourceDTO(int resourceId, String sesourceName) {
		
		this.resourceId = resourceId;
		this.sesourceName = sesourceName;
	}

	public int getResourceId() {
		return resourceId;
	}

	public void setResourceId(int resourceId) {
		this.resourceId = resourceId;
	}

	public String getSesourceName() {
		return sesourceName;
	}

	public void setSesourceName(String sesourceName) {
		this.sesourceName = sesourceName;
	}
	
}
