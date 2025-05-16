package com.example.danhsachphongtro.dao;

import com.example.danhsachphongtro.utils.DBConnection;
import com.example.danhsachphongtro.models.PaymentType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PaymentTypeDAO {
    public List<PaymentType> getAll() {
        List<PaymentType> list = new ArrayList<>();
        String sql = "SELECT * FROM payment_type";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PaymentType pt = new PaymentType();
                pt.setId(rs.getInt("id"));
                pt.setTypeName(rs.getString("type_name"));
                list.add(pt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
