
from AbstractEvent import AbstractEvent
import json

class Paid(AbstractEvent):
    id : int
    orderId : int
    
    def __init__(self):
        super().__init__()
        self.id = None
        self.orderId = None

