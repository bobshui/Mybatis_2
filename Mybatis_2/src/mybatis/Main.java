package mybatis;

import org.apache.ibatis.session.SqlSession;

import mapper.RoleMapper;
import pojo.Role;
import util.SqlSessionFactoryUtil;

public class Main {
	public static void main(String[] args) {
		SqlSession sqlSession = null;
		try {
			sqlSession = SqlSessionFactoryUtil.openSqlSession();
			RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
			Role role = new Role();
			role.setRoleName("testName");
			role.setNote("testNote");
			roleMapper.insertRole(role);
			roleMapper.deleteRole(12L);
			sqlSession.commit();
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
			sqlSession.rollback();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}
}
