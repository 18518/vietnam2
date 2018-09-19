package dto;

public class ResourceClassDTO {
	int classId;
	String className;

	public ResourceClassDTO() {
		super();
	}

	public ResourceClassDTO(int classId, String className) {
		super();
		this.classId = classId;
		this.className = className;
	}

	public int getClassId() {
		return classId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

}
