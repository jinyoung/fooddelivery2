import util
import StoreOrderDB
from StoreOrder import StoreOrder
storeOrderrepository = StoreOrderDB.repository

import MenuDB
from Menu import Menu
menurepository = MenuDB.repository


from Paid import Paid

def wheneverPaid_주문목록에추가(data):
    event = Paid()
    event = util.AutoBinding(data, event)
    
    storeOrder = StoreOrder()
    storeOrderrepository.save(storeOrder)
    menu = Menu()
    menurepository.save(menu)
    
from OrderCanceled import OrderCanceled

def wheneverOrderCanceled_주문취소알림(data):
    event = OrderCanceled()
    event = util.AutoBinding(data, event)
    
    storeOrder = StoreOrder()
    storeOrderrepository.save(storeOrder)
    menu = Menu()
    menurepository.save(menu)
    

