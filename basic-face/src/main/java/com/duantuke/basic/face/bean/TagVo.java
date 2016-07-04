package com.duantuke.basic.face.bean;

import java.io.Serializable;

public class TagVo  implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long tagId;

    private String tagName;

    private Long tagGroupId;
    
    private String businessType;
    
    

	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	public Long getTagId() {
		return tagId;
	}

	public void setTagId(Long tagId) {
		this.tagId = tagId;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public Long getTagGroupId() {
		return tagGroupId;
	}

	public void setTagGroupId(Long tagGroupId) {
		this.tagGroupId = tagGroupId;
	}
    
    
}
