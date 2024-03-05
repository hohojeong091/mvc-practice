package com.ohgiraffers.mvc.employee.model.service;

import com.ohgiraffers.mvc.employee.model.dao.EmployeeMapper;
import com.ohgiraffers.mvc.employee.model.dto.EmployeeDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.mvc.common.mybatis.Template.getSqlSession;

public class EmployeeService {

    private EmployeeMapper employeeMapper;


    public EmployeeDTO selectOneEmpById(String empId) {
        SqlSession sqlsession = getSqlSession();
        System.out.println("sqlSession : " + sqlsession);

        employeeMapper = sqlsession.getMapper(EmployeeMapper.class);
        EmployeeDTO selectedEmp = employeeMapper.selectOneEmpById(empId);

        sqlsession.close();

        return selectedEmp ;


    }

    public List<EmployeeDTO> selectAllEmp() {
        SqlSession sqlSession = getSqlSession();
        employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        List<EmployeeDTO> empList = employeeMapper.selectAllEmp();
        sqlSession.close();
        return empList;



    }
}
