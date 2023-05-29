package com.studywithme.persistence;

import com.studywithme.domain.GroupDTO;

public interface GroupDAO {
	
	public void createGroup(GroupDTO groupDTO) throws Exception;
}
