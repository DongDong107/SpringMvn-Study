package kr.co.rland.web.repository;

import org.apache.ibatis.annotations.Mapper;

import kr.co.rland.web.entity.Member;

@Mapper
public interface MemberRepository {

	Member findByUserName(String uid);
	
	
}
