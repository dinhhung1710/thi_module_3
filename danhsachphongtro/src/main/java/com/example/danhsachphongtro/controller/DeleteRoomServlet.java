package com.example.danhsachphongtro.controller;

import com.example.danhsachphongtro.dao.RoomDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteRoomServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] ids = req.getParameterValues("roomId");
        if (ids != null) {
            RoomDAO dao = new RoomDAO();
            for (String id : ids) {
                dao.deleteRoomById(Integer.parseInt(id));
            }
        }
        resp.sendRedirect("RoomListServlet");
    }
}
