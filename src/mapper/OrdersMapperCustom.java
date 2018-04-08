package mapper;

import po.OrderCustom;
import po.Orders;

import java.util.List;

public interface OrdersMapperCustom {
    List<OrderCustom> findOrderUserList() throws Exception;

    List<Orders> findOrderUserListResultMap() throws Exception;

    List<Orders> findOrderAndOrderDetails() throws Exception;

}
