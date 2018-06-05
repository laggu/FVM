package DB;

import java.io.Serializable;
import java.util.Date;

public class ProjectVO implements Serializable {
	String project_name;
	String path;
	String creation_date;
	
	public ProjectVO() {
		super();
	}

	public ProjectVO(String project_name, String path, String creation_date) {
		super();
		this.project_name = project_name;
		this.path = path;
		this.creation_date = creation_date;
	}



	public String getProject_name() {
		return project_name;
	}

	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(String creation_date) {
		this.creation_date = creation_date;
	}

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((creation_date == null) ? 0 : creation_date.hashCode());
		result = prime * result + ((path == null) ? 0 : path.hashCode());
		result = prime * result + ((project_name == null) ? 0 : project_name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProjectVO other = (ProjectVO) obj;
		if (creation_date == null) {
			if (other.creation_date != null)
				return false;
		} else if (!creation_date.equals(other.creation_date))
			return false;
		if (path == null) {
			if (other.path != null)
				return false;
		} else if (!path.equals(other.path))
			return false;
		if (project_name == null) {
			if (other.project_name != null)
				return false;
		} else if (!project_name.equals(other.project_name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProjectVO [project_name=" + project_name + ", path=" + path + ", creation_date=" + creation_date + "]";
	}
	

}
