package com.devkgm.app.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.devkim.app.util.DBConnector;

@Repository
public class ProductDAO {

	
	
	public List<ProductDTO> getList() throws Exception {
		Connection connection = DBConnector.getConnector();
		String sql = "SELECT * FROM PRODUCT";
		PreparedStatement st = connection.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		List<ProductDTO> list = new ArrayList<ProductDTO>();
		while(rs.next()) {
			ProductDTO productDTO = new ProductDTO();
			productDTO.setId(rs.getLong("ID"));
			productDTO.setDescription(rs.getString("DESCRIPTION"));
			productDTO.setName(rs.getString("NAME"));
			productDTO.setRate(rs.getDouble("RATE"));
			list.add(productDTO);
		}
		DBConnector.disConnect(rs, st, connection);
		return list;
	}
	public ProductDTO getDetail(ProductDTO productDTO) throws Exception{
		Connection connection = DBConnector.getConnector();
		String sql = "SELECT * FROM PRODUCT WHERE ID = ?";
		PreparedStatement st = connection.prepareStatement(sql);
		st.setLong(1, productDTO.getId());
		ResultSet rs = st.executeQuery();
		rs.next();
		productDTO.setDescription(rs.getString("DESCRIPTION"));
		productDTO.setName(rs.getString("name"));
		productDTO.setRate(rs.getDouble("RATE"));
		DBConnector.disConnect(rs, st, connection);
		return productDTO;
	}
	public int add(ProductDTO productDTO) throws Exception{
		Connection connection = DBConnector.getConnector();
		String sql = "INSERT INTO PRODUCT VALUES (PRODUCT_SEQ.NEXTVAL, ?, ?, ?)";
		PreparedStatement st = connection.prepareStatement(sql);
		st.setString(1, productDTO.getName());
		st.setString(2, productDTO.getDescription());
		st.setDouble(3, productDTO.getRate());
		int result = st.executeUpdate();
		DBConnector.disConnect( st, connection);
		return result;
	}
	public int modify(ProductDTO productDTO) throws Exception{
		Connection connection = DBConnector.getConnector();
		String sql = "UPDATE PRODUCT SET NAME=?, DESCRIPTION=?, RATE=? WHERE ID = ?";
		PreparedStatement st = connection.prepareStatement(sql);
		st.setString(1, productDTO.getName());
		st.setString(2, productDTO.getDescription());
		st.setDouble(3, productDTO.getRate());
		st.setLong(4, productDTO.getId());
		
		int result = st.executeUpdate();
		DBConnector.disConnect(st, connection);
		return result;
	}
	public int delete(ProductDTO productDTO) throws Exception{
		Connection connection = DBConnector.getConnector();
		String sql = "DELETE FROM PRODUCT WHERE ID = ?";
		PreparedStatement st = connection.prepareStatement(sql);
		st.setLong(1, productDTO.getId());
		int result = st.executeUpdate();
		DBConnector.disConnect(st, connection);
		return result;
	}
}
