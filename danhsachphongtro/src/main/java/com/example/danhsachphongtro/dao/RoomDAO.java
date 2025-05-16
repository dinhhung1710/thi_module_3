package com.example.danhsachphongtro.dao;

import com.example.danhsachphongtro.utils.DBConnection;
import com.example.danhsachphongtro.models.RentRoom;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RoomDAO {
    public List<RentRoom> getAllRooms() {
        List<RentRoom> list = new ArrayList<>();
        String sql = "SELECT r.*, p.type_name FROM rent_room r JOIN payment_type p ON r.payment_type_id = p.id";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                RentRoom room = new RentRoom();
                room.setId(rs.getInt("id"));
                room.setTenantName(rs.getString("tenant_name"));
                room.setPhoneNumber(rs.getString("phone_number"));
                room.setStartDate(rs.getString("start_date"));
                room.setPaymentTypeId(rs.getInt("payment_type_id"));
                room.setPaymentTypeName(rs.getString("type_name"));
                room.setNote(rs.getString("note"));
                list.add(room);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<RentRoom> searchRooms(String keyword) {
        List<RentRoom> list = new ArrayList<>();
        String sql = "SELECT r.*, p.type_name FROM rent_room r JOIN payment_type p ON r.payment_type_id = p.id WHERE r.id LIKE ? OR r.tenant_name LIKE ? OR r.phone_number LIKE ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            String kw = "%" + keyword + "%";
            ps.setString(1, kw);
            ps.setString(2, kw);
            ps.setString(3, kw);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                RentRoom room = new RentRoom();
                room.setId(rs.getInt("id"));
                room.setTenantName(rs.getString("tenant_name"));
                room.setPhoneNumber(rs.getString("phone_number"));
                room.setStartDate(rs.getString("start_date"));
                room.setPaymentTypeId(rs.getInt("payment_type_id"));
                room.setPaymentTypeName(rs.getString("type_name"));
                room.setNote(rs.getString("note"));
                list.add(room);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void insertRoom(RentRoom room) {
        String sql = "INSERT INTO rent_room (tenant_name, phone_number, start_date, payment_type_id, note) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, room.getTenantName());
            ps.setString(2, room.getPhoneNumber());
            ps.setString(3, room.getStartDate());
            ps.setInt(4, room.getPaymentTypeId());
            ps.setString(5, room.getNote());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteRoomById(int id) {
        String sql = "DELETE FROM rent_room WHERE id = ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
