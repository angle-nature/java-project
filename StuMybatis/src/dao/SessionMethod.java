package dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pojo.InputOptionValue;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class SessionMethod<E,T> {
    private static final String resource="mybatis-config.xml";
    private static InputStream inputStream=null;
    private static SqlSession sqlSession = null;

    static{  //static语句块 只运行一次 进行初始化
        try {
            InputStream stream = inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
            sqlSession=sqlSessionFactory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public T selectOneObject(InputOptionValue<E> inputOptionValue){
        T returnOb=null;
        String str=inputOptionValue.getStr();
        E value=inputOptionValue.getValue();
        returnOb=sqlSession.selectOne(str,inputOptionValue.getValue());
        return returnOb;
    }

    public List<T> selectListObject(InputOptionValue<E> inputOptionValue){
        List<T> returnObList=null;
        String str=inputOptionValue.getStr();
        E value=inputOptionValue.getValue();
        if(value==null)
            returnObList=sqlSession.selectList(str);
        else
            returnObList=sqlSession.selectList(str,value);
        return returnObList;
    }

    public boolean doInsert(InputOptionValue<E> inputOptionValue){
        boolean flag=false;
        String str=inputOptionValue.getStr();
        E value=inputOptionValue.getValue();
        if(sqlSession.insert(str, value)>0)
            flag=true;
        sqlSession.commit();
        return flag;
    }

    public boolean doDelete(InputOptionValue<E> inputOptionValue){
        boolean flag=false;
        String str=inputOptionValue.getStr();
        E value=inputOptionValue.getValue();
        if(sqlSession.delete(str, value)>0)
            flag=true;
        sqlSession.commit();
        return flag;
    }

    public boolean doUpdate(InputOptionValue<E> inputOptionValue){
        boolean flag=false;
        String str=inputOptionValue.getStr();
        E value=inputOptionValue.getValue();
        if(sqlSession.update(str, value)>0)
            flag=true;
        sqlSession.commit();
        return flag;
    }
}
