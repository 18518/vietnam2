package dto;

public class ResourceDTO {
	private int resourceld;
	private String resourceName;
	public ResourceDTO(int resourceld, String resourceName){
		this.resourceld = resourceld;
		this.resourceName = resourceName;
	}
	public int getResourceld() {
		return resourceld;
	}
	public void setResourceld(int resourceld) {
		this.resourceld = resourceld;
	}
	public String  getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}


}

