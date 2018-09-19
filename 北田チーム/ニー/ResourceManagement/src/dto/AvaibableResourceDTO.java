package dto;

public class AvaibableResourceDTO {
	private int resourceId;
	private String resourceName;


	public AvaibableResourceDTO() {

		// TODO 自動生成されたコンストラクター・スタブ
	}

	public AvaibableResourceDTO(int resourceId, String resourceName) {

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

	public void setSesourceName(String resourceName) {
		this.resourceName = resourceName;
	}

}
