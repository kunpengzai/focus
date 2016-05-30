package com.jarvis.focus.dao;

import com.jarvis.focus.dto.MemberDTO;

/**
 * Created by Jarvis on 2016/5/21.
 */
public interface MemberDao {

    public Long saveMember(MemberDTO memberDTO);

    public int updateMember(MemberDTO memberDTO);

    public Long saveMemberApplyInfo(MemberDTO memberDTO);
}
