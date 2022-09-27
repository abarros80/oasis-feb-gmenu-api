package oasis.feb.gestaomenu.bean;

import java.io.Serializable;

public class FileInfo  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	  private String name;
	  private String url;

	  public FileInfo(String name, String url) {
	    this.name = name;
	    this.url = url;
	  }

	  public String getName() {
	    return this.name;
	  }

	  public void setName(String name) {
	    this.name = name;
	  }

	  public String getUrl() {
	    return this.url;
	  }

	  public void setUrl(String url) {
	    this.url = url;
	  }

}
