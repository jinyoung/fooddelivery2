from AbstractEvent import AbstractEvent
import json
from datetime import datetime

class Rejected(AbstractEvent):
    id : int
    
    def __init__(self):
        super().__init__()
        self.id = None

