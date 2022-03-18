package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import po.Goods;
import service.IGoodsService;
import util.DBUtil;

public class GoodsDao implements IGoodsService {
	private Connection connection=null;
	private PreparedStatement preState=null;
	private ResultSet resultSet=null;

	//查询所有商品
	public List<Goods> queryAllGoods(){
		List<Goods> allGoods=new ArrayList<Goods>();
		String sql="select * from Goods";

		try {
			connection=DBUtil.getCon();
			preState=connection.prepareStatement(sql);
			resultSet=preState.executeQuery();
			while (resultSet.next()){
				Goods goods=new Goods(resultSet.getInt("id"),resultSet.getString("name"),
									  resultSet.getString("city"),resultSet.getFloat("price"),
						              resultSet.getInt("number"),resultSet.getString("picture"));
				allGoods.add(goods);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(connection,preState,resultSet);
		}
		return allGoods;
	}

	/**
	 * 根据id 名称 产地等查询商品
	 * @param id
	 * @param name
	 * @param city
	 * @return
	 */
	public List<Goods> find(Integer id,String name,String city){
		   connection=DBUtil.getCon();
		   List<Goods> goods=new ArrayList<Goods>();
		   String sql="select * from Goods where 1=1";
		   if(id!=null)
		   {
			   sql=sql+" and id='"+id+"'";
		   }
		   if(name!=null){
			   sql=sql+" and name='"+name+"'";
		   }
		   if(city!=null){
			   sql=sql+" and city='"+city+"'";
		   }
		   try {
			   preState=connection.prepareStatement(sql);
			   resultSet=preState.executeQuery();
			   //处理结果集
			   while(resultSet.next()){
				   Goods good=new Goods(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("city"),
						   resultSet.getFloat("price"), resultSet.getInt("number"), resultSet.getString("picture"));

				   goods.add(good);
			   }

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeAll(connection, preState, resultSet);
		}
		return goods;
	}

	public Goods findGoodsById(int id){
		Goods goods=null;
		String sql="select * from Goods where id="+id;

		try {
			connection=DBUtil.getCon();
			preState=connection.prepareStatement(sql);
			resultSet=preState.executeQuery();
			if (resultSet.next()){
				goods=new Goods(resultSet.getInt("id"),resultSet.getString("name"),
						resultSet.getString("city"),resultSet.getFloat("price"),
						resultSet.getInt("number"),resultSet.getString("picture"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(connection,preState,resultSet);
		}
		return goods;
	}

	//刷新商品的库存
	public boolean updateGoodsNumber(int goodsId,int buyNumber){
		boolean result=false;
		String sql="update goods set number=number-"+buyNumber+" where id="+goodsId;
		System.out.println(sql);
		connection=DBUtil.getCon();
		try {
			preState=connection.prepareStatement(sql);
			result=preState.executeUpdate()>0?true:false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}