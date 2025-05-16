<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Quản lý thuê phòng trọ</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body class="p-4">
<div class="container">
    <h2 class="mb-4">Danh sách thuê phòng trọ</h2>
    <!-- Search Form -->
    <form method="get" action="RoomListServlet" class="mb-3">
        <div class="input-group">
            <input type="text" name="keyword" class="form-control" placeholder="Tìm kiếm theo mã, tên, SĐT" value="${keyword}">
            <button class="btn btn-primary" type="submit">Tìm kiếm</button>
        </div>
    </form>
    <!-- Error Message -->
    <c:if test="${not empty error}">
        <div class="alert alert-danger">${error}</div>
    </c:if>
    <!-- Table Room List -->
    <form method="post" action="DeleteRoomServlet">
        <table class="table table-bordered table-hover">
            <thead>
            <tr>
                <th></th>
                <th>Mã phòng</th>
                <th>Họ tên</th>
                <th>SĐT</th>
                <th>Ngày thuê</th>
                <th>Hình thức</th>
                <th>Ghi chú</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="room" items="${listRoom}">
                <tr>
                    <td><input type="checkbox" name="roomId" value="${room.id}"/></td>
                    <td>PT-${room.id}</td>
                    <td>${room.tenantName}</td>
                    <td>${room.phoneNumber}</td>
                    <td>${room.startDate}</td>
                    <td>${room.paymentTypeName}</td>
                    <td>${room.note}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <!-- Delete Button & Confirmation -->
        <c:if test="${param.roomId != null}">
            <div class="alert alert-warning">
                <p>Bạn có muốn xóa thông tin thuê trọ:
                    <c:forEach var="id" items="${param.roomId}">
                        PT-${id}<c:if test="${!fn:contains(param.roomId[param.roomId.length - 1], id)}">, </c:if>
                    </c:forEach>
                    ?</p>
                <button type="submit" class="btn btn-danger">Có</button>
                <a href="RoomListServlet" class="btn btn-secondary">Không</a>
            </div>
        </c:if>
        <button class="btn btn-danger" name="confirmDelete" value="true">Xóa</button>
    </form>
    <hr>
    <h4>Thêm mới thuê trọ</h4>
    <form method="post" action="CreateRoomServlet">
        <div class="row g-3">
            <div class="col-md-4">
                <label>Họ tên</label>
                <input name="tenantName" class="form-control" required pattern="[A-Za-z\s]{5,50}"/>
            </div>
            <div class="col-md-4">
                <label>Số điện thoại</label>
                <input name="phoneNumber" class="form-control" required pattern="\d{10}"/>
            </div>
            <div class="col-md-4">
                <label>Ngày bắt đầu thuê</label>
                <input name="startDate" type="date" class="form-control" required/>
            </div>
            <div class="col-md-4">
                <label>Hình thức thanh toán</label>
                <select name="paymentTypeId" class="form-select" required>
                    <c:forEach var="pt" items="${paymentTypes}">
                        <option value="${pt.id}">${pt.typeName}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-md-8">
                <label>Ghi chú</label>
                <textarea name="note" class="form-control" maxlength="200"></textarea>
            </div>
            <div class="col-12">
                <button type="submit" class="btn btn-success">Tạo mới</button>
                <a href="RoomListServlet" class="btn btn-secondary">Hủy</a>
            </div>
        </div>
    </form>
</div>
</body>
</html>