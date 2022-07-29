from AbstractEvent import AbstractEvent
import json
from datetime import datetime

class Cooked(AbstractEvent):
    id : int
    foodId : str
    preference : str
    orderId : int
    status : str
    
    def __init__(self):
        super().__init__()
        self.id = None
        self.foodId = None
        self.preference = None
        self.orderId = None
        self.status = None

