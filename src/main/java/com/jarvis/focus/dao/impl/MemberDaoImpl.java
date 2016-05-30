package com.jarvis.focus.dao.impl;

import com.jarvis.focus.dao.MemberDao;
import com.jarvis.focus.dto.MemberDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Jarvis on 2016/5/21.
 */
public class MemberDaoImpl extends BaseDaoImpl implements MemberDao {

    private static final Logger log = LoggerFactory.getLogger(MemberDaoImpl.class);

    public Long saveMember(MemberDTO memberDTO) {
        try {
            this.getSqlSession().insert("member.saveMember", memberDTO);
            return memberDTO.getId();
        } catch(RuntimeException e) {
            log.error("memberDao.saveMember", e);
            throw e;
        }
    }

    public int updateMember(MemberDTO memberDTO) {
        try {
            return this.getSqlSession().update("member.updateMember", memberDTO);
        } catch(RuntimeException e) {
            log.error("memberDao.updateMember", e);
            throw e;
        }
    }

    public Long saveMemberApplyInfo(MemberDTO memberDTO) {
        try {
            this.getSqlSession().insert("member.saveMemberApplyInfo", memberDTO);
            return memberDTO.getId();
        } catch(RuntimeException e) {
            log.error("memberDao.saveMemberApplyInfo", e);
            throw e;
        }
    }
}
