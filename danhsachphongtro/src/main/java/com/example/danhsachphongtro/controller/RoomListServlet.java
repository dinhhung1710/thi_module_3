package com.example.danhsachphongtro.controller;

import com.example.danhsachphongtro.models.RentRoom;
import com.example.danhsachphongtro.dao.PaymentTypeDAO;
import com.example.danhsachphongtro.dao.RoomDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class RoomListServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RoomDAO dao = new RoomDAO();
        PaymentTypeDAO ptDao = new PaymentTypeDAO();

        String keyword = req.getParameter("keyword");
        List<RentRoom> rooms = (keyword != null && !keyword.isEmpty()) ? dao.searchRooms(keyword) : dao.getAllRooms();

        req.setAttribute("listRoom", rooms);
        req.setAttribute("paymentTypes", ptDao.getAll());
        req.setAttribute("keyword", keyword);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
