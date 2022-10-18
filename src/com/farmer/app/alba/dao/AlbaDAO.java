package com.farmer.app.alba.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.farmer.app.alba.vo.AlbaVO;
import com.farmer.mybatis.config.MyBatisConfig;

public class AlbaDAO {
	SqlSessionFactory sqlSessionFactory = MyBatisConfig.getSqlsessionFactory();
	SqlSession sqlSession;

	public AlbaDAO() {
		sqlSession = sqlSessionFactory.openSession(true);
	}

//	전체 아르바이트 목록 출력
	public List<AlbaVO> selectRegistration(Map<String, Integer> pageMap) {
		return sqlSession.selectList("Alba.selectRegistration", pageMap);
	}
	
//	전체 아르바이트 개수 조회
	public int selectCount() {
		return sqlSession.selectOne("Alba.selectCount");
	}
	
//	진행중인 아르바이트 개수 조회
	public int selectProcess(String today) {
		return sqlSession.selectOne("Alba.selectProcess", today);
	}
	
	
}
